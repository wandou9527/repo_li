package com.wandou.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * coupon
 *
 * @author lm 2020-01-22
 */

@Data
@TableName("tb_coupon")
public class TbCouponPO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer couponType;

    private String couponContent;

    private Date startTime;

    private Date endTime;

    private Integer couponSum;

    public TbCouponPO() {
    }

}
