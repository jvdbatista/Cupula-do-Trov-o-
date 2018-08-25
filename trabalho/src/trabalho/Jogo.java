/*ghk
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import Painel.Dialogo;
import Painel.Matriz2;
import Painel.NewJFrame;
import Painel.novo;
import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;

import java.util.Random;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Marcos
 */
public class Jogo extends Thread  implements Serializable {
    private Cupula arena;
    private int arenaTamanho;
    private boolean erro;
    private Matriz2 t;



    public Jogo(Cupula arena, boolean erro,Matriz2 t) {
         this.arena = arena;
        this.erro = erro;
        this.t = t;
        
    }

     
   
    public void play(){

        System.out.println("Bem vindo á Cupula do Trovao");
        while(((ArrayList<Guerreiro>)arena.getGuerreiros()).size() != 1){
           arena.printTabuleiro();            
           rodada(((ArrayList<Guerreiro>)arena.getGuerreiros()));
            Collections.shuffle(((ArrayList<Guerreiro>)arena.getGuerreiros()));
        }
        arena.printTabuleiro();
        System.out.println("E o fim");
    }
    
    
    public void rodada(ArrayList<Guerreiro> guerreiros){
        int turnos = 0;
        Random r = new Random();
    
        for(int i = 0; i < guerreiros.size(); i++){
            int x= 0, y = 0;
            arena.printTabuleiro();
            this.t.repaint();
            (guerreiros.get(i)).moverGuerreiro(arena, guerreiros, i, arena.getM(), erro,t);
            turnos++;
            arena.checarEspacos(arenaTamanho);
            if(turnos >= 10 && arena.isSemEspacos() == true) arena.adicionarArmadilhasTela(t);
        }

    }
   public void createArena(){
        int gladiadoresNum, trapsNum, armasNum, escudosNum;
        int arenaDimensao, valorErro;
        int playerRandom, playerTeclado, botBurro, botAgressivo;
        Scanner reader = new Scanner(System.in);
        System.out.println("Digite o tamanho da arena da morte");
        System.out.println("Local de sangue e morte, onde só um gladiador sobreviverá");
        do{
            arenaTamanho = reader.nextInt();
            if(arenaTamanho < 3 || arenaTamanho < 0){
                System.out.println("Erro 404, valor invalido");
            }
        }while(arenaTamanho < 3 || arenaTamanho < 0);
        if(arenaTamanho <= 0){
            System.out.println("Erro 404");
            return;
        }
        arenaDimensao = arenaTamanho * arenaTamanho;
        System.out.println("Voce tem " + arenaDimensao + " espacos utilizaveis");
        System.out.println("Digite o numero de gladiadores da arena");
        System.out.println("Guerreiros sanguinarios guerreando pela sua diversao");
        do{
            gladiadoresNum = reader.nextInt();
            if(gladiadoresNum <= 0){
                System.out.println("Erro 404, valor invalido, < 0");
            }
            if(arenaDimensao - gladiadoresNum < 0){
                System.out.println("Erro 404, valor invalido");
            }
        }while(arenaDimensao - gladiadoresNum < 0 || gladiadoresNum <= 0);
        arenaDimensao = arenaDimensao - gladiadoresNum;
        
        System.out.println("Voce tem " + gladiadoresNum + " espacos utilizaveis para guerreiros diferentes");
        System.out.println("Digite o numero de gladiadores controlados por voce, pelo teclado");
        do{
            playerTeclado = reader.nextInt();
            if(playerTeclado <= 0){
                System.out.println("Erro 404, valor invalido, <= 0");
            }
            if(gladiadoresNum - playerTeclado < 0){
                System.out.println("Erro 404, valor invalido");
            }
        }while(gladiadoresNum - playerTeclado < 0 || playerTeclado <= 0);
        gladiadoresNum = gladiadoresNum - playerTeclado;
        
        if(gladiadoresNum != 0){
            System.out.println("Voce tem " + gladiadoresNum + " espacos utilizaveis para guerreiros diferentes");
            System.out.println("Digite o numero de gladiadores controlados por voce, mas de forma randomica");
            do{
                playerRandom = reader.nextInt();
                if(playerRandom < 0){
                    System.out.println("Erro 404, valor invalido, < 0");
                }
                if(gladiadoresNum - playerRandom < 0){
                    System.out.println("Erro 404, valor invalido");
                }
            }while(gladiadoresNum - playerRandom < 0 || playerRandom < 0);
            gladiadoresNum = gladiadoresNum - playerRandom;
            
            if(gladiadoresNum != 0){
                System.out.println("Voce tem " + gladiadoresNum + " espacos utilizaveis para guerreiros diferentes");
                System.out.println("Digite o numero de gladiadores controlados pelo computador, mas de forma randomica");
                do{
                    botBurro = reader.nextInt();
                    if(botBurro < 0){
                        System.out.println("Erro 404, valor invalido, < 0");
                    }
                    if(gladiadoresNum - botBurro < 0){
                        System.out.println("Erro 404, valor invalido");
                    }
                }while(gladiadoresNum - botBurro < 0 || botBurro <= 0);
                gladiadoresNum = gladiadoresNum - botBurro;

                if(gladiadoresNum != 0){
                    System.out.println("Os " + gladiadoresNum + " gladiadores restantes serao usados controlados pelo computador");
                    System.out.println("Mas se ser de forma randomica");
                    botAgressivo = gladiadoresNum;
                    gladiadoresNum = gladiadoresNum - botAgressivo;
                }
                else{
                    botAgressivo = 0;
                }
            }
            else{
                botBurro = 0;
                botAgressivo = 0;
            }
        }
        else{
            playerRandom = 0;
            botBurro = 0;
            botAgressivo = 0;
        }
        
        if(arenaDimensao != 0){
            System.out.println("Voce tem " + arenaDimensao + " espacos utilizaveis");
            System.out.println("Digite o numero de armadilhas mortais da arena");
            System.out.println("Capazes de matar um guerreiro em um golpe, ou nao");
            do{
                trapsNum = reader.nextInt();
                if(trapsNum < 0){
                    System.out.println("Erro 404, valor invalido, < 0");
                }
                if(arenaDimensao - trapsNum < 0){
                    System.out.println("Erro 404, valor invalido");
                }
            }while(arenaDimensao - trapsNum < 0 || trapsNum < 0);
            arenaDimensao = arenaDimensao - trapsNum;
            if(arenaDimensao != 0){
                System.out.println("Voce tem " + arenaDimensao + " espacos utilizaveis");
                System.out.println("Digite o numero de armas da cupula");
                System.out.println("Feitas pelos ferreiros mais habilidosos do reinado");
                do{
                    armasNum = reader.nextInt();
                    if(armasNum < 0){
                        System.out.println("Erro 404, valor invalido, < 0");
                    }
                    if(arenaDimensao - armasNum < 0){
                        System.out.println("Erro 404, valor invalido");
                    }
                }while(arenaDimensao - armasNum < 0 || armasNum < 0);
                arenaDimensao = arenaDimensao - armasNum;
                if(arenaDimensao != 0){
                    System.out.println("Voce tem " + arenaDimensao + " espacos utilizaveis");
                    System.out.println("Digite o numero de escudos da cupula");
                    System.out.println("Feitos de adamantio capazes de duportar o pior dos hits");
                    do{
                        escudosNum = reader.nextInt();
                        if(escudosNum < 0){
                            System.out.println("Erro 404, valor invalido, < 0");
                        }
                        if(arenaDimensao - escudosNum < 0){
                            System.out.println("Erro 404, valor invalido");
                        }
                    }while(arenaDimensao - escudosNum < 0 || escudosNum < 0);
                }
                else{
                    escudosNum = 0;
                }
            }
            else{
                armasNum = 0;
                escudosNum = 0;
            }
        }
        else{
            trapsNum = 0;
            armasNum = 0;
            escudosNum = 0;
        }
        System.out.println("Entre com o erro do movimento");
        System.out.println("A cupula do trovao eh um lugar perigoso, nem sempre");
        System.out.println("voce ira para onde quer");
        System.out.println("Escolha 1 para o erro em cruz, 5 espacos");
        System.out.println("ou escolha 0 para o erro em quadrado, 8 espacos");
        do{
            valorErro = reader.nextInt();
            if(valorErro < 0 || valorErro > 1){
                System.out.println("Mano, escolhe o erro direito arromabado");
            }
        }while(valorErro < 0 || valorErro > 1);
        if(valorErro == 0){
            erro = false;
        }
        else if(valorErro == 1){
            erro = true;
        }
        else{
            System.out.println("Isso nao devia ter passado");
        }
        arena = new Cupula(arenaTamanho, playerRandom, playerTeclado, botBurro, botAgressivo, trapsNum, armasNum, escudosNum);
    }
    //Pega a cupula e salva em um arquivo;

    public int getArenaTamanho() {
        return arenaTamanho;
    }

    public void setArenaTamanho(int arenaTamanho) {
        this.arenaTamanho = arenaTamanho;
    }

    public boolean isErro() {
        return erro;
    }

    public void setErro(boolean erro) {
        this.erro = erro;
    }

    public Matriz2 getT() {
        return t;
    }

    public void setT(Matriz2 t) {
        this.t = t;
    }
    

    public Cupula getArena() {
        return arena;
    }

}
