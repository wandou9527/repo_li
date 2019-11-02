package com.wandou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wandou.model.po.AccountPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper extends BaseMapper<AccountPO> {
}
