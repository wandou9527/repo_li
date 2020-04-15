package com.wandou.config;

import com.wandou.common.BusinessException;
import com.wandou.enumeration.ReturnCodeEnum;
import com.wandou.model.vo.BaseRespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandler {

    /**
     * 处理所有接口数据验证异常
     *
     * @param e
     * @return
     */
    @SuppressWarnings("rawtypes")
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseRespVO handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.info("controller入参校验失败！方法:{} 提示信息:{}", e.getParameter().getMethod().getName(), e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return BaseRespVO.error(ReturnCodeEnum.BAD_PARAM.getCode(), e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }


    /**
     * 处理所有接口数据验证异常
     *
     * @param e
     * @return
     */
    @SuppressWarnings("rawtypes")
    @org.springframework.web.bind.annotation.ExceptionHandler(BindException.class)
    @ResponseBody
    public BaseRespVO bindException(BindException e) {
        log.info("controller入参校验失败！方法：{}", e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return BaseRespVO.error(ReturnCodeEnum.BAD_PARAM.getCode(), e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }


    /**
     * 自定义异常
     *
     * @param e
     * @return
     */
    @SuppressWarnings("rawtypes")
    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    @ResponseBody
    public BaseRespVO handleTradeException(BusinessException e) {
        log.error("BusinessException: ", e);
        return BaseRespVO.error(e.getCode(), e.getMessage());
    }


    @SuppressWarnings("rawtypes")
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseRespVO exceptionHandler(Exception e) {
        log.error("发生异常Exception ", e);
        return BaseRespVO.error();
    }
}
