package main.java.dao;

import main.java.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // Metodo para adicionar um novo usuário no banco de dados
    public void adicionarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, email, senha, tipo_usuario) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha()); // A senha pode ser criptografada antes de salvar
            stmt.setString(4, usuario.getTipoUsuario());
            stmt.executeUpdate();
        }
    }

    // Metodo para listar todos os usuários cadastrados
    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipoUsuario(rs.getString("tipo_usuario"));
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    // Metodo para verificar se um usuário existe no sistema (validação de login)
    public boolean validarLogin(String email, String senha) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Retorna true se encontrar um usuário com email e senha correspondentes
        }
    }
}
