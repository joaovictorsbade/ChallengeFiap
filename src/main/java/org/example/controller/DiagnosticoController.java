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

    //MostrarDiagnosticoRecente
    public Diagnostico mostrarDiagnosticoRecente(Usuario usuario) {
        int usuarioId = usuario.getId();
        return diagnosticoDAO.mostrarDiagnosticoRecente(usuarioId, usuario);
    }

    //ListarDiagnosticos
    public List<Diagnostico> listarDiagnosticos(Usuario usuario) {
        int usuarioId = usuario.getId();
        List<Diagnostico> listarDiagnosticos = diagnosticoDAO.listarDiagnosticosPorUsuario(usuarioId);
        return listarDiagnosticos;
    }
    //Excluir diagnostico
}
