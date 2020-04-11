package com.wandou.controller;

import com.wandou.enumeration.MatterLogTypeEnum;
import com.wandou.model.dto.MatterLogDTO;
import com.wandou.model.vo.BaseRespVO;
import com.wandou.service.MatterLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liming
 * @date 2020-03-25
 * @description 事件记录，每个事件的记录比如一个小目标每天完成的时间，阶段完成的数额等等
 */

@Slf4j
@RequestMapping("/matter_log")
@RestController
public class MatterLogController {
    @Autowired
    private MatterLogService matterLogService;


    @GetMapping("/list/mock")
    public List<Object> listMock() {
        List<Object> matterLogs = new LinkedList<>();
        addList(matterLogs, "2020-03-16", 6);
        addList(matterLogs, "2020-03-17", 5);
        addList(matterLogs, "2020-03-18", 1);
        addList(matterLogs, "2020-03-19", 5.5);
        addList(matterLogs, "2020-03-20", 12);
        addList(matterLogs, "2020-03-21", 5);
        addList(matterLogs, "2020-03-22", 11);
        return matterLogs;
    }

    /**
     * 二维数组 list里加list
     */
    private void addList(List<Object> list, Object var1, Object var2) {
        list.add(Arrays.asList(var1, var2));
    }

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/list")
    public BaseRespVO<List<MatterLogDTO>> list(@RequestParam(name = "userId", required = false, defaultValue = "2") Long userId,
                                               @RequestParam(name = "mType", required = false, defaultValue = "2") Integer mType) {
        log.info("matter log list req userId: {}, mType: {}", userId, mType);
        List<MatterLogDTO> list = matterLogService.list(userId, mType);
        BaseRespVO<List<MatterLogDTO>> baseRespVO = BaseRespVO.success(list);
        return baseRespVO;
    }

    @PostMapping
    public BaseRespVO<Object> add(@RequestBody MatterLogDTO matterLog) {
        if (matterLog.getUserId() == null || matterLog.getUserId() > 40L) {
            return BaseRespVO.error("请添加自己的数据");
        }
        if (matterLog.getReachAmount() == null || matterLog.getReachAmount() > 20000d) {
            return BaseRespVO.error("请填写合理的数值");
        }
        if (matterLog.getMType() == null) {
            matterLog.setMType(MatterLogTypeEnum.STEP_NUMBER.getCode());
        }
        String addResult = matterLogService.add(matterLog);
        return BaseRespVO.success(addResult);
    }

}
