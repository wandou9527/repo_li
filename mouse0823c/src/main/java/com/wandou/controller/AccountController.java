package com.wandou.controller;

import com.wandou.model.po.AccountPO;
import com.wandou.model.vo.BaseRespVO;
import com.wandou.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 2019-11-02
 * 记账 controller
 */

@RequestMapping("account")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/list")
    public List<AccountPO> list() {
        return accountService.list();
    }

    @PostMapping
    public BaseRespVO insert(@RequestBody AccountPO accountPO) {
        if (accountPO.getUid() != 108) {
            return BaseRespVO.success("not ok");
        }
        boolean success = accountService.insert(accountPO);
        return BaseRespVO.success("ok");
    }

}
