package batiment;

import terrain.Civilisation;
import utilitaire.Generateur;
import vivant.Chercheur;
import vivant.Militaire;
import vivant.Personne;
import vivant.Population;

import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.Vector;

public class Hopital extends Generateur implements Serializable {

    int personneMax = 3;
    double pvMiampy = 1;

    public int getPersonneMax() {
        return personneMax;
    }

    public void setPersonneMax(int personneMax) {
        this.personneMax = personneMax;
    }

    public double getPvMiampy() {
        return pvMiampy;
    }

    public void setPvMiampy(double pvMiampy) {
        this.pvMiampy = pvMiampy;
    }

    public Hopital(Vector<Point2D.Double> position, float prix, int personneMax, double pvMiampy) {
        super(position, prix);
        this.personneMax = personneMax;
        this.pvMiampy = pvMiampy;
    }

    public Hopital(Vector<Point2D.Double> position, int personneMax, double pvMiampy) {
        super(position);
        this.personneMax = personneMax;
        this.pvMiampy = pvMiampy;
    }

    public Hopital(int personneMax, double pvMiampy) {
        this.personneMax = personneMax;
        this.pvMiampy = pvMiampy;
    }

    public Hopital(Vector<Point2D.Double> position){
        super(position);
    }
    public Hopital() {

    }
    public Vector<Personne> allPers(Civilisation civilisation){
        Vector<Personne> olonaRehetra = new Vector<>();
        olonaRehetra.addAll(civilisation.getPopulations());
        olonaRehetra.addAll(civilisation.getChercheurs());
        olonaRehetra.addAll(civilisation.getMilitaires());

        return olonaRehetra;
    }

    public void soignerAll(Civilisation civilisation){
        Vector<Personne> olonaRehetra = allPers(civilisation);
        for (int i = 0; i < olonaRehetra.size(); i++) {
            if (this.containPoint(olonaRehetra.elementAt(i).getCoord()) == true) {
                if (olonaRehetra.elementAt(i).getVie() < 50 && (olonaRehetra.elementAt(i) instanceof Population || olonaRehetra.elementAt(i) instanceof Chercheur)){
                    olonaRehetra.elementAt(i).soinPersonne(getPvMiampy());
                } else if (olonaRehetra.elementAt(i).getVie() < 100 && olonaRehetra.elementAt(i) instanceof Militaire) {
                    olonaRehetra.elementAt(i).soinPersonne(getPvMiampy());
                }

            }
        }
    }

    public int nbPersInHopital(Civilisation civilisation) {
        int count = 0;
        Vector<Personne> olonaRehetra = allPers(civilisation);
        for (int i = 0; i < olonaRehetra.size(); i++) {
            if (this.containPoint(olonaRehetra.elementAt(i).getCoord()) == true) {
                count ++;
            }
        }
        return count;
    }
}

