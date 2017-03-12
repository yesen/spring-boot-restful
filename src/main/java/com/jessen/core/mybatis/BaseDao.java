package com.jessen.core.mybatis;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sen.ye on 2017/3/1.
 */
public interface BaseDao<Entity extends AbstractEntity<PK>,PK extends Serializable> {

    List<Entity> findAll();

    Entity find(PK id);

    PK create(Entity entity);

    PK update(Entity entity);

    void delete(PK id);
}
