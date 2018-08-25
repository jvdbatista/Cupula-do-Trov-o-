/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Painel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import trabalho.Arma;
import trabalho.Armadilha;
import trabalho.BotAgressivo;
import trabalho.BotBurro;
import trabalho.Cupula;
import trabalho.Elemento;
import trabalho.Escudo;
import trabalho.PlayerRandom;
import trabalho.PlayerTeclado;

/**
 *
 * @author jvdba
 */
public class Matriz2 extends javax.swing.JPanel {
private Cupula arena;
private Elemento[][] tabuleiro;   
/** Creates new form Matriz2 */
    public JPanel panel;
    public JLabel[][] matriz;
	
        public Matriz2(Cupula arena){
            this.arena = arena;
            initComponents();
            componentes();
            this.setVisible(true);
        }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
public void componentes(){
		int m = arena.getM();
                this.tabuleiro = arena.getTabuleiro();
                Random r = new Random();
		this.setLayout(new BorderLayout());
		matriz = new JLabel[m][m];
		panel = new JPanel();
		panel.setLayout(new GridLayout(m,m));
		panel.setBackground(Color.BLACK);
                for(int i = 0; i < m; i++){
			for(int j = 0; j < m; j++){
				JLabel l = new JLabel();
                                if(tabuleiro[i][j] == null){
                                //l.setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\vazio.jpeg")));
                                l.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.jpeg"))); 
                                }
                                else if(tabuleiro[i][j] instanceof PlayerTeclado){
                                //l.setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\Guerrerinho.jpeg")));
                                l.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Guerrerinho.jpeg"))); // NOI18N

                                }
                                else if(tabuleiro[i][j] instanceof Arma){
                                //l.setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\Arma.jpeg")));
                                l.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Arma.jpeg"))); 
                                }
                                else if(tabuleiro[i][j] instanceof Armadilha){
                                //l.setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\Armadilha.jpeg")));
                                l.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Armadilha.jpeg"))); 
                                } 
                                else if(tabuleiro[i][j] instanceof Escudo){
                                //l.setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\Escudo.jpeg")));
                                l.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Escudo.jpeg"))); 
                                }
                                else if(tabuleiro[i][j] instanceof BotBurro){
                                //l.setIcon((new javax.swing.ImageIcon("")));
                                l.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Burro.jpeg"))); 
                                }
                                else if(tabuleiro[i][j] instanceof PlayerRandom){
                               // l.setIcon((new javax.swing.ImageIcon("")));
                                  l.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Guerrerinho.jpeg")));
                                }
                                else if(tabuleiro[i][j] instanceof BotAgressivo){
                                //l.setIcon((new javax.swing.ImageIcon("")));
                                  l.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Agro.jpeg")));
                                }
                                l.setHorizontalAlignment(JLabel.CENTER);	
				matriz[i][j] = l;
				panel.add(matriz[i][j]);
			}
		}
		this.add(panel, BorderLayout.CENTER);//C:\\Users\\jvdba\\Desktop\\mamitinha\\WhatsApp Image 2018-02-21 at 22.38.59.jpeg
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

public void soArmadilha(int i,int j){
           matriz[i][j].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\Armadilha.jpeg")));
}
public void alteracoesArmaD(int i,int j,int i2,int j2,boolean venci){
          //matriz[i][j].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\vazio.jpeg")));
          matriz[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.jpeg"))); 
          if(venci == true){
          //matriz[i2][j2].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\Guerrerinho.jpeg")));
          matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Guerrerinho.jpeg"))); // NOI18N
          }
          else{
          //matriz[i2][j2].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\Armadilha.jpeg")));
          matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Armadilha.jpeg"))); 
          }
}

public void alteracoesArmaDBurro(int i,int j,int i2,int j2,boolean venci){
          //matriz[i][j].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\vazio.jpeg")));
          matriz[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.jpeg"))); 
          if(venci == true){
          //matriz[i2][j2].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\Guerrerinho.jpeg")));
         // matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/.jpeg"))); // NOI18N
          matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Burro.jpeg"))); 
          }
          else{
          //matriz[i2][j2].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\Armadilha.jpeg")));
          matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Armadilha.jpeg"))); 
          }
}
public void alteracoesArmaDRandom(int i,int j,int i2,int j2,boolean venci){
          //matriz[i][j].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\vazio.jpeg")));
          matriz[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.jpeg"))); 
          if(venci == true){
          //matriz[i2][j2].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\Guerrerinho.jpeg")));
          matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Guerrerinho.jpeg"))); // NOI18N
          }
          else{
          //matriz[i2][j2].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\Armadilha.jpeg")));
          matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Armadilha.jpeg"))); 
          }
}

public void alteracoesArmaDAgro(int i,int j,int i2,int j2,boolean venci){
          //matriz[i][j].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\vazio.jpeg")));
          matriz[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.jpeg"))); 
          if(venci == true){
          //matriz[i2][j2].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\Guerrerinho.jpeg")));
          matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Agro.jpeg"))); // NOI18N
          }
          else{
          //matriz[i2][j2].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\Armadilha.jpeg")));
          matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Armadilha.jpeg"))); 
          }
}

public void alteracoesGue(int i,int j,int i2,int j2){
            //matriz[i][j].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\vazio.jpeg")));
           // matriz[i2][j2].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\Guerrerinho.jpeg")));
           matriz[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.jpeg"))); 
           matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Guerrerinho.jpeg")));
    }
public void alteracoesGueBurro(int i,int j,int i2,int j2){
           matriz[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.jpeg"))); 
           //matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/.jpeg")));
           matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Burro.jpeg"))); 
    }
public void alteracoesGueRandom(int i,int j,int i2,int j2){
           matriz[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.jpeg"))); 
           matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Guerrerinho.jpeg")));
    }
public void alteracoesGueArgro(int i,int j,int i2,int j2){
           matriz[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.jpeg"))); 
           matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Agro.jpeg")));
    }

public void combate(int i,int j,int i2,int j2,boolean venci){
          //matriz[i][j].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\vazio.jpeg")));
          matriz[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.jpeg"))); 
          if(venci == true){
          //matriz[i2][j2].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\Guerrerinho.jpeg")));
          matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Guerrerinho.jpeg"))); // NOI18N
          }
    }
public void combateBurro(int i,int j,int i2,int j2,boolean venci){
          //matriz[i][j].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\vazio.jpeg")));
          matriz[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.jpeg"))); 
          if(venci == true){
          //matriz[i2][j2].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\Guerrerinho.jpeg")));
          //matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/.jpeg")));
          matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Burro.jpeg"))); 
          }
    }
public void combateRandom(int i,int j,int i2,int j2,boolean venci){
          //matriz[i][j].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\vazio.jpeg")));
          matriz[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.jpeg"))); 
          if(venci == true){
          //matriz[i2][j2].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\Guerrerinho.jpeg")));
          matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Guerrerinho.jpeg"))); // NOI18N
          }
    }
public void combateAgro(int i,int j,int i2,int j2,boolean venci){
          //matriz[i][j].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\vazio.jpeg")));
          matriz[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vazio.jpeg"))); 
          if(venci == true){
          //matriz[i2][j2].setIcon((new javax.swing.ImageIcon("C:\\Users\\jvdba\\Desktop\\mamitinha\\Guerrerinho.jpeg")));
          matriz[i2][j2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Agro.jpeg"))); // NOI18N
          }
    }

public void minhavez(int i,int j){
 matriz[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Guerrerinhov.jpeg"))); 

}
public void minhavezBurro(int i,int j){
 matriz[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Burrov.jpeg"))); 

}
public void minhavezAgro(int i,int j){
 matriz[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Agrov.jpeg"))); 

}
}