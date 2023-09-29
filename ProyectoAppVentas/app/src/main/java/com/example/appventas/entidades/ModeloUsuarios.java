package com.example.appventas.entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ModeloUsuarios implements Serializable {
    private int USERID;
    private String USERNAME;
    private String USERPASSWORD;

    public ModeloUsuarios() {}

    public ModeloUsuarios(int userID, String userName, String password) {
        this.USERID = userID;
        this.USERNAME = userName;
        this.USERPASSWORD = password;
    }

    public ModeloUsuarios(String userName, String password) {
        this.USERNAME = userName;
        this.USERPASSWORD = password;
    }

    public int getUserID() {
        return USERID;
    }

    public String getUserName() {
        return USERNAME;
    }

    public String getPassword() {
        return USERPASSWORD;
    }
}
