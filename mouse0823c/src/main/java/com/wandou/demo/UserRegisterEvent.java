package com.wandou.demo;

import com.wandou.model.po.UserPO;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;


@Getter
@ToString
public class UserRegisterEvent extends ApplicationEvent {
    //注册用户对象
    private UserPO user;

    /**
     * 重写构造函数
     *
     * @param source 发生事件的对象
     * @param user   注册用户对象
     */
    public UserRegisterEvent(Object source, UserPO user) {
        super(source);
        this.user = user;
    }
}
