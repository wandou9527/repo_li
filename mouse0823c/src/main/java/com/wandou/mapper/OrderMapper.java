package com.wandou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wandou.model.po.OrderPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liming
 * @date 2020-05-03
 * @description
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderPO> {
}
