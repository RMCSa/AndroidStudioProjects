package com.example.mylist3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter<Curso>(
            this, android.R.layout.simple_list_item_1, ListaDeCurso()
        )
        findViewById<ListView>(R.id.lvLista).adapter = adapter
    }

    fun ListaDeCurso(): List<Curso>{
        return listOf(
            Curso("Java", "Java Basico", EstadoAtual.FAZENDO),
            Curso("HTML", "HTML Basico", EstadoAtual.FINALIZADO),
            Curso("CSS", "CSS Basico", EstadoAtual.FAZENDO),
            Curso("Python", "Python Básico", EstadoAtual.FAZENDO),
            Curso("SQL", "SQL Básico", EstadoAtual.FINALIZADO),
            Curso("JavaScript", "JavaScript Básico", EstadoAtual.FAZENDO),
            Curso("C", "C Básico", EstadoAtual.FAZENDO),
            Curso("Java Avançado", "Java Avançado", EstadoAtual.FAZENDO),
            Curso("React", "React Básico", EstadoAtual.FINALIZADO),
            Curso("Flutter", "Flutter Básico", EstadoAtual.FAZENDO),
            Curso("Data Science", "Introdução à Ciência de Dados", EstadoAtual.FINALIZADO)
        )
    }

}