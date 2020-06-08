/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Alex
 */
public class Nivel {

    private String nombre;
    private int m;
    private int n;
    private String tablero;
    
    public Nivel() {
       this.nombre = "";
        this.m = 0;
        this.n = 0;
        this.tablero = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getTablero() {
        return tablero;
    }

    public void setTablero(String tablero) {
        this.tablero = tablero;
    }

   
}
