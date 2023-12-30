package affichage;


import ecoute.Listener;
import ecoute.SaveListener;
import terrain.Terre;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Graph extends JFrame {


//    public Graph(SaveListener save) {
//        setSize(1920,1080);
//        setTitle("Age of Empire");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        BufferedImage buffer = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_ARGB);
//
//        Draw drawMonde = new Draw(save);
//        buffer.createGraphics();
//
//
//        drawMonde.addMouseListener(new Listener(save,drawMonde));
//        this.addKeyListener(save);
//        add(drawMonde);
//        this.setVisible(true);
//    }
    public Graph() {
        setSize(1920,1080);
        setTitle("Age of Empire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setVisible(true);
    }


}
