package com.wandou.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wandou.constant.RedisConst;
import com.wandou.mapper.UserMapper;
import com.wandou.model.dto.req.ReqLoginDTO;
import com.wandou.model.po.UserPO;
import com.wandou.service.UserService;
import com.wandou.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author liming
 * @date 2020-04-04
 * @description
 */

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;


    @Override
    public void perfectUserInfo() {
        IPage<UserPO> pageParam = new Page<>(2, 10);
        ((Page<UserPO>) pageParam).setDesc("id");
        IPage<UserPO> pageResult = userMapper.selectPage(pageParam, null);
//        System.out.println("pageResult = " + pageResult);
//        System.out.println("pageResult = " + JSON.toJSONString(pageResult, true));
        if (pageResult == null || CollectionUtils.isEmpty(pageResult.getRecords())) {
            return;
        }
        List<UserPO> records = pageResult.getRecords();
        for (int i = 0; i < records.size(); i++) {
            UserPO userPO = records.get(i);
            if (StringUtils.isBlank(userPO.getUsername())) {
                List<UserPO> sameUsernameUsers;
                String username;
                do {
                    username = "1" + redisUtil.randomIncId();
                    //查询是否与已生成的id重复的 如重复重新生成
                    userPO.setUsername(username);
                    QueryWrapper<UserPO> queryWrapper = new QueryWrapper<>(userPO);
                    sameUsernameUsers = userMapper.selectList(queryWrapper);
                } while (!CollectionUtils.isEmpty(sameUsernameUsers));
                userPO.setUsername(username);
                userMapper.updateById(userPO);
                log.info("设置username: {}", JSON.toJSONString(userPO, true));

            }
        }
    }

    @Override
    public String login(ReqLoginDTO reqLoginDTO) {
        UserPO userParam = new UserPO(reqLoginDTO.getUsername(), reqLoginDTO.getPassword());
        QueryWrapper<UserPO> queryWrapper = new QueryWrapper<>(userParam);
        UserPO userPO = userMapper.selectOne(queryWrapper);
        if (userPO == null) {
            return null;
        }
        String token = userPO.getId() + UUID.randomUUID().toString();
        redisUtil.set(RedisConst.TOKEN_KEY + token, userPO.getId().toString(), 7L, TimeUnit.DAYS);
        return token;
    }

    @Override
    public UserPO getInfoById(Long userId) {
        return userMapper.selectById(userId);
    }
}

