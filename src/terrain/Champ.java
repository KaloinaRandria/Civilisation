package terrain;


import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.Vector;

public class Champ implements Serializable {
    float rendement;
    String typeChamp; //or , bois , fambolena

    Vector<Point2D.Double> points = new Vector<Point2D.Double>();

    public double[] getAllx() { //maka coord ny x rehetra
        double[] listeX = new double[points.size()];
        for (int i = 0; i < points.size(); i++) {
            listeX[i] = points.get(i).getX();
        }
        return listeX;
    }
    public double[] getAlly() {
        double[] listeY = new double[points.size()];
        for (int i = 0; i < points.size(); i++) {
            listeY[i] = points.get(i).getY();
        }
        return listeY;
    }

    public Path2D traceFormeChamp() { //manao sary champ am izay forme tiana
        double[] listeX = this.getAllx();
        double[] listeY = this.getAlly();
        Path2D path = new Path2D.Double();
        path.moveTo(listeX[0],listeY[0]);

        for (int i = 0; i < listeX.length; i++) {
            path.lineTo(listeX[i],listeY[i]);

        }
        path.closePath();
        return path;
    }

    public boolean containPoint(Point2D.Double point) { //mijery hoe ao anaty ilay forme ve ilay point(olona)
        double x = point.getX();
        double y = point.getY();

        Path2D path = this.traceFormeChamp();

        return path.contains(x,y);
    }

    public float getRendement() {
        return rendement;
    }

    public void setRendement(float rendement) {
        this.rendement = rendement;
    }

    public String getTypeChamp() {
        return typeChamp;
    }

    public void setTypeChamp(String typeChamp) {
        this.typeChamp = typeChamp;
    }

    public Vector<Point2D.Double> getPoints() {
        return points;
    }

    public void setPoints(Vector<Point2D.Double> points) {
        this.points = points;
    }

    public Champ(float rendement, String typeChamp, Vector<Point2D.Double> points) {
        this.rendement = rendement;
        this.typeChamp = typeChamp;
        this.points = points;
    }

    public Champ() {

    }
}
