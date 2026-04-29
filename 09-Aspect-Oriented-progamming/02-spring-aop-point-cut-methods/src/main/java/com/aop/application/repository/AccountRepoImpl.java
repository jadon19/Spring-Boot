package com.aop.application.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepoImpl implements AccountRepo{
    @Override
    public void addAccount() {
        System.out.println(getClass().getName()+" : Adding account to database\n");
    }
}
