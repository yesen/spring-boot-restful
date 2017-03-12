package com.jessen.entity.sys;

import com.jessen.core.mybatis.AbstractEntity;

import java.util.Date;

public class UsersEntity extends AbstractEntity<Long> {

    //主键
    private Long id;
    //用户名称
    private String name;
    //密码
    private String password;
    //加密密码
    private String hashPassword;
    //创建时间
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        hashPassword = hashPassword;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        createTime = createTime;
    }

    @Override
    protected Long getPk() {
        return id;
    }


}