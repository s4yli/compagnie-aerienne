package com.uca.reservation;

/**
 * Représente l'état annulé d'une réservation.
 * Dans cet état, aucune opération de confirmation ou de paiement n'est possible.
 */
public class Annuler extends EtatReservation {

    // --------------------------- CONSTRUCTEUR ---------------------------------
    /**
     * Constructeur qui initialise l'état annulé pour une réservation donnée.
     * @param reservation La réservation concernée par cet état.
     */
    Annuler(Reservation reservation) {
        super(reservation);
    }

    // ----------------------------- MÉTHODES -----------------------------------
    /**
     * Opération d'annulation sur une réservation déjà annulée.
     * Cette méthode indique que la réservation est déjà annulée.
     */
    @Override
    public void annuler() {
        System.out.println("La réservation est déjà annulée.");
    }

    /**
     * Tente de confirmer une réservation déjà annulée.
     * Cette méthode indique que la réservation ne peut pas être confirmée une fois annulée.
     */
    @Override
    public void confirmer() {
        throw new IllegalStateException("La réservation ne peut pas être confirmée une fois annulée.");
    }

    /**
     * Tente de payer une réservation déjà annulée.
     * Cette méthode indique que la réservation ne peut pas être payée une fois annulée.
     */
    @Override
    public void payer() {
        throw new IllegalStateException("La réservation ne peut pas être payée une fois annulée.");
    }

    @Override
    public String getNameEtat(){
        return "Annulée";
    }
}
