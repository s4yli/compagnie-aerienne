package com.uca.gestionVol;

import com.uca.reservation.Client;
import com.uca.reservation.Passager;
import com.uca.reservation.Reservation;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 * Représente un vol, incluant le trajet, les réservations, et les informations de gestion de départ.
 */
public class Vol {

    private NumeroVol                           numero;
    private ZonedDateTime                       dateDepart;
    private Trajet                              trajet;
    private ArrayList<Reservation>              reservations;
    private Boolean                             ouvert;

    // --------------------------- CONSTRUCTEUR ---------------------------------

    /**
     * Constructeur pour initialiser un vol avec un numéro, un trajet et une date de départ.
     * @param numero Le numéro unique du vol.
     * @param trajet Le trajet du vol.
     * @param dateDepart La date et heure de départ du vol.
     */
    protected Vol(NumeroVol numero, Trajet trajet, ZonedDateTime dateDepart){
        this.numero                 = numero;
        this.trajet                 = trajet;
        this.dateDepart             = dateDepart;
        this.reservations           = new ArrayList<>();
        this.ouvert                 = false;  // Initialiser le vol comme fermé aux réservations
    }

    // ----------------------------- MÉTHODES -----------------------------------

    /**
     * Calcul la durée totale du trajet en appelant la méthode du trajet
     */
    public ZonedDateTime getDateArrivee() {
        Duration totalDuration = trajet.getDureeTotale();
        return dateDepart.plus(totalDuration);
    }

    /**
     * Retarde la date de départ du vol.
     * @param duree La durée de retard.
     */
    public void retardeDepart(Duration duree){
        if(this.dateDepart.isAfter(ZonedDateTime.now())){
            this.dateDepart = this.dateDepart.plus(duree);
            System.out.println("La date de départ du vol " + this.numero.getNumero() + " a été retardé de " + duree + ".");
        }
        else{
            throw new RuntimeException("Erreur : vous ne pouvez pas retarder le départ d'un vol si l'avion a déjà décollé.");
        }
    }

    /**
     * Ouvre les réservations pour ce vol.
     */
    public void ouvrir(){
        this.ouvert = true;
    }

    /**
     * Ferme les réservations pour ce vol.
     */
    public void fermer(){
        this.ouvert = false;
    }

    /**
     * Crée une réservation pour un client et un passager.
     * @param client Le client qui fait la réservation.
     * @param passager Le passager pour lequel la réservation est faite.
     * @return La réservation créée.
     */
    public Reservation createReservation(Client client, Passager passager) throws IllegalStateException {
        if (this.ouvert) {
            Reservation r = new Reservation(client, passager);
            this.reservations.add(r);
            return r;
        } else {
            throw new IllegalStateException("Erreur : ce vol n'est pas ouvert à la réservation");
        }
    }

    /**
     * Retarde un saut spécifique du trajet de ce vol. Ne doit pas être le saut initial, pour cela
     * utiliser retardeDepart()
     * @param saut Le saut à retarder dans le trajet.
     * @param duree La durée du retard.
     */
    public Trajet retardeSaut(Saut saut, Duration duree) throws CloneNotSupportedException {
        this.trajet = this.trajet.retarderSaut(saut, duree);
        return this.trajet;
    }

    // ----------------------- GETTERS AND SETTERS -----------------------------

    /**
     * Récupère les réservations associées à ce vol.
     * @return La liste des réservations faites pour ce vol.
     */
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Récupère le trajet associé à ce vol.
     * @return Le trajet du vol.
     */
    public Trajet getTrajet() {
        return this.trajet;
    }

    /**
     * Récupère le numéro unique du vol.
     * @return Le numéro du vol.
     */
    public NumeroVol getNumero() {
        return numero;
    }

    /**
     * Récupère la date et heure de départ du vol.
     * @return La date et heure de départ.
     */
    public ZonedDateTime getDateDepart() {
        return dateDepart;
    }

    /**
     * Met à jour la date et heure de départ du vol.
     * @param nouvelleDate La nouvelle date et heure de départ.
     */
    public void setDateDepart(ZonedDateTime nouvelleDate) {
        this.dateDepart = nouvelleDate;
    }

}

