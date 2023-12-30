package batiment;

import terrain.Civilisation;
import utilitaire.Generateur;
import utilitaire.Ressource;
import vivant.Chercheur;
import java.awt.geom.Point2D;
import java.util.Vector;

public class CentralChercheur extends Generateur {
    public Chercheur genereScientist(Civilisation civilisation) {
        Chercheur chercheur = new Chercheur(50,civilisation.getChercheurs().size() +1,new Point2D.Double(this.getPosition().elementAt(1).getX() + 10,this.getPosition().elementAt(1).getY() + 10));
        Ressource ressource = new Ressource(civilisation.getRessource().getArgent());
        civilisation.setRessource(ressource);
//        chercheur.setVie(50);
//        Point2D.Double coord = new Point2D.Double(, );
//        chercheur.setCoord(coord);
        this.setPrixCreation(40);
//        chercheur.setIdPers();
        if(this.getPrixCreation() <= civilisation.getRessource().getArgent()) {
            float newSolde = civilisation.getRessource().getArgent() - getPrixCreation();
            civilisation.getRessource().setArgent(newSolde);
            civilisation.getChercheurs().add(chercheur);
            System.out.println("Le nouveau chercheur arrive ,solde" + newSolde);
        }
        else {
            throw new RuntimeException("Ressoure de la Civilisation insuffisante");
        }
        return civilisation.getChercheurs().lastElement();
    }

    public CentralChercheur(Vector<Point2D.Double> position) {
        super(position);
    }
    public CentralChercheur(Vector<Point2D.Double> position, float prix) {
        super(position, prix);
    }

    public CentralChercheur() {
    }
}
