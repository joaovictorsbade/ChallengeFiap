package org.example.controller;

import org.example.bo.ModeloBO;
import org.example.model.Modelo;

import java.util.List;

public class ModeloController {

    private ModeloBO modeloBO;

    // Construtor para injeção de dependência
    public ModeloController() {
        this.modeloBO = new ModeloBO();
    }

    // Cadastrar Modelo
    public boolean cadastrarModelo(String marca, String nomeModelo, int ano, String versao) {
        return modeloBO.cadastrarModelo(marca, nomeModelo, ano, versao);
    }

    // Listar Modelos
    public List<Modelo> listarModelos() {
        return modeloBO.listarTodosModelos();
    }
}
