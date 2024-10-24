package org.example.controller;

import org.example.bo.VeiculoBO;
import org.example.model.Modelo;
import org.example.model.Veiculo;

import java.util.List;

public class VeiculoController {

    private VeiculoBO veiculoBO;

    // Construtor para injeção de dependência
    public VeiculoController() {
        this.veiculoBO = new VeiculoBO();
    }

    // Cadastrar Veículo
    public boolean cadastrarVeiculo(Modelo modelo) {
        return veiculoBO.cadastrarVeiculo(modelo);
    }

    // Listar Veículos
    public List<Veiculo> listarVeiculos() {
        return veiculoBO.listarVeiculosPorUsuario();
    }

    // Excluir Veículo
    public boolean excluirVeiculo(int idVeiculo) {
        return veiculoBO.excluirVeiculo(idVeiculo);
    }
}
