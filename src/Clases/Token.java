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
public class Token {

    public String lexema;
    public String lexico;
    public int Fila;
    public int Columna;
    public String tipo;

    public Token(String lexema, String lexico, int Fila, int Columna, String tipo) {
        this.lexema = lexema;
        this.lexico = lexico;
        this.Fila = Fila;
        this.Columna = Columna;
        this.tipo = tipo;
    }
}
