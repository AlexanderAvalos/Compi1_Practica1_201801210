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

                    break;
                case 2:

                    break;
                case 3:
                    if (codCaracter == '!') {
                        estado = 5;
                    } else {
                        lst_token.add(new TokenPzs(codCaracter + "", "Simbolos", fila, columna));
                        estado = iniciales(codCaracter);
                    }
                    break;
                case 4:
                    if (codCaracter == '/') {
                        estado = 6;
                    } else {
                        lst_error.add(new ErrorTokenPzs(codCaracter + "", "Caracter Erroneo", columna, row));
                    }
                    break;
                case 5:

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
            return 2;
        } else if (codCaracter == 'v' || codCaracter == '^' || codCaracter == '>' || codCaracter == '<') {
            return 3;
        } else if (codCaracter == '/') {
            return 4;
        } else {
            lst_error.add(new ErrorTokenPzs(codCaracter + "", "Caracter Erroneo", columna, row));
        }
        return 0;
    }
}
