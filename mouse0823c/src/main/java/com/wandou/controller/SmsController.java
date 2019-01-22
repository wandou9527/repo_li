package com.wandou.controller;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.wandou.service.SmsService;
import com.wandou.util.AliyunSmsUtil;
import com.wandou.util.GenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

/**
 * @author liming
 * @date 2018/8/26 10:48
 * @description
 */
@RequestMapping("/sms")
@Controller
public class SmsController {
    @Autowired
    private SmsService smsService;

//    @Value("${changliang.zhuru}")
//    private String changLiangZr;

    private static final String cipherBase = "7788";


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
                       @RequestParam(name = "type", required = false) Integer type,
                       @RequestParam("cipher") String cipher)
            throws ClientException {
        if (!cipherBase.equals(cipher)) {
            throw new RuntimeException("无权访问！");
        }

        System.out.println("请求 name: " + name + "; phone: " + phone);
//        System.out.println(changLiangZr + "----------");

        String templateCode = "";
        if (Objects.isNull(type)) {
            templateCode = "SecrecySmsConst.TEMPLATE_CODE_VERIFY_CODE";
        } else {
            switch (type) {
                case 1:
                    templateCode = "SecrecySmsConst.TEMPLATE_CODE_VERIFY_CODE";
                    break;
                case 2:
                    templateCode = "SecrecySmsConst.TEMPLATE_CODE_VERIFY_CODE";
                    break;
                default:
                    templateCode = "SecrecySmsConst.TEMPLATE_CODE_VERIFY_CODE";
                    break;
            }
        }


        SendSmsResponse sendSmsResponse = AliyunSmsUtil.sendSms(
                phone,
                name,
                GenUtil.genCode(4),
                content,
                templateCode,
                null);

//        return "wandou thanks your use!";
        return "<h3>wandou thanks your use!</h3>" + JSON.toJSONString(sendSmsResponse);
    }

    /**
     * 跳到短信页面
     *
     * @param modelAndView
     * @return
     */
    @GetMapping
    public String toSmsPage(ModelAndView modelAndView) {
        if (smsService.checkSmsreQuest()) {
            return "send_sms";
        }
        return "index";
    }
}
