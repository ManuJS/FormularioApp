package com.example.emanuellemenali.formularioapp;

import android.arch.lifecycle.ViewModel;

/**
 * Created by emanuellemenali on 25/09/17.
 */

class FormularioViewModel extends ViewModel {

    String nome = "";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
