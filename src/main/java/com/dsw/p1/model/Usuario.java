package com.dsw.p1.model;

public class Usuario {

    private int id;
    private String email;
    private String senha;
    private boolean admin;

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.admin = false;
    }

    public Usuario(String email, String senha, boolean admin) {
        this(email, senha);
        this.admin = admin;
    }

    public Usuario(int id, String email, String senha, boolean admin) {
        this(email, senha, admin);
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getAdmin() {
        return this.admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
