/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

import Clases.ErrorToken;
import Clases.Token;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Analizador_Nivel {

    public ArrayList<Token> lst_token = new ArrayList<>();
    public ArrayList<ErrorToken> lst_error = new ArrayList<>();
    private int columna, row;
    private boolean continua = false, cierre = false;
    private int estado = 0;
    private String lexema = "";
    private boolean primero = true;

    public void analizadorNivel(String linea, int fila) {
        row = fila;
        char[] caracter;
        char codCaracter;
        for (columna = 0; columna < linea.length(); columna++) {
            caracter = linea.toCharArray();
            codCaracter = caracter[columna];

            if (estado == 0 && continua == false) {
                estado = iniciales(codCaracter);
            }
            switch (estado) {
                case 1:
                    if (Character.isDigit(codCaracter)) {
                        lexema = lexema + codCaracter;
                        estado = 1;
                    } else {
                        lst_token.add(new Token(lexema, "numero", fila, columna));
                        lexema = "";
                        estado = iniciales(codCaracter);
                    }
                    break;
                case 3:
                    if (Character.isLetterOrDigit(codCaracter) || codCaracter == '_') {
                        lexema = lexema + codCaracter;
                        estado = 3;
                    } else {
                        lst_token.add(new Token(lexema, "ID", fila, columna));
                        lexema = "";
                        estado = 0;
                    }
                    break;
                case 4:
                    if (codCaracter == '/') {
                        estado = 6;
                    } else {
                        lst_error.add(new ErrorToken(codCaracter + "", "Caracter Erroneo", columna, row));
                    }
                    break;
                case 5:
                    if (codCaracter == '!') {
                        lexema = lexema + codCaracter;
                        estado = 7;
                    }
                    break;
                case 6:
                    if (codCaracter == '\n' && cierre == true) {
                        lexema = lexema + codCaracter;
                        lst_token.add(new Token('/' + lexema, "Comentario Linea", fila, columna));
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
                    if (codCaracter == '!' && cierre == true) {
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
                    if (codCaracter == '>') {
                        lexema = lexema + codCaracter;
                        lst_token.add(new Token(lexema, "Comentario multilinea", fila, columna));
                        lexema = "";
                        estado = iniciales(codCaracter);
                    }
                    break;
                case 10:

                    break;
            }
        }
    }

    private int iniciales(char codCaracter) {
        if (Character.isLetter(codCaracter)) {
            return 3;
        } else if (Character.isDigit(codCaracter)) {
            return 1;
        } else if (codCaracter == '-') {
            lst_token.add(new Token(codCaracter + "", "Guion", row, columna));
            estado = 0;
        } else if (codCaracter == '#' || codCaracter == '*') {
            if (codCaracter == '#') {
                lst_token.add(new Token(codCaracter + "", "Numeral", row, columna));
                estado = 0;
            } else {
                lst_token.add(new Token(codCaracter + "", "Asterisco", row, columna));
                estado = 0;
            }
        } else if (codCaracter == '/') {
            return 4;
        } else if (codCaracter == '<') {
            return 5;
        } else {
            lst_error.add(new ErrorToken(codCaracter + "", "Caracter Erroneo", columna, row));
        }
        return 0;
    }
}
