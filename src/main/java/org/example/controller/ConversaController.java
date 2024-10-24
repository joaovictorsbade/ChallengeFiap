package org.example.controller;

import org.example.bo.ConversaBO;
import org.example.model.Conversa;

import java.util.List;

public class ConversaController {

    private ConversaBO conversaBO;

    // Construtor para injeção de dependência
    public ConversaController() {
        this.conversaBO = new ConversaBO();
    }

    // Criar conversa através da BO
    public boolean criarConversa() {
        return conversaBO.criarConversa();
    }

    // Listar conversas através da BO
    public List<Conversa> listarConversas() {
        return conversaBO.listarConversasPorUsuario();
    }

    // Finalizar conversa através da BO
    public boolean finalizarConversa(int id) {
        return conversaBO.finalizarConversa(id);
    }
}
