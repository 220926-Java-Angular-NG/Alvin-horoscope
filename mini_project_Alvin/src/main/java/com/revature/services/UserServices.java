package com.revature.services;

import com.revature.models.User;
import com.revature.repos.UserRepo;

import java.util.List;

public class UserServices {
    private UserRepo userRepo;

    public UserServices() {
        userRepo = new UserRepo();
    }

    public UserServices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public int createUser(User user) {
        return userRepo.create(user);
    }

    public List<User> getAllUsers() {
        return userRepo.getAll();
    }

    public User getUserById(int id) {
        return userRepo.getById(id);
    }

    public User logInUser(User user) {
        return userRepo.logIn(user);
    }

    public User updateUser(User user)
    {
        return userRepo.update(user);
    }
    public boolean deleteUser(User user)
    {
        return userRepo.delete(user);
    }
    public boolean deleteUserById(int id)
    {
        return userRepo.deleteById(id);
    }
}
