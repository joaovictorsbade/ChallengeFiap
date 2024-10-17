package org.example.controller;

import org.example.model.Modelo;
import org.example.model.Veiculo;
import org.example.dao.VeiculoDAO;

import java.util.List;

public class VeiculoController {

    private VeiculoDAO veiculoDAO;

    // Construtor para injeção de dependência
    public VeiculoController() {
        this.veiculoDAO = new VeiculoDAO();
    }

    //CadastrarVeiculo
    public void cadastrarVeiculo(Modelo modelo){
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.cadastrarVeiculo(modelo);
    }
    //ListarVeiculos
    public List<Veiculo> listarVeiculos() {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        List<Veiculo> listarVeiculos = veiculoDAO.listarVeiculosPorUsuario();
        return listarVeiculos;
    }
    //ExcluirVeiculo
    public void excluirVeiculo(int idVeiculo){
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.excluirVeiculo(idVeiculo);
    }
}
