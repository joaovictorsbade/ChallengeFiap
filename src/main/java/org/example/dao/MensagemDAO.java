package org.example.dao;

import org.example.model.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.example.config.*;

public class MensagemDAO {

    // Método para listar todas as mensagens de uma conversa
    public List<Mensagem> listarMensagensPorConversa(Conversa conversa) {
        String sql = "SELECT * FROM mensagem WHERE fk_Conversa_id = ?";
        List<Mensagem> mensagens = new ArrayList<>();

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, conversa.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mensagem mensagem = new Mensagem(
                        rs.getInt("id"),
                        rs.getString("conteudo"),
                        rs.getString("tipo"),
                        rs.getDate("data_hora"),
                        conversa
                );
                mensagens.add(mensagem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return mensagens;
    }

    // Método para inserir uma nova mensagem
    public boolean inserirMensagem(Mensagem mensagem) {
        String sql = "INSERT INTO mensagem (conteudo, tipo, data_hora, fk_Conversa_id) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mensagem.getConteudo());
            ps.setString(2, mensagem.getTipo());
            ps.setDate(3, new Date(mensagem.getDataHora().getTime()));
            ps.setInt(4, mensagem.getConversa().getId());
            System.out.println("Mensagem inserida no banco result="+ps.executeUpdate());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Conexao.fecharConexao();
        }
    }
}
