package com.wandou.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author liming
 * @date 2020-05-02
 * @description
 */

@TableName("commodity")
@Data
public class CommodityPO {
    private Long id;
    private Long skuNo;
    private Integer originalPrice;
    private String commodityName;
    private String title;
    private Integer price;
    private Integer stock;
    private Long merchant;
    private String tags;
    private Long category;
    private Integer commodityType;
    private Integer commodityStatus;
    private Integer reducedPrice;
    private String imgs;
    private Date updateTime;
    private Date createTime;
    private Integer isDelete;

}
