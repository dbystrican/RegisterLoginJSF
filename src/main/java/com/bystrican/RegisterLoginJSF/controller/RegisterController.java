package com.bystrican.RegisterLoginJSF.controller;

import com.bystrican.RegisterLoginJSF.model.User;
import com.bystrican.RegisterLoginJSF.model.Users;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;

@ManagedBean
@RequestScoped
public class RegisterController {
    @ManagedProperty(value="#{users}")
    private Users users;
    @ManagedProperty(value="#{user}")
    private User user;

    public RegisterController() {

    }
    //main register method
    public String onRegister(){
        if(validateRegisterData()) {
            user.setUserID(getNewUserID());
            users.addUser(user);
            System.out.println("User registredwith userID "+ user.getUserID());
        } else return "register.xhtml";
        System.out.println("Registered users "+users.getUsers());
        return "login.xhtml";
    }
    //logic behind registration
    private boolean validateRegisterData(){
        //check if all data inserted
        if(user.getUsername().isEmpty()||user.getEmail().isEmpty()||user.getPassword().isEmpty()){
            System.out.println("Not all fields filled");
            return false;
        }
        //check for same username, email across registered users
        for(User u: users.getUsers()){
            if(u.getEmail().equals(user.getEmail()) || u.getUsername().equals(user.getUsername())){
                System.out.println("user allready registrated");
                return false;
            }
        }
        System.out.println("Valid user registration");
        return true;
    }
    //gives user id 1 higher then the highest current one
    private int getNewUserID(){
        ArrayList<User> registeredUsers =(ArrayList<User>) users.getUsers();
        return registeredUsers.get(registeredUsers.size() - 1).getUserID()+1;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public RegisterController(Users users, User user) {
        this.users = users;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
