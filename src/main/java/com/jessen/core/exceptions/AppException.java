package com.jessen.core.exceptions;

import com.jessen.core.enums.ApplicationEnum;

/**
 * Created by sen.ye on 2017/3/1.
 */
public class AppException extends RuntimeException {

    public AppException(){
        super();
    }


    public AppException(ApplicationEnum app){
        this.code = app.getCode();
        this.message = app.getContext();
    }

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
