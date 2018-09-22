package com.wandou.service;

import com.wandou.constant.NameConst;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.EAN;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author liming
 * @date 2018/9/22 16:23
 * @description
 */
@Service
public class C2Service {

    private static final List list = Arrays.asList("曲艳杰", "甜甜");

    public String paris(String name) {
        if (list.contains(name)) {
            return "美丽的我，果然漂亮哦！";
        } else if (StringUtils.isBlank(name)) {
            return "你一定如" + NameConst.shuffleList(NameConst.jinSwordsmans).get(0) + "一样潇洒！";
        }
        return "hehe！ " + NameConst.shuffleList(NameConst.jinSwordsmans).get(0) + "为你折服！";
    }


}
