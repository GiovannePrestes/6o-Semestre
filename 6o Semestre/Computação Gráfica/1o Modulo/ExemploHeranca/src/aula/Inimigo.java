package aula;

import java.awt.Color;
import java.awt.Graphics;
/*
 * Bola.java
 *
 * Created on 25 de Março de 2008, 21:46
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author glauco
 */
public class Inimigo extends Elemento {
    
     public Inimigo(Color color, int x, int y, int largura, int altura, int incX)
     {
        setColor(color);
        setX(x);
        setY(y);
        setLargura(largura);
        setAltura(altura);
        setIncX(incX);
         setIncY(0);
     }
         
     @Override
     public void desenhar(Graphics g)
     {
         g.setColor(getColor());
         g.fillRect(getX(),getY(),getLargura(),getAltura());
    }

    void getIncX(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
