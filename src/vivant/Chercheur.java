package vivant;


import java.awt.geom.Point2D;

public class Chercheur extends Personne{
    float[] experience; //ex: bois lasa  +1.1 , or lasa +1.2
    public float[] getExperience() {
        return experience;
    }

    public void setExperience(float[] experience) {
        this.experience = experience;
    }

    public Chercheur(int vie , int id , Point2D.Double coord) {
        super(vie,id,coord);
        float[] exp = new float[3];
        exp[0]  = 1.1F; //bois
        exp[1] = 1.2F; //or
        exp[2] = 1.3F; //fambolena
        this.experience = exp;
    }
    public Chercheur(){
        float[] exp = new float[3];
        exp[0]  = 1.1F; //bois
        exp[1] = 1.2F; //or
        exp[2] = 1.3F; //fambolena
        this.experience = exp;
    }

}
