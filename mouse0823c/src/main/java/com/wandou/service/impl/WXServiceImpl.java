package com.wandou.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.alibaba.fastjson.JSON;
import com.wandou.service.WXService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.annotation.Resource;

/**
 * @author liming
 */

@Slf4j
@Service
public class WXServiceImpl implements WXService {

    @Resource(name = "wandouiMaService")
    private WxMaService maService;

    @Override
    public Object login(String code, String encryptedData, String ivs, String rawData, String signature) throws WxErrorException {
        WxMaJscode2SessionResult sessionInfo = maService.getUserService().getSessionInfo(code);
        log.info("sessionInfo:{}", sessionInfo);

        if(!maService.getUserService().checkUserInfo(sessionInfo.getSessionKey(), rawData, signature)){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "user check failed");
        }

        WxMaUserInfo userInfo = maService.getUserService().getUserInfo(sessionInfo.getSessionKey(), encryptedData, ivs);
        log.info("userInfo:{}", JSON.toJSONString(userInfo));

//        mRedisRepository.setCache(sKey + userInfo.getOpenId(), sessionInfo.getSessionKey(), (int) DateUtil.DAY * 7);

//        return WechatUserInfo.builder()
//                .openId(userInfo.getOpenId())
//                .unionId(userInfo.getUnionId())
//                .nickname(userInfo.getNickName())
//                .headImgUrl(userInfo.getAvatarUrl())
//                .city(userInfo.getCity())
//                .province(userInfo.getProvince())
//                .country(userInfo.getCountry())
//                .sexId(Integer.valueOf(userInfo.getGender()))
//                .sex(userInfo.getGender().equals("0") ? "未知" : userInfo.getGender().equals("1") ? "男" : "女")
//                .build();

        return userInfo;
    }

//    @Override
//    public Object login() {
//        return null;
//    }
}
