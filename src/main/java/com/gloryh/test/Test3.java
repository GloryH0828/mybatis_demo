package com.gloryh.test;

import com.gloryh.entity.Student;
import com.gloryh.repository.AccountRepository;
import com.gloryh.repository.ClassesRepository;
import com.gloryh.repository.CustomerRepository;
import com.gloryh.repository.StudentRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * 级联测试
 *
 * @author 黄光辉
 * @since 2020/9/19
 **/
public class Test3 {
    public static void main(String[] args) {
        //加载MyBatis配置文件
        InputStream stream = Test.class.getClassLoader().getResourceAsStream("config.xml");

        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = factoryBuilder.build(stream);
        SqlSession session = sessionFactory.openSession();
        //获取实现接口的代理对象
        StudentRepository studentRepository = session.getMapper(StudentRepository.class);
      /*  ClassesRepository classesRepository =session.getMapper(ClassesRepository.class);*/
        /*CustomerRepository  customerRepository =session.getMapper(CustomerRepository.class);*/
        //调用接口方法实现查询
        Student student =studentRepository.findByIdLazy(1L);
        System.out.println(student.getClasses());
       /* System.out.println(classesRepository.findByIdLazy(student.getClasses().getId()));*/
       /* System.out.println(customerRepository.findById(1L));*/
        session.close();
    }
}
