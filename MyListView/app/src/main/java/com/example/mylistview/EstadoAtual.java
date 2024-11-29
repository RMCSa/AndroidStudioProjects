package com.example.mylistview;

import androidx.annotation.NonNull;

public enum EstadoAtual{
    FAZENDO{
        @NonNull
        @Override
        public String toString(){
            return  "fazendo";
        }
    } ,
    FINALIZADO{
        @NonNull
        @Override
        public String toString(){
            return "finalizado";
        }
    }
}
