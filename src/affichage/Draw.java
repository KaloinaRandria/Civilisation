package affichage;

import ecoute.Listener;
import ecoute.SaveListener;
import terrain.Champ;
import terrain.Civilisation;
import terrain.Terre;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Draw extends JPanel {
//    Terre monde;
    SaveListener save;
    Listener mouv;

    public SaveListener getSave() {
        return save;
    }

    public void setSave(SaveListener save) {
        this.save = save;
    }

    public Draw(SaveListener save , Listener list) {
        this.save = save;
        this.mouv = list;
    }
    public Draw() {

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Terre monde = save.getMonde();
        Vector<Civilisation> lsCiv = monde.getCivilisations();
        Vector<Champ> lsChamps = monde.getChamps();
        mouv.setList(monde,this);
        for (int i = 0; i < lsChamps.size(); i++) {
            if(lsChamps.elementAt(i).getTypeChamp().equals("or")) {
                g.setColor(Color.orange);
            } else if (lsChamps.elementAt(i).getTypeChamp().equals("bois")) {
                g.setColor(Color.green);
            }else {
                g.setColor(Color.PINK);
            }
            ((Graphics2D) g).fill(lsChamps.elementAt(i).traceFormeChamp());


        }
            int n = 0;
            for (int i = 0; i < lsCiv.size(); i++) {
                n = n+40;
                float epaisseurLigne = 5.0f;
                BasicStroke epL = new BasicStroke(epaisseurLigne);

                Font font = new Font("Arial",Font.BOLD,18);
                g.setFont(font);
                g.setColor(Color.black);
                g.drawString("Argent civilisation id "+String.valueOf(lsCiv.elementAt(i).getIdCivilisation())+ " : " + String.valueOf(lsCiv.elementAt(i).getRessource().getArgent()) + " Ar",1600 ,20 + n);

                String text ="CP"; //centrale Peuple
                FontMetrics metrics = ((Graphics2D) g).getFontMetrics(font);
                int textWidth = metrics.stringWidth(text);
                int textHeight = metrics.getHeight();

                double centreXp =(lsCiv.elementAt(i).getGenerePersonne().traceFormeCentrale().getBounds2D().getWidth() - textWidth) / 2 + lsCiv.elementAt(i).getGenerePersonne().traceFormeCentrale().getBounds2D().getX();
                double centreYp = (lsCiv.elementAt(i).getGenerePersonne().traceFormeCentrale().getBounds2D().getHeight() - textHeight) / 2 + lsCiv.elementAt(i).getGenerePersonne().traceFormeCentrale().getBounds2D().getY() + metrics.getAscent();

                g.setColor(Color.RED);
                ((Graphics2D) g).drawString(text,(float) centreXp,(float)centreYp); //manoratra text
                ((Graphics2D) g).setStroke(epL);
                ((Graphics2D) g).draw(lsCiv.elementAt(i).getGenerePersonne().traceFormeCentrale());

                text = "CM"; //centrale Militaire
                double centreXm =(lsCiv.elementAt(i).getGenereMilitaire().traceFormeCentrale().getBounds2D().getWidth() - textWidth) / 2 + lsCiv.elementAt(i).getGenereMilitaire().traceFormeCentrale().getBounds2D().getX();
                double centreYm = (lsCiv.elementAt(i).getGenereMilitaire().traceFormeCentrale().getBounds2D().getHeight() - textHeight) / 2 + lsCiv.elementAt(i).getGenereMilitaire().traceFormeCentrale().getBounds2D().getY() + metrics.getAscent();

                g.setColor(Color.blue);
                ((Graphics2D) g).drawString(text,(float) centreXm ,(float) centreYm) ;
                ((Graphics2D)g).draw(lsCiv.elementAt(i).getGenereMilitaire().traceFormeCentrale());

                text = "CC"; //centrale Chercheur
                double centreXc =(lsCiv.elementAt(i).getGenereChercheur().traceFormeCentrale().getBounds2D().getWidth() - textWidth) / 2 + lsCiv.elementAt(i).getGenereChercheur().traceFormeCentrale().getBounds2D().getX();
                double centreYc = (lsCiv.elementAt(i).getGenereChercheur().traceFormeCentrale().getBounds2D().getHeight() - textHeight) / 2 + lsCiv.elementAt(i).getGenereChercheur().traceFormeCentrale().getBounds2D().getY() + metrics.getAscent();

                g.setColor(Color.DARK_GRAY);
                ((Graphics2D) g).drawString(text,(float) centreXc ,(float) centreYc) ;
                ((Graphics2D) g).draw(lsCiv.elementAt(i).getGenereChercheur().traceFormeCentrale());

                text = "H"; //hopital
                double centreXh = (lsCiv.elementAt(i).getHopital().traceFormeCentrale().getBounds2D().getWidth() - textWidth) / 2 + lsCiv.elementAt(i).getHopital().traceFormeCentrale().getBounds2D().getX();
                double centreYh = (lsCiv.elementAt(i).getHopital().traceFormeCentrale().getBounds2D().getWidth() - textWidth) / 2 + lsCiv.elementAt(i).getHopital().traceFormeCentrale().getBounds2D().getY() + metrics.getAscent();
                g.setColor(Color.CYAN);
                ((Graphics2D) g).drawString(text,(float) centreXh,(float) centreYh);
                ((Graphics2D) g).draw(lsCiv.elementAt(i).getHopital().traceFormeCentrale());
//                text = "T"; //trano
//                double centreXt = (lsCiv.elementAt(1).getTrano().traceFormeCentrale().getBounds2D().getWidth() - textWidth) / 2 + lsCiv.elementAt(1).getTrano().traceFormeCentrale().getBounds2D().getX();
//                double centreYt = (lsCiv.elementAt(1).getTrano().traceFormeCentrale().getBounds2D().getWidth() - textWidth) / 2 + lsCiv.elementAt(1).getTrano().traceFormeCentrale().getBounds2D().getY() + metrics.getAscent();
//                g.setColor(Color.black);
//                ((Graphics2D) g).drawString(text,(float) centreXt,(float) centreYt);
//                ((Graphics2D) g).draw(lsCiv.elementAt(1).getTrano().traceFormeCentrale());
//
//                Point2D.Double alika = new Point2D.Double(1180 ,1000);
//                g.fillOval((int) alika.getX(),(int) alika.getY(),10,10);

                for (int j = 0; j < lsCiv.elementAt(i).getMilitaires().size(); j++) {
                    g.setColor(Color.green);
                    g.fillRect((int) lsCiv.elementAt(i).getMilitaires().elementAt(j).getCoord().getX(),(int) lsCiv.elementAt(i).getMilitaires().elementAt(j).getCoord().getY() -10,(int) lsCiv.elementAt(i).getMilitaires().elementAt(j).getVie(),5);

                    g.setColor(Color.black);
                    g.drawString("idCiv : " + String.valueOf(lsCiv.elementAt(i).getIdCivilisation()),(int) lsCiv.elementAt(i).getMilitaires().elementAt(j).getCoord().getX(),(int) lsCiv.elementAt(i).getMilitaires().elementAt(j).getCoord().getY() + 50);

                    g.setColor(Color.blue);

                    int x = (int) lsCiv.elementAt(i).getMilitaires().elementAt(j).getCoord().getX();
                    int y = (int) lsCiv.elementAt(i).getMilitaires().elementAt(j).getCoord().getY();
                    int smallCircleSize = 20;
                    int bigCircleSize = 150;

// Calcul des nouvelles coordonnées pour le petit cercle
//
                    int bigCircleX = x - (bigCircleSize / 2) +10 ;
                    int bigCircleY = y - (bigCircleSize / 2) +10 ;

// Dessin du petit cercle centré dans le grand cercle
                    g.fillOval(x, y, smallCircleSize, smallCircleSize);


// Dessin du grand cercle
                    g.setColor(Color.orange);
                    float opacity = 0.5F;
                    AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
                    ((Graphics2D) g).setComposite(alphaComposite);
                    g.fillOval(bigCircleX, bigCircleY, bigCircleSize, bigCircleSize);

                    lsCiv.elementAt(i).getMilitaires().elementAt(j).rushCiv(lsCiv.elementAt(i).autreCivilisation(lsCiv));

                    if (lsCiv.elementAt(i).getMilitaires().elementAt(j).getVie() <= 0) {
                        if (lsCiv.elementAt(i).getHopital().nbPersInHopital(lsCiv.elementAt(i)) == lsCiv.elementAt(i).getHopital().getPersonneMax()){
                            lsCiv.elementAt(i).getMilitaires().remove(lsCiv.elementAt(i).getMilitaires().elementAt(j));
                        }else {
                            lsCiv.elementAt(i).getMilitaires().elementAt(j).getCoord().setLocation(lsCiv.elementAt(i).getHopital().getPosition().elementAt(0).getX() + 10,lsCiv.elementAt(i).getHopital().getPosition().elementAt(0).getY() + 10);
                            mouv.setPointFirst(null);
                            mouv.setPointSecond(null);

                        }
                    }

                }
                for (int j = 0; j < lsCiv.elementAt(i).getChercheurs().size(); j++) {
                    ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
                    g.setColor(Color.green);
                    g.fillRect((int) lsCiv.elementAt(i).getChercheurs().elementAt(j).getCoord().getX(),(int) lsCiv.elementAt(i).getChercheurs().elementAt(j).getCoord().getY()-10,(int) lsCiv.elementAt(i).getChercheurs().elementAt(j).getVie(),5);
                    g.setColor(Color.black);
                    g.drawString("id Civ : " + String.valueOf(lsCiv.elementAt(i).getIdCivilisation()),(int) lsCiv.elementAt(i).getChercheurs().elementAt(j).getCoord().getX() ,(int) lsCiv.elementAt(i).getChercheurs().elementAt(j).getCoord().getY() + 40);

                    g.setColor(Color.darkGray);
                    g.fillOval((int) lsCiv.elementAt(i).getChercheurs().elementAt(j).getCoord().getX(),(int) lsCiv.elementAt(i).getChercheurs().elementAt(j).getCoord().getY(),20,20);

                    if (lsCiv.elementAt(i).getChercheurs().elementAt(j).getVie() <= 0) {
                        if (lsCiv.elementAt(i).getHopital().nbPersInHopital(lsCiv.elementAt(i)) == lsCiv.elementAt(i).getHopital().getPersonneMax()){
                            lsCiv.elementAt(i).getChercheurs().remove(lsCiv.elementAt(i).getChercheurs().elementAt(j));
                        }else {
                            lsCiv.elementAt(i).getChercheurs().elementAt(j).getCoord().setLocation(lsCiv.elementAt(i).getHopital().getPosition().elementAt(0).getX() + 10,lsCiv.elementAt(i).getHopital().getPosition().elementAt(0).getY() + 10);
                            mouv.setPointFirst(null);
                            mouv.setPointSecond(null);

                        }
                    }
                }

                for (int j = 0; j < lsCiv.elementAt(i).getPopulations().size(); j++) {
                    g.setColor(Color.green);
                    g.fillRect((int) lsCiv.elementAt(i).getPopulations().elementAt(j).getCoord().getX(),(int) lsCiv.elementAt(i).getPopulations().elementAt(j).getCoord().getY() -10,(int) lsCiv.elementAt(i).getPopulations().elementAt(j).getVie(),5);
                    g.setColor(Color.black);
                    g.drawString("id Civ : " + String.valueOf(lsCiv.elementAt(i).getIdCivilisation()),(int) lsCiv.elementAt(i).getPopulations().elementAt(j).getCoord().getX() ,(int) lsCiv.elementAt(i).getPopulations().elementAt(j).getCoord().getY() + 40);

                    g.setColor(Color.RED);
                    g.fillOval((int) lsCiv.elementAt(i).getPopulations().elementAt(j).getCoord().getX(),(int) lsCiv.elementAt(i).getPopulations().elementAt(j).getCoord().getY(),20,20);

                        lsCiv.elementAt(i).getPopulations().elementAt(j).mitsoka(lsCiv.elementAt(i).autreCivilisation(lsCiv));
                    if (lsCiv.elementAt(i).getPopulations().elementAt(j).getVie() <= 0) {
                        if (lsCiv.elementAt(i).getHopital().nbPersInHopital(lsCiv.elementAt(i)) == lsCiv.elementAt(i).getHopital().getPersonneMax()){
                            lsCiv.elementAt(i).getPopulations().remove(lsCiv.elementAt(i).getPopulations().elementAt(j));
                        }else {
                            lsCiv.elementAt(i).getPopulations().elementAt(j).getCoord().setLocation(lsCiv.elementAt(i).getHopital().getPosition().elementAt(0).getX() + 10,lsCiv.elementAt(i).getHopital().getPosition().elementAt(0).getY() + 10);
                            mouv.setPointFirst(null);
                            mouv.setPointSecond(null);

                        }
                    }
                }
                lsCiv.elementAt(i).modifyMoneyCiv(lsChamps);
                lsCiv.elementAt(i).getHopital().soignerAll(lsCiv.elementAt(i));

            }
            try {
                Thread.sleep(20);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            repaint();
    }
}



