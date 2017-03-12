package com.jessen.core.mybatis;

import org.mybatis.spring.SqlSessionTemplate;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sen.ye on 2017/3/1.
 */
public abstract class AbstractBaseDao<Entity extends AbstractEntity<PK>,PK extends Serializable> implements BaseDao<Entity,PK> {

    private String packageName;

    public AbstractBaseDao(String packageName){
        this.packageName = packageName;
    }

    protected abstract SqlSessionTemplate getSqlSessionTemplate();

    @Override
    public List<Entity> findAll() {
        return getSqlSessionTemplate().selectList(packageName + ".findAll");
    }

    @Override
    public Entity find(PK id) {
        return getSqlSessionTemplate().selectOne(packageName + ".find",id);
    }

    @Override
    public PK create(Entity entity) {
        getSqlSessionTemplate().insert(packageName + ".create",entity);
        return entity.getPk();
    }

    @Override
    public PK update(Entity entity) {
        getSqlSessionTemplate().update(packageName + ".update",entity);
        return entity.getPk();
    }

    @Override
    public void delete(PK id) {
        getSqlSessionTemplate().delete(packageName + ".delete",id);
    }
}
