package com.bystrican.RegisterLoginJSF.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {
    private int loggedUserId=-1;

    public SessionBean() {

    }

    public int getLoggedUserId() {
        return loggedUserId;
    }

    public void setLoggedUserId(int loggedUserId) {
        this.loggedUserId = loggedUserId;
    }
}
