/*
 * FrmJogo.java
 *
 * Created on 7 de Agosto de 2008, 09:51
 */
package frame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import base.Bola;
import jogo.Game;
import base.Raquete;
import javax.swing.JOptionPane;

/**
 *
 * @author Glauco
 */
public class FrmJogo extends javax.swing.JFrame implements Runnable {

    private boolean esquerdo = false;
    private boolean direito = false;
    private boolean tiro = false;

    /**
     * Creates new form FrmJogo
     */
    public FrmJogo() {
        initComponents();
        this.setSize(1000,600);

        //Constroi um buffer duplo
        createBufferStrategy(2);

        //Constroi uma Thread
        Thread t = new Thread(this);

        //Start a Thread
        t.start();

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            esquerdo = true;
        }

        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            direito = true;
        }
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            tiro = true;
        }


    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            esquerdo = false;
        }

        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            direito = false;
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            tiro             = false;
        }


    }//GEN-LAST:event_formKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmJogo().setVisible(true);

            }
        });
    }
    public void run() {
        tiro = false;
        esquerdo = false;
        direito = false;
        BufferStrategy buffer = getBufferStrategy();
        Graphics bg;

        Raquete player = new Raquete(getWidth() / 2 - 40, getHeight() - 50, "../imagem/nave.gif");
       
        Game g = new Game(getWidth(), getHeight(), player);
        
        for(int i = 0; i<4; i++){
            for(int j = 0; j<5; j++){
                g.add(new Bola((getWidth()/5)*j + 50, -10-i*100, "../imagem/alien.jpg"));
            }
        }
        g.add(player);
       
        while (true) {

            //Aloca o Graphics
            bg = buffer.getDrawGraphics();

            bg.setFont(new Font("Dialog",Font.ITALIC,25));
            
            if(g.upDate(bg) == 1){
              JOptionPane.showMessageDialog(this,"GAME OVER!");
              run();
            }else if(g.upDate(bg) == 0){
              JOptionPane.showMessageDialog(this,"YOU WIN!");
            }
            g.setPlayerActions(direito, esquerdo, tiro);
                
            //Libera o Graphics
            bg.dispose();

            //Mostra o desenho
            buffer.show();

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {

            }

        }

    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
