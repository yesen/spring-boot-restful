package com.jessen.core.mybatis;

import com.jessen.core.enums.ApplicationEnum;
import com.jessen.core.exceptions.AppException;
import com.jessen.core.utils.PropertyUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sen.ye on 2017/3/1.
 */
public class AbstractBaseService<Domain extends AbstractDomain, Entity extends AbstractEntity<PK>, PK extends Serializable>
        extends PropertyUtils<Domain, Entity> implements BaseService<Domain, Entity, PK> {

    private BaseDao<Entity, PK> businessDao = null;

    public AbstractBaseService(BaseDao<Entity, PK> businessDao) {
        this.businessDao = businessDao;
    }

    @Override
    public List<Domain> findAll() {
        List<Entity> entityList = businessDao.findAll();
        List<Domain> domainList = new ArrayList<Domain>();
        if (entityList != null && !entityList.isEmpty()) {
            for (Entity entity : entityList) {
                domainList.add(copyFromEntity(entity));
            }
        }
        return domainList;
    }

    @Override
    public Domain find(PK id) {
        return copyFromEntity(businessDao.find(id));
    }

    @Override
    public PK create(Domain domain) {
        Entity entity = copyFromDomain(domain);
        if (entity == null) {
            throw new AppException(ApplicationEnum.APP_OBJECT_NULL);
        }
        return businessDao.create(entity);
    }

    @Override
    public PK update(Domain domain) {
        Entity entity = copyFromDomain(domain);
        if (entity == null) {
            throw new AppException(ApplicationEnum.APP_OBJECT_NULL);
        }
        return businessDao.update(entity);
    }

    @Override
    public void delete(PK id) {
        businessDao.delete(id);
    }
}
