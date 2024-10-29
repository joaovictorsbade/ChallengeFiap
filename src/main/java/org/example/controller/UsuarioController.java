package org.example.controller;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.*;
import org.example.bo.UsuarioBO;
import org.example.model.Usuario;

@Path("/usuario")
public class UsuarioController {

    private UsuarioBO usuarioBO;

    public UsuarioController() {
        this.usuarioBO = new UsuarioBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrarUsuario(Usuario usuario, @Context UriInfo uriInfo) {
        Usuario novoUsuario = usuarioBO.cadastrarUsuario(usuario.getNome(), usuario.getEmail(), usuario.getSenha());
        if (novoUsuario != null) {
            UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            builder.path(Integer.toString(novoUsuario.getId())); // Supondo que o objeto Usuario tem um método getId()
            return Response.created(builder.build()).entity(novoUsuario).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao cadastrar o usuário.").build();
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
