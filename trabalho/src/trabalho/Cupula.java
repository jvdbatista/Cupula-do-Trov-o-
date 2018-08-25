/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;
import Painel.Matriz2;
import Painel.novo;
import java.util.ArrayList;
import java.util.Random;
import java.io.Serializable;
/**
 *
 * @author jvdba
 */
public class Cupula implements Serializable{
    //Teste k = new Teste(); //Objeto Teste para obviamente testar.
    // m é a dimensao da matriz, pois ela é sempre quadrada: m x m.
    private int m;
    public Elemento[][] tabuleiro;
    public ArrayList<Guerreiro> gladiadores;
    private Random r;
    private boolean semEspacos;

    
    
    //Constutor da cupula,cria o tabuleiro e iguala todas as posições a null
    public Cupula(int dimensao, int npteclado,int nbrandom, int nprandom, int nbagressivo, int ntraps, int narmas, int nescudos){
        m = dimensao;
        r = new Random();
        semEspacos = false;
        gladiadores = new ArrayList<>();
        this.tabuleiro = new Elemento[m][m];

        for(int i = 0; i < m; i++){
            System.out.print('\n');
            for(int j= 0; j < m ; j++){
                this.tabuleiro[i][j] = null;
            }
        }
        adicionarElementos(npteclado, nprandom, nbrandom, nbagressivo);
        adicionarArmadilhas(ntraps);
        adicionarArmas(narmas);
        adicionarEscudo(nescudos);
    }
     //Define posições aleatórias para os guerreiros
     //gs de guerreiros.
    public void adicionarElementos(int npteclado,int nprandom, int nbrandom, int nbagressivo){

        for (int i = 0; i < npteclado; i++) {
            PlayerTeclado lutador = new PlayerTeclado();
            int a=0,b=0;
            do{
                lutador.setI(r.nextInt(m));
                a = lutador.getI();
                lutador.setJ(r.nextInt(m));
                b = lutador.getJ();

            }while(tabuleiro[a][b] != null);

        gladiadores.add(lutador);
        tabuleiro[a][b] = lutador;
        }
        for (int i = 0; i < nprandom; i++) {
            PlayerRandom lutador = new PlayerRandom();
            int a=0,b=0;
            do{
                lutador.setI(r.nextInt(m));
                a = lutador.getI();
                lutador.setJ(r.nextInt(m));
                b = lutador.getJ();

            }while(tabuleiro[a][b] != null);

        gladiadores.add(lutador);
        tabuleiro[a][b] = lutador;
        }
        for (int i = 0; i < nbrandom; i++) {
            BotBurro lutador = new BotBurro();
            int a=0,b=0;
            do{
                lutador.setI(r.nextInt(m));
                a = lutador.getI();
                lutador.setJ(r.nextInt(m));
                b = lutador.getJ();
            }while(tabuleiro[a][b] != null);

        gladiadores.add(lutador);
        tabuleiro[a][b] = lutador;
        }
        for (int i = 0; i < nbagressivo; i++) {
            BotAgressivo lutador = new BotAgressivo();
            int a=0,b=0;
            do{
                lutador.setI(r.nextInt(m));
                a = lutador.getI();
                lutador.setJ(r.nextInt(m));
                b = lutador.getJ();

            }while(tabuleiro[a][b] != null);

        gladiadores.add(lutador);
        tabuleiro[a][b] = lutador;
        }
    }
    //Define posições aleatórias para as armadilhas
    public void adicionarArmadilhas(int W){
        for (int i = 0; i < W; i++) {
            Armadilha armadilha = new Armadilha();
            int a = 0, b = 0;

            do{

                armadilha.setI(r.nextInt(m));
                a = armadilha.getI();
                armadilha.setJ(r.nextInt(m));
                b = armadilha.getJ();
            }while(tabuleiro[a][b] != null);

            tabuleiro[a][b] = armadilha;
        }
    }
    
     public void adicionarArmadilhasTela(Matriz2 t){
            Armadilha armadilha = new Armadilha();
            int a = 0, b = 0;

            do{

                armadilha.setI(r.nextInt(m));
                a = armadilha.getI();
                armadilha.setJ(r.nextInt(m));
                b = armadilha.getJ();

            }while(tabuleiro[a][b] != null);
            t.soArmadilha(a, b);
            t.repaint();
            tabuleiro[a][b] = armadilha;
        }
    
     //Define posições aleatórias para as armas
    public void adicionarArmas(int A){

        for (int i = 0; i < A; i++) {

            Arma  arma = new Arma();
            int a=0,b=0;
            do{
                arma.setI(r.nextInt(m));
                a = arma.getI();
                arma.setJ(r.nextInt(m));
                b = arma.getJ();
            }while(tabuleiro[a][b] != null);

            tabuleiro[a][b] = arma;
        }
    }
          //Define posições aleatórias para os escudos
    public void adicionarEscudo(int E){
        for (int i = 0; i < E; i++) {
            Escudo escudo = new Escudo();
            int a=0,b=0;
            do{
                escudo.setI(r.nextInt(m));
                a = escudo.getI();
                escudo.setJ(r.nextInt(m));
                b = escudo.getJ();
            }while(tabuleiro[a][b] != null);
                tabuleiro[a][b] = escudo;
        }
    }
    //Imprime o tabuleiro
    public void printTabuleiro(){
        System.out.print("\n ======================= \n");
        for (int c = 0; c < m; c++) {
            for(int d = 0; d < m; d++ ){
                if(tabuleiro[c][d] == null){
                    System.out.print(" - ");
                }
                else if(tabuleiro[c][d] instanceof Guerreiro){
                    System.out.print(" G ");
                }
                else if(tabuleiro[c][d] instanceof Armadilha){
                    System.out.print(" W ");
                }
                else if(tabuleiro[c][d] instanceof Arma){
                    System.out.print(" A ");
                }
                else   if(tabuleiro[c][d] instanceof Escudo){
                    System.out.print(" E ");
                }
            } System.out.print("\n");
        }
    }
    
    public void checarEspacos(int m){
        this.semEspacos = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++){
                if (tabuleiro[i][j] == null) this.semEspacos = false;
                return;
            }
        }
    }
    
    public boolean checarTabuleiro(char Elem){
        for(int i = 0; i < this.m; i++){
            for(int j = 0; j < this.m ; j++){
                if (Elem == 'W'){
                    if (tabuleiro[i][j] instanceof Armadilha) return true;
                }
                if (Elem == 'A'){
                    if (tabuleiro[i][j] instanceof Arma) return true;
                }
                if (Elem == 'E'){
                    if (tabuleiro[i][j] instanceof Escudo) return true;
                }
                if (Elem == 'G'){
                    if (tabuleiro[i][j] instanceof Guerreiro) return true;
                }
            }
        }
        return false;
    }
    
    public Elemento[][] getTabuleiro() {
        return tabuleiro;
    }
    public ArrayList<Guerreiro> getGuerreiros(){
        return gladiadores;
    }

    public boolean isSemEspacos() {
        return semEspacos;
    }

    public void setSemEspacos(boolean semEspacos) {
        this.semEspacos = semEspacos;
    }

    public int getM() {
        return m;
    }
    



}

