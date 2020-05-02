package com.wandou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wandou.mapper.CommodityMapper;
import com.wandou.model.dto.PageDTO;
import com.wandou.model.dto.req.ReqCommodityQueryDTO;
import com.wandou.model.dto.resp.RespCommodityDTO;
import com.wandou.model.po.CommodityPO;
import com.wandou.service.CommodityService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liming
 * @date 2020-05-02
 * @description
 */
@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public PageDTO<RespCommodityDTO> list(ReqCommodityQueryDTO reqCommodityQueryDTO) {
        CommodityPO commodityParam = new CommodityPO();
        commodityParam.setCommodityType(reqCommodityQueryDTO.getCommodityType());
        commodityParam.setMerchant(reqCommodityQueryDTO.getMerchant());
        QueryWrapper<CommodityPO> queryWrapper = new QueryWrapper<>(commodityParam);
        Page<CommodityPO> page = new Page<>(reqCommodityQueryDTO.getPageNo(), reqCommodityQueryDTO.getPageSize());
        page.setOptimizeCountSql(false);
        IPage<CommodityPO> pageResp = commodityMapper.selectPage(page, queryWrapper);
        if (pageResp == null || CollectionUtils.isEmpty(pageResp.getRecords())) {
            return null;
        }
        List<RespCommodityDTO> respList = new LinkedList<>();
        for (CommodityPO commodityPO : pageResp.getRecords()) {
            RespCommodityDTO respCommodityDTO = new RespCommodityDTO();
            BeanUtils.copyProperties(commodityPO, respCommodityDTO);
            respList.add(respCommodityDTO);
        }
        return new PageDTO<>(pageResp.getTotal(), respList);
    }
}
