package com.jessen.core.utils;

import com.jessen.core.mybatis.AbstractDomain;
import com.jessen.core.mybatis.AbstractEntity;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by sen.ye on 2017/2/28.
 */
public class PropertyUtils<Domain extends AbstractDomain,Entity extends AbstractEntity> {

    private Class domainClass = null;
    private Class entityClass = null;

    public Entity copyFromDomain(Domain domain) {
        // 如果domain,直接返回null
        if (domain == null) {
            return null;
        }
        // 获取所有的泛型类型
        Class targetClass = getGenericType(1);
        Object target = null;
        try {
            target = targetClass.newInstance();
            BeanUtils.copyProperties(domain, target);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return (Entity) target;
    }

    public Domain copyFromEntity(Entity entity) {
        // 如果entity,直接返回null
        if (entity == null) {
            return null;
        }
        // 获取所有的泛型类型
        Class targetClass = getGenericType(0);
        Object target = null;

        try {
            target = targetClass.newInstance();
            BeanUtils.copyProperties(entity, target);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return (Domain) target;
    }




    public Class getGenericType(int index) {
        if (index == 0) {
            if (entityClass == null) {
                synchronized (this) {
                    if (entityClass == null) {
                        entityClass = getClass(index);
                    }
                }
            }
            return entityClass;
        } else if (index == 1) {
            if (domainClass == null) {
                synchronized (this) {
                    if (domainClass == null) {
                        domainClass = getClass(index);
                    }
                }
            }
            return domainClass;
        }
        return Object.class;

    }

    private Class getClass(int index) {
        Type genType = getClass().getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            throw new RuntimeException("Index outof bounds");
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }
}
