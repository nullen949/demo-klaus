package com.nullen.demo.helloworld.mapstruct;

import com.nullen.demo.helloworld.dto.TestDTO;
import com.nullen.demo.helloworld.entity.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Silas
 */
@Mapper
public interface TestConverter {

    TestConverter INSTANCE = Mappers.getMapper(TestConverter.class);

    TestDTO convertToDTO(Test test);

}
