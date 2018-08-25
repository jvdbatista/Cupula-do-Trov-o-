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

public class Arma extends Elemento implements Comparable<Arma>{


    private int poder;
    private Random r;


    public Arma() {
        r = new Random();
        this.poder = r.nextInt(10);
    }

    public void print(Arma A){
      System.out.println(poder);
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    @Override
    public int compareTo(Arma o) {
          return this.poder - o.getPoder();
    }

}
