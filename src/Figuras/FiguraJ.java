/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Figuras;

/**
 *
 * @author Alex
 */
public class FiguraJ implements pieza {

    private int x1, x2, x3, x4;
    private int y1, y2, y3, y4;
    private boolean vertical, horizontal;

    public FiguraJ(int x1, int x2, int x3,int x4, int y1, int y2,int val) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.y1 = y1;
        this.y2 = this.y3 = this.y4 = y2;
        this.horizontal = true;
    }

    public FiguraJ(int x1, int x2, int y1, int y2, int y3, int y4) {
        this.x1 = x1;
        this.x2 = this.x3 = this.x4 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.y4 = y4;
        this.vertical = true;
    }

    @Override
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    @Override
    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    @Override
    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    @Override
    public int getX4() {
        return x4;
    }

    public void setX4(int x4) {
        this.x4 = x4;
    }

    @Override
    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    @Override
    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    @Override
    public int getY4() {
        return y4;
    }

    public void setY4(int y4) {
        this.y4 = y4;
    }

    @Override
    public void mover() {
        if (horizontal) {
            y1++;
            y2 = y1+1;
            y3 = y1+1;
            y4 = y1+1;

        } else if (vertical) {
            y1++;
            y2++;
            y3++;
            y4++;
        }
    }
}
