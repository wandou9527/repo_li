package com.wandou.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wandou.constant.CommonConst;
import com.wandou.enumeration.MatterLogTypeEnum;
import com.wandou.mapper.MatterLogMapper;
import com.wandou.model.dto.MatterLogDTO;
import com.wandou.model.po.MatterLogPO;
import com.wandou.service.MatterLogService;
import com.wandou.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
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
    public List<MatterLogDTO> list(long userId, int mType, String partitionValue, Long happenTimeStart, Long happenTimeEnd) {
//        MatterLogPO matterLogParam = new MatterLogPO();
//        matterLogParam.setUserId(userId);
//        matterLogParam.setMType(mType);
//        matterLogParam.setIsDelete(0);
//        if (StringUtils.isNotBlank(partitionValue)) {
//            matterLogParam.setPartitionValue(partitionValue);
//        }
//        QueryWrapper<MatterLogPO> queryWrapper = new QueryWrapper(matterLogParam);
//        List<MatterLogPO> matterLogs = matterLogMapper.selectList(queryWrapper);

        Date happenTimeStartD = null;
        Date happenTimeEndD = null;
        if (happenTimeStart != null) {
            happenTimeStartD = new Date(happenTimeStart);
        }
        if (happenTimeEnd != null) {
            happenTimeEndD = new Date(happenTimeEnd);
        }
        List<MatterLogPO> matterLogs = matterLogMapper.listByUserIdAndHappenTime(userId, happenTimeStartD, happenTimeEndD, mType, partitionValue);
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
        matterLogDTOS = matterLogDTOS.stream().sorted(Comparator.comparing(MatterLogDTO::getHappenTime).reversed()).collect(Collectors.toList());
        return matterLogDTOS;
    }


    @Override
    public void addMatterLogByMqDemo(Long userId, Integer mType, String remark) {
        // money相关暂时不程序添加
        if (MatterLogTypeEnum.T_1.getCode().equals(mType)) {
            return;
        }
        if (userId == null) {
            userId = 0L;
        }
        if (mType == null) {
            mType = MatterLogTypeEnum.STEP_NUMBER.getCode();
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
        matterLogPO.setMType(mType);
        matterLogPO.setIsDelete(0);
        QueryWrapper<MatterLogPO> queryWrapper = new QueryWrapper(matterLogPO);
        List<MatterLogPO> matterLogPOS = matterLogMapper.selectList(queryWrapper);
        log.info("matterLogPOS: {}", JSON.toJSONString(matterLogPOS));
        if (CollectionUtils.isNotEmpty(matterLogPOS)) {
            //看是否有今天数据
            for (MatterLogPO m : matterLogPOS) {
                if (DateUtils.isSameDay(date, m.getHappenTime())) {
                    return;
                }
            }
        }

        computeMatterLogRanch(matterLogPO);
        matterLogPO.setHappenTime(date);
        matterLogPO.setPartitionValue(DateFormatUtils.format(date, CommonConst.PATTERN_YYYYMM));
        matterLogPO.setPartitionType(1);
        matterLogPO.setRemark(remark);
        int insert = matterLogMapper.insert(matterLogPO);
        log.info("insert: {}", insert);

    }

    @Override
    public String add(MatterLogDTO matterLog) {
        Date happenTime = matterLog.getHappenTime();
        List<MatterLogPO> matterLogPOS = matterLogMapper.listByUserIdAndHappenTime(matterLog.getUserId(),
                DateUtil.getStartTimeOfDay(happenTime),
                DateUtil.getEndTimeOfDay(happenTime),
                matterLog.getMType(),
                null);
        if (CollectionUtils.isNotEmpty(matterLogPOS)) {
            MatterLogPO matterLogOld = matterLogPOS.get(matterLogPOS.size() - 1);
            matterLogOld.setReachAmount(matterLog.getReachAmount());
            matterLogMapper.updateById(matterLogOld);
            return "已有记录，将为你更新原记录";
        }

        MatterLogPO matterLogPO = new MatterLogPO();
        BeanUtils.copyProperties(matterLog, matterLogPO);
        matterLogPO.setMType(matterLog.getMType());
        matterLogPO.setPartitionType(1);
        matterLogPO.setPartitionValue(DateFormatUtils.format(new Date(), CommonConst.PATTERN_YYYYMM));
        matterLogPO.setId(null);
        matterLogMapper.insert(matterLogPO);
        return "冷";
    }

    /**
     * 随机给出reachAmount值，给出unit字段信息
     *
     * @param matterLog
     */
    private void computeMatterLogRanch(MatterLogPO matterLog) {
        if (matterLog.getReachAmount() != null) {
            return;
        }
        if (MatterLogTypeEnum.STUDY.getCode().equals(matterLog.getMType())) {
            matterLog.setReachAmount(0d);
            matterLog.setReachAmountUnit(MatterLogTypeEnum.STUDY.getDefaultUnit());

        } else if (MatterLogTypeEnum.STEP_NUMBER.getCode().equals(matterLog.getMType())) {
            matterLog.setReachAmount(2000d + (100d * RandomUtils.nextInt(1, 10)));
            matterLog.setReachAmountUnit(MatterLogTypeEnum.STEP_NUMBER.getDefaultUnit());
        } else {
            matterLog.setReachAmount(0d);
        }
    }


    /**
     * mybatisPlus 用法
     * queryWrapper.in(R column, Object... values)
     */
}
