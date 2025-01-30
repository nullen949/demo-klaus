package com.nullen.demo.helloworld.test;

import com.nullen.demo.comm.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Silas
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestHandler<Entity extends BaseEntity> {

    private Class<Entity> entityClass;

}
