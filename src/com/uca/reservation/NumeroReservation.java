package com.uca.reservation;

import com.uca.gestionVol.GenerateurNumero;

/**
 * Représente le numéro d'une réservation, généré automatiquement pour garantir l'unicité.
 */
public class NumeroReservation {
    private String numero;  // Le numéro unique de la réservation

    // --------------------------- CONSTRUCTEUR ---------------------------------
    /**
     * Constructeur qui génère un numéro de réservation unique.
     * Le préfixe "BILLET-" est ajouté au numéro généré automatiquement.
     */
    public NumeroReservation() {
        this.numero = "BILLET-" + GenerateurNumero.getNouveauNumero();
    }

    // ----------------------- GETTERS AND SETTERS -----------------------------

    /**
     * Récupère le numéro de la réservation.
     * @return Le numéro unique de la réservation.
     */
    public String getNumero() {
        return this.numero;
    }
}
