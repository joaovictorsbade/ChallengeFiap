package org.example.dao;

import org.example.model.*;
import org.example.config.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiagnosticoDAO {

    public List<Diagnostico> listarDiagnosticosPorUsuario(int usuarioId) {
        String sql = "SELECT d.id, d.relatorio, d.data_hora, " +
                "v.id AS fk_Veiculo_id, v.fk_Modelo_id, " +
                "u.id AS fk_Usuario_id " +
                "FROM diagnostico d " +
                "JOIN veiculo v ON d.fk_Veiculo_id = v.id " +
                "JOIN usuario u ON d.fk_Usuario_id = u.id " +
                "WHERE d.fk_Usuario_id = ?";

        List<Diagnostico> diagnosticos = new ArrayList<>();

        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, usuarioId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("fk_Usuario_id"), null, null);
                Veiculo veiculo = new Veiculo(rs.getInt("fk_Veiculo_id"), usuario, null); // Ajustar depois
                Diagnostico diagnostico = new Diagnostico(
                        rs.getInt("id"),
                        rs.getString("relatorio"),
                        rs.getDate("data_hora"),
                        usuario,
                        veiculo
                );
                diagnosticos.add(diagnostico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diagnosticos;
    }

    public Diagnostico mostrarDiagnosticoRecente(int usuarioId) {
        Diagnostico diagnostico = null;

        String sql = "SELECT d.id AS diagnostico_id, d.relatorio, d.data_hora, " +
                "v.id AS veiculo_id, " +
                "m.id AS modelo_id, m.marca, m.modelo AS modelo_nome, m.ano, m.versao " +
                "FROM Diagnostico d " +
                "JOIN Veiculo v ON d.fk_Veiculo_id = v.id " +
                "JOIN Modelo m ON v.fk_Modelo_id = m.id " +
                "WHERE d.fk_Usuario_id = ? " +
                "ORDER BY d.data_hora DESC " +
                "FETCH FIRST 1 ROW ONLY";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, usuarioId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Modelo modelo = new Modelo(
                        rs.getInt("modelo_id"),
                        rs.getString("marca"),
                        rs.getString("modelo_nome"),
                        rs.getInt("ano"),
                        rs.getString("versao")
                );

                Usuario usuario = new Usuario(usuarioId, null, null); // Passar o ID do usuário
                Veiculo veiculo = new Veiculo(
                        rs.getInt("veiculo_id"),
                        usuario,
                        modelo
                );

                diagnostico = new Diagnostico(
                        rs.getInt("diagnostico_id"),
                        rs.getString("relatorio"),
                        rs.getDate("data_hora"),
                        usuario,
                        veiculo
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return diagnostico;
    }

    public boolean excluirDiagnosticoPorUsuario(int diagnosticoId, int usuarioId) {
        String sql = "DELETE FROM diagnostico WHERE id = ? AND fk_Usuario_id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, diagnosticoId);
            ps.setInt(2, usuarioId);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
