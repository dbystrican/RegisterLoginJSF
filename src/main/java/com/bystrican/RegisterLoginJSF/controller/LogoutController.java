package com.bystrican.RegisterLoginJSF.controller;

import com.bystrican.RegisterLoginJSF.model.SessionBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
//simply sets session bean id to -1 to indicate log out
public class LogoutController {
    @ManagedProperty(value="#{sessionBean}")
    private SessionBean sessionBean;
    public String onLogOut(){
        sessionBean.setLoggedUserId(-1);
        return "index.xhtml";
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
