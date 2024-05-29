package com.example.mudafacil.servico;

public class Servicomodel {
 private String lugar;
 private String endreco;
 private String  valor;
 private String  data;

 private String status;

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

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public Servicomodel(String lugar, String endreco, String valor, String data, String status) {
        this.lugar = lugar;
        this.endreco = endreco;
        this.valor = valor;
        this.data = data;
        this.status = status;
    }
}
