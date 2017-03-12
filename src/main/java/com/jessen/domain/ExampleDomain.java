package com.jessen.domain;

import com.jessen.core.mybatis.AbstractDomain;

import java.util.Date;

/**
 * Created by sen.ye on 2017/2/27.
 */
public class ExampleDomain extends AbstractDomain{

    private Long id ;
    private String name;
    private String password;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
