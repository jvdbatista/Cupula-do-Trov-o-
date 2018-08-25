/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 *
 * @author jvdba
 */
public class Save implements Serializable {

    private Cupula arena;

    public Save() {
        
    }
    public void SaveGame(Cupula arena)throws IOException{
        File file = new File("SalveFile.data");
        FileOutputStream savefile = new FileOutputStream(file);
        ObjectOutputStream gamesavefile = new ObjectOutputStream(savefile);
        gamesavefile.writeObject(arena);
        gamesavefile.close();
    }
    
    public void LoadGame()throws IOException, ClassNotFoundException{
        File file = new File("SalveFile.data");
        FileInputStream savefile = new FileInputStream(file);
        ObjectInputStream gamesavefile = new ObjectInputStream(savefile);
        this.arena = (Cupula) gamesavefile.readObject();
        gamesavefile.close();
    }

    public Cupula getArena() {
        return arena;
    }

}
