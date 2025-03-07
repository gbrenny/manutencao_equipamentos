package main.java.model;

import java.util.Date;

public class Manutencao {
    private int id;
    private int equipamentoId;
    private Date dataManutencao;
    private String descricao;

    public Manutencao() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEquipamentoId() { return equipamentoId; }
    public void setEquipamentoId(int equipamentoId) { this.equipamentoId = equipamentoId; }

    public Date getDataManutencao() { return dataManutencao; }
    public void setDataManutencao(Date dataManutencao) { this.dataManutencao = dataManutencao; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
