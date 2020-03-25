package com.wandou.service;

import me.chanjar.weixin.common.error.WxErrorException;

public interface WXService {

    /**
     * 登录
     *
     * @param code
     * @param encryptedData
     * @param ivs
     * @param rawData
     * @param signature
     * @return
     */
    Object login(String code, String encryptedData, String ivs, String rawData, String signature) throws WxErrorException;
}
