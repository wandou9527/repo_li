package com.wandou.common;

import com.wandou.enumeration.ReturnCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liming
 * @date 2020-04-15
 * @description
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BizException extends RuntimeException {

    private String code;

    private String message;

    public BizException(ReturnCodeEnum returnCodeEnum) {
        this.code = returnCodeEnum.getCode();
        this.message = returnCodeEnum.getMessage();
    }

}
