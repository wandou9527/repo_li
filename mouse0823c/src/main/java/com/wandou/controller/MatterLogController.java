package com.wandou.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        matterLogs.add("2020-03-16");
        matterLogs.add(6);
        matterLogs.add("2020-03-17");
        matterLogs.add(5);
        matterLogs.add("2020-03-18");
        matterLogs.add(1);
        matterLogs.add("2020-03-25");
        matterLogs.add(5.5);
        return matterLogs;
    }

}
