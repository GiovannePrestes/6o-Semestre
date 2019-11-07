/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

/**
 *
 * @author Giovanne Prestes
 */
public class Chefao extends Base{
    private int vida = 10;
    public Chefao(int x, int y, String path){
        super(x, y, path);
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
}
