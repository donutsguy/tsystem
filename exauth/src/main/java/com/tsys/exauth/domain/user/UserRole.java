package com.tsys.exauth.domain.user;

public enum UserRole {
    ADMIN("admin"),

    RECEPCIONISTA("recepcionista"),

    PACIENTE("paciente"),

    MEDICO("medico");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    String getRole(){
        return this.role;
    }
}
