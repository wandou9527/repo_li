package com.wandou.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author liming
 * @date 2020-03-26
 * @description
 */
@Data
public class MatterLogDTO {
    private Long id;

    private Long userId;

    private Date happenTime;

    private String happenDate;

    private Integer mType;

    private Integer subType;

    private Double reachAmount;

    private String reachAmountUnit;

}
