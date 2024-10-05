package com.uca.reservation;

/**
 * Représente un client faisant des réservations.
 * Chaque client possède un nom, une référence, un moyen de paiement et un contact.
 */
public class Client {
    private final String            nom;
    private final NumeroClient      reference;
    private final String            paiement;
    private final String            contact;

    // --------------------------- CONSTRUCTEUR ---------------------------------

    /**
     * Constructeur qui initialise un client avec toutes les informations nécessaires.
     * @param nom Le nom du client.
     * @param paiement Le moyen de paiement préféré du client.
     * @param contact Les informations de contact du client.
     */
    public Client(String nom, String paiement, String contact) {
        this.nom            = nom;
        this.reference      = new NumeroClient();;
        this.paiement       = paiement;
        this.contact        = contact;
    }

    // ----------------------- GETTERS AND SETTERS -----------------------------

    /**
     * Récupère le nom du client.
     * @return Le nom du client.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Récupère la référence unique du client.
     * @return La référence du client.
     */
    public NumeroClient getReference() {
        return reference;
    }

    /**
     * Récupère le moyen de paiement du client.
     * @return Le moyen de paiement.
     */
    public String getPaiement() {
        return paiement;
    }

    /**
     * Récupère les informations de contact du client.
     * @return Les informations de contact.
     */
    public String getContact() {
        return contact;
    }
}
