package com.wandou.enumeration;

/**
 * @author liming
 * @date 2020-03-26
 * @description
 */
public enum MatterLogTypeEnum {
    /**
     * 2020还款计划
     */
    T_1(1, "2020还款计划"),

    /**
     * 艳杰学习目标
     */
    T_2(2, "艳杰学习目标"),
    ;

    private Integer code;
    private String desc;

    MatterLogTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
