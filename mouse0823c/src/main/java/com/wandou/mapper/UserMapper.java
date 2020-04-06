package com.wandou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wandou.model.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liming
 * @date 2020-04-04
 * @description
 */

@Mapper
public interface UserMapper extends BaseMapper<UserPO> {
}
