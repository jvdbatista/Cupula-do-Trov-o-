/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import Painel.Dialogo;
import Painel.Gambiarra;
import Painel.Matriz2;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Marcos
 */
public class PlayerTeclado extends Guerreiro{
    public PlayerTeclado(){
        this.ataque = 0;
        this.defesa = 0;
        armas = new ArrayList();
        escudos = new ArrayList();
    }
    
    @Override
    public void moverGuerreiro(Cupula arena, ArrayList<Guerreiro> guerreiros, int index, int arenaTamanho, boolean erro,Matriz2 t){
        Elemento[][] tabuleiro = (Elemento[][]) arena.getTabuleiro();
        Guerreiro g;
        Scanner reader = new Scanner(System.in);
        Random r = new Random();
        t.minhavez(getI(), getJ());
        Gambiarra gb = new Gambiarra(null,true,getAtaque(),getDefesa(),getI(),getJ(),arena);
        gb.setVisible(true);
        int x,y;
        System.out.println("O proximo guerreiro a sem mover pertence a posicao Y:" + getI());
        System.out.println("e X: " + getJ());
        do{
         Dialogo d = new Dialogo(null,true,arena);
         d.setVisible(true);
         x = d.getX();
         y = d.getY();    
            //System.out.println("Entre com as coordenadas de x e de y:");
            //System.out.print("Y: ");
            //x = reader.nextInt();
            //System.out.print("X: ");
            //y = reader.nextInt();
            if(x >= arenaTamanho || y >= arenaTamanho || x < 0 || y < 0){
                System.out.println("Erro 404: Voce e burro");
            }   
        }while(x >= arenaTamanho || y >= arenaTamanho || x < 0 || y < 0);
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
            t.alteracoesGue(getI(), getJ(), x, y);
            encontraArma(tabuleiro, x, y);
            g = (Guerreiro) tabuleiro[getI()][getJ()];
            tabuleiro[getI()][getJ()] = null;
            tabuleiro[x][y] = null;
            tabuleiro[x][y] = g;
            setI(x);
            setJ(y);
        }
        else if(tabuleiro[x][y] instanceof Escudo){
            encontraEscudo(tabuleiro, x, y);
            t.alteracoesGue(getI(), getJ(), x, y);
            g = (Guerreiro) tabuleiro[getI()][getJ()];
            tabuleiro[getI()][getJ()] = null;
            tabuleiro[x][y] = null;
            tabuleiro[x][y] = g;
            setI(x);
            setJ(y);
        }
        else if(tabuleiro[x][y] instanceof Armadilha){
            if(encontraArmadilha(tabuleiro, x, y)){
                t.alteracoesArmaD(getI(), getJ(), x, y, true);
                g = (Guerreiro) tabuleiro[getI()][getJ()];
                tabuleiro[getI()][getJ()] = null;
                tabuleiro[x][y] = null;
                tabuleiro[x][y] = g;
                setI(x);
                setJ(y);
            }
            else{
               t.alteracoesArmaD(getI(), getJ(), x, y, false);
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
                   t.combate(getI(), getJ(), x, y, true);
                   guerreiros.remove(g2);
                   g = (Guerreiro) tabuleiro[getI()][getJ()];
                   tabuleiro[getI()][getJ()] = null;
                   tabuleiro[x][y] = null;
                   tabuleiro[x][y] = g;
                   setI(x);
                   setJ(y);
                }
                else{
                    t.combate(getI(),getJ(),x,y,false);
                    guerreiros.remove(index);
                    tabuleiro[getI()][getJ()] = null;
                }
            }
        }
        else if(tabuleiro[x][y] == null){
            t.alteracoesGue(getI(), getJ(), x, y);
            g = (Guerreiro) tabuleiro[getI()][getJ()];
            tabuleiro[getI()][getJ()] = null;
            tabuleiro[x][y] = null;
            tabuleiro[x][y] = g;
            setI(x);
            setJ(y);
        }
    }

   
 
}
