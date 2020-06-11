/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Clases.Piezas;
import Figuras.pieza;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Alex
 */
public class juego extends Thread {

    private JLabel[][] tablero;
    private pieza figura;
    private int fig;
    private boolean posicion;
    private int limite;

    public juego(JLabel[][] tablero, pieza figura, boolean posicion, int fig, int limite) {
        this.tablero = tablero;
        this.figura = figura;
        this.posicion = posicion;
        this.fig = fig;
        this.limite = limite;
    }

    public void run() {
        boolean finalizo = false;
        int cont = 0;
        while (finalizo != true) {
            cont++;
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(juego.class.getName()).log(Level.SEVERE, null, ex);
            }
            figura.mover();
            switch (fig) {
                case 1:
                    if (figura.getY4() < (limite - 1) && (tablero[figura.getX4()][figura.getY4()].getBackground() != Color.red || tablero[figura.getX4()][figura.getY4()].getBackground() != Color.YELLOW) && posicion == false) {
                        tablero[figura.getX1()][figura.getY1() - 1].setBackground(Color.white);
                        tablero[figura.getX1()][figura.getY1()].setBackground(Color.red);
                        tablero[figura.getX2()][figura.getY2()].setBackground(Color.red);
                        tablero[figura.getX3()][figura.getY3()].setBackground(Color.red);
                        tablero[figura.getX4()][figura.getY4()].setBackground(Color.red);

                    } else if (figura.getY1() < (limite - 1) && (tablero[figura.getX1()][figura.getY1()].getBackground() != Color.red || tablero[figura.getX1()][figura.getY1()].getBackground() != Color.YELLOW) && posicion) {
                        tablero[figura.getX1()][figura.getY1() - 1].setBackground(Color.white);
                        tablero[figura.getX2()][figura.getY2() - 1].setBackground(Color.white);
                        tablero[figura.getX3()][figura.getY3() - 1].setBackground(Color.white);
                        tablero[figura.getX4()][figura.getY4() - 1].setBackground(Color.white);
                        tablero[figura.getX1()][figura.getY1()].setBackground(Color.red);
                        tablero[figura.getX2()][figura.getY2()].setBackground(Color.red);
                        tablero[figura.getX3()][figura.getY3()].setBackground(Color.red);
                        tablero[figura.getX4()][figura.getY4()].setBackground(Color.red);
                    } else {
                        finalizo = true;
                    }
                    break;
                case 2:
                    if (figura.getY1() < (limite - 1) && (tablero[figura.getX1()][figura.getY1()].getBackground() != Color.red || tablero[figura.getX1()][figura.getY1()].getBackground() != Color.YELLOW) && posicion == false) {
                        tablero[figura.getX1()][figura.getY1() - 1].setBackground(Color.white);
                        tablero[figura.getX1()][figura.getY1()].setBackground(Color.red);
                        tablero[figura.getX2()][figura.getY2() - 1].setBackground(Color.white);
                        tablero[figura.getX2()][figura.getY2()].setBackground(Color.red);
                        tablero[figura.getX3()][figura.getY3()].setBackground(Color.red);
                        tablero[figura.getX4()][figura.getY4()].setBackground(Color.red);

                    } else if (figura.getY1() < (limite - 1) && (tablero[figura.getX1()][figura.getY1()].getBackground() != Color.red || tablero[figura.getX1()][figura.getY1()].getBackground() != Color.YELLOW) && posicion) {
                        tablero[figura.getX1()][figura.getY1() - 1].setBackground(Color.white);
                        tablero[figura.getX3()][figura.getY3() - 1].setBackground(Color.white);
                        tablero[figura.getX4()][figura.getY4() - 1].setBackground(Color.white);
                        tablero[figura.getX1()][figura.getY1()].setBackground(Color.red);
                        tablero[figura.getX2()][figura.getY2()].setBackground(Color.red);
                        tablero[figura.getX3()][figura.getY3()].setBackground(Color.red);
                        tablero[figura.getX4()][figura.getY4()].setBackground(Color.red);
                    } else {
                        finalizo = true;
                    }
                case 3:
                    if (figura.getY4() < (limite - 1) && (tablero[figura.getX4()][figura.getY4()].getBackground() != Color.red || tablero[figura.getX4()][figura.getY4()].getBackground() != Color.YELLOW) && posicion == false) {
                        tablero[figura.getX1()][figura.getY1() - 1].setBackground(Color.white);
                        tablero[figura.getX1()][figura.getY1()].setBackground(Color.red);
                        tablero[figura.getX4()][figura.getY4() - 1].setBackground(Color.white);
                        tablero[figura.getX2()][figura.getY2()].setBackground(Color.red);
                        tablero[figura.getX3()][figura.getY3()].setBackground(Color.red);
                        tablero[figura.getX4()][figura.getY4()].setBackground(Color.red);

                    } else if (figura.getY2() < (limite - 1) && (tablero[figura.getX2()][figura.getY2()].getBackground() != Color.red || tablero[figura.getX2()][figura.getY2()].getBackground() != Color.YELLOW) && posicion) {
                        tablero[figura.getX1()][figura.getY1() - 1].setBackground(Color.white);
                        tablero[figura.getX3()][figura.getY3() - 1].setBackground(Color.white);
                        tablero[figura.getX4()][figura.getY4() - 1].setBackground(Color.white);
                        tablero[figura.getX1()][figura.getY1()].setBackground(Color.red);
                        tablero[figura.getX2()][figura.getY2()].setBackground(Color.red);
                        tablero[figura.getX3()][figura.getY3()].setBackground(Color.red);
                        tablero[figura.getX4()][figura.getY4()].setBackground(Color.red);
                    } else {
                        finalizo = true;
                    }
                    break;
                case 4:
                    if (figura.getY2() < (limite - 1) && (tablero[figura.getX2()][figura.getY2()].getBackground() != Color.red || tablero[figura.getX2()][figura.getY2()].getBackground() != Color.YELLOW) && posicion == false) {
                        tablero[figura.getX1()][figura.getY1() - 1].setBackground(Color.white);
                        tablero[figura.getX1()][figura.getY1()].setBackground(Color.red);
                        tablero[figura.getX3()][figura.getY3() - 1].setBackground(Color.white);
                        tablero[figura.getX2()][figura.getY2()].setBackground(Color.red);
                        tablero[figura.getX3()][figura.getY3()].setBackground(Color.red);
                        tablero[figura.getX4()][figura.getY4()].setBackground(Color.red);
                    } else if (figura.getY2() < (limite - 1) && (tablero[figura.getX2()][figura.getY2()].getBackground() != Color.red || tablero[figura.getX2()][figura.getY2()].getBackground() != Color.YELLOW) && posicion) {
                        tablero[figura.getX1()][figura.getY1() - 1].setBackground(Color.white);
                        tablero[figura.getX3()][figura.getY3() - 1].setBackground(Color.white);
                        tablero[figura.getX1()][figura.getY1()].setBackground(Color.red);
                        tablero[figura.getX2()][figura.getY2()].setBackground(Color.red);
                        tablero[figura.getX3()][figura.getY3()].setBackground(Color.red);
                        tablero[figura.getX4()][figura.getY4()].setBackground(Color.red);
                    } else {
                        finalizo = true;
                    }

                    break;
                case 5:
                    if (figura.getY1() < (limite - 1) && (tablero[figura.getX1()][figura.getY1()].getBackground() != Color.red || tablero[figura.getX1()][figura.getY1()].getBackground() != Color.YELLOW) && posicion == false) {
                        tablero[figura.getX1()][figura.getY1() - 1].setBackground(Color.white);
                        tablero[figura.getX2()][figura.getY2() - 1].setBackground(Color.white);
                        tablero[figura.getX4()][figura.getY4() - 1].setBackground(Color.white);
                        tablero[figura.getX1()][figura.getY1()].setBackground(Color.red);
                        tablero[figura.getX2()][figura.getY2()].setBackground(Color.red);
                        tablero[figura.getX3()][figura.getY3()].setBackground(Color.red);
                        tablero[figura.getX4()][figura.getY4()].setBackground(Color.red);
                    } else if (figura.getY3() < (limite - 1) && (tablero[figura.getX3()][figura.getY3()].getBackground() != Color.red || tablero[figura.getX3()][figura.getY3()].getBackground() != Color.YELLOW) && posicion) {
                        tablero[figura.getX1()][figura.getY1() - 1].setBackground(Color.white);
                        tablero[figura.getX4()][figura.getY4() - 1].setBackground(Color.white);
                        tablero[figura.getX1()][figura.getY1()].setBackground(Color.red);
                        tablero[figura.getX2()][figura.getY2()].setBackground(Color.red);
                        tablero[figura.getX3()][figura.getY3()].setBackground(Color.red);
                        tablero[figura.getX4()][figura.getY4()].setBackground(Color.red);
                    } else {
                        finalizo = true;
                    }
                    break;
                case 6:
                    if (figura.getY1() < (limite - 1) && (tablero[figura.getX1()][figura.getY1()].getBackground() != Color.red || tablero[figura.getX1()][figura.getY1()].getBackground() != Color.YELLOW) && posicion == false) {
                        tablero[figura.getX1()][figura.getY1() - 1].setBackground(Color.white);
                        tablero[figura.getX2()][figura.getY2() - 1].setBackground(Color.white);
                        tablero[figura.getX4()][figura.getY4() - 1].setBackground(Color.white);
                        tablero[figura.getX1()][figura.getY1()].setBackground(Color.red);
                        tablero[figura.getX2()][figura.getY2()].setBackground(Color.red);
                        tablero[figura.getX3()][figura.getY3()].setBackground(Color.red);
                        tablero[figura.getX4()][figura.getY4()].setBackground(Color.red);
                    } else if (figura.getY3() < (limite - 1) && (tablero[figura.getX3()][figura.getY3()].getBackground() != Color.red || tablero[figura.getX3()][figura.getY3()].getBackground() != Color.YELLOW) && posicion) {
                        tablero[figura.getX1()][figura.getY1() - 1].setBackground(Color.white);
                        tablero[figura.getX3()][figura.getY3() - 1].setBackground(Color.white);
                        tablero[figura.getX1()][figura.getY1()].setBackground(Color.red);
                        tablero[figura.getX2()][figura.getY2()].setBackground(Color.red);
                        tablero[figura.getX3()][figura.getY3()].setBackground(Color.red);
                        tablero[figura.getX4()][figura.getY4()].setBackground(Color.red);
                    } else {
                        finalizo = true;
                    }
                    break;
                case 7:
                    if (figura.getY3() < (limite - 1) && (tablero[figura.getX3()][figura.getY3()].getBackground() != Color.red || tablero[figura.getX3()][figura.getY3()].getBackground() != Color.YELLOW) && posicion == false) {
                        tablero[figura.getX1()][figura.getY1() - 1].setBackground(Color.white);
                        tablero[figura.getX2()][figura.getY2() - 1].setBackground(Color.white);
                        tablero[figura.getX4()][figura.getY4() - 1].setBackground(Color.white);
                        tablero[figura.getX1()][figura.getY1()].setBackground(Color.red);
                        tablero[figura.getX2()][figura.getY2()].setBackground(Color.red);
                        tablero[figura.getX3()][figura.getY3()].setBackground(Color.red);
                        tablero[figura.getX4()][figura.getY4()].setBackground(Color.red);
                    } else if (figura.getY2() < (limite - 1) && (tablero[figura.getX2()][figura.getY2()].getBackground() != Color.red || tablero[figura.getX2()][figura.getY2()].getBackground() != Color.YELLOW) && posicion) {
                        tablero[figura.getX1()][figura.getY1() - 1].setBackground(Color.white);
                        tablero[figura.getX3()][figura.getY3() - 1].setBackground(Color.white);
                        tablero[figura.getX1()][figura.getY1()].setBackground(Color.red);
                        tablero[figura.getX2()][figura.getY2()].setBackground(Color.red);
                        tablero[figura.getX3()][figura.getY3()].setBackground(Color.red);
                        tablero[figura.getX4()][figura.getY4()].setBackground(Color.red);
                    } else {
                        finalizo = true;
                    }
                    break;
                default:
                    System.out.println("error");

            }
        }
    }

}
