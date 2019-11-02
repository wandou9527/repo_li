package com.wandou.service;

import com.wandou.mapper.AccountMapper;
import com.wandou.model.po.AccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public List<AccountPO> list() {
        List<AccountPO> accountPOS = accountMapper.selectList(null);
        return accountPOS;
    }

    public boolean insert(AccountPO accountPO) {
        int insert = accountMapper.insert(accountPO);
        return insert == 1;
    }
}
