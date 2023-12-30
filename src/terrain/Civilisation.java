package terrain;

import batiment.*;
import utilitaire.Ressource;
import vivant.*;

import java.io.Serializable;
import java.util.Vector;

public class Civilisation implements Serializable {
    int idCivilisation;
    Vector<Population> populations = new Vector<>();
    Vector<Militaire> militaires = new Vector<Militaire>();
    Vector<Chercheur> chercheurs = new Vector<Chercheur>();
    Ressource ressource;
    CentralPeuple generePersonne;
    CentralMilitaire genereMilitaire;
    CentralChercheur genereChercheur;
    Hopital hopital;
    Trano trano;

    public Trano getTrano() {
        return trano;
    }

    public void setTrano(Trano trano) {
        this.trano = trano;
    }

    public Hopital getHopital() {
        return hopital;
    }

    public void setHopital(Hopital hopital) {
        this.hopital = hopital;
    }

    public int getIdCivilisation() {
        return idCivilisation;
    }

    public void setIdCivilisation(int idCivilisation) {
        this.idCivilisation = idCivilisation;
    }

    public Vector<Population> getPopulations() {
        return populations;
    }

    public void setPopulations(Vector<Population> populations) {
        this.populations = populations;
    }

    public Vector<Militaire> getMilitaires() {
        return militaires;
    }

    public void setMilitaires(Vector<Militaire> militaires) {
        this.militaires = militaires;
    }

    public Vector<Chercheur> getChercheurs() {
        return chercheurs;
    }

    public void setChercheurs(Vector<Chercheur> chercheurs) {
        this.chercheurs = chercheurs;
    }

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }

    public CentralPeuple getGenerePersonne() {
        return generePersonne;
    }

    public void setGenerePersonne(CentralPeuple generePersonne) {
        this.generePersonne = generePersonne;
    }

    public CentralMilitaire getGenereMilitaire() {
        return genereMilitaire;
    }

    public void setGenereMilitaire(CentralMilitaire genereMilitaire) {
        this.genereMilitaire = genereMilitaire;
    }

    public CentralChercheur getGenereChercheur() {
        return genereChercheur;
    }

    public void setGenereChercheur(CentralChercheur genereChercheur) {
        this.genereChercheur = genereChercheur;
    }
    public int isaPersInChamp (Champ champ) {
        int count = 0;
        for (int i = 0; i < populations.size(); i++) {
            if (champ.containPoint(populations.elementAt(i).getCoord()) == true) {
                count++;
            }
        }
        return count;
    }
    public int isaChercInChamp(Champ champ) {
        int count = 0;
        for (int i = 0; i < chercheurs.size(); i++) {
            if(champ.containPoint(chercheurs.elementAt(i).getCoord()) == true) {
                count ++;
            }
        }
        return count;
    }

    public Population[] personneInChamp(Champ champ) {
       Population [] lsPers = new Population[isaPersInChamp(champ)];
        int count = 0;
        for (int i = 0; i < populations.size(); i++) {
            if (champ.containPoint(populations.elementAt(i).getCoord()) == true) {
                lsPers[count] = populations.elementAt(i);
                count++;
            }
        }
       return lsPers;
    }

    public Chercheur[] chercheurInChamp(Champ champ) {
        Chercheur[] lsCherch = new Chercheur[isaChercInChamp(champ)];
        int count = 0;
//        System.out.println("size "+chercheurs.size());
        for (int i = 0; i < chercheurs.size(); i++) {
            if (champ.containPoint(chercheurs.elementAt(i).getCoord()) == true) {

                lsCherch[count] = chercheurs.elementAt(i);
                count++;
            }
        }
        return lsCherch;
    }

    public float getRendparSecWithCherch(Champ champ) {
        float rend = champ.getRendement();

        Chercheur[] lsCherch = chercheurInChamp(champ);

        for (int i = 0; i < lsCherch.length; i++) {
            for (int j = 0; j < lsCherch.length; j++) {
                float[] ex = lsCherch[i].getExperience();
                if(champ.typeChamp.equals("bois")) {
                    rend = rend * ex[0];
                } else if (champ.typeChamp.equals("or")) {
                    rend = rend * ex[1];
                }else {
                    rend = rend * ex[2];
                }
            }
        }
       return rend ;
//        System.out.println("rendement avec chercheur " + rend);
    }

    public void modifyMoneyCiv(Vector<Champ> lsChamps) {
        float solde = this.getRessource().getArgent();
        for (int i = 0; i < lsChamps.size(); i++) {
            getRendparSecWithCherch(lsChamps.elementAt(i));
            float rend = this.getRendparSecWithCherch(lsChamps.elementAt(i));
            int isaPers = isaPersInChamp(lsChamps.elementAt(i));
//            System.out.println("isa pers anaty champs "+isaPers);
            solde = solde + (rend*isaPers);
        }
        this.getRessource().setArgent(solde);
//        System.out.println("solde civ " + solde);
    }
    public Civilisation(int i, Vector<Personne> peuples2, Vector<Militaire> militaires2, Vector<Chercheur> chercheurs2, CentralPeuple centralPeuple2, CentralMilitaire centralMilitaire2, CentralChercheur centralChercheur2) {

    }

    public Civilisation(int idCivilisation, Vector<Population> populations, Vector<Militaire> militaires, Vector<Chercheur> chercheurs, Ressource ressource, CentralPeuple generePersonne, CentralMilitaire genereMilitaire, CentralChercheur genereChercheur) {
        this.idCivilisation = idCivilisation;
        this.populations = populations;
        this.militaires = militaires;
        this.chercheurs = chercheurs;
        this.ressource = ressource;
        this.generePersonne = generePersonne;
        this.genereMilitaire = genereMilitaire;
        this.genereChercheur = genereChercheur;
    }

