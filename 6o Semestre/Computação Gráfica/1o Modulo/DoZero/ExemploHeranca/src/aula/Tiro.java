package aula;



import java.awt.Graphics;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author glauco
 */
public  class  Tiro extends Elemento {

    public Tiro(int altura, int largura)
    {
       setAltura(altura);
       setLargura(largura);
    }
    
    
    @Override
    public void desenhar(Graphics g) {
        g.setColor(getColor());
        g.fillRect(x,y,largura, altura);
        
    }
    
}



