package com.gloryh.entity;

import lombok.Data;

import java.util.List;

/**
 * 商品实体类
 *
 * @author 黄光辉
 * @since 2020/9/19
 **/
@Data
public class Goods {
    private long id;
    private String name;
    private List<Customer> customers;
}
