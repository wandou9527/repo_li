package com.wandou.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wandou.constant.CommonConst;
import com.wandou.mapper.MatterLogMapper;
import com.wandou.model.dto.MatterLogDTO;
import com.wandou.model.po.MatterLogPO;
import com.wandou.service.MatterLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
        MatterLogPO matterLogParam = new MatterLogPO();
        matterLogParam.setUserId(userId);
        matterLogParam.setMType(mType);
        matterLogParam.setIsDelete(0);
        QueryWrapper<MatterLogPO> queryWrapper = new QueryWrapper(matterLogParam);
        queryWrapper.excludeColumns("create_time");
        List<MatterLogPO> matterLogs = matterLogMapper.selectList(queryWrapper);
        log.info("matterLogs: {}", matterLogs);
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
        matterLogDTOS = matterLogDTOS.stream().sorted(Comparator.comparing(MatterLogDTO::getHappenTime)).collect(Collectors.toList());
        return matterLogDTOS;
    }


    @Override
    public void addMatterLogByMqDemo(Long userId, String remark) {
        if (userId == null) {
            userId = 0L;
        }
        Date date = new Date();
//        Date startTimeOfDay = DateUtil.getStartTimeOfDay(date);
//        Date endTimeOfDay = DateUtils.addDays(startTimeOfDay, 1);
//        log.info("startTimeOfDay: {}, endTimeOfDay: {}", startTimeOfDay, endTimeOfDay);
//        List<MatterLogPO> matterLogPOS = matterLogMapper.listByUserIdAndHappenTime(23L, startTimeOfDay, endTimeOfDay, 3);
//        log.info("matterLogPOS: {}", JSON.toJSONString(matterLogPOS, true));
//        if (CollectionUtils.isNotEmpty(matterLogPOS)) {
//            return;
//        }
        // =========================

        MatterLogPO matterLogPO = new MatterLogPO();
        matterLogPO.setUserId(userId);
        matterLogPO.setMType(3);
        matterLogPO.setIsDelete(0);
        QueryWrapper<MatterLogPO> queryWrapper = new QueryWrapper(matterLogPO);
        List<MatterLogPO> matterLogPOS = matterLogMapper.selectList(queryWrapper);
        log.info("matterLogPOS: {}", JSON.toJSONString(matterLogPOS, true));
        if (CollectionUtils.isNotEmpty(matterLogPOS)) {
            return;
        }

        //看是否有今天数据
        for (MatterLogPO m : matterLogPOS) {
            if (DateUtils.isSameDay(date, m.getHappenTime())) {
                return;
            }
        }

        matterLogPO.setHappenTime(date);
        matterLogPO.setReachAmount(666D);
        matterLogPO.setReachAmountUnit("bu");
        matterLogPO.setPartitionValue(DateFormatUtils.format(date, CommonConst.PATTERN_YYYYMM));
        matterLogPO.setPartitionType(1);
        matterLogPO.setRemark(remark);
        int insert = matterLogMapper.insert(matterLogPO);
        log.info("insert: {}", insert);

    }
}
