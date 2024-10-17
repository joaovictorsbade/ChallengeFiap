package org.example.controller;

import org.example.model.Modelo;
import org.example.dao.ModeloDAO;

import java.util.List;

public class ModeloController {

    private ModeloDAO modeloDAO;

    // Construtor para injeção de dependência
    public ModeloController() {
        this.modeloDAO = new ModeloDAO();
    }

    //CadastrarModelo
    public void cadastrarModelo(String marca, String nomeModelo, int ano, String versao) {
        Modelo modelo = new Modelo(marca, nomeModelo, ano, versao);
        modeloDAO.cadastrarModelo(modelo);
    }
    //ListarModelos
    public List<Modelo> listarModelos() {
        List<Modelo> listarModelos = modeloDAO.listarTodosModelos();
        return listarModelos;
    }
}
