package com.uca.reservation;

/**
 * Classe abstraite représentant l'état d'une réservation.
 * Cela fait partie du patron de conception 'État' utilisé pour gérer les différents états d'une réservation.
 */
public abstract class EtatReservation {

    protected Reservation reservation;  // La réservation associée à cet état
    protected String nomEtat;

    // --------------------------- CONSTRUCTEUR ---------------------------------
    /**
     * Constructeur pour initialiser l'état avec une réservation associée.
     * @param reservation La réservation concernée par cet état.
     */
    EtatReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    // ----------------------------- MÉTHODES ABSTRAITES -----------------------------------
    /**
     * Annule la réservation. L'implémentation varie selon l'état spécifique.
     */
    public abstract void annuler();

    /**
     * Paye la réservation. L'implémentation varie selon l'état spécifique.
     */
    public abstract void payer();

    /**
     * Confirme la réservation. L'implémentation varie selon l'état spécifique.
     */
    public abstract void confirmer();

    public abstract String getNameEtat();
}
