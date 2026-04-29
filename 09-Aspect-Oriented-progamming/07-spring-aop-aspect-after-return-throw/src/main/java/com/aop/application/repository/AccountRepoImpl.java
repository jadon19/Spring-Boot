package com.aop.application.repository;

import com.aop.application.Account;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepoImpl implements AccountRepo{
    private List<Account> accountList;
    public AccountRepoImpl(){
        this.accountList = new ArrayList<>();
        Account acc1 = new Account("tanishka",2352358);
        Account acc2 = new Account("yashaswi",4323235);
        Account acc3 = new Account("deepali",4253453);
        accountList.add(acc1);
        accountList.add(acc2);
        accountList.add(acc3);
    }
    @Override
    public void addAccount() {
        System.out.println(getClass().getName()+" : Adding account to database\n");
    }

    @Override
    public List<Account> findAllAccounts() {
        return findAllAccounts(false);
    }

    @Override
    public List<Account> findAllAccounts(boolean flag) {
        if(flag){
//            throw exception
            throw new RuntimeException("No details for you , lol!");
        }
        System.out.println(accountList);
        return accountList;
    }


}
