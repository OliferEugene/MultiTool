package company.controllers;
/*
Project Task 21 (GUI JavaFx) was created by Eugene Oliferenko 01.10.18
Class User was created in 10:24 01.10.18
© 2018 Olifer. All rights reserved. All trademarks are the property of their respective.
*/

public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String country;
    private String language;
    private String email;
    private String gender;

    public User(String firstName, String lastName, String userName,
                String password, String country, String language,
                String email, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.language = language;
        this.email = email;
        this.gender = gender;
    }

    public User() { }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
