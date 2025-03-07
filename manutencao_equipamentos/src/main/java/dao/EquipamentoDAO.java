package main.java.dao;

import main.java.model.Equipamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO {

    // Metodo para adicionar um novo equipamento no banco de dados
    public void adicionarEquipamento(Equipamento equipamento) throws SQLException {
        String sql = "INSERT INTO equipamentos (nome, descricao, data_aquisicao, valor, validade) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, equipamento.getNome());
            stmt.setString(2, equipamento.getDescricao());
            stmt.setDate(3, new java.sql.Date(equipamento.getDataAquisicao().getTime()));
            stmt.setDouble(4, equipamento.getValor());
            stmt.setDate(5, new java.sql.Date(equipamento.getValidade().getTime()));
            stmt.executeUpdate();
        }
    }

    // Metodo para listar todos os equipamentos cadastrados
    public List<Equipamento> listarEquipamentos() throws SQLException {
        List<Equipamento> equipamentos = new ArrayList<>();
        String sql = "SELECT * FROM equipamentos";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Equipamento equipamento = new Equipamento();
                equipamento.setId(rs.getInt("id"));
                equipamento.setNome(rs.getString("nome"));
                equipamento.setDescricao(rs.getString("descricao"));
                equipamento.setDataAquisicao(rs.getDate("data_aquisicao"));
                equipamento.setValor(rs.getDouble("valor"));
                equipamento.setValidade(rs.getDate("validade"));
                equipamentos.add(equipamento);
            }
        }
        return equipamentos;
    }

    // Metodo para deletar um equipamento pelo ID
    public void deletarEquipamento(int id) throws SQLException {
        String sql = "DELETE FROM equipamentos WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
