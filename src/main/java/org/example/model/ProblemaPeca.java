package org.example.model;

public class ProblemaPeca {
    private Peca peca;
    private Problemas problemas;

    public ProblemaPeca(Peca peca, Problemas problemas) {
        this.peca = peca;
        this.problemas = problemas;
    }

    // Getters and Setters

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public Problemas getProblemas() {
        return problemas;
    }

    public void setProblemas(Problemas problemas) {
        this.problemas = problemas;
    }
}