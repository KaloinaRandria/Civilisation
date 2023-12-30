package main;


import affichage.Draw;
import affichage.Graph;
import batiment.*;
import ecoute.Listener;
import ecoute.SaveListener;
import terrain.Champ;
import terrain.Civilisation;
import terrain.Terre;
import utilitaire.Ressource;
import vivant.*;
import java.awt.geom.Point2D;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Population pop = new Population();

        Vector<Point2D.Double> p = new Vector<Point2D.Double>();
        p.add(new Point2D.Double(50,50));
        p.add(new Point2D.Double(150,50));
        p.add(new Point2D.Double(150,150));

        Vector<Point2D.Double> p2 = new Vector<>();
        p2.add(new Point2D.Double(300,300));
        p2.add(new Point2D.Double(600,300));
        p2.add(new Point2D.Double(600,600));
        p2.add(new Point2D.Double(300,600));

        Vector<Point2D.Double> p3 = new Vector<>();
        p3.add(new Point2D.Double(800,600));
        p3.add(new Point2D.Double(1200,600));
        p3.add(new Point2D.Double(1200,800));
        p3.add(new Point2D.Double(1000,800));
        p3.add(new Point2D.Double(1000,750));
        p3.add(new Point2D.Double(800,750));

        Champ c = new Champ(2,"or",p);
        Champ c2= new Champ(4,"bois",p2);
        Champ c3 = new Champ(6,"tanimbary",p3);
//        Point2D.Double olona = new Point2D.Double(100,100);
//        System.out.println(c.boolToString(olona));

//      civilisation1
        Vector<Population> peuple = new Vector<Population>();
//        peuple.add(new Population(50,1,new Point2D.Double(1200,240)));
//        peuple.add(new Population(50,2,new Point2D.Double(800,500)));

        Vector<Militaire> militaires = new Vector<Militaire>();
//        militaires.add(new Militaire(100,1,new Point2D.Double(500,250)));
//        militaires.add(new Militaire(100,1,new Point2D.Double(1400,350)));

        Vector<Chercheur> chercheurs = new Vector<Chercheur>();
//        chercheurs.add(new Chercheur(50,1,new Point2D.Double(20,20)));
//        chercheurs.add(new Chercheur(50,2,new Point2D.Double(890,900)));

        Ressource ressource = new Ressource();

//      centre peuples

        Vector<Point2D.Double> cPeuple = new Vector<>();
        cPeuple.add(new Point2D.Double(50,200));
        cPeuple.add(new Point2D.Double(100,200));
        cPeuple.add(new Point2D.Double(100,250));
        cPeuple.add(new Point2D.Double(50,250));
        CentralPeuple centralPeuple = new CentralPeuple(cPeuple);

        Vector<Point2D.Double> cMilitaire = new Vector<>();
        cMilitaire.add(new Point2D.Double(50,600));
        cMilitaire.add(new Point2D.Double(100,600));
        cMilitaire.add(new Point2D.Double(100,650));
        cMilitaire.add(new Point2D.Double(50,650));
        CentralMilitaire centralMilitaire = new CentralMilitaire(cMilitaire);

        Vector<Point2D.Double> cChercheur = new Vector<>();
        cChercheur.add(new Point2D.Double(300,800));
        cChercheur.add(new Point2D.Double(500,800));
        cChercheur.add(new Point2D.Double(500,900));
        cChercheur.add(new Point2D.Double(300,900));
        CentralChercheur centralChercheur = new CentralChercheur(cChercheur);

        Vector<Point2D.Double> cHopital = new Vector<>();
        cHopital.add(new Point2D.Double(100, 300));
        cHopital.add(new Point2D.Double(200, 300));
        cHopital.add(new Point2D.Double(200, 400));
        cHopital.add(new Point2D.Double(100, 400));
        Hopital hopital1 = new Hopital(cHopital);

        Civilisation civilisation = new Civilisation(1,peuple,militaires,chercheurs,ressource,centralPeuple,centralMilitaire,centralChercheur,hopital1);
        civilisation.getRessource().setArgent(100);


//        civilisation2
        Vector<Population> peuples2 = new Vector<>();
//        peuples2.add(new Population(50,1,new Point2D.Double(1200,240)));
        Vector<Militaire> militaires2 = new Vector<>();
        Vector<Chercheur> chercheurs2 = new Vector<>();

        Vector<Point2D.Double> cPeuple2 = new Vector<>();
        cPeuple2.add(new Point2D.Double(1000,50));
        cPeuple2.add(new Point2D.Double(1050,50));
        cPeuple2.add(new Point2D.Double(1050,100));
        cPeuple2.add(new Point2D.Double(1000,100));
        CentralPeuple centralPeuple2 = new CentralPeuple(cPeuple2);

        Vector<Point2D.Double> cMilitaire2 = new Vector<>();
        cMilitaire2.add(new Point2D.Double(800,50));
        cMilitaire2.add(new Point2D.Double(850,50));
        cMilitaire2.add(new Point2D.Double(850,100));
        cMilitaire2.add(new Point2D.Double(800,100));
        CentralMilitaire centralMilitaire2 = new CentralMilitaire(cMilitaire2);

        Vector<Point2D.Double> cChercheur2 = new Vector<>();
        cChercheur2.add(new Point2D.Double(900,250));
        cChercheur2.add(new Point2D.Double(950,250));
        cChercheur2.add(new Point2D.Double(950,300));
        cChercheur2.add(new Point2D.Double(900,300));
        CentralChercheur centralChercheur2 = new CentralChercheur(cChercheur2);

        Vector<Point2D.Double> cHopital2 = new Vector<>();
        cHopital2.add(new Point2D.Double(1000,900));
        cHopital2.add(new Point2D.Double(1050,900));
        cHopital2.add(new Point2D.Double(1050,950));
        cHopital2.add(new Point2D.Double(1000,950));
        Hopital hopital2 = new Hopital(cHopital2);

        Vector<Point2D.Double> cTrano = new Vector<>();
        cTrano.add(new Point2D.Double(1200,1000));
        cTrano.add(new Point2D.Double(1250,1000));
        cTrano.add(new Point2D.Double(1250,1050));
        cTrano.add(new Point2D.Double(1200,1050));


        Trano trano = new Trano(cTrano);

        Ressource ressource2 = new Ressource();
        Civilisation civilisation2 = new Civilisation(2,peuples2,militaires2,chercheurs2,ressource2,centralPeuple2,centralMilitaire2,centralChercheur2,hopital2);
        civilisation2.getRessource().setArgent(100);
        Vector<Civilisation> lsCiv = new Vector<Civilisation>();
        lsCiv.add(civilisation);
        lsCiv.add(civilisation2);
        Vector<Champ> lsc = new Vector<Champ>();
        lsc.add(c);
        lsc.add(c2);
        lsc.add(c3);


    Terre monde = new Terre(lsCiv,lsc);
        SaveListener saveGame = new SaveListener(monde);
        Graph graphic = new Graph();

        Draw drawMonde = new Draw();
        drawMonde =  new Draw(saveGame,new Listener(saveGame,drawMonde));

        drawMonde.addMouseListener(new Listener(saveGame,drawMonde));
        graphic.addKeyListener(saveGame);
        graphic.add(drawMonde);
//        new Graph(saveGame);

    }
}