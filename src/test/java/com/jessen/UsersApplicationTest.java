/*
package com.jessen;

import com.jessen.system.dao.UsersDao;
import com.jessen.system.entity.UsersEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

*/
/**
 * Created by sen.ye on 2017/3/3.
 *//*

@RunWith(SpringRunner.class)
@SpringBootTest(classes= JessenApplication.class)//指定启动类
public class UsersApplicationTest {

    @Autowired
    private UsersDao usersDao;

    @Test
    public void test(){
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setId(1000L);
        usersEntity.setName("admin");
        usersEntity.setPassword("123");
        usersEntity.setHashPassword("2222");
        usersEntity.setCreateTime(new Date());
        usersDao.create(usersEntity);
    }
}
*/
