package terrain;


import vivant.Personne;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.Vector;

public class Terre extends Rectangle implements Serializable {
    Vector<Civilisation> civilisations = new Vector<Civilisation>();
    Vector<Champ> champs = new Vector<Champ>();

    public Vector<Civilisation> getCivilisations() {
        return civilisations;
    }

    public void setCivilisations(Vector<Civilisation> civilisations) {
        this.civilisations = civilisations;
    }

    public Vector<Champ> getChamps() {
        return champs;
    }

    public void setChamps(Vector<Champ> champs) {
        this.champs = champs;
    }

    public Terre(Vector<Civilisation> civilisations, Vector<Champ> champs) {
        this.civilisations = civilisations;
        this.champs = champs;
    }

    public Terre(Rectangle r, Vector<Civilisation> civilisations, Vector<Champ> champs) {
        super(r);
        this.civilisations = civilisations;
        this.champs = champs;
    }

    public Terre(int x, int y, int width, int height, Vector<Civilisation> civilisations, Vector<Champ> champs) {
        super(x, y, width, height);
        this.civilisations = civilisations;
        this.champs = champs;
    }

    public Terre(int width, int height, Vector<Civilisation> civilisations, Vector<Champ> champs) {
        super(width, height);
        this.civilisations = civilisations;
        this.champs = champs;
    }

    public Terre(Point p, Dimension d, Vector<Civilisation> civilisations, Vector<Champ> champs) {
        super(p, d);
        this.civilisations = civilisations;
        this.champs = champs;
    }

    public Terre(Point p, Vector<Civilisation> civilisations, Vector<Champ> champs) {
        super(p);
        this.civilisations = civilisations;
        this.champs = champs;
    }

    public Terre(Dimension d, Vector<Civilisation> civilisations, Vector<Champ> champs) {
        super(d);
        this.civilisations = civilisations;
        this.champs = champs;
    }
    public Terre() {

    }
    public Vector<Personne> olonaRehetra(Civilisation civilisation){
        Vector<Personne> allPers = new Vector<Personne>();

        allPers.addAll(civilisation.getPopulations());
        allPers.addAll(civilisation.getMilitaires());
        allPers.addAll(civilisation.getChercheurs());

        return allPers;
    }
    public Vector<Personne> olonaRehetraInGame(Vector<Civilisation> civilisations) {
        Vector<Personne> allPersonne = new Vector<Personne>();
        for (int i = 0; i < civilisations.size(); i++) {
            allPersonne.addAll(this.olonaRehetra(civilisations.elementAt(i)));

        }
        return allPersonne;
    }
    public Personne getPersByPoint(Point2D.Double point) {
        Vector<Personne> allPersonne = this.olonaRehetraInGame(this.getCivilisations());
        for (int i = 0; i < allPersonne.size(); i++) {
            if (Math.abs(point.getX() - allPersonne.elementAt(i).getCoord().getX())<=20 && Math.abs(point.getY() - allPersonne.elementAt(i).getCoord().getY())<=20) {
                return allPersonne.elementAt(i);
            }
        }
        return null;
    }
}
