package com.example.mudafacil.Opcao_veiculos;

import android.widget.TextView;

public class Opcao_VeiculosModel {
    private String tempo;
    private String capacidade;
    private String valor;
    private String veiculo;

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public Opcao_VeiculosModel(String tempo, String capacidade, String valor, String veiculo) {
        this.tempo = tempo;
        this.capacidade = capacidade;
        this.valor = valor;
        this.veiculo = veiculo;
    }
}
