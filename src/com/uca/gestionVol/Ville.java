package com.uca.gestionVol;

import java.util.HashSet;

/**
 * Représente une ville, gérant un ensemble d'aéroports associés à cette ville.
 */
public class Ville {
    private String              name;
    private HashSet<Aeroport>   aeroports;

    // --------------------------- CONSTRUCTEUR ---------------------------------
    /**
     * Crée une nouvelle ville avec un nom spécifié.
     * @param name Le nom de la ville.
     */
    public Ville(String name) {
        this.name               = name;
        this.aeroports          = new HashSet<>();
    }

    // ----------------------------- MÉTHODES -----------------------------------
    /**
     * Ajoute un aéroport à la liste des aéroports de cette ville.
     * @param a L'aéroport à ajouter.
     */
    public void addAeroport(Aeroport a) {
        this.aeroports.add(a);
    }

    // ----------------------- GETTERS AND SETTERS -----------------------------

    /**
     * Récupère l'ensemble des aéroports associés à cette ville.
     * @return Un ensemble d'aéroports.
     */
    public HashSet<Aeroport> getAeroports() {
        return aeroports;
    }

    /**
     * Récupère le nom de la ville.
     * @return Le nom de la ville.
     */
    public String getName() {
        return name;
    }
}
