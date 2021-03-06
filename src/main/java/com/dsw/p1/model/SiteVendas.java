package com.dsw.p1.model;

public class SiteVendas {

    private int id;
    private String url;
    private String nome;
    private String telefone;

    public SiteVendas(String url, String nome, String telefone) {
        this.url = url;
        this.nome = nome;
        this.telefone = telefone;
    }

    public SiteVendas(int id, String url, String nome, String telefone) {
        this(url, nome, telefone);
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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
