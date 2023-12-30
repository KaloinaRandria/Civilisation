package ecoute;

import affichage.Draw;
import affichage.Graph;
import terrain.Terre;
import vivant.Personne;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

public class Listener implements MouseListener {
   Terre monde;
   Draw dessin;
   static Point2D.Double pointFirst =null ;
   static Point2D.Double pointSecond = null;

    public static Point2D.Double getPointFirst() {
        return pointFirst;
    }

    public static void setPointFirst(Point2D.Double pointFirst) {
        Listener.pointFirst = pointFirst;
    }

    public static Point2D.Double getPointSecond() {
        return pointSecond;
    }

    public static void setPointSecond(Point2D.Double pointSecond) {
        Listener.pointSecond = pointSecond;
    }

    public void setList(Terre monde , Draw dessin) {
        this.monde = monde;
        this.dessin = dessin;
    }
    public Listener(SaveListener save,Draw dessin) {
        this.monde = save.getMonde();
        this.dessin=dessin;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) {
                for (int i = 0; i < monde.getCivilisations().size(); i++) {
                    if (this.monde.getCivilisations().elementAt(i).getGenerePersonne().containPoint(new Point2D.Double(e.getX(), e.getY()))) {
                        this.monde.getCivilisations().elementAt(i).getGenerePersonne().generePeuple(this.monde.getCivilisations().elementAt(i));

//                       System.out.println("Click ao anaty centrale personne ");
                    } else if (this.monde.getCivilisations().elementAt(i).getGenereChercheur().containPoint(new Point2D.Double(e.getX(), e.getY()))) {
                        this.monde.getCivilisations().elementAt(i).getGenereChercheur().genereScientist(this.monde.getCivilisations().elementAt(i));

//                       System.out.println("Click ao anaty centrale scientist");
                    } else if (this.monde.getCivilisations().elementAt(i).getGenereMilitaire().containPoint(new Point2D.Double(e.getX(), e.getY()))) {
                        this.monde.getCivilisations().elementAt(i).getGenereMilitaire().genereArme(this.monde.getCivilisations().elementAt(i));

                    }
                }

            }
            else {
                if (monde.getPersByPoint(new Point2D.Double(e.getX(),e.getY())) == null){
                    if (pointFirst!=null){
                        pointSecond =new Point2D.Double(e.getX(),e.getY());
                        Personne pers = monde.getPersByPoint(pointFirst);
                        Timer timer = new Timer(16, new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                double deltaX = pointSecond.getX() - pers.getCoord().getX();
                                double deltaY = pointSecond.getY() - pers.getCoord().getY();
                                if (Math.abs(deltaX) > 1 || Math.abs(deltaY) > 1) {
                                    pers.updatePoint(pointSecond);
                                    dessin.repaint();
                                }
                                else {
                                    pointFirst = null;
                                    pointSecond = null;
                                    ((Timer) e.getSource()).stop();
                                }

                            }
                        });
                        timer.start();
                    }
                }
                else {
                    if (monde.getPersByPoint(new Point2D.Double(e.getX(),e.getY())) != null) {
                        pointFirst =new Point2D.Double(e.getX(),e.getY()) ;
                        System.out.println(monde.getPersByPoint(new Point2D.Double(e.getX(),e.getY())).getVie());
                    }
                }

            }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
