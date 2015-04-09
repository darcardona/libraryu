package com.darcardona.libraryu.model.account;


import java.time.LocalDateTime;

/**
 * Created by dar on 11/22/14.
 */
public class Account {

    private AccountState state;
    private LocalDateTime openingDate;
    private User user;

    public Account(User user) {
        this.state = AccountState.OPENED;
        this.openingDate = LocalDateTime.now();
        this.user = user;
    }

    public AccountState getState() {
        return state;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDateTime openingDate) {
        this.openingDate = openingDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}