package com.example.mylist3

enum class EstadoAtual {

    FAZENDO{
        override fun toString(): String {
            return "Fazendo"
        }

           },
    FINALIZADO{
        override fun toString(): String = "Finalizado"
    }

}