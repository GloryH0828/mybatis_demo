package com.gloryh.repository;

import com.gloryh.entity.Classes;

/**
 * 班级实体类操作接口
 *
 * @author 黄光辉
 * @since 2020/9/19
 **/
public interface ClassesRepository {
    public Classes findById(long id);
    public Classes findByIdLazy(long id);
}
