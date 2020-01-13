package com.wandou.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserPO {
    //用户名
    private String name;
    //密码
    private String password;
}
