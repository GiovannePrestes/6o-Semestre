package aula;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * Bola.java
 *
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author glauco
 */
public class Bola {
    private int x = 50;
    private int y = 50;
    private int largura = 50;
    private int altura = 50;
    private int incX = 1;
    private int incY = 1;
    private Rectangle rect;
    private Color corColisao;
    private Color color;

    public Bola(Color color, Color corColisao) {
        this.color = color;
        this.corColisao = corColisao;
        rect = new Rectangle(x, y, largura, altura);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;

    }

    public void move() {

        y += incY;
        x += incX;
        rect.setBounds(x, y, largura, altura);

    }

    public void setIncX(int incX) {
        this.incX = incX;
    }

    public void setIncY(int incY) {
        this.incY = incY;
    }

    public void desenha(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, largura, altura);

    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getIncX() {
        return incX;
    }

    public boolean colisao(Bola b) {
        return rect.intersects(b.rect) 
                && corColisao.equals(b.getColor());
    }

    

    void aumentarTamanho() {
        altura *= 1.05;
        largura *= 1.05;
    }

    void colisaoForm(int width, int height) {
        if (x > width - largura) {
            incX = -1;
        }
        if (x < 0) {
            incX = 1;
        }

        if (y < 0) {
            incY = 1;
        }

        if (y > height - altura ) {
            incY = -1;
        }

    }

}
