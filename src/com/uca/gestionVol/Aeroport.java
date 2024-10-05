package com.uca.gestionVol;

import java.util.HashSet;

public class Aeroport {

    private String                      nom;

    private HashSet<Ville>              villes;

    // --------------------------- CONSTRUCTEUR ---------------------------------
    public Aeroport(String nom, Ville ville) {
        this.nom                        = nom;
        this.villes                     = new HashSet<>();
        this.villes.add(ville);
        ville.addAeroport(this);
    }

    // ----------------------------- MÉTHODES -----------------------------------

    /**
     * Ajoute une ville à l'aéroport et associe cet aéroport à la ville ajoutée.
     * @param ville La ville à ajouter à l'aéroport.
     */
    public void addVille(Ville ville){
        this.villes.add(ville);
        ville.addAeroport(this);
    }

    // ----------------------- GETTERS AND SETTERS -----------------------------

    /**
     * Récupère le nom de l'aéroport.
     * @return Le nom de l'aéroport.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom de l'aéroport.
     * @param nom Le nouveau nom de l'aéroport.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Récupère la liste des villes associées à cet aéroport.
     * @return La liste des villes associées à cet aéroport.
     */
    public HashSet<Ville> getVilles() {
        return this.villes;
    }
}
