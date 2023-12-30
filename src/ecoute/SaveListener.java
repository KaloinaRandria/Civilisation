package ecoute;

import sauvegarde.SaveGame;
import terrain.Terre;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SaveListener  implements KeyListener {
    Terre monde;

    public Terre getMonde() {
        return monde;
    }

    public void setMonde(Terre monde) {
        this.monde = monde;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        SaveGame saver = new SaveGame();
        if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("game saved");
            saver.save(this.monde);
        } else if (e.getKeyCode() == KeyEvent.VK_L) {
            System.out.println("game loaded");
            monde = (Terre) saver.load();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public SaveListener(Terre monde) {
        this.monde = monde;
    }
}
