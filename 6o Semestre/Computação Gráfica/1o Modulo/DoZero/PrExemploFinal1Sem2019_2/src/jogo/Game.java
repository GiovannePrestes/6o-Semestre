/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import base.Base;
import audio.PlayWave;
import base.Bola;
import base.Chefao;
import base.Tiro;
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
    long ultimoTiro  = System.currentTimeMillis();
    long tiroCorrente= 0;
    long tiroCorrentecChefao = 0;
    long ultimoTiroChefao = System.currentTimeMillis();
    ArrayList<Tiro> tirosControle = new ArrayList<Tiro>();
    ArrayList<Tiro> tirosControleChefao = new ArrayList<Tiro>();
    private ArrayList<Bola> inimigo = new ArrayList<Bola>();
    private Chefao chefao = new Chefao(1, 1, "../imagem/alien.jpg");
    

    public Game(int largura, int altura, Base player) {
        this.largura = largura;
        this.altura = altura;
        this.player = player;
        player.setIncY(0);
        this.player = player;
        
        PlayWave.novoAudio("../audio/chord.wav");
    }   
    
    public int upDate(Graphics bg)
    {       
        limpaTela(bg);
        if(fimDeJogo)
        {
            fimDeJogo(bg);
            return 0;
        }
        else
        {
            moverTodos();
            desenharTodos(bg);
            desenharPlacar(bg);
            if(verificarColisaoComPlayer())
                return 1;
            verificarDano();
            verificarColisaoComGame();
            containsChefao();
            if(verificarTiro())
                return 1;
            acabouInimigo();
            verificarFim();
        }
        return 2;
    }    
    
    public void add(Base b)
    {
        objetos.add(b);
        if(b instanceof Bola)
            inimigo.add((Bola) b);
    }

    public void setPlayerActions(boolean direito, boolean esquerdo, boolean tiro) {
        if(tiro)
        {
           tiroCorrente = System.currentTimeMillis(); 
           if(tiroCorrente > ultimoTiro+300) 
           {
                ultimoTiro  = System.currentTimeMillis();
                Tiro t = new Tiro(player.getX()+player.getLargura()/2, player.getY() - 11, "../imagem/fire.png");
                t.setAltura(10);
                t.setLargura(5);
                t.setIncY(-1);
                t.setIncX(0);
                tirosControle.add(t);

                objetos.add(t);
           }
        }else{
            if (direito && player.getX() < largura - player.getLargura()) {
                player.setIncX(2);
            } else if (esquerdo && player.getX() > 0) {
                player.setIncX(-2);
            } else {
                player.setIncX(0);
            }
        }
    }

    private void moverTodos() {
        for (Base b : objetos)
                b.mover();
    }

    private void desenharTodos(Graphics bg) {
     for (Base b : objetos)
                b.desenhar(bg);
    }

    private boolean verificarColisaoComPlayer() {
            for(Base ini: inimigo)
            {
                if(player.colisaoCom(ini) || ini.getY() > altura-ini.getAltura())
                {
                    return true;
                }
            }
            return false;
    }

    private void verificarColisaoComGame() {

        for(Base b: objetos)
        {
            if(b instanceof Tiro){
                if(b.getX() < 0)
                    b.setIncX(1);

                if(b.getY() < 25){
                    b.setIncY(1);
                }

                if(b.getX() > largura - b.getLargura())
                    b.setIncX(-1);
            }
            
        }
    }

    private boolean verificarTiro(){
        for(int t=0;t<tirosControle.size();t++)
            {   
                
                
                boolean remove = false;
                if(tirosControle.get(t).getY() < 0)
                {
                    remove=true;
                }
                
                for(int ini=0;ini< inimigo.size();ini++)
                {
                    if(tirosControle.get(t).colisaoCom(inimigo.get(ini)))
                    {
                        objetos.remove(inimigo.get(ini));
                        inimigo.remove(ini);
                        remove =true;
                    }
                }
                if(tirosControle.get(t).colisaoCom(chefao)){
                    objetos.remove(tirosControle.get(t));
                    chefao.setVida(chefao.getVida()-1);
                    if(chefao.getVida()==0){
                        return true;
                    }
                }
                if(remove){
                    objetos.remove(tirosControle.get(t));
                    tirosControle.remove(t);
                    
                }
            }
        return false;
    }
    
    private void containsChefao(){
        if(objetos.contains(chefao))
        {
            tiroCorrentecChefao = System.currentTimeMillis();
            if(tiroCorrentecChefao > ultimoTiroChefao +1000){
                ultimoTiroChefao  = System.currentTimeMillis();
                for(int i=chefao.getX();i<=chefao.getX()+chefao.getLargura();i+= (chefao.getX()+chefao.getLargura())/5)
                {
                    Tiro t = new Tiro(i,chefao.getY()+chefao.getAltura(), "../imagem/alien.jpg");
                    t.setAltura(10);
                    t.setLargura(5);
                    t.setIncY(1);
                    t.setIncX(0);
                    tirosControleChefao.add(t);
                    objetos.add(t);
                }
            }
        }
    }
    
    public void acabouInimigo()
    {
        if(inimigo.isEmpty() && !objetos.contains(chefao))
            {
                chefao.setAltura(150);
                chefao.setLargura(150);
                chefao.setX(largura/2);
                chefao.setX(150);
                chefao.setIncX(1);
                chefao.setIncY(0);
                objetos.add(chefao);
                
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
    
    public Base getPlayer() {
        return player;
    }

    public void setPlayer(Base player) {
        this.player = player;
    }
    
}
