package com.aop.application.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipRepoImpl implements MembershipRepo{
    @Override
    public void addAccount() {
        System.out.println(getClass().getName()+" : Adding member to database\n");
    }
}
