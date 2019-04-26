package org.dsw.model;

public class Teatro {
    private int id;
    private String cnpj;
    private String nome;
    private String cidade;

    public Teatro(int id, String cnpj, String nome, String cidade) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.cidade = cidade;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCNPJ() {
        return this.cnpj;
    }

    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
