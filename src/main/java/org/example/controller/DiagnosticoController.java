package org.example.controller;

import org.example.model.Diagnostico;
import org.example.model.Usuario;
import org.example.dao.DiagnosticoDAO;

import java.util.List;

public class DiagnosticoController {

    private DiagnosticoDAO diagnosticoDAO;

    // Construtor para injeção de dependência
    public DiagnosticoController() {
        this.diagnosticoDAO = new DiagnosticoDAO();
    }

    // Mostrar diagnóstico recente
    public Diagnostico mostrarDiagnosticoRecente(Usuario usuario) {
        return diagnosticoDAO.mostrarDiagnosticoRecente(usuario.getId());
    }

    // Listar diagnósticos
    public List<Diagnostico> listarDiagnosticos(Usuario usuario) {
        return diagnosticoDAO.listarDiagnosticosPorUsuario(usuario.getId());
    }

    // Excluir diagnóstico
    public boolean excluirDiagnostico(int diagnosticoId, Usuario usuario) {
        return diagnosticoDAO.excluirDiagnosticoPorUsuario(diagnosticoId, usuario.getId());
    }
}
