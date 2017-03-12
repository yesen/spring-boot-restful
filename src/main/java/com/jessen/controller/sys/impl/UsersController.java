package com.jessen.controller.sys.impl;

import com.jessen.controller.sys.UsersResource;
import com.jessen.domain.sys.UsersDomain;
import com.jessen.service.sys.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sen.ye on 2017/43/12.
 */
@Component
public class UsersController implements UsersResource {

    @Autowired
    private UsersService usersService;

    @Override
    public List<UsersDomain> findAll() {
        return usersService.findAll();
    }

    @Override
    public UsersDomain findById(Long id) {
        return usersService.find(id);
    }

    @Override
    public UsersDomain create(UsersDomain domain) {
        usersService.create(domain);
        return domain;
    }

    @Override
    public UsersDomain update(Long id, UsersDomain domain) {
        domain.setId(id);
        usersService.update(domain);
        return domain;
    }

    @Override
    public void delete(Long id) {
        usersService.delete(id);
    }
}

