package com.jessen.core.mybatis;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sen.ye on 2017/3/1.
 */
public interface BaseService<Domain extends AbstractDomain, Entity extends AbstractEntity<PK>, PK extends Serializable> {
    List<Domain> findAll();

    Domain find(PK id);

    PK create(Domain domain);

    PK update(Domain domain);

    void delete(PK id);
}
