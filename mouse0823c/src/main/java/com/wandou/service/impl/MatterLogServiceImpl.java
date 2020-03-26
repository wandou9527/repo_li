package com.wandou.service.impl;

import com.wandou.constant.CommonConst;
import com.wandou.mapper.MatterLogMapper;
import com.wandou.model.dto.MatterLogDTO;
import com.wandou.model.po.MatterLogPO;
import com.wandou.service.MatterLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liming
 * @date 2020-03-26
 * @description
 */
@Slf4j
@Service
public class MatterLogServiceImpl implements MatterLogService {
    @Autowired
    private MatterLogMapper matterLogMapper;


    @Override
    public List<MatterLogDTO> list(long userId, int mType) {
        MatterLogPO matterLogPO = new MatterLogPO();
        matterLogPO.setUserId(userId);
        matterLogPO.setMType(mType);
        List<MatterLogPO> matterLogs = matterLogMapper.selectList(null);
        if (CollectionUtils.isEmpty(matterLogs)) {
            return Collections.EMPTY_LIST;
        }
        List<MatterLogDTO> matterLogDTOS = new LinkedList<>();
        for (MatterLogPO matterLog : matterLogs) {
            MatterLogDTO matterLogDTO = new MatterLogDTO();
            BeanUtils.copyProperties(matterLog, matterLogDTO);
            matterLogDTO.setHappenDate(DateFormatUtils.format(matterLog.getHappenTime(), CommonConst.PATTERN_YYYY_MM_DD));
            matterLogDTOS.add(matterLogDTO);
        }
        return matterLogDTOS;
    }
}
