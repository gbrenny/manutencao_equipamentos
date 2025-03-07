package controller;

import dao.EquipamentoDAO;
import model.Equipamento;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@ManagedBean
@ViewScoped
public class EquipamentoBean implements Serializable {
    private Equipamento equipamento = new Equipamento();
    private List<Equipamento> listaEquipamentos;
    private EquipamentoDAO dao = new EquipamentoDAO();

    public EquipamentoBean() {
        carregarEquipamentos();
    }

    public void carregarEquipamentos() {
        try {
            listaEquipamentos = dao.listarEquipamentos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarEquipamento() {
        try {
            dao.adicionarEquipamento(equipamento);
            equipamento = new Equipamento();
            carregarEquipamentos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getters e Setters
    public Equipamento getEquipamento() { return equipamento; }
    public void setEquipamento(Equipamento equipamento) { this.equipamento = equipamento; }

    public List<Equipamento> getListaEquipamentos() { return listaEquipamentos; }
}
