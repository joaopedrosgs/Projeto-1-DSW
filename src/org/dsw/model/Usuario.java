package org.dsw.model;

public class Usuario {
    private int id;
    private String email;
    private String senha;

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario(int id, String email, String senha) {
        this(email, senha);
        this.id = id;
    }

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    public String getEmail() { return this.email; }

    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return this.senha; }

    public void setSenha(String senha) { this.senha = senha; }
}
