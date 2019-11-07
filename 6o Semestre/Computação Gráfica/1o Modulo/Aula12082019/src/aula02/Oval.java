/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula02;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author Giovanne Prestes
 */
public class Oval {
    private int x = 50;
    private int y = 50;
    private int mexeX = 1;
    private int mexeY = 1;
    private int widthBall = 10;
    private int heightBall = 10;
    private Color c;
    private Color cColisao;
    private int xaux = 0;
    private int yaux = 0;
    private Graphics g;
    private Rectangle rect;

    public Oval(Color c, Graphics g, Color cColisao) {
        this.c = c;
        this.g = g;
        this.cColisao = cColisao;
        rect.height = heightBall;
        rect.width = widthBall;
        
    }
    
    public void move(int widthScreen, int heightScreen){
        if(xaux<=this.getX() && yaux<=this.getY()){ //(+,+)
                xaux=x;
                yaux=y;
                x += mexeX;
                y += mexeY;
            }else if(xaux<this.getX() && yaux>this.getY()){ // (+,-)
                xaux=x;
                yaux=y;
                x += mexeX;
                y -= mexeY;
            }else if(xaux>this.getX() && yaux>this.getY()){ // (-,-)
                xaux=x;
                yaux=y;
                x -= mexeX;
                y -= mexeY;
            }else{ //(-,+)
                xaux=x;
                yaux=y;
                x -= mexeX;
                y += mexeY;
            }
            
            if(y > (heightScreen-heightBall)){
                yaux = y;
                y -= mexeY;
            }else if(x > (widthScreen-widthBall)){
                xaux=x;
                x -= mexeX;
            }else if(y < 20){
                yaux=y;
                y += mexeY;
            }else if(x < 0){
                xaux = x;
                x += mexeX;
            }
    }
    
    public void pintarBola(){
        g.setColor(c);
        g.fillOval(x, y, widthBall, heightBall);
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, widthBall, heightBall);
    }
    
    public void collision(ArrayList<Oval> o){
        ArrayList<Oval> delete = new ArrayList();
        for(Oval ov: o){
            if(c == Color.blue)
                if(ov.getC()== Color.red && this.getBounds().intersects(ov.getBounds())){
                    widthBall*=1.05;
                    heightBall*=1.05;
                    ov.setC(Color.yellow);
                    delete.add(ov);
                }
        }
        o.removeAll(delete);
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

    public int getWidthBall() {
        return widthBall;
    }

    public void setWidthBall(int widthBall) {
        this.widthBall = widthBall;
    }

    public int getHeightBall() {
        return heightBall;
    }

    public void setHeightBall(int heightBall) {
        this.heightBall = heightBall;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }
    
    
}
