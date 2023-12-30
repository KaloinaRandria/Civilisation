package utilitaire;

import java.io.Serializable;

public class Ressource implements Serializable {
    float argent;

    public float getArgent() {
        return argent;
    }

    public void setArgent(float argent) {
        this.argent = argent;
    }

    public Ressource(float argent) {
        this.setArgent(argent);
    }
    public Ressource() {

    }

}
