package com.example.mudafacil.api.model;

public class Usuario {
    private String nome;
    private String email;
    private String telefone;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario(String nome, String email, String telefone, String senha) {
        this.nome = nome;
        this.telefone=telefone;
        this.email= email;
        this.senha = senha;
    }

    public Usuario() {}
}
