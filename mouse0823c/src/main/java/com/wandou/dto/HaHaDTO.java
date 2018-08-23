package com.wandou.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.HandlerMapping;

public class HaHaDTO {
    private Integer uid;
    private String uname;
    private Integer age;
    @Qualifier("viewControllerHandlerMapping")
    @Autowired
    private HandlerMapping viewControllerHandlerMapping;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public HaHaDTO() {
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getUid() {
        return uid;
    }

    public String getUname() {
        return uname;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "HaHaDTO{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", age=" + age +
                '}';
    }
}
