package com.wandou.model.dto.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author liming
 * @date 2020-05-03
 * @description
 */

@Data
public class ReqSubmitOrderDTO {

    @NotNull(message = "uid 不能为空")
    private Long uid;

    /**
     * 商品id
     */
    @NotNull(message = "cid 商品id不能为空")
    private Long cid;

    private String remark;

    /**
     * 现金支付金额(分)
     */
    @NotNull(message = "payMoneyTotal 现金支付金额不能为空")
    private Long payMoneyTotal;

    /**
     * 运费 单位RMB分
     */
    private Long payPost;

    @NotEmpty(message = "address 地址不能为空")
    private String address;

    private Long addressId;

    /**
     * 商品数量
     */
    @NotNull(message = "num 购买数量不能为空")
    private Integer num;

    /**
     * 价格（订单总价格）
     */
    @NotNull(message = "price 订单总价不能为空")
    private Long price;

    /**
     * 积分使用
     */
    private Long coinUsed;
}
