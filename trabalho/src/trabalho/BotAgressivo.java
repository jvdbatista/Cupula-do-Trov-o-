/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import Painel.Gambiarra;
import Painel.Matriz2;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class BotAgressivo extends Guerreiro{
    private int contadorArmas;
    
    public BotAgressivo(){
        this.ataque = 0;
        this.defesa = 0;
        armas = new ArrayList();
        escudos = new ArrayList();
        contadorArmas = 0;
    }
    @Override
    public void moverGuerreiro(Cupula arena, ArrayList<Guerreiro> guerreiros, int index, int arenaTamanho, boolean erro,Matriz2 t){
        Elemento[][] tabuleiro = (Elemento[][]) arena.getTabuleiro();
        Guerreiro g;
        Random r = new Random();
        t.minhavezAgro(getI(), getJ());
        Gambiarra gb = new Gambiarra(null,true,getAtaque(),getDefesa(),getI(),getJ(),arena);
        gb.setVisible(true);
        int x = 0, y = 0;
        
        System.out.println("O proximo guerreiro a sem mover pertence a posicao Y:" + getI());
        System.out.println("e X: " + getJ());
        
        if(contadorArmas < 3 && arena.checarTabuleiro('A')){
            boolean confirmar = false;
            do{
                y = r.nextInt(arenaTamanho);
                x = r.nextInt(arenaTamanho);
                if(tabuleiro[x][y] instanceof Arma){
                  confirmar = true;
                }
            }while(!confirmar);
        }
        else{
            boolean achou = false;
            for(int i = 0; i < guerreiros.size() && !achou; i++){
                g = (Guerreiro) guerreiros.get(i);
                if(this.ataque > g.getAtaque()){
                    x = g.getI();
                    y = g.getJ();
                    achou = true;
                }
            }
            if(!achou){
                if(arena.checarTabuleiro('A')){
                    boolean confirmar = false;
                    do{
                        y = r.nextInt(arenaTamanho);
                        x = r.nextInt(arenaTamanho);
                        if(tabuleiro[x][y] instanceof Arma){
                          confirmar = true;
                        }
                    }while(!confirmar);
                }
                else if(arena.checarTabuleiro('E')){
                    boolean confirmar = false;
                    do{
                        y = r.nextInt(arenaTamanho);
                        x = r.nextInt(arenaTamanho);
                        if(tabuleiro[x][y] instanceof Escudo){
                          confirmar = true;
                        }
                    }while(!confirmar);
                }
                else{
                    boolean confirmar = false;
                    do{
                        y = r.nextInt(arenaTamanho);
                        x = r.nextInt(arenaTamanho);
                        if(tabuleiro[x][y] == null){
                          confirmar = true;
                        }
                    }while(!confirmar);
                }
            }
        }
        if(erro){
            do{
               int n;
               n = r.nextInt(8);
               if(n == 4){
                   x--;
               }
               else if(n == 5){
                   y--;
               }
               else if(n == 6){
                   x++;
               }
               else if(n == 7){
                   y++;
               }
            }while(x >= arenaTamanho || y >= arenaTamanho || x < 0 || y < 0);
        }
        else{
            do{
               int n;
               n = r.nextInt(16);
               if(n == 8){
                   x--;
               }
               else if(n == 9){
                   y++;
               }
               else if(n == 10){
                   x++;
               }
               else if(n == 11){
                   y--;
               }
               else if(n == 12){
                   x--;
                   y--;
               }
               else if(n == 13){
                   x--;
                   y++;
               }
               else if(n == 14){
                   x++;
                   y++;
               }else if(n == 15){
                   x++;
                   y--;
               }
            }while(x >= arenaTamanho || y >= arenaTamanho || x < 0 || y < 0);
        }
        if(tabuleiro[x][y] instanceof Arma){
           t.alteracoesGueArgro(getI(), getJ(), x, y);
            encontraArma(tabuleiro, x, y);
            g = (Guerreiro) tabuleiro[getI()][getJ()];
            tabuleiro[getI()][getJ()] = null;
            tabuleiro[x][y] = null;
            tabuleiro[x][y] = g;
            setI(x);
            setJ(y);
        }
        else if(tabuleiro[x][y] instanceof Escudo){
            t.alteracoesGueArgro(getI(), getJ(), x, y);
            encontraEscudo(tabuleiro, x, y);
            g = (Guerreiro) tabuleiro[getI()][getJ()];
            tabuleiro[getI()][getJ()] = null;
            tabuleiro[x][y] = null;
            tabuleiro[x][y] = g;
            setI(x);
            setJ(y);
        }
        else if(tabuleiro[x][y] instanceof Armadilha){
            if(encontraArmadilha(tabuleiro, x, y)){
                t.alteracoesArmaDAgro(getI(), getJ(), x, y, true);
                g = (Guerreiro) tabuleiro[getI()][getJ()];
                tabuleiro[getI()][getJ()] = null;
                tabuleiro[x][y] = null;
                tabuleiro[x][y] = g;
                setI(x);
                setJ(y);
            }
            else{
                t.alteracoesArmaDAgro(getI(), getJ(), x, y, false);
                guerreiros.remove(index);
                tabuleiro[getI()][getJ()] = null;
            }
        }
        else if(tabuleiro[x][y] instanceof Guerreiro){
            Guerreiro g2;
            g2 = (Guerreiro) tabuleiro[x][y];
            if(getI() == x && getJ() == y){
                return;
            }
            else{
                if(lutaGuerreiros(g2)){
                   t.combateAgro(getI(), getJ(), x, y, true);
                   guerreiros.remove(g2);
                   g = (Guerreiro) tabuleiro[getI()][getJ()];
                   tabuleiro[getI()][getJ()] = null;
                   tabuleiro[x][y] = null;
                   tabuleiro[x][y] = g;
                   setI(x);
                   setJ(y);
                }
                else{
                    t.combateAgro(getI(), getJ(), x, y, false);
                    guerreiros.remove(index);
                    tabuleiro[getI()][getJ()] = null;
                }
            }
        }
        else if(tabuleiro[x][y] == null){
            t.alteracoesGueArgro(getI(), getJ(), x, y);
            g = (Guerreiro) tabuleiro[getI()][getJ()];
            tabuleiro[getI()][getJ()] = null;
            tabuleiro[x][y] = null;
            tabuleiro[x][y] = g;
            setI(x);
            setJ(y);
        }
    }

    
}
   
    
