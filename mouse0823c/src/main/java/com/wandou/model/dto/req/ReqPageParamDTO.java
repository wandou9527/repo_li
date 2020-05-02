package com.wandou.model.dto.req;

import lombok.Data;

/**
 * @author liming
 * @date 2020-05-02
 * @description
 */

@Data
public class ReqPageParamDTO {

    private Long pageNo;

    private Long pageSize;

    public Long getPageNo() {
        if (pageNo == null || pageNo < 0) {
            return 1L;
        }
        return pageNo;
    }

    public Long getPageSize() {
        if (pageSize == null || pageSize < 0) {
            return 10L;
        }
        return pageSize;
    }
}
