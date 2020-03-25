package com.wandou.controller;

import com.wandou.service.WXService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liming
 * @date 2020-03-07
 */

@Slf4j
@RequestMapping("/wx")
@RestController
public class WXController {

    @Autowired
    private WXService wxService;

    @RequestMapping("/login")
    public Object login(@RequestParam String code,
                        @RequestParam String encryptedData,
                        @RequestParam String ivs,
                        @RequestParam String rawData,
                        @RequestParam String signature) throws WxErrorException {
        log.info(code);
        Object object = wxService.login(code, encryptedData, ivs, rawData, signature);
        return object;
    }


}
