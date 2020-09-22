package com.gloryh.repository;

import com.gloryh.entity.Account;

import java.util.List;

/**
 * 自动定义 repository 接口
 *
 * @author 黄光辉
 * @since 2020/9/19
 **/
public interface  AccountRepository {
    public int save(Account account );
    public int update(Account account);
    public int deleteById( long id);
    public List<Account> findAll();
    public Account findById(long id);
    public Account findByAccount(Account account);
    public List<Account> findByIds(Account account );
}