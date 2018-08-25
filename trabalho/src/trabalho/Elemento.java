/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;
import java.io.Serializable;
/**
 *
 * @author jvdba
 */
public abstract class  Elemento implements Serializable{
    
    protected int i,j;
    
    public void setJ(int j){
        this.j=j;
    }

    public int getJ() {
        return j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

}
