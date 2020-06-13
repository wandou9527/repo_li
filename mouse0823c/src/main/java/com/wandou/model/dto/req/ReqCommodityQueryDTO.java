package com.wandou.model.dto.req;

import lombok.Data;

/**
 * @author liming
 * @date 2020-05-02
 * @description
 */

@Data
public class ReqCommodityQueryDTO extends ReqPageParamDTO {

    /**
     * 商家
     */
    private Long merchant;

    /**
     * 商品类型
     */
    private Integer commodityType;
}
