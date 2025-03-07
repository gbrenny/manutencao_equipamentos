package controller;

import dao.ManutencaoDAO;
import model.Manutencao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@ManagedBean
@ViewScoped
public class ManutencaoBean implements Serializable {
    private Manutencao manutencao = new Manutencao();
    private List<Manutencao> listaManutencoes;
    private ManutencaoDAO dao = new ManutencaoDAO();

    public ManutencaoBean() {
        carregarManutencoes();
    }

    public void carregarManutencoes() {
        try {
            listaManutencoes = dao.listarManutencoes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarManutencao() {
        try {
            dao.adicionarManutencao(manutencao);
            manutencao = new Manutencao();
            carregarManutencoes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getters e Setters
    public Manutencao getManutencao() { return manutencao; }
    public void setManutencao(Manutencao manutencao) { this.manutencao = manutencao; }

    public List<Manutencao> getListaManutencoes() { return listaManutencoes; }
}
