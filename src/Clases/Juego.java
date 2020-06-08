/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Juego {

    private int noNivel;
    private int punteo;
    private ArrayList<Piezas> lst_pieza;
    private ArrayList<Nivel> lst_niveles;

    public Juego() {
        this.lst_niveles = new ArrayList<>();
        this.lst_pieza = new ArrayList<>();
        this.punteo = 0;
        this.noNivel = 0;
    }

    public int getNoNivel() {
        return noNivel;
    }

    public void setNoNivel(int noNivel) {
        this.noNivel = noNivel;
    }

    public int getPunteo() {
        return punteo;
    }

    public void setPunteo(int punteo) {
        this.punteo = punteo;
    }

    public ArrayList<Piezas> getLst_pieza() {
        return lst_pieza;
    }

    public void setLst_pieza(ArrayList<Piezas> lst_pieza) {
        this.lst_pieza = lst_pieza;
    }

    public ArrayList<Nivel> getLst_niveles() {
        return lst_niveles;
    }

    public void setLst_niveles(ArrayList<Nivel> lst_niveles) {
        this.lst_niveles = lst_niveles;
    }

}
