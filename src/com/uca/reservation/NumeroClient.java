package com.uca.reservation;

import com.uca.gestionVol.GenerateurNumero;

/**
 * Représente le numéro de référence d'un client, généré automatiquement pour garantir l'unicité.
 * Utilise la classe GenerateurNumero pour obtenir un nouveau numéro.
 */
public class NumeroClient {
    private String numero;

    // --------------------------- CONSTRUCTEUR ---------------------------------
    /**
     * Constructeur par défaut qui initialise un nouveau numéro de référence pour un client.
     * Le numéro est généré automatiquement pour assurer l'unicité.
     */
    protected NumeroClient() {
        this.numero = "CLIENT-" + GenerateurNumero.getNouveauNumero();
    }

    // ----------------------- GETTERS AND SETTERS -----------------------------

    /**
     * Récupère le numéro de référence du client.
     * @return Le numéro du client.
     */
    public String getNumero() {
        return this.numero;
    }
}
