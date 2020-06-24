package com.wandou.test;

import com.wandou.mapper.AreaMapper;
import com.wandou.model.po.AreaPO;
import com.wandou.util.ExcelUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liming
 * @date 2020-06-23
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBTest {

    @Autowired
    private AreaMapper areaMapper;

    @Test
    public void m1() throws IOException {
        File file = new File("/Users/liming/Documents/行政区划数据.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        List<Map<String, String>> data = ExcelUtil.getData(inputStream, true, Integer.MAX_VALUE);
        System.out.println("data = " + data);
        if (CollectionUtils.isEmpty(data)) {
            return;
        }
        for (int i = 0; i < data.size(); i++) {
            Map<String, String> map = data.get(i);
            AreaPO areaPO = new AreaPO();
            areaPO.setId(NumberUtils.toLong(map.get("code")));
            areaPO.setAreaName(StringUtils.deleteWhitespace(map.get("name")));
            areaMapper.insert(areaPO);
        }
    }

    /**
     * 这里的方式都没处理成功
     * areaName 处理前 =    石景山区
     * chars = [ ,  ,  , 石, 景, 山, 区]
     * bytes = [-62, -96, -62, -96, -62, -96, -25, -97, -77, -26, -103, -81, -27, -79, -79, -27, -116, -70]
     * areaName 处理后 =    石景山区
     */
    @Test
    public void m2() {
        List<AreaPO> areaPOS = areaMapper.selectList(null);
        for (AreaPO a : areaPOS) {
            String areaName = a.getAreaName();
            System.out.println("areaName 处理前 = " + areaName);
            char[] chars = areaName.toCharArray();
            System.out.println("chars = " + Arrays.toString(chars));
            byte[] bytes = areaName.getBytes();
            System.out.println("bytes = " + Arrays.toString(bytes));
            areaName = StringUtils.deleteWhitespace(areaName);
            areaName = areaName.trim();
            areaName = StringUtils.trim(areaName);
            areaName = areaName.replaceAll((char) -62 + "", "");
            areaName = areaName.replaceAll((char) -96 + "", "");
            System.out.println("areaName 处理后 = " + areaName);
            a.setAreaName(areaName);
            int updateRows = areaMapper.updateById(a);
            System.out.println("updateRows = " + updateRows);
        }
    }


    @Test
    public void trim() {
        List<AreaPO> areaPOS = areaMapper.selectList(null);
        for (AreaPO a :
                areaPOS) {
            doTrim(a);
        }
    }

    public void doTrim(AreaPO areaPO) {
        String areaName = areaPO.getAreaName();
        byte[] bytes = areaName.getBytes();
        List<Byte> list = new ArrayList<>();
        for (byte b :
                bytes) {
            list.add(b);
        }
        list = list.stream().filter(b -> b != -62 && b != -96).collect(Collectors.toList());
        int listSize = list.size();
        byte[] bytes1 = new byte[listSize];
        for (int i = 0; i < listSize; i++) {
            bytes1[i] = list.get(i);
        }
        areaName = new String(bytes1);
        System.out.println("areaName 处理后 = " + areaName);
        areaPO.setAreaName(areaName);
        int rows = areaMapper.updateById(areaPO);
        System.out.println("rows = " + rows);
    }

}
