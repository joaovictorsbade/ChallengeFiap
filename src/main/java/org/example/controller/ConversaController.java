package org.example.controller;

import org.example.model.Conversa;
import org.example.dao.ConversaDAO;

import java.util.List;

public class ConversaController {

    private ConversaDAO conversaDAO;

    // Construtor para injeção de dependência
    public ConversaController() {
        this.conversaDAO = new ConversaDAO();
    }

    //CriarConversa
    public void criarConversa(char status){
        Conversa conversa = new Conversa(status);
        conversaDAO.criarConversa(conversa);
    }
    //ListarConversasPorUsuario
    public List<Conversa> listarConversas() {
        List<Conversa> listarConversas = conversaDAO.listarConversasPorUsuario();
        return listarConversas;
    }

    //Metodo de finalizar conversa(Trocar o status)

    //Criar verificação de status
}
