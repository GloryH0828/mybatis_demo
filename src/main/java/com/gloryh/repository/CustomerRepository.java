package com.gloryh.repository;

import com.gloryh.entity.Customer;

/**
 * 客户实体类操作接口
 *
 * @author 黄光辉
 * @since 2020/9/19
 **/
public interface CustomerRepository {
    public Customer findById(long id);
}
