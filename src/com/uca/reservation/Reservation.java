package com.uca.reservation;

/**
 * Représente une réservation faite par un client pour un passager.
 * Gère le numéro de réservation, le client, le passager et l'état actuel de la réservation.
 */
public class Reservation {

    private final NumeroReservation     numero;
    private final Client                client;
    private final Passager              passager;
    private EtatReservation             etat;

    // --------------------------- CONSTRUCTEUR ---------------------------------
    /**
     * Constructeur pour créer une réservation.
     * Initialise la réservation avec un état initial.
     * @param client Le client qui fait la réservation.
     * @param passager Le passager pour lequel la réservation est faite.
     */
    public Reservation(Client client, Passager passager) {
        this.numero                     = new NumeroReservation();
        this.client                     = client;
        this.passager                   = passager;
        this.etat                       = new Initial(this);  // Démarre toujours dans l'état initial
    }

    // ----------------------- GETTERS AND SETTERS -----------------------------

    /**
     * Récupère le client associé à la réservation.
     * @return Le client.
     */
    public Client getClient() {
        return client;
    }

    /**
     * Récupère le numéro de la réservation.
     * @return Le numéro de la réservation.
     */
    public NumeroReservation getNumero() {
        return numero;
    }

    /**
     * Récupère le passager associé à la réservation.
     * @return Le passager.
     */
    public Passager getPassager() {
        return passager;
    }

    /**
     * Récupère l'état actuel de la réservation.
     * @return L'état de la réservation.
     */
    public EtatReservation getEtat() {
        return etat;
    }

    /**
     * Définit l'état de la réservation.
     * @param etat Le nouvel état de la réservation.
     */
    protected void setEtat(EtatReservation etat) {
        this.etat = etat;
    }
}
