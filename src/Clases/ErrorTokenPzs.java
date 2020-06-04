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
public class ErrorTokenPzs {

    public String Caracter;
    public String Descripcion;
    public int fila;
    public int columna;

    public ErrorTokenPzs(String Caracter, String Descripcion, int fila, int columna) {
        this.Caracter = Caracter;
        this.Descripcion = Descripcion;
        this.fila = fila;
        this.columna = columna;
    }
}
