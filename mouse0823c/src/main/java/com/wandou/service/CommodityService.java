package com.wandou.service;

import com.wandou.model.dto.PageDTO;
import com.wandou.model.dto.req.ReqCommodityAddDTO;
import com.wandou.model.dto.req.ReqCommodityQueryDTO;
import com.wandou.model.dto.resp.RespCommodityDTO;
import com.wandou.model.po.CommodityPO;

/**
 * @author liming
 * @date 2020-05-02
 * @description
 */
public interface CommodityService {

    PageDTO<RespCommodityDTO> list(ReqCommodityQueryDTO reqCommodityQueryDTO);

    CommodityPO get(Long id);

    int updateById(CommodityPO commodity);

    int add(ReqCommodityAddDTO reqCommodityAddDTO);
}
