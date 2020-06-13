package com.wandou.service;

import com.wandou.model.dto.MatterLogDTO;

import java.util.List;

/**
 * @author liming
 * @date 2020-03-26
 * @description
 */
public interface MatterLogService {

    /**
     * 列表
     *
     * @param userId
     * @param mType
     * @param partitionValue
     * @return
     */
    List<MatterLogDTO> list(long userId, int mType, String partitionValue);

    /**
     * 接到mq消息添加matterLog数据
     * 暂定只添加今天及明天的，当数据不存在时添加
     * @param userId
     * @param mType
     * @param remark
     */
    void addMatterLogByMqDemo(Long userId, Integer mType, String remark);

    String add(MatterLogDTO matterLog);

}
