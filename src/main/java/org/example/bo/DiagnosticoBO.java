package org.example.bo;

import org.example.model.Diagnostico;
import org.example.model.Usuario;
import org.example.dao.DiagnosticoDAO;

import java.util.List;

public class DiagnosticoBO {

    private DiagnosticoDAO diagnosticoDAO;

    public DiagnosticoBO() {
        this.diagnosticoDAO = new DiagnosticoDAO();
    }

    public List<Diagnostico> listarDiagnosticosPorUsuario(Usuario usuario) {
        return diagnosticoDAO.listarDiagnosticosPorUsuario(usuario.getId());
    }

    public Diagnostico obterDiagnosticoRecente(Usuario usuario) {
        return diagnosticoDAO.mostrarDiagnosticoRecente(usuario.getId());
    }

    public boolean excluirDiagnostico(int diagnosticoId, Usuario usuario) {
        return diagnosticoDAO.excluirDiagnosticoPorUsuario(diagnosticoId, usuario.getId());
    }
}
