package com.wandou.controller;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liming
 * @date 2020-03-25
 * @description 时间记录
 */

@RequestMapping("/matter_log")
@RestController
public class MatterLogController {

    @GetMapping("/list")
    public List<Object> list() {
        List<Object> matterLogs = new LinkedList<>();
        addList(matterLogs, "2020-03-16", 6);
        addList(matterLogs, "2020-03-17", 5);
        addList(matterLogs, "2020-03-18", 1);
        addList(matterLogs, "2020-03-19", 5.5);
        return matterLogs;
    }

    /**
     * 二维数组 list里加list
     */
    private void addList(List<Object> list, Object var1, Object var2) {
        list.add(Arrays.asList(var1, var2));
    }

}
