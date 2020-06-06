/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

import Clases.ErrorTokenPzs;
import Clases.TokenPzs;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Analizador_Piezas {

    public ArrayList<TokenPzs> lst_token = new ArrayList<>();
    public ArrayList<ErrorTokenPzs> lst_error = new ArrayList<>();
    private int columna, row;
    private boolean continua = false, cierre = false;
    private int estado = 0;
    private String lexema = "";

    public void analizadorPieza(String linea, int fila) {
        row = fila;
        char[] caracter;
        char codCaracter;
        int carac = 0;
        for (columna = 0; columna < linea.length(); columna++) {
            caracter = linea.toCharArray();
            codCaracter = caracter[columna];
            carac = (int) caracter[columna];
            if (estado == 0 && continua == false) {
                estado = iniciales(codCaracter);
            }
            switch (estado) {
                case 1:
                    lexema = lexema + codCaracter;
                    if (reservada(lexema)) {
                        if (lexema.equals("v")) {
                            lst_token.add(new TokenPzs(codCaracter + "", "Simbolos", fila, columna));
                            lexema = "";
                            estado = iniciales(codCaracter);
                        } else {
                            lst_token.add(new TokenPzs(lexema, "Letra", fila, columna));
                            lexema = "";
                            estado = iniciales(codCaracter);
                        }
                    } else {
                        lst_error.add(new ErrorTokenPzs(lexema, "Letra no pertenece a lenguaje", columna, fila));
                        lexema = "";
                        estado = iniciales(codCaracter);
                    }
                    break;
                case 3:
                    lst_token.add(new TokenPzs(codCaracter + "", "Simbolos", fila, columna));
                    estado = 0;

                    break;
                case 4:
                    if (codCaracter == '/') {
                        estado = 6;
                    } else {
                        lst_error.add(new ErrorTokenPzs(codCaracter + "", "Caracter Erroneo", columna, fila));
                    }
                    break;
                case 5:
                    if (codCaracter == '<') {
                        estado = 2;
                    }
                    break;
                case 2:
                    if (codCaracter == '!') {
                        lexema = lexema + codCaracter;
                        estado = 7;
                    } else {
                        lst_token.add(new TokenPzs("<", "Simbolos", fila, columna));
                        lexema = "";
                        estado = 0;
                    }
                    break;
                case 6:
                    if (codCaracter == '\n' && cierre == true) {
                        lexema = lexema + codCaracter;
                        lst_token.add(new TokenPzs(lexema, "Comentario Linea", fila, columna));
                        lexema = "";
                        estado = iniciales(codCaracter);
                        continua = false;
                        cierre = false;
                    } else {
                        lexema = lexema + codCaracter;
                        estado = 6;
                        cierre = true;
                        continua = true;
                    }
                    break;
                case 7:
                    if (codCaracter == '>' && cierre == true) {
                        lexema = lexema + codCaracter;
                        estado = 8;
                        continua = false;
                        cierre = false;
                    } else {
                        lexema = lexema + codCaracter;
                        estado = 7;
                        cierre = true;
                        continua = true;
                    }
                    break;
                case 8:
                    lexema = lexema + codCaracter;
                    lst_token.add(new TokenPzs(lexema, "Comentario multilinea", fila, columna));
                    lexema = "";
                    estado = iniciales(codCaracter);

                    break;
            }
        }
    }

    private int iniciales(char codCaracter) {
        int caracter = (int) codCaracter;
        if (Character.isLetter(codCaracter)) {
            return 1;
        } else if (Character.isDigit(codCaracter)) {
            lst_error.add(new ErrorTokenPzs(codCaracter + "", "No hay numeros en el lenguaje", columna, row));
        } else if (codCaracter == ',') {
            lst_token.add(new TokenPzs(codCaracter + "", "coma", row, columna));
            estado = 0;
        } else if (codCaracter == 'v' || codCaracter == '^' || codCaracter == '>') {
            return 3;
        } else if (codCaracter == '<') {
            return 5;
        } else if (codCaracter == '/') {
            return 4;
        } else {
            lst_error.add(new ErrorTokenPzs(codCaracter + "", "Caracter Erroneo", columna, row));
        }
        return 0;
    }

    private boolean reservada(String letra) {
        if (letra.equals("L")) {
            return true;
        } else if (letra.equals("I")) {
            return true;
        } else if (letra.equals("S")) {
            return true;
        } else if (letra.equals("Z")) {
            return true;
        } else if (letra.equals("T")) {
            return true;
        } else if (letra.equals("O")) {
            return true;
        } else if (letra.equals("J")) {
            return true;
        } else if (letra.equals("v")) {
            return true;
        } else {
            return false;
        }
    }
}
