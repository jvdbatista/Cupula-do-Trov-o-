/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import Painel.Matriz2;
import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public interface InteracoesMoveis{
    
    public void moverGuerreiro(Cupula arena, ArrayList<Guerreiro> guerreiros, int index, int arenaTamanho, boolean erro, Matriz2 t );
    
    public void encontraArma(Elemento[][] tabuleiro, int x, int y);
    
    public void encontraEscudo(Elemento[][] tabuleiro, int x, int y);
    
    public boolean encontraArmadilha(Elemento[][] tabuleiro, int x, int y);
    
    public boolean lutaGuerreiros(Guerreiro desafiante);
}
