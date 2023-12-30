package utilitaire;


import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.Vector;

public class Generateur implements Serializable { //trano famokarana fotsiny
    Vector<Point2D.Double> position = new Vector<Point2D.Double>();
    float prixCreation;
    public double[] getAllx() { //maka coord ny x rehetra
        double[] listeX = new double[position.size()];
        for (int i = 0; i < position.size(); i++) {
            listeX[i] = position.get(i).getX();
        }
        return listeX;
    }
    public double[] getAlly() {
        double[] listeY = new double[position.size()];
        for (int i = 0; i < position.size(); i++) {
            listeY[i] = position.get(i).getY();
        }
        return listeY;
    }

    public Path2D traceFormeCentrale() { //manamboatra forme centrale izay forme tiana
        double[] listeX = this.getAllx();
        double[] listeY = this.getAlly();
        Path2D path = new Path2D.Double();
        path.moveTo(listeX[0],listeY[0]);

        for (int i = 0; i < listeX.length; i++) {
            path.lineTo(listeX[i],listeY[i]);

        }
        path.closePath();
        return path;
    }

    public boolean containPoint(Point2D.Double point) {
        double x = point.getX();
        double y = point.getY();

        Path2D path = this.traceFormeCentrale();

        return path.contains(x,y);
    }

    public Vector<Point2D.Double> getPosition() {
        return position;
    }

    public void setPosition(Vector<Point2D.Double> position) {
        this.position = position;
    }

    public float getPrixCreation() {
        return prixCreation;
    }

    public void setPrixCreation(float prixCreation) {
        this.prixCreation = prixCreation;
    }

    public Generateur(Vector<Point2D.Double> position,float prix) {
        this.position = position;
        this.prixCreation = prix;
    }

    public Generateur(Vector<Point2D.Double> position) {
        this.position = position;
    }
    public Generateur() {

    }

}

