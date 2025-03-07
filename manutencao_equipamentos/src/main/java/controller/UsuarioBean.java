package controller;

import dao.UsuarioDAO;
import model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {
    private Usuario usuario = new Usuario();
    private List<Usuario> listaUsuarios;
    private UsuarioDAO dao = new UsuarioDAO();

    public UsuarioBean() {
        carregarUsuarios();
    }

    public void carregarUsuarios() {
        try {
            listaUsuarios = dao.listarUsuarios();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarUsuario() {
        try {
            dao.adicionarUsuario(usuario);
            usuario = new Usuario();
            carregarUsuarios();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getters e Setters
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<Usuario> getListaUsuarios() { return listaUsuarios; }
}
