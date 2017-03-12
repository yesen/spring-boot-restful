/*
package com.jessen;

import com.jessen.domain.ExampleDomain;
import com.jessen.entity.ExampleEntity;
import com.jessen.core.utils.PropertyUtils;

import java.util.Date;

*/
/**
 * Created by sen.ye on 2017/2/28.
 *//*

public class PropertyUtilsImplTest extends PropertyUtils<ExampleDomain, ExampleEntity> {

    public static void main(String[] args) {
        testCopyFromEntity();
        testCopyFromDomain();
    }

    public static void testCopyFromEntity() {
        PropertyUtilsImplTest property = new PropertyUtilsImplTest();
        ExampleEntity exampleEntity = new ExampleEntity();
        exampleEntity.setId(1000L);
        exampleEntity.setName("1");
        exampleEntity.setPassword("2");
        exampleEntity.setCreateTime(new Date());

        ExampleDomain exampleDomain = property.copyFromEntity(exampleEntity);

        System.out.println(exampleDomain.getCreateTime());
    }

    public static void testCopyFromDomain() {
        PropertyUtilsImplTest property = new PropertyUtilsImplTest();
        ExampleDomain exampleDomain = new ExampleDomain();
        exampleDomain.setId(1000L);
        exampleDomain.setName("1");
        exampleDomain.setPassword("2");
        exampleDomain.setCreateTime(new Date());

        ExampleEntity exampleEntity = property.copyFromDomain(exampleDomain);

        System.out.println(exampleEntity.getId());
    }
}
*/
