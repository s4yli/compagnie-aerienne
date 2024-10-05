package com.uca.reservation;

/**
 * Représente l'état confirmé d'une réservation.
 * Dans cet état, la réservation peut être annulée mais ne peut plus être confirmée ni payée à nouveau.
 */
public class Confirmer extends EtatReservation {

    // --------------------------- CONSTRUCTEUR ---------------------------------
    /**
     * Constructeur pour l'état confirmé de la réservation.
     * @param reservation La réservation associée à cet état.
     */
    Confirmer(Reservation reservation) {
        super(reservation);
    }

    // ----------------------------- MÉTHODES -----------------------------------
    /**
     * Opération pour annuler la réservation.
     * Change l'état de la réservation à annulé.
     */
    @Override
    public void annuler() {
        this.reservation.setEtat(new Annuler(this.reservation));
        System.out.println("La réservation a été annulée.");
    }

    /**
     * Opération pour confirmer la réservation.
     * Affiche un message indiquant que la réservation a déjà été confirmée.
     */
    @Override
    public void confirmer() {
        System.out.println("La réservation a déjà été confirmée.");
    }

    /**
     * Opération pour payer la réservation.
     * Affiche un message indiquant que la réservation a déjà été payée.
     */
    @Override
    public void payer() {
        System.out.println("La réservation a déjà été payée.");
    }

    @Override
    public String getNameEtat(){
        return "Confirmée";
    }
}
