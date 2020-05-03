package com.wandou.common;

import com.wandou.enumeration.ReturnCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

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

    public BizException(ReturnCodeEnum returnCodeEnum, String message) {
        this.code = returnCodeEnum.getCode();
        if (StringUtils.isNotBlank(message)) {
            this.message = message;
        } else {
            this.message = returnCodeEnum.getMessage();
        }
    }

}
