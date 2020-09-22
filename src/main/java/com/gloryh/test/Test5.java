package com.gloryh.test;

import com.gloryh.entity.Account;
import com.gloryh.repository.AccountRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * 测试  MyBatis 缓存
 *
 * @author 黄光辉
 * @since 2020/9/21
 **/
public class Test5 {
    public static void main(String[] args) {
        //加载MyBatis配置文件
        InputStream stream = Test.class.getClassLoader().getResourceAsStream("config.xml");

        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = factoryBuilder.build(stream);
        SqlSession session = sessionFactory.openSession();

        AccountRepository accountRepository = session.getMapper(AccountRepository.class);
        Account account = accountRepository.findById(1L);
        System.out.println(account);
        session.close();
        SqlSession session1 = sessionFactory.openSession();
        accountRepository = session1.getMapper(AccountRepository.class);
        Account account1 = accountRepository.findById(1L);
        System.out.println(account1);
        session.close();
    }
}