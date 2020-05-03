package com.wandou.controller;

import com.wandou.common.BizException;
import com.wandou.enumeration.ReturnCodeEnum;
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
    public BaseRespVO<String> submit(@RequestBody @Validated ReqSubmitOrderDTO submitOrderDTO) {
        String orderNo = orderService.submit(submitOrderDTO);
        return BaseRespVO.success(orderNo);
    }

    @GetMapping("/list")
    public BaseRespVO<List<RespOrderDTO>> list(@RequestHeader(name = "uid", required = false) Long uid,
                                               @RequestParam(name = "oStatus", required = false) Integer oStatus) {
        if (uid == null) {
            throw new BizException(ReturnCodeEnum.BAD_PARAM, "uid不可为空，在header传递");
        }
        List<RespOrderDTO> orderList = orderService.list(uid, oStatus);
        return BaseRespVO.success(orderList);
    }

}
