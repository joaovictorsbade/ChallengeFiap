package org.example.controller;

import org.example.bo.MensagemBO;
import org.example.model.Conversa;
import org.example.model.Mensagem;

import java.util.Date;
import java.util.List;

public class MensagemController {

    private MensagemBO mensagemBO;

    // Construtor para injeção de dependência
    public MensagemController() {
        this.mensagemBO = new MensagemBO();
    }

    // Criar Mensagem
    public boolean inserirMensagem(String conteudo, String tipo, Date dataHora, Conversa conversa) {
        return mensagemBO.inserirMensagem(conteudo, tipo, dataHora, conversa);
    }

    // Listar Mensagens por Conversa
    public List<Mensagem> listarMensagens(Conversa conversa) {
        return mensagemBO.listarMensagensPorConversa(conversa);
    }
}
