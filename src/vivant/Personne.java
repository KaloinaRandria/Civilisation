package vivant;

import terrain.Civilisation;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Vector;

public class Personne implements Serializable {
    double vie;
     int idPers;
     Point2D.Double coord;
     Point2D.Double target;


    public Point2D.Double getTarget() {
        return target;
    }

    public void setTarget(Point2D.Double target) {
        this.target = target;
    }

    public double getVie() {

        return vie;
    }

    public void setVie(double vie) {
        this.vie = vie;
    }

    public int getIdPers() {
        return idPers;
    }

    public void setIdPers(int idPers) {
        this.idPers = idPers;
    }

    public Point2D.Double getCoord() {
        return coord;
    }

    public void setCoord(Point2D.Double coord) {
        this.coord = coord;
    }

    public void shotGun(double degat) {
        this.setVie(this.getVie() - degat);
    }

    public Personne() {

    }
     public Personne(int vie,int idPers, Point2D.Double coord ) {
        this.vie = vie;
        this.idPers = idPers;
        this.coord = coord;
     }

     public void updatePoint(Point2D.Double point) {
        Point2D.Double oldP = this.getCoord();
        double deltaX = point.getX() - oldP.getX();
        double deltaY = point.getY() - oldP.getY();
        this.getCoord().setLocation((oldP.getX() + (deltaX/10) ),(oldP.getY() +  (deltaY/10) ));

     }
     public void soinPersonne(double soin) {
        this.setVie(this.getVie() + soin);
     }

     //mitsoka Militaire rehefa anaty rayon any
    public Point2D.Double getDirection(Militaire militaire) {
        Point2D.Double milCoord = militaire.getCoord();
        double deltaX = this.getCoord().getX() - milCoord.getX();
        double deltaY = this.getCoord().getY() - milCoord.getY();

        return new Point2D.Double(deltaX,deltaY);
    }
    public int getSigne(double point) {
        if (point < 0) {
            return -1;
        }
        else {
            return 1;
        }
    }
    public void mitsokaPra(Militaire militaire) {
        Point2D.Double vecteur = this.getDirection(militaire);
        if (Math.abs(vecteur.getX()) >= Math.abs(vecteur.getY())) {
            this.getCoord().setLocation(this.getCoord().getX() + (5 * getSigne(vecteur.getX())),this.getCoord().getY());
        }
        else {
            this.getCoord().setLocation(this.getCoord().getX(),this.getCoord().getY() + (5 * getSigne(vecteur.getY())));
        }
    }
    public void mitsoka (Vector<Civilisation> civilisation) {

        for (int i = 0; i < civilisation.size() ; i++) {
            for (int j = 0; j < civilisation.elementAt(i).getMilitaires().size(); j++) {
                this.mitsokaPra(civilisation.elementAt(i).getMilitaires().elementAt(j));
            }
        }
    }
}
