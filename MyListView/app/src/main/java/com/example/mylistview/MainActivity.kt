package com.example.mylistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import java.security.CryptoPrimitive

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var estado : EstadoAtual = EstadoAtual.FAZENDO
        var curso : Curso = Curso("Java","Java Básico", estado)
        println(curso.toString())
        Log.d("Aula", curso.toString())

        var lvLista = findViewById<ListView>(R.id.lvLista)

        var lista : List<Curso> = listOf(
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

        val arrayAdapter = ArrayAdapter<Curso>(this, android.R.layout.simple_list_item_1, lista)
        lvLista.adapter = arrayAdapter

    }
}