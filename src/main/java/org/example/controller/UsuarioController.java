package org.example.controller;

import org.example.bo.UsuarioBO;
import org.example.model.Usuario;

public class UsuarioController {

    private UsuarioBO usuarioBO;

    public UsuarioController() {
        this.usuarioBO = new UsuarioBO();
    }

    public void cadastrarUsuario(String nome, String email, String senha) {
        Usuario usuario = usuarioBO.cadastrarUsuario(nome, email, senha);
        if (usuario != null) {
            System.out.println("Usuário cadastrado com sucesso.");
        } else {
            System.out.println("Erro ao cadastrar o usuário.");
        }
    }

    public void loginUsuario(String email, String senha) {
        Usuario usuario = usuarioBO.loginUsuario(email, senha);
        if (usuario != null) {
            System.out.println("Usuário logado com sucesso.");
        } else {
            System.out.println("Erro ao realizar login.");
        }
    }

    public void editarSenhaUsuario(String novaSenha) {
        boolean resultado = usuarioBO.editarSenhaUsuario(novaSenha);
        if (resultado) {
            System.out.println("Senha alterada com sucesso.");
        } else {
            System.out.println("Erro ao alterar a senha.");
        }
    }

    public void excluirUsuario() {
        boolean resultado = usuarioBO.excluirUsuario();
        if (resultado) {
            System.out.println("Usuário excluído com sucesso.");
        } else {
            System.out.println("Erro ao excluir o usuário.");
        }
    }
}
