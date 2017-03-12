package com.code.generate;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by home on 2017/3/12.
 */
@Component
@Configurable
public class CodeContextConfig {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public Context contenxt(@Value("${class.name}") String className,
                            @Value("${model.name}") String modelName,
                            @Value("${sql.table}") String table,
                            @Value("${sql.query}") String sql,
                            @Value("${root.model}") String rootModel
    ) {
        VelocityContext context = new VelocityContext();
        context.put("className", className);
        context.put("lowerClassName",StringRef.lowerProccess(className));
        context.put("tableName",table);
        context.put("modelName", modelName);
        context.put("rootModel",rootModel);
        context.put("rootTime",new SimpleDateFormat("yyyy/mm/dd").format(new Date()));

        String[] longs = {"bigint"};
        String[] strs = {"varchar", "varchar2", "char", "text"};
        String[] decimals = {"double", "decimal"};
        String[] dates = {"date", "datetime", "timestamp"};
        Map<String, String> imports = new HashMap<String, String>();

        System.out.println(">>>>>>>SQL>>>>>" + sql);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list.size());

        String dataType = null;
        String columnName = null;
        for (Map<String, Object> map : list) {
            System.out.println(map.toString());

            dataType = map.get("data_type").toString().toLowerCase();//小写
            if (Arrays.asList(longs).contains(dataType)) {
                map.put("col_type", "Long");
            } else if (Arrays.asList(strs).contains(dataType)) {
                map.put("col_type", "String");
            } else if (Arrays.asList(decimals).contains(dataType)) {
                map.put("col_type", "BigDecimal");
                if (!imports.containsKey("BigDecimal")) imports.put("BigDecimal", "import java.math.BigDecimal;");
            } else if (Arrays.asList(dates).contains(dataType)) {
                map.put("col_type", "Date");
                if (!imports.containsKey("Date")) imports.put("Date", "import java.util.Date;");
            }

            columnName = map.get("column_name").toString();
            map.put("col_field",StringRef.lowerProccess(columnName));
            map.put("col_field_fun",StringRef.upperProccess(columnName));

        }
        //{column_name=id, data_type=bigint, column_key=PRI, column_comment=主键}
        context.put("col_list", list);
        context.put("imports", imports);
        return context;
    }
}
