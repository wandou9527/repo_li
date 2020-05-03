package com.wandou.controller;

import com.wandou.annotation.XParam;
import com.wandou.enumeration.XParamsType;
import com.wandou.model.dto.req.ReqSubmitOrderDTO;
import com.wandou.model.dto.resp.RespOrderDTO;
import com.wandou.model.vo.BaseRespVO;
import com.wandou.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liming
 * @date 2020-05-03
 * @description
 */

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/submit")
    public BaseRespVO<String> submit(@XParam(XParamsType.UID) Long userId,
                                     @RequestBody @Validated ReqSubmitOrderDTO submitOrderDTO) {
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
