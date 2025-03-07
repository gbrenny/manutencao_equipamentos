package main.java.dao;

import main.java.model.Manutencao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoDAO {

    // Metodo para registrar uma manutenção
    public void adicionarManutencao(Manutencao manutencao) throws SQLException {
        String sql = "INSERT INTO manutencoes (equipamento_id, data_manutencao, descricao) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, manutencao.getEquipamentoId());
            stmt.setDate(2, new java.sql.Date(manutencao.getDataManutencao().getTime()));
            stmt.setString(3, manutencao.getDescricao());
            stmt.executeUpdate();
        }
    }

    // Metodo para listar todas as manutenções registradas
    public List<Manutencao> listarManutencoes() throws SQLException {
        List<Manutencao> manutencoes = new ArrayList<>();
        String sql = "SELECT * FROM manutencoes";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Manutencao manutencao = new Manutencao();
                manutencao.setId(rs.getInt("id"));
                manutencao.setEquipamentoId(rs.getInt("equipamento_id"));
                manutencao.setDataManutencao(rs.getDate("data_manutencao"));
                manutencao.setDescricao(rs.getString("descricao"));
                manutencoes.add(manutencao);
            }
        }
        return manutencoes;
    }
}
