package com.wandou.model.dto.req;

import lombok.Data;

/**
 * @author liming
 * @date 2020-05-02
 * @description
 */

@Data
public class ReqCommodityQueryDTO extends ReqPageParamDTO {
    private Long merchant;
    private Integer commodityType;
}
