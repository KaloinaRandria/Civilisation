package batiment;

import terrain.Civilisation;
import utilitaire.Generateur;
import utilitaire.Ressource;
import vivant.Militaire;

import java.awt.geom.Point2D;
import java.util.Vector;

public class CentralMilitaire extends Generateur {
    public Militaire genereArme(Civilisation civilisation) {
        Militaire militaire = new Militaire();
        Ressource ressource = new Ressource(civilisation.getRessource().getArgent());
        civilisation.setRessource(ressource);
        militaire.setVie(100);
        Point2D.Double coord = new Point2D.Double(this.getPosition().elementAt(1).getX() + 10, this.getPosition().elementAt(1).getY() + 10);
        militaire.setCoord(coord);
        this.setPrixCreation(50);
        militaire.setIdPers(civilisation.getMilitaires().size() + 1);
        if(this.getPrixCreation() <= civilisation.getRessource().getArgent()) {
            float newSolde = civilisation.getRessource().getArgent() - getPrixCreation();
            civilisation.getRessource().setArgent(newSolde);
            civilisation.getMilitaires().add(militaire);
//            System.out.println("Nouvelle recrue arrive");
        }
        else {
            throw new RuntimeException("Ressoure de la Civilisation insuffisante");
        }
        return civilisation.getMilitaires().lastElement();
    }
    public CentralMilitaire(Vector<Point2D.Double> position) {
      super(position);
    }
    public CentralMilitaire(Vector<Point2D.Double> position ,float prix) {
        super(position,prix);
    }
    public CentralMilitaire() {

    }
}
