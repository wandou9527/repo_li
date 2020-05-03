package com.wandou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wandou.common.BizException;
import com.wandou.constant.ColumnConst;
import com.wandou.enumeration.ReturnCodeEnum;
import com.wandou.mapper.OrderMapper;
import com.wandou.model.dto.req.ReqSubmitOrderDTO;
import com.wandou.model.dto.resp.RespOrderDTO;
import com.wandou.model.po.CommodityPO;
import com.wandou.model.po.OrderPO;
import com.wandou.service.CommodityService;
import com.wandou.service.OrderService;
import com.wandou.util.RedisUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liming
 * @date 2020-05-03
 * @description
 */

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private CommodityService commodityService;

    @Override
    public Object test() {
        return orderMapper.selectList(null);
    }

    @Override
    public String submit(ReqSubmitOrderDTO submitOrderDTO) {
        CommodityPO commodity = commodityService.get(submitOrderDTO.getCid());
        if (commodity == null) {
            throw new BizException(ReturnCodeEnum.COMMODITY_INEXISTENCE);
        }
        OrderPO orderPO = new OrderPO();
        BeanUtils.copyProperties(submitOrderDTO, orderPO);
        if (orderPO.getPayPost() == null) {
            orderPO.setPayPost(0L);
        }
        if (orderPO.getCoinUsed() == null) {
            orderPO.setCoinUsed(0L);
        }
        orderPO.setOrderNo(redisUtil.randomIncId().toString());
        orderMapper.insert(orderPO);
        return orderPO.getOrderNo();
    }

    @Override
    public List<RespOrderDTO> list(Long uid, Integer oStatus) {
        OrderPO orderParam = new OrderPO();
        orderParam.setUid(uid);
        orderParam.setOStatus(oStatus);
        QueryWrapper<OrderPO> queryWrapper = new QueryWrapper<>(orderParam);
        queryWrapper.orderByDesc(ColumnConst.CREATE_TIME);
        List<OrderPO> orderPOS = orderMapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(orderPOS)) {
            return null;
        }
        List<RespOrderDTO> respList = new LinkedList<>();
        orderPOS.forEach(orderPO -> {
            RespOrderDTO respOrderDTO = new RespOrderDTO();
            BeanUtils.copyProperties(orderPO, respOrderDTO);
            respList.add(respOrderDTO);
        });
        return respList;
    }
}
