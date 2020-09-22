package com.gloryh.test;

import com.gloryh.entity.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * 测试类
 *
 * @author 黄光辉
 * @since 2020/9/17
 **/
public class Test {
    public static void main(String[] args) {
        //加载MyBatis配置文件
        InputStream stream = Test.class.getClassLoader().getResourceAsStream("config.xml");

        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory=factoryBuilder.build(stream);
        SqlSession session=sessionFactory.openSession();
        //namespace+id找到对应的方法
        String statement ="com.gloryh.mapper.AccountMapper.save";
        //实体化对象用于save
        Account account=new Account(1L,"张三","123",20,null);
        session.insert(statement,account);
        //执行save方法
        session.commit();
        //关闭资源
        session.close();
    }
}
