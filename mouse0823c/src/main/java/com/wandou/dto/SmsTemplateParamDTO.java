package com.wandou.dto;

/**
 * @author liming
 * @date 2018/8/25 18:47
 * @description
 */
public class SmsTemplateParamDTO {
    private String name;
    private String code;
    private String content;

    public SmsTemplateParamDTO() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
