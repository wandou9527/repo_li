package com.wandou.controller;

import com.alibaba.fastjson.JSON;
import com.wandou.annotation.XParam;
import com.wandou.enumeration.XParamsType;
import com.wandou.model.dto.req.ReqSubmitOrderDTO;
import com.wandou.model.dto.resp.RespOrderDTO;
import com.wandou.model.vo.BaseRespVO;
import com.wandou.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liming
 * @date 2020-05-03
 * @description
 */

@Slf4j
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/submit")
    public BaseRespVO<String> submit(@XParam(XParamsType.UID) Long userId,
                                     @RequestBody @Validated ReqSubmitOrderDTO submitOrderDTO) {
        log.info("{} submit order req: {}", userId, JSON.toJSONString(submitOrderDTO));
        String orderNo = orderService.submit(submitOrderDTO, userId);
        return BaseRespVO.success(orderNo);
    }

    @GetMapping("/list")
    public BaseRespVO<List<RespOrderDTO>> list(@XParam(XParamsType.UID) Long userId,
                                               @RequestParam(name = "oStatus", required = false) Integer oStatus) {
        List<RespOrderDTO> orderList = orderService.list(userId, oStatus);
        return BaseRespVO.success(orderList);
    }

}
