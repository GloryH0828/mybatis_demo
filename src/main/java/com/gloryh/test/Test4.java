package com.gloryh.test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Generator 执行的类 === 测试方法
 *
 * @author 黄光辉
 * @since 2020/9/19
 **/
public class Test4 {
    public static void main(String[] args) {
        List<String> warings =new ArrayList<String>();
        boolean overwirte =true;
        String generatorConfig="/generatorConfig.xml";
        File configFile =new File("E:\\Program Files\\IDEA Workspace\\mybatis_demo\\src\\main\\resources\\generatorConfig.xml");
        ConfigurationParser configurationParser =new ConfigurationParser(warings);
        Configuration configuration =null;
        try {
            configuration=configurationParser.parseConfiguration(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        }
        DefaultShellCallback callback =new DefaultShellCallback(overwirte);
        MyBatisGenerator myBatisGenerator=null;
        try {
            myBatisGenerator=new MyBatisGenerator(configuration,callback,warings);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        try {
            myBatisGenerator.generate(null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
