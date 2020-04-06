package com.wandou.enumeration;

import lombok.Getter;

/**
 * @author liming
 * @date 2020-03-26
 * @description
 */
@Getter
public enum MatterLogTypeEnum {
    /**
     * 2020还款计划
     */
    T_1(1, "2020还款计划", ""),

    /**
     * 学习目标 h 小时
     */
    STUDY(2, "学习目标统计", "h"),

    STEP_NUMBER(3, "步数统计", "step");

    private Integer code;
    private String desc;
    private String defaultUnit;

    MatterLogTypeEnum(Integer code, String desc, String defaultUnit) {
        this.code = code;
        this.desc = desc;
        this.defaultUnit = defaultUnit;
    }

    public static boolean contains(Integer code) {
        if (code == null) {
            return false;
        }
        for (MatterLogTypeEnum m : values()) {
            if (code.equals(m.code)) {
                return true;
            }
        }
        return false;
    }
}
