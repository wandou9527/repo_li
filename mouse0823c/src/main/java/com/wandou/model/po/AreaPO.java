package com.wandou.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liming
 * @date 2020-06-23
 * @description
 */

@Data
@TableName("area")
public class AreaPO implements Serializable {
    private Long id;

    private Long pid;

    private String areaName;

    private Date createTime;

}
