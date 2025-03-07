import main.java.dao.UsuarioDAO;
import main.java.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class TestUsuarioDAO {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();

        try {
            // Testar a adição de um usuário
            Usuario user = new Usuario();
            user.setNome("Admintracao");
            user.setEmail("admin1@email.com");
            user.setSenha("adminadmin");
            user.setTipoUsuario("admin");

            dao.adicionarUsuario(user);
            System.out.println("Usuário adicionado com sucesso!");

            // Testar a listagem de usuários
            List<Usuario> usuarios = dao.listarUsuarios();
            for (Usuario u : usuarios) {
                System.out.println("ID: " + u.getId() + ", Nome: " + u.getNome() + ", Email: " + u.getEmail());
            }

            // Testar a validação de login
            boolean loginValido = dao.validarLogin("admin@email.com", "senha123");
            if (loginValido) {
                System.out.println("Login bem-sucedido!");
            } else {
                System.out.println("Falha no login! Verifique o email e senha.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
