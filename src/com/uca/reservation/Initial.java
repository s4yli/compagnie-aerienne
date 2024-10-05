package com.uca.reservation;

/**
 * Représente l'état initial d'une réservation.
 * Dans cet état, la réservation peut être annulée ou payée, mais elle ne peut pas être confirmée sans paiement.
 */
public class Initial extends EtatReservation {

    // --------------------------- CONSTRUCTEUR ---------------------------------
    /**
     * Constructeur pour l'état initial de la réservation.
     * @param reservation La réservation associée à cet état.
     */
    Initial(Reservation reservation) {
        super(reservation);
    }

    // ----------------------------- MÉTHODES -----------------------------------
    /**
     * Paye la réservation et change son état à payé.
     */
    @Override
    public void payer() {
        this.reservation.setEtat(new Payer(this.reservation));
        System.out.println("La réservation a été payée.");
    }

    /**
     * Tente de confirmer la réservation sans paiement préalable.
     * Affiche un message indiquant que la confirmation n'est pas possible sans paiement.
     */
    @Override
    public void confirmer() {
        throw new IllegalStateException("Vous ne pouvez pas confirmer une réservation si vous n'avez pas payé.");
    }

    /**
     * Annule la réservation et change son état à annulé.
     */
    @Override
    public void annuler() {
        this.reservation.setEtat(new Annuler(this.reservation));
        System.out.println("La réservation a été annulée.");
    }

    @Override
    public String getNameEtat(){
        return "Initial";
    }
}
