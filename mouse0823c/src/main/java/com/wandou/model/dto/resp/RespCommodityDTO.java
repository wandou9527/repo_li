package com.wandou.model.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author liming
 * @date 2020-05-02
 * @description
 */

@Data
public class RespCommodityDTO {
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Integer isDelete;
}
