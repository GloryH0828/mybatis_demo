package com.gloryh.entity;

import lombok.Data;

/**
 * 学生实体类
 *
 * @author 黄光辉
 * @since 2020/9/19
 **/
@Data
public class Student {
    private long id;
    private String name;
    private Classes classes;
}
