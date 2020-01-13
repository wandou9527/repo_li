package com.wandou.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * @author liming
 * @date 2018/9/29 15:30
 * @description https://www.cnblogs.com/HawkFalcon/p/7999583.html
 * @modify
 * @用法：在配置文件写好地址、密码、表
 * MybatisGenerator自动生成代码 (带自定义注释) https://blog.csdn.net/qigc_0529/article/details/80704330
 */

public class MybatisGen {

    public static void main(String[] args) throws Exception {
        try {
//            GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
//            generatorSqlmap.generator();
            new MybatisGen().generator();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void generator() throws Exception {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        //指定 逆向工程配置文件
        File configFile = new File("/Users/liming/Documents/java/java_self/git_site_self/repo_li/mbg/src/main/java/com/wandou/demo/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

    }

    // other: https://blog.csdn.net/travellersy/article/details/78620247

}