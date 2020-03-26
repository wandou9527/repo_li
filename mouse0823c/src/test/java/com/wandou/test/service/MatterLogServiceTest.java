package com.wandou.test.service;

import com.wandou.model.dto.MatterLogDTO;
import com.wandou.service.MatterLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author liming
 * @date 2020-03-26
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MatterLogServiceTest {
    @Autowired
    private MatterLogService matterLogService;


    @Test
    public void m1() {
        List<MatterLogDTO> list = matterLogService.list(0, 0);
        System.out.println("list = " + list);
    }


}