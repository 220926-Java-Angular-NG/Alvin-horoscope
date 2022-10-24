package com.revature.utils;

import java.util.List;

public interface CRUDDaoInterface<T> {
    int create(T t);//Creates the user

    //
    List<T> getAll();//Lists all the users

    T getById(int id);//Get the specific user

    T logIn(T t);//The user logs in

    T update(T t);//The user updates something about themselves

    boolean delete(T t);//Deletes the user

    boolean deleteById(int id);//Deletes the specific user
}
