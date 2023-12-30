package sauvegarde;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveGame {
    public void save(Object saveGame) {
        try {
            FileOutputStream out  = new FileOutputStream("saveGame.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(out);
            objectOut.writeObject(saveGame);
            objectOut.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public Object load() {
        try {
            FileInputStream in = new FileInputStream("saveGame.txt");
            ObjectInputStream  objectIn = new ObjectInputStream(in);
            Object o = objectIn.readObject();
            objectIn.close();
            return o;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
