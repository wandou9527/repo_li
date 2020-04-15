package com.wandou.model.dto.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author liming
 * @date 2020-04-15
 * @description
 */

@Data
public class ReqLoginDTO {

    @NotBlank(message = "请输入用户名")
    private String username;

    @NotBlank(message = "请输入密码")
    private String password;

}
