package org.example.bo;

import org.example.dao.ConversaDAO;
import org.example.model.Conversa;
import org.example.model.UsuarioSession;

import java.util.List;

public class ConversaBO {

    private ConversaDAO conversaDAO;

    public ConversaBO() {
        this.conversaDAO = new ConversaDAO();
    }

    // Criar nova conversa, verificando se o usuário está logado
    public boolean criarConversa() {
        if (UsuarioSession.getInstance().getUsuario() != null) {
            Conversa conversa = new Conversa('A');
            return conversaDAO.criarConversa(conversa);
        }
        System.out.println("Usuário não está logado.");
        return false;
    }

    // Listar conversas do usuário logado
    public List<Conversa> listarConversasPorUsuario() {
        if (UsuarioSession.getInstance().getUsuario() != null) {
            return conversaDAO.listarConversasPorUsuario();
        }
        System.out.println("Usuário não está logado.");
        return null;
    }

    // Finalizar uma conversa (alterar status para 'B')
    public boolean finalizarConversa(int id) {
        if (UsuarioSession.getInstance().getUsuario() != null) {
            Conversa conversa = new Conversa(id);
            return conversaDAO.editarStatusConversa(conversa);
        }
        System.out.println("Usuário não está logado.");
        return false;
    }
}
