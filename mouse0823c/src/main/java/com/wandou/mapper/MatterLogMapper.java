package com.wandou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wandou.model.po.MatterLogPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author liming
 * @date 2020-03-26
 * @description
 */
@Mapper
public interface MatterLogMapper extends BaseMapper<MatterLogPO> {

    MatterLogPO selectByPrimaryKey(Long id);

    List<MatterLogPO> listByUserIdAndHappenTime(@Param("userId") Long userId,
                                                @Param("happenTimeStart") Date happenTimeStart,
                                                @Param("happenTimeEnd") Date happenTimeEnd,
                                                @Param("mType") Integer mType,
                                                @Param("subType") Integer subType,
                                                @Param("partitionValue") String partitionValue);

}
