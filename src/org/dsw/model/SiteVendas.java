package org.dsw.model;

public class SiteVendas {
    private int id;
    private String email;
    private String senha;
    private String url;
    private String nome;
    private String telefone;

    public SiteVendas(int id) {
        this.id = id;
    }

    public SiteVendas(String email, String senha, String url, String nome, String telefone) {
        this.email = email;
        this.senha = senha;
        this.url = url;
        this.nome = nome;
        this.telefone = telefone;
    }

    public SiteVendas(int id, String email, String senha, String url, String nome, String telefone) {
        this(email, senha, url, nome, telefone);
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

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