// constructor with hopital
    public Civilisation(int idCivilisation, Vector<Population> populations, Vector<Militaire> militaires, Vector<Chercheur> chercheurs, Ressource ressource, CentralPeuple generePersonne, CentralMilitaire genereMilitaire, CentralChercheur genereChercheur, Hopital hopital) {
        this.idCivilisation = idCivilisation;
        this.populations = populations;
        this.militaires = militaires;
        this.chercheurs = chercheurs;
        this.ressource = ressource;
        this.generePersonne = generePersonne;
        this.genereMilitaire = genereMilitaire;
        this.genereChercheur = genereChercheur;
        this.hopital = hopital;
    }

    public Civilisation(int idCivilisation, Vector<Population> populations, Vector<Militaire> militaires, Vector<Chercheur> chercheurs, Ressource ressource, CentralPeuple generePersonne, CentralMilitaire genereMilitaire, CentralChercheur genereChercheur, Hopital hopital, Trano trano) {
        this.idCivilisation = idCivilisation;
        this.populations = populations;
        this.militaires = militaires;
        this.chercheurs = chercheurs;
        this.ressource = ressource;
        this.generePersonne = generePersonne;
        this.genereMilitaire = genereMilitaire;
        this.genereChercheur = genereChercheur;
        this.hopital = hopital;
        this.trano = trano;
    }

    public Vector<Civilisation> autreCivilisation(Vector<Civilisation> lsCiv) {
        Vector<Civilisation> otherCiv = new Vector<>();
        for (int i = 0; i < lsCiv.size(); i++) {
            if (this != lsCiv.elementAt(i)) {
                otherCiv.add(lsCiv.elementAt(i));
            }
        }
        return otherCiv;
    }
//    public void rushAdva(Vector<Civilisation> civilisations) {
//        for (Civilisation cible : civilisations) {
//            if (!cible.equals(this)) {
//                Vector<Personne> lsVictime = new Vector<>();
//                for (int i = 0; i < this.getMilitaires().size(); i++) {
//                     lsVictime = this.getMilitaires().elementAt(i).getPersAdvaInRayon(cible);
//                }
//                for (int i = 0; i < lsVictime.size(); i++) {
//                    lsVictime.elementAt(i).shotGun(this.getMilitaires().elementAt(i).getPuissance() / lsVictime.size());
//                }
//            }
////            System.out.println("pv" + this.getMilitaires().elementAt(0).getVie());
//        }
//    }



}
