package org.dsw.model;

import java.util.Date;

public class Promocao {
    private int id;
    private int siteId;
    private int teatroId;
    private String nome;
    private double preco;
    private Date diaHorario;

    private Promocao(int siteId, int teatroId, String nome, double preco) {
        this.siteId = siteId;
        this.teatroId = teatroId;
        this.nome = nome;
        this.preco = preco;
    }

    public Promocao(int siteId, int teatroId, String nome, double preco, Date diaHorario) {
        this(siteId, teatroId, nome, preco);
        this.diaHorario = diaHorario;
    }

    public Promocao(int siteId, int teatroId, String nome, double preco, int diaHorario) {
        this(siteId, teatroId, nome, preco);
        this.diaHorario = new Date((long) 1000 * diaHorario);
    }

    public Promocao(int id, int siteId, int teatroId, String nome, double preco, Date diaHorario) {
        this(siteId, teatroId, nome, preco, diaHorario);
        this.id = id;
    }

    public Promocao(int id, int siteId, int teatroId, String nome, double preco, int diaHorario) {
        this(siteId, teatroId, nome, preco, diaHorario);
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSiteId() {
        return this.siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getTeatroId() {
        return this.teatroId;
    }

    public void setTeatroId(int teatroId) {
        this.teatroId = teatroId;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getDiaHorario() {
        return this.diaHorario;
    }

    public void setDiaHorario(Date diaHorario) {
        this.diaHorario = diaHorario;
    }

    public void setDiaHorario(int diaHorario) {
        this.diaHorario = new Date((long) 1000 * diaHorario);
    }

    public int getDiaHorarioTimestamp() {
        return (int) this.diaHorario.getTime() / 1000;
    }
}
