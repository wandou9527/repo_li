package com.wandou.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author liming
 */

@AllArgsConstructor
@Data
@TableName("user")
public class UserPO {
    private Long id;

    private String username;

    private String phone;

    private String birth;

    private String wechat;

    private String realName;

    private Integer sex;

    private String nick;

    private String idcard;

    //密码
    private String password;

    private Date createTime;

    private Date updateTime;

    public UserPO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
