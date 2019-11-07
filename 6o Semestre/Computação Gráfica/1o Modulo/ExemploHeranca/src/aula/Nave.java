package aula;


import java.awt.Color;
import java.awt.Graphics;

public class Nave extends Elemento
{
    public Nave(Color color, int x, int y, int largura, int altura, int incY)
     {
        setColor(color);
        setX(x);
        setY(y);
        setLargura(largura);
        setAltura(altura);
        setIncX(0);
        setIncY(incY);
     }
    @Override
    public void desenhar(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getLargura(), getAltura());
    }

}  
   