package batiment;

import terrain.Civilisation;
import utilitaire.Generateur;
import utilitaire.Ressource;
import vivant.Population;

import java.awt.geom.Point2D;
import java.util.Vector;

public class CentralPeuple extends Generateur {

    public Population generePeuple(Civilisation civilisation) {

        Population personne  = new Population();
        Ressource ressource = new Ressource(civilisation.getRessource().getArgent());
        civilisation.setRessource(ressource);
            personne.setVie(50);
            Point2D.Double coord = new Point2D.Double(this.getPosition().elementAt(1).getX() + 10,this.getPosition().elementAt(1).getY() +10);
            personne.setCoord(coord);
            this.setPrixCreation(30);
            personne.setIdPers(civilisation.getPopulations().size() + 1);
            if(this.getPrixCreation() <= civilisation.getRessource().getArgent()) {
                float newSolde  = civilisation.getRessource().getArgent() - getPrixCreation();
                civilisation.getRessource().setArgent(newSolde);
                civilisation.getPopulations().add(personne);
                System.out.println("Nouvelle personne cree , solde " + newSolde);
            }
            else {
                throw new RuntimeException("Ressoure de la Civilisation insuffisante");
            }
        return civilisation.getPopulations().lastElement();
    }
    public CentralPeuple(Vector<Point2D.Double> position, float prix) {
        super(position, prix);
    }

    public CentralPeuple(Vector<Point2D.Double> position) {
        super(position);
    }

    public CentralPeuple() {

    }
}
