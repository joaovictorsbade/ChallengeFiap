package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.model.Diagnostico;
import org.example.model.Usuario;
import org.example.dao.DiagnosticoDAO;

import java.util.List;

@Path("/diagnosticos")
public class DiagnosticoController {

    private DiagnosticoDAO diagnosticoDAO;

    // Construtor para injeção de dependência
    public DiagnosticoController() {
        this.diagnosticoDAO = new DiagnosticoDAO();
    }

    // Mostrar diagnóstico recente para um usuário
    @GET
    @Path("/recente")
    @Produces(MediaType.APPLICATION_JSON)
    public Response mostrarDiagnosticoRecente(@QueryParam("usuarioId") int usuarioId) {
        Diagnostico diagnostico = diagnosticoDAO.mostrarDiagnosticoRecente(usuarioId);
        if (diagnostico != null) {
            return Response.ok(diagnostico).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Nenhum diagnóstico recente encontrado para o usuário.").build();
    }

    // Listar todos os diagnósticos de um usuário
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarDiagnosticos(@QueryParam("usuarioId") int usuarioId) {
        List<Diagnostico> diagnosticos = diagnosticoDAO.listarDiagnosticosPorUsuario(usuarioId);
        if (diagnosticos != null && !diagnosticos.isEmpty()) {
            return Response.ok(diagnosticos).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Nenhum diagnóstico encontrado para o usuário.").build();
    }

    // Excluir diagnóstico
    @DELETE
    @Path("/{diagnosticoId}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response excluirDiagnostico(@PathParam("diagnosticoId") int diagnosticoId, @QueryParam("usuarioId") int usuarioId) {
        boolean excluido = diagnosticoDAO.excluirDiagnosticoPorUsuario(diagnosticoId, usuarioId);
        if (excluido) {
            return Response.ok("Diagnóstico excluído com sucesso.").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao excluir diagnóstico.").build();
    }
}
