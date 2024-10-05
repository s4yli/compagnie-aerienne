package com.uca.reservation;

/**
 * Représente un passager.
 * Actuellement, seul le nom est géré.
 */
public class Passager {
    private final String nom;  // Le nom du passager non modifiable

    // --------------------------- CONSTRUCTEUR ---------------------------------
    /**
     * Constructeur pour créer un passager avec un nom spécifié.
     * @param nom Le nom du passager.
     */
    public Passager(String nom) {
        this.nom = nom;
    }

    // ----------------------- GETTERS AND SETTERS -----------------------------

    /**
     * Récupère le nom du passager.
     * @return Le nom du passager.
     */
    public String getNom() {
        return nom;
    }
}
