package com.gloryh.test;

import com.gloryh.entity.Account;
import com.gloryh.repository.AccountRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * 测试mapper自定义接口
 *
 * @author 黄光辉
 * @since 2020/9/19
 **/
public class Test2 {
    public static void main(String[] args) {
        //加载MyBatis配置文件
        InputStream stream = Test.class.getClassLoader().getResourceAsStream("config.xml");

        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory=factoryBuilder.build(stream);
        SqlSession session=sessionFactory.openSession();
        //获取实现接口的代理对象
        AccountRepository accountRepository =session.getMapper(AccountRepository.class);
        //调用接口方法实现查询
        List<Account> accounts =accountRepository.findAll();
        for (Account account:accounts) {
            System.out.println(account);
        }
    }
}
