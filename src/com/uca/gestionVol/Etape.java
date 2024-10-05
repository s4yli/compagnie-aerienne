package com.uca.gestionVol;

import java.time.Duration;

public class Etape implements Cloneable{
    Aeroport                aeroport;
    Duration                duree;

    // --------------------------- CONSTRUCTEUR ---------------------------------
    public Etape(Aeroport a, Duration duree){
        this.aeroport       = a;
        this.duree          = duree;
    }

    protected Etape(Etape cible){
        if(cible != null){
            this.aeroport   = cible.aeroport;
            this.duree      = cible.duree;
        }
    }

    // ----------------------------- MÉTHODES -----------------------------------

    /**
     * Clone cette étape.
     * @return Une copie de cette étape.
     */
    protected Etape clone() throws CloneNotSupportedException{
        return new Etape(this);
    }

    /**
     * Clone cette étape et ajoute un retard à sa durée.
     * @param duree Le retard à ajouter à la durée de l'étape.
     * @return Une copie de cette étape avec le retard ajouté.
     */
    protected Etape cloneEtRetarder(Duration duree) throws CloneNotSupportedException {
        Etape etape         = this.clone();
        etape.retarder(duree);
        System.out.println("Le départ depuis l'escale à l'aéroport " + this.aeroport.getNom() + " a été retardé de " + this.duree + ".");
        return etape;
    }

    /**
     * Retarde l'étape en ajoutant une durée de retard.
     */
    private void retarder(Duration duree){
        this.duree = this.duree.plus(duree);
    }

    // ----------------------- GETTERS AND SETTERS -----------------------------

    /**
     * Récupère la durée de cette étape.
     * @return La durée de cette étape.
     */
    public Duration getDuree(){
        return this.duree;
    }

    /**
     * Récupère l'aéroport associé à cette étape.
     * @return L'aéroport associé à cette étape.
     */
    public Aeroport getAeroport(){
        return this.aeroport;
    }
}
