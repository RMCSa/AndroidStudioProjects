package com.example.mylist3

class Curso(val nome: String,
            val descricao: String,
            val estado: EstadoAtual)  {

    override fun toString(): String {
        return "Curso: " + nome + " Descrição: " +
                descricao + " Estado: " + estado;
    }

}