package org.example.controller;

import org.example.model.Usuario;
import org.example.dao.UsuarioDAO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Permite chamadas do front-end rodando em localhost:3000
@RequestMapping("/usuarios") // Define o caminho base para os endpoints
public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    // Construtor para injeção de dependência
    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO(); // Usa o DAO sem conexão explícita
    }

    // Cadastrar novo usuário
    @PostMapping("/cadastro")
    public void cadastrarUsuario(@RequestParam String nome, @RequestParam String email, @RequestParam String senha) {
        Usuario usuario = new Usuario(nome, email, senha);
        usuarioDAO.cadastrarUsuario(usuario);
    }

    // Login de usuário
    @PostMapping("/login")
    public void loginUsuario(@RequestParam String email, @RequestParam String senha) {
        Usuario usuario = new Usuario(email, senha);
        usuarioDAO.loginUsuario(usuario);
    }

    // Editar senha de um usuário
    @PutMapping("/editar-senha")
    public void editarSenhaUsuario(@RequestParam String novaSenha) {
        usuarioDAO.editarSenhaUsuario(novaSenha);
    }

    // Excluir usuário
    @DeleteMapping("/excluir")
    public void excluirUsuario() {
        usuarioDAO.excluirUsuario();
    }
}
