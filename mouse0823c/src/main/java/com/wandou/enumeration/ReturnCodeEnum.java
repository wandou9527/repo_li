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

    ERROR("5000", "网络开小差，请稍后再试~");

    private String code;
    private String message;

    ReturnCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
