package org.example.config;

public class AppConfig {

    // Aqui você pode definir configurações gerais da aplicação

    // Por exemplo, definir o ambiente (desenvolvimento, produção)
    public static final String AMBIENTE = "DESENVOLVIMENTO"; // ou "PRODUÇÃO"

    // Outras configurações podem ser centralizadas aqui
    // Exemplo: log level, URLs de APIs, variáveis de ambiente

    public static void carregarConfiguracoes() {
        System.out.println("AppConfig: Carregando configurações para o ambiente " + AMBIENTE);
        // Carregue outras configurações específicas aqui
    }
}
