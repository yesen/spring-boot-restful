package com.code.generate;

/**
 * Created by sen.ye on 2017/3/2.
 */
public interface CodeTemplate {

    void createEntity();

    void createDao();

    void createDaoImpl();

    void createMapper();

    void createService();

    void createSerivceImpl();

    void createDomain();

    void createResource();

    void createController();
}
