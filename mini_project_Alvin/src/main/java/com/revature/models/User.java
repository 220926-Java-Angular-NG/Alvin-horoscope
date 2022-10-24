package com.revature.models;

public class User {

    private int userId;//Unique number for each user
    private String firstName;
    private String lastName;
    private String userName;
    private String pass_word;
    private String zodiac;
    private String mood;

    public User() {
    }

    public User(int userId, String pass_word) {
        this.userId = userId;
        this.pass_word = pass_word;
    }//For Log in

    public User(int userId) {
        this.userId = userId;
    }

    public User(int userId, String firstName, String lastName, String userName, String pass_word, String zodiac, String mood) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.pass_word = pass_word;
        this.zodiac = zodiac;
        this.mood = mood;
    }
    public User(int userId, String firstName, String lastName, String userName, String pass_word, String zodiac) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.pass_word = pass_word;
        this.zodiac = zodiac;
    }
    public User(String firstName, String lastName, String userName, String pass_word, String zodiac, String mood) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.pass_word = pass_word;
        this.zodiac = zodiac;
        this.mood = mood;
    }
    public User(String firstName, String lastName, String userName, String pass_word, String zodiac) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.pass_word = pass_word;
        this.zodiac = zodiac;
    }




    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPass_word() {
        return pass_word;
    }

    public String getZodiac() {
        return zodiac;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMood() {
        return mood;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", pass_word='" + pass_word + '\'' +
                ", zodiac='" + zodiac + '\'' +
                ", mood='" + mood + '\'' +
                '}';
    }
}
