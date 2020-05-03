package com.wandou.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author liming
 * @date 2020-05-03
 * @description
 */

@TableName("a_order")
@Data
public class OrderPO {
    private Long id;

    /**
     * 订单唯一编号
     */
    private String orderNo;

    private Long uid;

    /**
     * 商品id
     */
    private Long cid;

    private String remark;

    private Integer oStatus;

    /**
     * 支付单号
     */
    private String payNo;

    /**
     * 现金支付金额(分)
     */
    private Long payMoneyTotal;

    /**
     * 运费 单位RMB分
     */
    private Long payPost;

    private Long payTime;

    private String address;

    private Long addressId;

    /**
     * 取消原因
     */
    private String cancelReason;

    /**
     * 商品数量
     */
    private Integer num;

    /**
     * 价格（订单总价格）
     */
    private Long price;

    /**
     * 积分使用
     */
    private Long coinUsed;

    /**
     * 版本号，乐观锁，修改请where版本号并且set version+1
     */
    private Integer version;


    private String backRemark;

    private Integer oType;

    private Date createTime;

    private Date updateTime;

    private Integer isDelete;

}
