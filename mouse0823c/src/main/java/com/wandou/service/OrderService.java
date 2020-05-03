package com.wandou.service;

import com.wandou.model.dto.req.ReqSubmitOrderDTO;
import com.wandou.model.dto.resp.RespOrderDTO;

import java.util.List;

/**
 * @author liming
 * @date 2020-05-03
 * @description
 */
public interface OrderService {
    Object test();

    /**
     * 提交订单
     *
     * @param submitOrderDTO
     * @return
     */
    String submit(ReqSubmitOrderDTO submitOrderDTO);

    List<RespOrderDTO> list(Long uid, Integer oStatus);
}
