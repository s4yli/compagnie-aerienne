package com.uca.reservation;

/**
 * Représente l'état payé d'une réservation.
 * Dans cet état, la réservation peut être confirmée ou annulée, mais aucun paiement double n'est autorisé.
 */
public class Payer extends EtatReservation {

    // --------------------------- CONSTRUCTEUR ---------------------------------
    /**
     * Constructeur pour l'état payé de la réservation.
     * @param reservation La réservation associée à cet état.
     */
    Payer(Reservation reservation) {
        super(reservation);
    }

    // ----------------------------- MÉTHODES -----------------------------------
    /**
     * Tente de payer la réservation une seconde fois.
     * Affiche un message indiquant que la réservation a déjà été payée.
     */
    @Override
    public void payer() {
        System.out.println("La réservation a déjà été payée.");
    }

    /**
     * Confirme la réservation, changeant son état à confirmé.
     */
    @Override
    public void confirmer() {
        this.reservation.setEtat(new Confirmer(this.reservation));
        System.out.println("La réservation a été confirmée.");
    }

    /**
     * Annule la réservation, changeant son état à annulé.
     * Cela pourrait potentiellement déclencher un remboursement.
     */
    @Override
    public void annuler() {
        this.reservation.setEtat(new Annuler(this.reservation));
        System.out.println("La réservation a été annulée.");
    }

    @Override
    public String getNameEtat(){
        return "Payée";
    }
}
