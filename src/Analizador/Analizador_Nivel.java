/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

import Clases.ErrorToken;
import Clases.Juego;
import Clases.Nivel;
import Clases.Token;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Analizador_Nivel {
    
    public static Juego juego = new Juego();
    public ArrayList<Nivel> lst_nivel = new ArrayList<>();
    public ArrayList<Token> lst_token = new ArrayList<>();
    public ArrayList<ErrorToken> lst_error = new ArrayList<>();
    private Nivel nivel_actual;
    private int columna, row;
    private boolean continua = false, cierre = false;
    private int estado = 0;
    private String lexema = "";
    private boolean primero = true;
    private boolean m = false, n = false;
    private boolean tabla = false;
    private String tablero = "";
    private boolean empieza = false;
    private boolean termina = false;
    private int fin;
    private int aux, cont = 0;
    
    public void analizadorNivel(String linea, int fila) {
        row = fila;
        fin = linea.length() - 1;
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
                        
                        if (primero == true) {
                            System.out.println("niveles :" + lexema);
                            primero = false;
                            nivel_actual = new Nivel();
                        } else if (n == true) {
                            System.out.println("n :" + lexema);
                            nivel_actual.setN(Integer.parseInt(lexema));
                            n = false;
                        } else if (m == true && n == false) {
                            System.out.println("m :" + lexema);
                            aux = Integer.parseInt(lexema);
                            nivel_actual.setM(aux);
                        }
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
                        nivel_actual.setNombre(lexema);
                        System.out.println("nombre nivel :" + lexema);
                        lst_token.add(new Token(lexema, "ID", fila, columna));
                        lexema = "";
                        estado = 0;
                        tabla = true;
                        
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
            }
        }
    }
    
    private int iniciales(char codCaracter) {
        int caracter = (int) codCaracter;
        if (Character.isLetter(codCaracter)) {
            return 3;
        } else if (Character.isDigit(codCaracter)) {
            m = true;
            return 1;
        } else if (codCaracter == '-') {
            lst_token.add(new Token(codCaracter + "", "Guion", row, columna));
            estado = 0;
            n = true;
        } else if (codCaracter == '#' || codCaracter == '*') {
            
            if (empieza == false) {
                empieza = true;
                
            }
            tablero = tablero + codCaracter;
            if (codCaracter == '#') {
                lst_token.add(new Token(codCaracter + "", "Numeral", row, columna));
                estado = 0;
            } else {
                lst_token.add(new Token(codCaracter + "", "Asterisco", row, columna));
                estado = 0;
            }
            if (columna == fin - 1) {
                cont++;
                empieza = false;
                tablero = tablero + '\n';
            }
            if (cont == aux) {
                nivel_actual.setTablero(tablero);
                lst_nivel.add(nivel_actual);
                System.out.println(tablero);
                cont = 0;
                tablero = "";
                nivel_actual = new Nivel();
            }
        } else if (codCaracter == '/') {
            return 4;
        } else if (codCaracter == '<') {
            return 5;
        } else if (caracter == 9 || caracter == 13 || caracter == 32 || caracter == 10) {
            return 0;
        } else {
            lst_error.add(new ErrorToken(codCaracter + "", "Caracter Erroneo", columna, row));
        }
        return 0;
    }
}
