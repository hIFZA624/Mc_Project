package com.example.wastemanagementsystem;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String Password;
    private String ConfirmPassword;
    private int Id;
    public User(String firstName, String lastName, String email,  String Password,String ConfirmPassword,int Id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.Password = Password;
        this.Id=Id;
        this.ConfirmPassword=ConfirmPassword;
    }
    public User(String firstName, String lastName, String email, int Id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        this.Id=Id;

    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return Password;
    }
    public int getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", Password='" + Password + '\'' +
                ", ConfirmPassword='" + ConfirmPassword + '\'' +
                ", Id=" + Id +
                '}';
    }
}
