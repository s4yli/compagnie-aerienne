package com.uca;

import com.uca.gestionVol.*;
import com.uca.reservation.*;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

// EL YAAGOUBI ILYAS 22111267

public class Start {

    public static void main(String[] args) throws CloneNotSupportedException {

        GenerateurNumero.getInstance();

        // Création des villes et aéroports

        Ville paris = new Ville("Paris");
        Ville berlin = new Ville("Berlin");
        Ville moscou = new Ville("Moscou");

        Aeroport aeroportParis = new Aeroport("Paris Nord", paris);
        Aeroport aeroportBerlin = new Aeroport("Berlin North", berlin);
        Aeroport aeroportMoscou = new Aeroport("Moscou Airport", moscou);

        // Création et configuration des sauts et trajets

        // Initialisation des sauts en commençant par la fin.
        // 3h d'escale sur l'aéroport de Berlin et enfin 6h pour arriver à l'aéroport de Moscou. Au total ce trajet dure 11h.
        Saut sautBerlinMoscou = new Saut(null, aeroportBerlin, aeroportMoscou, Duration.ofHours(3), Duration.ofHours(6));

        // 0h sur l'aéroport de Paris car aéroport de départ, pour aller jusqu'à l'aéroport de Berlin il faut 2h
        Saut sautParisBerlin = new Saut(sautBerlinMoscou, aeroportParis, aeroportBerlin, Duration.ZERO, Duration.ofHours(2));

        Trajet trajetParisMoscou = new Trajet(sautParisBerlin);

        // Création des compagnies aériennes et ajout des vols

        Compagnie airFrance = new Compagnie("Air France");
        Vol volParisMoscouAirFrance = airFrance.ajouteVol(trajetParisMoscou, ZonedDateTime.of(2024, 5, 27, 11, 0, 0, 0, ZoneId.of("Europe/Paris")));

        Compagnie ryanAir = new Compagnie("Ryan air");
        Vol volParisMoscouRyanAir = ryanAir.ajouteVol(trajetParisMoscou, ZonedDateTime.of(2024, 5, 26, 9, 0, 0,0, ZoneId.of("Europe/Paris")));

        airFrance.afficheVols();
        ryanAir.afficheVols();

        // On peut retarder le départ d'un vol de cette manière
        Duration retard = Duration.ofHours(2);
        volParisMoscouAirFrance.retardeDepart(retard);

        // On peut retarder un saut (En fait on retarde plus spécifiquement la durée d'une escale et pas la durée dans les airs,
        // cette implémentation ne permet pas de retarder un vol quand il est dans les airs).

        volParisMoscouAirFrance.retardeSaut(sautBerlinMoscou, Duration.ofHours(2));

        ryanAir.ajouteVol(trajetParisMoscou, ZonedDateTime.of(2024, 5, 26, 9, 0, 0,0, ZoneId.of("Europe/Paris")));

        //  Le vol en question de c1 est bien retardé et celui de c2 non alors que les deux compagnies utilisent le même trajet.
        //  Nous pouvons alors configurer des vols régulier sans soucis.
        airFrance.afficheVols();
        ryanAir.afficheVols();

        // Gestion des réservations pour le vol retardé

        Client client1 = new Client("Joe", "CB","joe@gmail.com");
        Passager p1 = new Passager("Jordan");
        Passager p2 = new Passager("Joe");
        Passager p3 = new Passager("Lily");

        volParisMoscouAirFrance.ouvrir();
        Reservation r1 = volParisMoscouAirFrance.createReservation(client1, p1);
        Reservation r2 = volParisMoscouAirFrance.createReservation(client1, p2);

        r1.getEtat().payer();
        r1.getEtat().annuler();

        // Affiche que r1 ne peut pas être confirmer une fois annulé et donc son état ne change pas
        //r1.getEtat().confirmer();
        // Affiche 'com.uca.reservation.Annuler@1d44bcfa', on est toujours dans l'état annulé.
        //System.out.println(r1.getEtat());

        volParisMoscouAirFrance.fermer();

        // Génère une erreur si on enlève le commentaire : on ne peut pas créer de réservation si le vol est fermé.
        // Reservation r3 = volDeN1.createReservation(client1, p3);

    }
}
