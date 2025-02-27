package com.example.mylistview;
public class Curso {
    private String nome;

    private String descricao;

    private EstadoAtual estado;

    public Curso(String nome, String descricao, EstadoAtual estado){
        this.nome = nome;
        this.descricao = descricao;
        this.estado = estado;
    }


    public EstadoAtual getEstado() {
        return estado;
    }

    public void setEstado(EstadoAtual estado) {
        this.estado = estado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return  "Curso: " + nome + " Descrição: " +
                descricao + " Estado: " + estado;
    }

}
