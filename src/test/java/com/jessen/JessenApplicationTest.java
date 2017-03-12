/*
package com.jessen;


import com.jessen.dao.ExampleDao;
import com.jessen.entity.ExampleEntity;
import com.jessen.service.ExampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

*/
/**
 * Created by sen.ye on 2017/2/28.
 *//*


@RunWith(SpringRunner.class)
@SpringBootTest(classes= JessenApplication.class)//指定启动类
public class JessenApplicationTest {

    @Autowired
    private ExampleDao exampleDao;

    @Autowired
    private ExampleService exampleService;

    @Test
    public void testFindAll(){
        List<ExampleEntity> list = exampleDao.findAll();
        System.out.println(list);
    }

    @Test
    public void testCreate(){
        ExampleEntity example = new ExampleEntity();
        example.setId(3000L);
        example.setName("admin");
        example.setPassword("admin");
        example.setCreateTime(new Date());
        //exampleDao.create(example);

        exampleService.create(getBeanUtils().copyFromEntity(example));
    }

    @Test
    public void testFind(){
        ExampleEntity exampleEntity = exampleDao.find(2000L);
        System.out.println(exampleEntity);
    }

    @Test
    public void testUpdate(){
        ExampleEntity example = new ExampleEntity();
        example.setId(1000L);
        example.setName("admin");
        example.setPassword("123");
        exampleDao.update(example);
    }

    @Test
    public void testDelete(){
        exampleDao.delete(1000L);
    }

    public PropertyUtilsImplTest getBeanUtils(){
        return new PropertyUtilsImplTest();
    }
}
*/
