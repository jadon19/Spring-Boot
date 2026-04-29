package com.aop.application.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepoImpl implements AccountRepo{
    @Override
    public void addAccount(int id, String name) {
        System.out.println("Adding account to database\n");
        System.out.println("id: "+id);
        System.out.println("Name: "+ name);
    }
}
