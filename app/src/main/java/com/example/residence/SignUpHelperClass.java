package com.example.residence;

public class SignUpHelperClass {
    String user_name, email, phone_number, password_;

    public SignUpHelperClass() {
    }

    public SignUpHelperClass(String user_name, String email, String phone_number, String password_) {
        this.user_name = user_name;
        this.email = email;
        this.phone_number = phone_number;
        this.password_ = password_;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword_() {
        return password_;
    }

    public void setPassword_(String password_) {
        this.password_ = password_;
    }


}
