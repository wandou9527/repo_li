package com.wandou.model.vo;

import com.wandou.enumeration.ReturnCodeEnum;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @param <T>
 * @author liming
 * @date 2019
 */

@Data
public class BaseRespVO<T> {
    private String code;
    private String message;
    private T data;

    public static <T> BaseRespVO<T> success(T data) {
        BaseRespVO<T> baseRespVO = new BaseRespVO<>();
        baseRespVO.setCode(ReturnCodeEnum.SUCCESS.getCode());
        baseRespVO.setMessage(ReturnCodeEnum.SUCCESS.getMessage());
        baseRespVO.setData(data);
        return baseRespVO;
    }

    public static <T> BaseRespVO<T> error(String message) {
        BaseRespVO<T> baseRespVO = new BaseRespVO<>();
        baseRespVO.setCode(ReturnCodeEnum.ERROR.getCode());
        if (StringUtils.isNotBlank(message)) {
            baseRespVO.setMessage(message);
        } else {
            baseRespVO.setMessage(ReturnCodeEnum.ERROR.getMessage());
        }
        baseRespVO.setData(null);
        return baseRespVO;
    }

    public static <T> BaseRespVO<T> error() {
        return error("");
    }

    public static <T> BaseRespVO<T> error(ReturnCodeEnum returnCodeEnum) {
        BaseRespVO<T> baseRespVO = new BaseRespVO<>();
        baseRespVO.setCode(returnCodeEnum.getCode());
        baseRespVO.setMessage(returnCodeEnum.getMessage());
        baseRespVO.setData(null);
        return baseRespVO;
    }
}
