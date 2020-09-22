package com.gloryh.repository;

import com.gloryh.entity.Student;

/**
 * 学生实体类操作接口
 *
 * @author 黄光辉
 * @since 2020/9/19
 **/
public interface StudentRepository {
    public Student findById(long id);
    public Student findByIdLazy(long id);
}
