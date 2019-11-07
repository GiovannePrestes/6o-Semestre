package aula;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author glauco
 */
public abstract class Elemento {

    protected int x;
    protected int y;
    protected int largura;
    protected int altura;
    private Color color;
    private int incX;
    private int incY;
    private Rectangle rect = new Rectangle();

    public boolean colisao(Elemento elemento) {
        return rect.intersects(elemento.rect);
    }

    public abstract void desenhar(Graphics g);

    public int getAltura() {
        return altura;
    }

    public Color getColor() {
        return color;
    }

    public int getLargura() {
        return largura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void mover() {
        setX(getX() + incX);
        setY(getY() + incY);
        rect.setBounds(getX(), getY(), getLargura(), getAltura()-5);
    }

    public int getIncX() {
        return incX;
    }

    public void setIncX(int incX) {
        this.incX = incX;
    }

    public int getIncY() {
        return incY;
    }

    public void setIncY(int incY) {
        this.incY = incY;
    }
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

}
