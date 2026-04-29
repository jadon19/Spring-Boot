package com.aop.application.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepoImpl implements AccountRepo{
    private String name;
    private long accountNumber;

    @Override
    public void addAccount() {
        System.out.println(getClass().getName()+" : Adding account to database\n");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
}
