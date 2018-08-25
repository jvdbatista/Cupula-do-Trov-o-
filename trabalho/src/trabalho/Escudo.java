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
public class Escudo extends Elemento implements Comparable<Escudo>{
    private int defesa;
    private Random r;

    public Escudo() {
        r = new Random();
        this.defesa = r.nextInt(10);
    }

    public void print(Escudo E){
        System.out.println(defesa);
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    @Override
    public int compareTo(Escudo o) {
        if (this.defesa < o.getDefesa()){
            return -1;
        } else if (this.defesa > o.getDefesa()){
            return 1;
        }
            return 0;
    }
}
