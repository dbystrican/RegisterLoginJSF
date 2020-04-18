package com.bystrican.RegisterLoginJSF.controller;

import com.bystrican.RegisterLoginJSF.model.SessionBean;
import com.bystrican.RegisterLoginJSF.model.User;
import com.bystrican.RegisterLoginJSF.model.Users;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LoginController {
    @ManagedProperty(value="#{users}")
    private Users users;
    @ManagedProperty(value="#{user}")
    private User user;
    @ManagedProperty(value="#{sessionBean}")
    private SessionBean sessionBean;
    public String onLogin(){
        for(User u : users.getUsers()){
            if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())){
                sessionBean.setLoggedUserId(u.getUserID());
                return "index.xhtml";
            }
        }
        return "login.xhtml";
    }

    public LoginController() {
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
