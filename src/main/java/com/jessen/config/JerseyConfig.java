package com.jessen.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by sen.ye on 2017/2/27.
 */
@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        //register(Endpoint.class);
        //register(JacksonJsonProvider.class);//注册json转换器
        packages("com.jessen.controller");

    }
}