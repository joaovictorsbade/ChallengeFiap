package org.example.controller;

import org.example.model.Usuario;
import org.example.dao.UsuarioDAO;

public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    // Construtor para injeção de dependência
    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO(); // Usa o DAO sem conexão explícita
    }

    //CadastrarUsuario
    public void cadastrarUsuario(String nome, String email, String senha) {
        Usuario usuario = new Usuario(nome, email, senha);
        usuarioDAO.cadastrarUsuario(usuario);
    }
    //Login
    public void loginUsuario(String email, String senha) {
        Usuario usuario = new Usuario(email, senha);
        usuarioDAO.loginUsuario(usuario);
    }
    //EditarSenhaUsuario
    public void editarSenhaUsuario(String novaSenha) {
        usuarioDAO.editarSenhaUsuario(novaSenha);
    }
    //ExcluirUsuario
    public void excluirUsuario() {
        usuarioDAO.excluirUsuario();
    }
}
