package com.wandou.controller;

import com.wandou.model.dto.PageDTO;
import com.wandou.model.dto.req.ReqCommodityQueryDTO;
import com.wandou.model.dto.resp.RespCommodityDTO;
import com.wandou.model.vo.BaseRespVO;
import com.wandou.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liming
 * @date 2020-05-02
 * @description 商品
 */

@RequestMapping("/commodity")
@RestController
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @PostMapping("/list")
    public BaseRespVO list(@RequestBody ReqCommodityQueryDTO reqCommodityQueryDTO) {
        PageDTO<RespCommodityDTO> pageDTO = commodityService.list(reqCommodityQueryDTO);
        return BaseRespVO.success(pageDTO);
    }


}
