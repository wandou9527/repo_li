package com.wandou;

import com.alibaba.fastjson.JSON;
import com.wandou.mapper.AccountMapper;
import com.wandou.mapper.TbCouponMapper;
import com.wandou.mapper.UserMapper;
import com.wandou.model.po.AccountPO;
import com.wandou.model.po.TbCouponPO;
import com.wandou.model.po.UserPO;
import com.wandou.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mouse0823cApplicationTests {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private TbCouponMapper tbCouponMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;


    @Test
    public void contextLoads() {
    }

    @Test
    public void accountTest() {
        AccountPO accountPO = accountMapper.selectById(1);
        System.out.println(accountPO);
    }

    @Test
    public void accountInsert() {
        for (int i = 0; i < 5; i++) {
            AccountPO accountPO = new AccountPO();
            accountPO.setUid(5L);
            accountPO.setAmount(RandomUtils.nextLong(1L, 10000L));
            accountPO.setAType(RandomUtils.nextInt(0, 10));
            accountPO.setRemark("买东西" + RandomStringUtils.randomAlphabetic(4));

            int insert = accountMapper.insert(accountPO);
            System.out.println(insert);

        }
        List<AccountPO> accountPOS = accountMapper.selectList(null);
        System.out.println(accountPOS);

    }

    @Test
    public void couponInsert() {
        TbCouponPO tbCouponPO = new TbCouponPO();
        tbCouponPO.setId(4);
        tbCouponPO.setCouponContent("啦啦啦卡券内容content");
        tbCouponPO.setCouponSum(8);
        tbCouponPO.setCouponType(1);
        Date date = new Date();
        tbCouponPO.setStartTime(date);
        tbCouponPO.setEndTime(date);
        tbCouponMapper.insert(tbCouponPO);
    }

    @Test
    public void m3User() {
        List<UserPO> userPOS = userMapper.selectBatchIds(Arrays.asList(1L));
        System.out.println(JSON.toJSONString(userPOS, true));
    }

    @Test
    public void m4() {
        userService.perfectUserInfo();
    }
}
