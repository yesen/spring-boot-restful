package com.jessen.core.mybatis;

import java.io.Serializable;

/**
 * Created by sen.ye on 2017/2/28.
 */
public abstract class AbstractEntity<PK extends Serializable> {

    private PK pk;

    protected abstract PK getPk();
}
