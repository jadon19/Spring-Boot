package com.aop.application.repository;

import com.aop.application.Account;

import java.util.List;

public interface AccountRepo {
    void addAccount();
    List<Account> findAllAccounts();
}
