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

    protected int x = 50;
    protected int y = 50;
    protected int largura = 50;
    protected int altura = 50;
    private Color color;
    private int incX = 1;
    private int incY = 1;
    private Rectangle rect = new Rectangle();

    public boolean colisao(Elemento elemento) {
        return rect.intersects(elemento.rect);
    }

    public abstract void desenhar(Graphics g);


    public void mover() {
        setY(getY() + incY);
        setX(getX() + incX);
        rect.setBounds(x, y, largura, altura);
    }
    
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

    public void setIncX(int incX) {
        this.incX = incX;
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
