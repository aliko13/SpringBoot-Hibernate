package com.example.springdata_hibernate.entity.table_per_class;

import javax.persistence.*;

@Entity
public class Twitter extends Post {

    @Column(name = "account_name")
    private String accountName;
    private int followers = 0;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }
}
