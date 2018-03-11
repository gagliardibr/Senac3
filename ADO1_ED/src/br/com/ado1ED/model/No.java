/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ado1ED.model;

/**
 *
 * @author bruga
 */
public class No {

    private Carro c;
    private No prox;

    public No(Carro car) {
        this.c = car;
        this.prox = null;
    }

    public Carro getC() {
        return c;
    }

    public void setC(Carro c) {
        this.c = c;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
}
