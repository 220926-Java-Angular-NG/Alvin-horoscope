package com.revature.models;

public class CurrentUser {

    public static User currentUser;

    public CurrentUser(User user)
    {
        this.currentUser = user;
    }
    private CurrentUser()
    {}
}
