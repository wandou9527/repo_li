package com.wandou.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liming
 * @date 2020-05-02
 * @description
 */

@TableName("commodity")
@Data
public class CommodityPO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long skuNo;

    /**
     * 商品原价
     */
    private Integer originalPrice;

    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 标题
     */
    private String title;

    /**
     * 现价格单位：分
     */
    private Integer price;

    /**
     * 库存量
     */
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
     * 状态
     */
    private Integer commodityStatus;

    /**
     * 优惠价
     */
    private Long reducedPrice;

    /**
     * 图片
     */
    private String imgs;

    private Date updateTime;

    private Date createTime;

    private Integer isDelete;

}
