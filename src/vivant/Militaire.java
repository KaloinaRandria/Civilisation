package vivant;

import terrain.Civilisation;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Vector;

public class Militaire extends Personne{
    int rayon = 150;
    double puissance = 1;


    int idCivilisation;

    public int getIdCivilisation() {
        return idCivilisation;
    }

    public void setIdCivilisation(int idCivilisation) {
        this.idCivilisation = idCivilisation;
    }

    public int getRayon() {
        return rayon;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    public double getPuissance() {
        return puissance;
    }

    public void setPuissance(double puissance) {
        this.puissance = puissance;
    }

    public Militaire(int vie , int id , Point2D.Double coord) {
        super(vie,id,coord);
    }
    public Militaire() {

    }


    public boolean inRayonMilitaire(Point2D.Double point) {
        Point2D.Double coordMilitaire = this.getCoord();
        Ellipse2D.Double rayon = new Ellipse2D.Double(coordMilitaire.getX()-(this.rayon/2),coordMilitaire.getY()-(this.rayon/2),this.rayon,this.rayon);
        if(rayon.contains(point)) {
            return true;
        }
        return false;
    }
    public Vector<Personne> getPersAdvaInRayon(Civilisation civAdva) {
        Vector<Personne> lsPers = new Vector<Personne>();
        Vector<Personne> listeAllPersonne = new Vector<Personne>();
        listeAllPersonne.addAll(civAdva.getPopulations());
        listeAllPersonne.addAll(civAdva.getMilitaires());
        listeAllPersonne.addAll(civAdva.getChercheurs());
        for (int i = 0; i < listeAllPersonne.size(); i++) {
            Personne pers = listeAllPersonne.elementAt(i);
            Point2D.Double coordPers = pers.getCoord();
            if(this.inRayonMilitaire(coordPers)== true) {
                lsPers.add(pers);
            }
        }

        return lsPers;
    }
    public void rushAdva(Civilisation civilisation) {
        Vector<Personne> lsVictime = this.getPersAdvaInRayon(civilisation);

            for (int i = 0; i < lsVictime.size(); i++) {
                lsVictime.elementAt(i).shotGun(this.puissance/ lsVictime.size());
            }
    }

    public void rushCiv(Vector<Civilisation> lsCiv) {
        for (int i = 0; i < lsCiv.size(); i++) {
            rushAdva(lsCiv.elementAt(i));
        }
    }

}
