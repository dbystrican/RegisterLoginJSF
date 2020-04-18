package com.bystrican.RegisterLoginJSF.model;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class Users implements Serializable {
    private List<User> users = new ArrayList<User>();

    public Users(List<User> users) {
        this.users = users;
    }

    public Users() {
        users.add(new User(1,"admin","admin","admin@jsf.com"));
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user){
        users.add(user);
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }
}
