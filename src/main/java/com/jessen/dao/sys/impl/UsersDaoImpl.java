package com.jessen.dao.sys.impl;

import com.jessen.core.mybatis.AbstractBaseDao;
import com.jessen.dao.sys.UsersDao;
import com.jessen.entity.sys.UsersEntity;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by sen.ye on 2017/13/10.
 */
@Repository
public class UsersDaoImpl extends AbstractBaseDao<UsersEntity, Long> implements UsersDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public UsersDaoImpl() {
        super(UsersDaoImpl.class.getName());
    }

    @Override
    protected SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

}
