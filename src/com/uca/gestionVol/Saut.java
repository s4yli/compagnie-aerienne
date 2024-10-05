package com.uca.gestionVol;

import java.time.Duration;

/**
 * Représente un saut dans un trajet, c'est-à-dire une étape de vol entre deux aéroports.
 * Chaque saut est composé de deux étapes : départ et arrivée.
 */
public class Saut implements Cloneable{
    private Etape                   etapeDepart;
    private Etape                   etapeArrivee;

    private Saut                    sautSuivant;

    // --------------------------- CONSTRUCTEUR ---------------------------------
    /**
     * Constructeur pour créer un saut avec des étapes de départ et d'arrivée spécifiées.
     * @param sautSuivant Le saut suivant dans le trajet, peut être null si c'est le dernier saut.
     * @param aeroport1 L'aéroport de départ.
     * @param aeroport2 L'aéroport d'arrivée.
     * @param duree1 La durée de l'étape de départ.
     * @param duree2 La durée de l'étape d'arrivée.
     */
    public Saut(Saut sautSuivant, Aeroport aeroport1, Aeroport aeroport2, Duration duree1, Duration duree2) {
        this.etapeDepart            = new Etape(aeroport1, duree1);
        this.etapeArrivee           = new Etape(aeroport2, duree2);
        this.sautSuivant            = sautSuivant;
    }

    private Saut(Saut cible) {
        if (cible != null) {
            this.etapeDepart        = cible.etapeDepart;
            this.etapeArrivee       = cible.etapeArrivee;
            this.sautSuivant        = cible.sautSuivant;
        }
    }

    // ----------------------------- MÉTHODES -----------------------------------

    /**
     * Clone ce saut pour créer une copie indépendante.
     * @return Une nouvelle instance de Saut, copie de l'instance courante.
     */
    protected Saut clone() throws CloneNotSupportedException {
        return new Saut(this);
    }

    /**
     * Clone le saut actuel et retarde le saut spécifié dans le trajet.
     * Il est possible de retarder l'étape de départ mais pas l'étape d'arrivée, car si nous autorisons les retards
     * sur l'étape d'arrivée cela veut dire que l'avion prend du retard dans les airs.
     * @param sautCible Le saut à retarder.
     * @param duree La durée du retard.
     * @return Un nouveau saut avec le retard appliqué.
     */
    public Saut retarder(Saut sautCible, Duration duree) throws CloneNotSupportedException {
        Saut saut                   = this.clone();
        if (sautCible == this) {
            // On est sur le saut à retarder, on le clone et on le retarde
            saut.etapeDepart        = this.etapeDepart.cloneEtRetarder(duree);
            saut.etapeArrivee       = this.etapeArrivee.clone();
        } else {
            saut.etapeDepart        = this.etapeDepart.clone();
            saut.etapeArrivee       = this.etapeArrivee.clone();
            // On est pas sur le bon saut à retarder --> on rappel la méthode sur le prochain saut
            saut.sautSuivant        = saut.sautSuivant.retarder(sautCible, duree);
        }
        return saut;
    }

    // ----------------------- GETTERS AND SETTERS -----------------------------

    /**
     * Récupère le saut suivant dans le trajet.
     * @return Le saut suivant, ou null s'il n'y a pas de suivant.
     */
    public Saut getSautSuivant() {
        return this.sautSuivant;
    }

    /**
     * Récupère l'étape d'arrivée de ce saut.
     * @return L'étape d'arrivée.
     */
    public Etape getEtapeArrivee() {
        return this.etapeArrivee;
    }

    /**
     * Récupère l'étape de départ de ce saut.
     * @return L'étape de départ.
     */
    public Etape getEtapeDepart() {
        return this.etapeDepart;
    }
}
