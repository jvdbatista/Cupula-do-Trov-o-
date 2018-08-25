/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;
import java.util.Random;
/**
 *
 * @author jvdba
 */
public class Armadilha extends Elemento{
    private int dano;
    private Random r;

    public Armadilha() {
        this.r = new Random();
        this.dano = r.nextInt(10);
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
}
