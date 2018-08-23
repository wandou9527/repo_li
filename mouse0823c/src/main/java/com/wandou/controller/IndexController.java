package com.wandou.controller;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String indexWandou() {
        return "index";
    }

    @RequestMapping("/date")
    @ResponseBody
    public String m2() {
        return "今天日期时间是：" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.S");
    }
}
