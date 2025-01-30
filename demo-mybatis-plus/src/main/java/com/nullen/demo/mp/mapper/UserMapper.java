package com.nullen.demo.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nullen.demo.comm.bo.UserBO;
import com.nullen.demo.comm.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Nullen
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


    List<User> batchGetByIdsAndUserCodes(List<UserBO> userBOList);

}
