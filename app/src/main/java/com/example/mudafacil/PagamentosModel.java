package com.example.mudafacil;

public class PagamentosModel {
    private String amount;
    private String date;
    private String description;

    public PagamentosModel(String amount, String date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}

