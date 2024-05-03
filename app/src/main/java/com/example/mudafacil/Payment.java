package com.example.mudafacil;

public class Payment {
    private String amount;
    private String date;
    private String description;

    public Payment(String amount, String date, String description) {
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

