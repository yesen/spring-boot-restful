package com.jessen.service.sys.impl;

import com.jessen.core.mybatis.AbstractBaseService;
import com.jessen.dao.sys.UsersDao;
import com.jessen.domain.sys.UsersDomain;
import com.jessen.entity.sys.UsersEntity;
import com.jessen.service.sys.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by sen.ye on 2017/27/12.
 */
@Repository
public class UsersServiceImpl extends AbstractBaseService<UsersDomain,UsersEntity, Long> implements UsersService {

    private final UsersDao usersDao;

    @Autowired
    public UsersServiceImpl(UsersDao usersDao) {
        super(usersDao);
        this.usersDao = usersDao;
    }

}
