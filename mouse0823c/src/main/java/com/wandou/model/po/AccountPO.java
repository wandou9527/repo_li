package com.wandou.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * account
 *
 * @author lm 2019-11-02
 */

@Data
@TableName("account")
public class AccountPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 金额 单位分
     */
    private Long amount;

    /**
     * uid
     */
    private Long uid;

    /**
     * 记账种类
     */
    private Integer aType;

    /**
     * 备注用户界面输入的花费介绍
     */
    private String remark;

    /**
     * account_time
     */
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date accountTime;

    /**
     * create_time
     */
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date createTime;

    /**
     * update_time
     */
//    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private Date updateTime;

    /**
     * is_delete
     */
    private Integer isDelete;

    public AccountPO() {
    }

}
