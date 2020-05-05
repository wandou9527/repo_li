package com.wandou.model.dto.req;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author liming
 * @date 2020-05-05
 * @description
 */

@Data
public class ReqCommodityAddDTO {
    /**
     * 商品原价
     */
    @Min(value = 1, message = "originalPrice 值不合适，需大于0")
    @NotNull(message = "originalPrice 原价不可为空")
    private Integer originalPrice;

    /**
     * 商品名称
     */
    @NotEmpty(message = "commodityName 商品名称不可为空")
    private String commodityName;

    /**
     * 标题
     */
    @NotEmpty(message = "title 标题不可为空")
    private String title;

    /**
     * 现价格单位：分
     */
    @Min(value = 1, message = "price 值不合适")
    @NotNull(message = "price 现价不可为空")
    private Integer price;

    /**
     * 库存量
     */
    @Min(value = 1, message = "stock 库存值不合适，需大于0")
    @NotNull(message = "stock 库存量不可为空")
    private Integer stock;

    /**
     * 商家
     */
    private Long merchant;

    /**
     * 标签
     */
    private String tags;

    /**
     * 商品分类 例如家电手机等
     */
    private Long category;

    /**
     * 商品类型 是否是活动商品等
     */
    private Integer commodityType;

    /**
     * 优惠价
     */
    @Min(value = 1, message = "reducedPrice 优惠价值不合适，需大于0")
    private Long reducedPrice;

    /**
     * 图片
     */
    private String imgs;

}
