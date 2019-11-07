/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Abutua
 */
public abstract  class Base {
    
     protected int x;
     protected int y;
     protected int incX=1;
     protected int incY=1;
     protected int largura;
     protected int altura;
     protected Rectangle rect;
     protected Image img;
     
              
    
     public Base(){
     }
     
     public Base(int x, int y, String path) {
        this.x = x;
        this.y = y;

        
        URL url = this.getClass().getResource(path);
        img     = new ImageIcon(url).getImage();
                   
        this.largura = img.getWidth(null);
        this.altura = img.getHeight(null);
        rect = new Rectangle(x,y,largura,altura);
        
        
    }

     
    public void mover()
    {
       this.x = x + incX;
       this.y = y + incY;
       rect.x = x;
       rect.y = y;
    }
    
    public boolean colisaoCom(Base b)
    {
        if(this.getClass().equals(b.getClass()))
            return false;
        else            
            return this.rect.intersects(b.rect);
    }
    
    
    
    public  void desenhar(Graphics g)
    {
         g.drawImage(img,x, y, null);
         
    }
    
    
    
    
    
     
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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

     
     
     
     
    
}
