package org.example.view;

import org.example.controller.*;
import org.example.model.*;
import java.util.List;

public class ChallengeFiapApplication {

    public static void main(String[] args) {

    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
        // Criação dos controladores
//        UsuarioController usuarioController = new UsuarioController();
//        ModeloController modeloController = new ModeloController();
//        VeiculoController veiculoController = new VeiculoController();
//        ConversaController conversaController = new ConversaController();
//        DiagnosticoController diagnosticoController = new DiagnosticoController();
//        MensagemController mensagemController = new MensagemController();

//        ^^----------------Usuario funcionado---------------------^^

//        Usuario usuario = new Usuario(26,"Alguem", "alguem@eample.com");

        // Cadastrar um novo usuário
//        usuarioController.cadastrarUsuario("", "", "");

        // Login do usuário
//        usuarioController.loginUsuario("irineu@eample.com", "senha123");

//        // Editar senha do usuário
//        usuarioController.editarSenhaUsuario("novaSenhaSofia");

//        // Excluir o usuário
//        usuarioController.excluirUsuario();

//        ^^----------------Usuario funcionado---------------------^^

//        ^^----------------Modelo funcionado---------------------^^

//        // Cadastrar um novo modelo
//        modeloController.cadastrarModelo("Ford", "Mustang", 2024, "GT");
//        modeloController.cadastrarModelo("Volkswagen", "T-Cross", 2023, "Highline");
//        modeloController.cadastrarModelo("BMW", "X3", 2024, "M Sport");
//        modeloController.cadastrarModelo("Nissan", "Kicks", 2023, "Unique");
//        modeloController.cadastrarModelo("Hyundai", "Creta", 2024, "Diamond");

        // Listar modelos
//        List<Modelo> modelos = modeloController.listarModelos();
//        for (Modelo modelo : modelos) {
//            System.out.printf("ID: %d, Marca: %s, Modelo: %s, Ano: %d, Versão: %s%n",
//                    modelo.getId(),
//                    modelo.getMarca(),
//                    modelo.getNomeModelo(),
//                    modelo.getAno(),
//                    modelo.getVersao());
//        }
//        ^^----------------Modelo funcionado---------------------^^

//        ^^----------------Veiculo funcionado---------------------^^
        // Cadastrar um novo veículo
//        Modelo modelo = modelos.get(0); // Assumindo que a lista não está vazia
//        veiculoController.cadastrarVeiculo(modelo);
//
//        // Listar veículos por usuário
//        List<Veiculo> veiculos = veiculoController.listarVeiculos();
//        for (Veiculo veiculo : veiculos) {
//            System.out.println(veiculo);
//        }

        // Excluir um veículo
//        if (!veiculos.isEmpty()) {
//            veiculoController.excluirVeiculo(veiculos.get(0).getId());
//        }
//        ^^----------------Veiculo funcionado---------------------^^

//        ^^----------------Conversa funcionado---------------------^^
//        // Criar uma conversa
//        conversaController.criarConversa();
//
        // Listar conversas por usuário
//        List<Conversa> conversas = conversaController.listarConversas();
//        for (Conversa c : conversas) {
//            System.out.println("Conversa:"+c);
//        }

//        conversaController.finalizarConversa(21);

//        ^^----------------Conversa funcionado---------------------^^

        // Inserir uma mensagem
//        if (!conversas.isEmpty()) {
//            Conversa conversaExistente = conversas.get(0);
//            mensagemController.inserirMensagem("Olá, tenho um problema no meu carro", "user", new java.util.Date(), conversaExistente);
//        }

         //Listar mensagens por conversa
//        List<Mensagem> mensagens = mensagemController.listarMensagens(conversa);
//        for (Mensagem mensagem : mensagens) {
//            System.out.println(mensagem);
//        }

         //Mostrar diagnóstico recente
//        List<Diagnostico> diagnosticos = diagnosticoController.listarDiagnosticos(usuario);
//        if (!diagnosticos.isEmpty()) {
//            Diagnostico diagnosticoRecente = diagnosticoController.mostrarDiagnosticoRecente(usuario);
//            System.out.println(diagnosticoRecente);
//        }
    }
}
