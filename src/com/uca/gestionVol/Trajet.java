package com.uca.gestionVol;

import java.time.Duration;

/**
 * Représente un trajet composé de plusieurs sauts.
 * Chaque trajet est initialisé avec un saut, et des opérations comme cloner et retarder le trajet sont possibles.
 */
public class Trajet implements Cloneable {
    private Saut saut;

    // --------------------------- CONSTRUCTEUR ---------------------------------

    /**
     * Crée un nouveau trajet basé sur un saut initial.
     * Le saut initial doit avoir une durée de départ de zéro.
     * @param saut Le saut initial du trajet.
     * @throws IllegalArgumentException si la durée de départ n'est pas zéro.
     */
    public Trajet(Saut saut) {
        if (saut.getEtapeDepart().getDuree().toMillis() == 0) {
            this.saut = saut;
        } else {
            throw new IllegalArgumentException("Erreur : vérifiez que vous avez bien entré le saut initial, ou bien que la durée de la première étape est bien égale à zéro.");
        }
    }

    private Trajet(Trajet trajet) {
        if(trajet != null) {
            this.saut = trajet.saut;
        }
    }

    // ----------------------------- MÉTHODES -----------------------------------

    /**
     * Clone ce trajet pour créer une copie indépendante.
     * @return Une nouvelle instance de Trajet, copie de l'instance courante.
     */
    protected Trajet clone() throws CloneNotSupportedException {
        return new Trajet(this);
    }

    /**
     * Retarde un saut différent de l'initial dans le trajet par une durée spécifiée.
     * @param saut Le saut à retarder.
     * @param duree La durée de retard.
     * @return Un nouveau trajet avec le saut retardé.
     */
    public Trajet retarderSaut(Saut saut, Duration duree) throws CloneNotSupportedException {
        if (saut == this.saut){
            throw new RuntimeException("Erreur : vous essayez de retarder la date de départ, utilisez retardeDepart() pour cela");
        }
        Trajet nouveauTrajet = this.clone();
        nouveauTrajet.saut = nouveauTrajet.getSaut().retarder(saut, duree);
        return nouveauTrajet;
    }

    /**
     * Calcule la durée totale du trajet, incluant tous les sauts et les escales.
     * @return La durée totale du trajet.
     */
    public Duration getDureeTotale() {
        Duration totalDuration = Duration.ZERO;
        Saut currentSaut = saut;
        while (currentSaut != null) {
            Duration flightDuration = currentSaut.getEtapeArrivee().getDuree();
            totalDuration = totalDuration.plus(flightDuration);

            if (currentSaut.getSautSuivant() != null) {
                Duration stopoverDuration = currentSaut.getSautSuivant().getEtapeDepart().getDuree();
                totalDuration = totalDuration.plus(stopoverDuration);
            }
            currentSaut = currentSaut.getSautSuivant();
        }
        return totalDuration;
    }

    // ----------------------- GETTERS AND SETTERS -----------------------------

    /**
     * Récupère le saut de départ du trajet.
     * @return Le saut de départ du trajet.
     */
    public Saut getSaut() {
        return this.saut;
    }

}
