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
     * @return
     */
    List<MatterLogDTO> list(long userId, int mType);
}
