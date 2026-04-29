package com.aop.application.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepoImpl implements AccountRepo{

    @Override
    public void getFortune() {
        System.out.println("Fetching your fortune!\n");
        System.out.println("Yes you are luckyyyyy!\n\n");
    }
}
