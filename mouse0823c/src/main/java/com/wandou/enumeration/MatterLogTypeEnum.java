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
     * money相关
     * sub1 2020还款计划，累计已还款金额
     */
    T_1(1, "money相关", "fen"),

    /**
     * 学习目标 h 小时
     */
    STUDY(2, "学习目标统计", "h"),

    STEP_NUMBER(3, "运动与步数", "step"),

    WEIGHT(4, "体重", "kg"),

    /**
     * 工作
     */
    WORK(5, "工作", ""),

    /**
     * 生活
     * sub 0 理发
     * sub 1 喝酒
     */
    LIFE(6, "生活", ""),
    ;

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

    // ----------------------------------------
//    public enum SubType {
//
//        /**
//         * 累计已还款金额
//         */
//        TOTAL_REPAYMENT(1, "累计已还款金额", "fen"),
//        ;
//
//        private Integer code;
//        private String desc;
//        private String defaultUnit;
//
//        SubType(int code, String desc, String defaultUnit) {
//            this.code = code;
//            this.desc = desc;
//            this.defaultUnit = defaultUnit;
//        }
//    }
}
