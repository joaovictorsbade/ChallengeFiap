package org.example.controller;

import org.example.model.Conversa;
import org.example.model.Mensagem;
import org.example.dao.MensagemDAO;

import java.util.Date;
import java.util.List;

public class MensagemController {

    private MensagemDAO mensagemDAO;

    // Construtor para injeção de dependência
    public MensagemController() {
        this.mensagemDAO = new MensagemDAO();
    }

    //CriarMensagem
    public void inserirMensagem(String conteudo, String tipo, Date dataHora, Conversa conversa) {
        Mensagem mensagem = new Mensagem(conteudo, tipo, dataHora, conversa);
        mensagemDAO.inserirMensagem(mensagem);

    }
    //ListarMensagensPorConversa
    public List<Mensagem> listarMensagens(Conversa conversa) {
        List<Mensagem> listarMensagens = mensagemDAO.listarMensagensPorConversa(conversa);
        //apartir dessa lista tenho que criar duas listas
        return listarMensagens;
    }
}
