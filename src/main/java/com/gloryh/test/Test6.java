package com.gloryh.test;

import com.gloryh.entity.Account;
import com.gloryh.repository.AccountRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 动态 SQL 测试类
 *
 * @author 黄光辉
 * @since 2020/9/22
 **/
public class Test6 {
    public static void main(String[] args) {
        //加载MyBatis配置文件
        InputStream stream = Test.class.getClassLoader().getResourceAsStream("config.xml");

        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = factoryBuilder.build(stream);
        SqlSession session = sessionFactory.openSession();
        //获取实现接口的代理对象
        AccountRepository accountRepository = session.getMapper(AccountRepository.class);
        //调用接口方法实现查询
        Account account = new Account();
        List<Long> ids=new ArrayList<Long>();
        ids.add(1L);
        ids.add(2L);
        account.setIds(ids);
        System.out.println( accountRepository.findByIds(account));
        session.close();
    }
}
