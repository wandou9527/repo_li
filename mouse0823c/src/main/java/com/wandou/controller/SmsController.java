package com.wandou.controller;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.wandou.constant.SmsConst;
import com.wandou.util.AliyunSmsUtil;
import com.wandou.util.GenUtil;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * @author liming
 * @date 2018/8/26 10:48
 * @description
 */
@RequestMapping("/sms")
@Controller
public class SmsController {
    /**
     * 发短信
     *
     * @param phone
     * @param name
     * @param content
     * @param type    1验证码（仅需要phone）； 2节日的（需要phone、name、content）
     * @return
     * @throws ClientException
     */
    @ResponseBody
    @PostMapping
    public String send(@RequestParam(name = "phone") String phone,
                       @RequestParam("name") String name,
                       @RequestParam(name = "content", required = false) String content,
                       @RequestParam(name = "type", required = false) Integer type)
            throws ClientException {
        System.out.println("请求 name: " + name + ";phone: " + phone);

        String templateCode = "";
        if (Objects.isNull(type)) {
            templateCode = SmsConst.TEMPLATE_CODE_VERIFY_CODE;
        } else if (type == 1) {
            templateCode = SmsConst.TEMPLATE_CODE_VERIFY_CODE;
        } else if (type == 2) {
            templateCode = SmsConst.TEMPLATE_CODE_FESTIVAL;
        } else {
            templateCode = SmsConst.TEMPLATE_CODE_VERIFY_CODE;
        }

        SendSmsResponse sendSmsResponse = AliyunSmsUtil.sendSms(phone,
                name,
                GenUtil.genCode(4),
                content,
                templateCode);

//        return "wandou thanks your use!";
        return "<h4>wandou thanks your use!</h4>" + JSON.toJSONString(sendSmsResponse);
    }
}
