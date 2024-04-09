package com.alilopez.application.models;

import com.alilopez.application.App;

public class Login {
    private String adminId = "admin";
    private String adminPassword = "123";
    private String id;
    private String password;
    private short access;

    public short checkLogin(String id, String password){
        access = 0;
        this.id = id;
        boolean flag = false;
        if (adminId.equals(id) && adminPassword.equals(password)){
            access = 1;
            flag = true;
        }
        if (!flag) {
            for (int i = 0; i < App.getTienda().getUsuarios().size(); i++) {
                Usuario user = App.getTienda().getUsuarios().get(i);
                if (id.equals(user.getIdUsuario()) && password.equals(user.getPassword())) {
                    if (user.getCargo().equals("Capturista")) {
                        access = 2;
                    } else if (user.getCargo().equals("Empleado")) {
                        access = 3;
                    }
                }
            }
        }
        return access;
    }

    public short getAcess() {
        return access;
    }

    public String getId() {
        return id;
    }
}
