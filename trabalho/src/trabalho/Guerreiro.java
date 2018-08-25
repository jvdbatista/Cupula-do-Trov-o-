/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import Painel.Matriz2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



/**
 *
 * @author jvdba
 */
public abstract class Guerreiro extends Elemento implements InteracoesMoveis{
    protected int ataque;
    protected int defesa;
    protected ArrayList<Arma> armas;
    protected ArrayList<Escudo> escudos;
    public ArrayList<Arma> getArma() {
        return armas;
    }

    public void setArma(ArrayList<Arma> arma) {
        this.armas = arma;
    }

    public ArrayList<Escudo> getEscudos() {
        return escudos;
    }

    public void setEscudos(ArrayList<Escudo> escudos) {
        this.escudos = escudos;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
    //Adiciona a arma ao arraylist e o ataque da arma ao do guerreiro
    public void pegarArma(Arma arma){
        armas.add(arma);
        this.ataque = this.ataque + arma.getPoder();
    }
    //Adiciona o escudo ao arraylist e a defesa ddo escudo ao do guerreiro
    public void pegarEscudo(Escudo escudo){
        escudos.add(escudo);
        this.defesa = this.defesa + escudo.getDefesa();
    }
    /*IRÁ dar sort no arraylist de escudos e jogar fora o mais forte, além de
    decrescer a defesa do escudo jogado fora da defesa do guerreiro */
    public void levarDano(Armadilha w){
        if (escudos.size() > 0){
          Collections.sort(this.escudos);
          this.defesa = this.defesa - (this.escudos.get(0)).getDefesa();
          this.escudos.remove(0);
        }
    }
    public void quebrarArma(){
        if (armas.size() > 0){
          Collections.sort(this.armas);
          this.ataque = this.ataque - (this.armas.get(0)).getPoder();
          this.armas.remove(0);
        }
    }
    
    public abstract void moverGuerreiro(Cupula arena, ArrayList<Guerreiro> guerreiros, int index, int arenaTamanho, boolean erro,Matriz2 t);
    
    @Override
    public void encontraArma(Elemento[][] tabuleiro, int x, int y){
        /*Se o guerreiro cair na mesma posiçao da arma, chama o metodo 
        de pegar arma do guerreiro e apaga a arma da posição
        */
        Arma a;
        a = (Arma) tabuleiro[x][y];
        pegarArma(a);

        // O mesmo que o de cima só que pra escudos
            
        }
    
    @Override
    public void encontraEscudo(Elemento[][] tabuleiro, int x, int y){
        Escudo e;
        e = (Escudo) tabuleiro[x][y] ;
        pegarEscudo(e);
    }
    
    @Override
    public  boolean encontraArmadilha(Elemento[][] tabuleiro, int x, int y){
        Armadilha w;
        w = (Armadilha) tabuleiro[x][y];
        if (getDefesa() > w.getDano()){
            levarDano(w);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean lutaGuerreiros(Guerreiro desafiante){
        if (getAtaque() > desafiante.getAtaque()){
            quebrarArma();
            return true;
        } 
        else if (getAtaque() < desafiante.getAtaque()){
            desafiante.quebrarArma();
            return false;
        } 
        else{
            Random r = new Random();
            int dado = r.nextInt(1);
            if (dado == 0){
                quebrarArma();
                return true;
            } 
            else {
                desafiante.quebrarArma();
                return false;
            }  
        }
   }
}
   