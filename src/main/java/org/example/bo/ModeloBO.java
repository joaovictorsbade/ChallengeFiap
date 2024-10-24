package org.example.bo;

import org.example.dao.ModeloDAO;
import org.example.model.Modelo;

import java.util.List;

public class ModeloBO {

    private ModeloDAO modeloDAO;

    public ModeloBO() {
        this.modeloDAO = new ModeloDAO();
    }

    public boolean cadastrarModelo(String marca, String nomeModelo, int ano, String versao) {
        Modelo modelo = new Modelo(marca, nomeModelo, ano, versao);
        return modeloDAO.cadastrarModelo(modelo);
    }

    public List<Modelo> listarTodosModelos() {
        return modeloDAO.listarTodosModelos();
    }
}
