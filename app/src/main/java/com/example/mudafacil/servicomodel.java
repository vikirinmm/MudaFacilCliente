package com.example.mudafacil;

public class servicomodel {
 private String lugar;
 private String endreco;
 private String  valor;
 private String  data;

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getEndreco() {
        return endreco;
    }

    public void setEndreco(String endreco) {
        this.endreco = endreco;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public servicomodel(String lugar, String endreco, String valor, String data) {
        this.lugar = lugar;
        this.endreco = endreco;
        this.valor = valor;
        this.data = data;
    }
}
