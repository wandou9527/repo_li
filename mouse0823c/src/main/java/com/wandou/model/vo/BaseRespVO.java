package com.wandou.model.vo;

import lombok.Data;

@Data
public class BaseRespVO<T> {
    private String code;
    private String message;
    private T data;

    public static <T> BaseRespVO success(T data) {
        BaseRespVO<T> baseRespVO = new BaseRespVO<>();
        baseRespVO.setCode("2000");
        baseRespVO.setMessage("success");
        baseRespVO.setData(data);
        return baseRespVO;
    }
}
