package com.jessen.core.enums;

/**
 * 应用级别
 * Created by sen.ye on 2017/3/1.
 */
public enum ApplicationEnum {

    APP_OBJECT_NULL("100000","系统级别,参数对象为空"),

    ;

    private ApplicationEnum(String code,String context){
        this.code = code;
        this.context = context;
    }

    private String code;
    private String context;

    public String getCode() {
        return code;
    }

    public String getContext() {
        return context;
    }
}
