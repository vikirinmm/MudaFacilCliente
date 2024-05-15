package com.example.mudafacil;

public class Tela_Principal_Model {
    private String lugar;
    private String endereco;

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Tela_Principal_Model(String lugar, String endereco) {
        this.lugar = lugar;
        this.endereco = endereco;
    }
}
