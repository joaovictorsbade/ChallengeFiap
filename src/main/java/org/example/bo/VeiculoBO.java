package org.example.bo;

import org.example.dao.VeiculoDAO;
import org.example.model.Modelo;
import org.example.model.Veiculo;

import java.util.List;

public class VeiculoBO {

    private VeiculoDAO veiculoDAO;

    public VeiculoBO() {
        this.veiculoDAO = new VeiculoDAO();
    }

    public boolean cadastrarVeiculo(Modelo modelo) {
        return veiculoDAO.cadastrarVeiculo(modelo);
    }

    public List<Veiculo> listarVeiculosPorUsuario() {
        return veiculoDAO.listarVeiculosPorUsuario();
    }

    public boolean excluirVeiculo(int veiculoId) {
        return veiculoDAO.excluirVeiculo(veiculoId);
    }
}
