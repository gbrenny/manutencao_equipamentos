package main.java.model;

import java.util.Date;

public class Equipamento {
    private int id;
    private String nome;
    private String descricao;
    private Date dataAquisicao;
    private double valor;
    private Date validade;

    // Construtor
    public Equipamento() {}

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Date getDataAquisicao() { return dataAquisicao; }
    public void setDataAquisicao(Date dataAquisicao) { this.dataAquisicao = dataAquisicao; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public Date getValidade() { return validade; }
    public void setValidade(Date validade) { this.validade = validade; }
}
