package com.wandou.enumeration;

import lombok.Getter;

/**
 * @author liming
 * @date 2020-04-11
 * @description
 */

@Getter
public enum ReturnCodeEnum {
    /**
     * 成功
     */
    SUCCESS("2000", "成功"),

    BAD_PARAM("4001", "参数错误"),

    BAD_REQUEST("4002", "错误的请求"),

    BAD_USERNAME_OR_PASSWORD("4003", "用户名或密码错误"),

    BAD_TOKEN("4005", "token无效"),

    COMMODITY_INEXISTENCE("4006", "商品不存在"),

    ERROR("5000", "网络开小差，请稍后再试~"),
    ;

    private final String code;
    private final String message;

    ReturnCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
