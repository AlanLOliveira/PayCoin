package com.example.paycoin.models;

public class Usuario implements Cloneable {

    private int id;
    private String nome;
    private String login;
    private String senha;
    private String cpf;
    private String contabancaria;
    private String valorinicial;

    public Usuario(){}

    public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
    }

    public Usuario (String nome, String login, String senha, String cpf,
                    String contabancaria, String valorinicial){

        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.contabancaria = contabancaria;
        this.valorinicial = valorinicial;
    }

    public Usuario(int id, String nome, String login, String senha, String cpf,
                   String contabancaria, String valorinicial){
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.contabancaria = contabancaria;
        this.valorinicial = valorinicial;
    }

    public Usuario(Usuario u){
        this.id = u.id;
        this.nome = u.nome;
        this.login = u.login;
        this.senha = u.senha;
        this.cpf = u.cpf;
        this.contabancaria = u.contabancaria;
        this.valorinicial = u.valorinicial;

    }
   public int getId(){
        return this.id;
     }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String n) {
        this.nome = n;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String l) {
        this.login = l;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String s) {
        this.senha = s;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String c){
        this.cpf = c;
    }

    public String getContaBancaria() {

        return this.contabancaria;
    }

    public void setContaBancaria(String cb){
        this.contabancaria = cb;
    }

    public String getValorInicial() {
        return this.valorinicial;
    }

    public void setValorInicial(String vi){
        this.valorinicial = vi;
    }



    @Override
    public Object clone(){
        Usuario clone = new Usuario (this);
        return clone;
    }
}
