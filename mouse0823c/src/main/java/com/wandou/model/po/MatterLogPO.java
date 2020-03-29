package com.wandou.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author liming
 * @date 2020-03-26
 * @description
 */
@Data
@TableName("matter_log")
public class MatterLogPO {
    private Long id;

    private Long userId;

    private Date happenTime;

    private Integer mType;

    private Integer subType;

    private Double reachAmount;

    private String reachAmountUnit;

    private String partitionValue;

    private Integer partitionType;

    private String remark;

    private Date createTime;

    private Integer isDelete;
}
