package com.uca;

import com.uca.gestionVol.*;
import com.uca.reservation.Client;
import com.uca.reservation.Passager;
import com.uca.reservation.Reservation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;


public class VolTests {
    private Reservation reservation;

    private Reservation reservationConfirmee;
    private Reservation reservationPayee;
    private Reservation reservationAnnulee;
    private Vol volParisMoscou;

    private Trajet trajetParisMoscou;

    private Saut sautParisBerlin;
    private Compagnie airFrance;


    private Client client;
    private Passager passager;
    private Saut sautBerlinMoscou;

    @BeforeEach
    void setUp() throws CloneNotSupportedException {

        GenerateurNumero.getInstance();

        this.client = new Client("John Doe", "Carte Bancaire", "john.doe@exemple.com");

        Aeroport aeroportParis = new Aeroport("Paris Airport", new Ville("Paris"));
        Aeroport aeroportBerlin = new Aeroport("Berlin Airport", new Ville("Berlin"));
        Aeroport aeroportMoscou = new Aeroport("Moscou Airport", new Ville("Moscou"));

        this.passager = new Passager("Jordan");

        this.sautParisBerlin = new Saut(null, aeroportParis,aeroportBerlin, Duration.ZERO, Duration.ofHours(2));
        this.sautBerlinMoscou = new Saut(sautParisBerlin, aeroportBerlin, aeroportMoscou, Duration.ofHours(3), Duration.ofHours(6));

        this.trajetParisMoscou = new Trajet(sautParisBerlin);

        this.airFrance = new Compagnie("Air France");

        ZonedDateTime dateDepart = ZonedDateTime.of(2024, 5, 26, 9, 0, 0,0, ZoneId.of("Europe/Paris"));
        this.volParisMoscou = airFrance.ajouteVol(trajetParisMoscou, dateDepart);
        
        volParisMoscou.ouvrir();

        this.reservation = volParisMoscou.createReservation(client, passager);

        // Création de réservation dans un état prédéfini pour pouvoir faire les tests
        this.reservationPayee = volParisMoscou.createReservation(client, passager);
        reservationPayee.getEtat().payer();

        this.reservationConfirmee = volParisMoscou.createReservation(client, passager);
        reservationConfirmee.getEtat().payer();
        reservationConfirmee.getEtat().confirmer();

        this.reservationAnnulee = volParisMoscou.createReservation(client, passager);
        reservationAnnulee.getEtat().annuler();

    }

    @Test
    public void testRetarderVolDejaParti() {
        ZonedDateTime date = ZonedDateTime.of(2023,5,7,8,0,0,0,ZoneId.of("Europe/Paris"));
        Vol volTest = airFrance.ajouteVol(trajetParisMoscou, date);
        assertThrows(RuntimeException.class, () -> volTest.retardeDepart(Duration.ofHours(2))); // Pas possible car le vol est déjà parti
    }

    @Test
    public void testRetarderSautDeAeroportDepart() {
        assertThrows(RuntimeException.class, () -> volParisMoscou.retardeSaut(sautParisBerlin, Duration.ofHours(2))); // Pas possible, il faut retarder dateDepart à la place
    }

    @Test
    public void testCreerReservationVolNonOuvert() {
        volParisMoscou.fermer();
        assertThrows(IllegalStateException.class, () -> volParisMoscou.createReservation(client, passager));
    }
    
    @Test
    public void testInitialReservation() {
        assertEquals("Initial", this.reservation.getEtat().getNameEtat());
    }

    @Test
    public void testConfirmerReservation() {
        reservation.getEtat().payer();
        reservation.getEtat().confirmer();
        assertEquals("Confirmée", this.reservation.getEtat().getNameEtat());
    }
    @Test
    public void testPayerReservation() {
        reservation.getEtat().payer();
        assertEquals("Payée", reservation.getEtat().getNameEtat());
    }

    @Test
    public void testAnnulerReservation() {
        reservation.getEtat().annuler();
        assertEquals("Annulée", reservation.getEtat().getNameEtat());
    }

    @Test
    public void testConfirmerReservationNonPayee() {
        assertThrows(IllegalStateException.class, () -> reservation.getEtat().confirmer());
    }


    @Test
    public void testConfirmerReservationAnnulee() {
        assertThrows(IllegalStateException.class, () -> reservationAnnulee.getEtat().confirmer());
    }



    @Test
    public void testPayerReservationAnnulee() {
        assertThrows(IllegalStateException.class, () -> reservationAnnulee.getEtat().payer());
    }



}
