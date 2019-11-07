/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import base.Base;
import audio.PlayWave;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Abutua
 */
public class Game {
    
    private ArrayList<Base> objetos = new ArrayList<Base>();
    private ArrayList <Base> lixo = new ArrayList<Base>();
    private Base player;
    private int placar=0;
    private int largura;
    private int altura;
    private int danos=0;
    private boolean fimDeJogo= false;
    
    

    public Game(int largura, int altura, Base player) {
        this.largura = largura;
        this.altura = altura;
        this.player = player;
        player.setIncY(0);
        this.player = player;
        
        PlayWave.novoAudio("../audio/chord.wav");
    
    }

    public Base getPlayer() {
        return player;
    }

    public void setPlayer(Base player) {
        this.player = player;
    }

    
    
    public void upDate(Graphics bg)
    {
            
            limpaTela(bg);
            if(fimDeJogo)
            {
                fimDeJogo(bg);
            }
            else
            {
                moverTodos();
               
                desenharTodos(bg);
                desenharPlacar(bg);
                verificarColisaoComPlayer();
                verificarDano();
                verificarColisaoComGame();
                verificarFim();
            }

            
            
            
        
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
    
    
    public void add(Base b)
    {
        objetos.add(b);
    }

    public void setPlayerActions(boolean direito, boolean esquerdo) {
            if (direito && player.getX() < largura - player.getLargura()) {
                player.setIncX(1);
            } else if (esquerdo && player.getX() > 0) {
                player.setIncX(-1);
            } else {
                player.setIncX(0);
            }
    }

    private void moverTodos() {
        for (Base b : objetos) {
                b.mover();
            }
    }

    private void desenharTodos(Graphics bg) {
     for (Base b : objetos) {
                b.desenhar(bg);
            }
    }

    private void verificarColisaoComPlayer() {
            for(Base b: objetos)
            {
                if(player.colisaoCom(b))
                {
                    new PlayWave(0).start();
                    b.setIncY(-1);
                    placar++;
                }
            }
    }

    private void verificarColisaoComGame() {

        for(Base b: objetos)
        {
            if(b.getX() < 0)
                b.setIncX(1);
            
            if(b.getY() < 25){
                b.setIncY(1);
            }
            
            if(b.getX() > largura - b.getLargura())
                b.setIncX(-1);
            
        }
    }

    private void desenharPlacar(Graphics bg) {
        bg.setColor(Color.WHITE);
        bg.drawString("Placar: " + placar + " Danos: " + danos,50,100);
    }

    private void limpaTela(Graphics bg) {
        
        bg.setColor(Color.BLACK);
        bg.fillRect(0, 0, largura, altura);
            
    }

    private void verificarDano() {
        
        
        for(Base b: objetos)
        {
           if(b.getY() > altura)
           {
               danos ++;
               lixo.add(b);
               
           }    
        }
        
        objetos.removeAll(lixo);
        lixo.clear();
        
        
    }

    
    private void verificarFim() {
    
           if(objetos.size() == 1)
           {
               fimDeJogo = true;
           }
    }

    private void fimDeJogo(Graphics bg) {
        
        bg.setColor(Color.BLACK);
        String msg = "FIM DE JOGO";
        bg.drawString(msg,300,100);
    }
    
    
    
}
