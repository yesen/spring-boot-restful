package com.code.generate;

import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by sen.ye on 2017/3/2.
 */
@Component
public class CodeTemplateImpl implements CodeTemplate {

    @Autowired
    private Context context;

    @Value("${root.path}")
    private String rootPath;

    @Value("${root.model}")
    private String rootModel;

    @Value("${class.name}")
    private String className;

    @Value("${model.name}")
    private String modelName;

    @Override
    public void createEntity() {
        String template = "code/template/entity.vm";
        String filePath = rootPath + "/src/main/java/com/" + rootModel + "/entity/" + modelName + "/" + className + "Entity.java";
        createTemplate(template, filePath);
    }

    @Override
    public void createDao() {
        String template = "code/template/dao.vm";
        String filePath = rootPath + "/src/main/java/com/" + rootModel + "/dao/" + modelName + "/" + className + "Dao.java";
        createTemplate(template, filePath);
    }

    @Override
    public void createDaoImpl() {
        String template = "code/template/daoImpl.vm";
        String filePath = rootPath + "/src/main/java/com/" + rootModel + "/dao/" + modelName + "/impl/" + className + "DaoImpl.java";
        createTemplate(template, filePath);
    }

    @Override
    public void createMapper() {
        String template = "code/template/mapper.vm";
        String filePath = rootPath + "/src/main/resources/mapper/" + rootModel + "/" + modelName + "/" + context.get("lowerClassName") + ".mapper.xml";
        createTemplate(template, filePath);
    }

    @Override
    public void createService() {
        String template = "code/template/service.vm";
        String filePath = rootPath + "/src/main/java/com/" + rootModel + "/service/" + modelName + "/" + className + "Service.java";
        createTemplate(template, filePath);
    }

    @Override
    public void createSerivceImpl() {
        String template = "code/template/serviceImpl.vm";
        String filePath = rootPath + "/src/main/java/com/" + rootModel + "/service/" + modelName + "/impl/" + className + "ServiceImpl.java";
        createTemplate(template, filePath);
    }

    @Override
    public void createDomain() {
        String template = "code/template/domain.vm";
        String filePath = rootPath + "/src/main/java/com/" + rootModel + "/domain/" + modelName + "/" + className + "Domain.java";
        createTemplate(template, filePath);
    }

    @Override
    public void createResource() {
        String template = "code/template/resource.vm";
        String filePath = rootPath + "/src/main/java/com/" + rootModel + "/controller/" + modelName + "/" + className + "Resource.java";
        createTemplate(template, filePath);
    }

    @Override
    public void createController() {
        String template = "code/template/controller.vm";
        String filePath = rootPath + "/src/main/java/com/" + rootModel + "/controller/" + modelName + "/impl/" + className + "Controller.java";
        createTemplate(template, filePath);
    }

    public void createTemplate(String vm, String filePath) {
        try {
            Template template = Velocity.getTemplate(vm);
            File domainFile = new File(filePath);
            if (!domainFile.getParentFile().exists()) {
                domainFile.getParentFile().mkdirs();
            }
            PrintWriter writer = new PrintWriter(domainFile, "utf-8");
            template.merge(context, writer);
            writer.flush();
            writer.close();
            System.out.println(">>>>>>>>>>>>>success>>" + filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
