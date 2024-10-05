package com.uca.gestionVol;

/**
 * Représente le numéro d'un vol, généré automatiquement pour garantir l'unicité.
 * Utilise la classe GenerateurNumero pour obtenir un nouveau numéro.
 */
public class NumeroVol {
    private String numero;

    // --------------------------- CONSTRUCTEUR ---------------------------------
    /**
     * Constructeur par défaut qui initialise un nouveau numéro de vol.
     * Le numéro est généré automatiquement pour assurer l'unicité.
     */
    protected NumeroVol() {
        this.numero = GenerateurNumero.getNouveauNumero();
    }

    // ----------------------- GETTERS AND SETTERS -----------------------------

    /**
     * Récupère le numéro du vol.
     * @return Le numéro du vol.
     */
    public String getNumero() {
        return this.numero;
    }
}
