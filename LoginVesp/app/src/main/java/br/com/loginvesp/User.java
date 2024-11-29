package br.com.loginvesp;


import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Objects;

@IgnoreExtraProperties
public class User {
    private  String ra;
    private  String nome;

    public User(){

    }

    public User( String ra, String nome){
        this.ra = ra;
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public String getNome() {
        return nome;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(ra, user.ra) && Objects.equals(nome, user.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ra, nome);
    }
}
