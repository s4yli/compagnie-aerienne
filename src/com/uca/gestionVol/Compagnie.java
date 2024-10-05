package com.uca.gestionVol;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Compagnie {

    private String                                  name;
    private HashMap<Vol, NumeroVol>                 vols;

    // --------------------------- CONSTRUCTEUR ---------------------------------

    public Compagnie(String name) {
        this.name                                   = name;
        this.vols                                   = new HashMap<>();
    }

    // ----------------------------- MÉTHODES -----------------------------------

    /**
     * Ajoute un nouveau vol à la compagnie avec le trajet et la date de départ spécifiés. Génère automatiquement
     * le numéro de vol.
     * @param t Le trajet du vol.
     * @param dateDepart La date de départ du vol.
     */
    public Vol ajouteVol(Trajet t, ZonedDateTime dateDepart) {
        NumeroVol numeroVol                         = new NumeroVol();
        Vol vol                                     = new Vol(numeroVol, t, dateDepart);
        this.vols.put(vol, numeroVol);
        return vol;
    }

    /**
     * Supprime un vol de la compagnie.
     * @param vol Le vol à supprimer.
     */
    public void enleveVol(Vol vol){
        this.vols.remove(vol);
    }

    /**
     * Affiche tous les vols de la compagnie avec leurs détails.
     */
    public void afficheVols() {
        System.out.println("\nVols de la compagnie \033[0;1m[" + this.name + "]\033[0m\n"); // Nom de la compagnie en bleu

        DateTimeFormatter formatter                 = DateTimeFormatter.ofPattern("dd MMMM yyyy à HH:mm", Locale.FRENCH);

        for (Map.Entry<Vol, NumeroVol> entry : this.vols.entrySet()) {
            Vol key                                 = entry.getKey();
            NumeroVol value                         = entry.getValue();

            ZonedDateTime dateDepart                = key.getDateDepart();
            ZonedDateTime dateArrivee               = key.getDateArrivee();

            System.out.println("\tPour le numéro de vol: \033[32m" + value.getNumero() + "\033[0m");

            System.out.println("\tDate de départ: \033[0;1m[" + dateDepart.format(formatter) + "]\033[0m");
            System.out.println("\tDate d'arrivée: \033[0;1m[" + dateArrivee.format(formatter) + "]\033[0m\n");
        }

        System.out.println("---------------------------------------------------\n");
    }

    /**
     * Trouve un vol par son numéro de vol.
     * @param numero Le numéro de vol à rechercher.
     * @return Le vol correspondant au numéro donné, ou null s'il n'est pas trouvé.
     */
    public Vol trouveVolParNumero(NumeroVol numero) {
        for (Map.Entry<Vol, NumeroVol> entry : this.vols.entrySet()) {
            if (entry.getValue().equals(numero)) {
                return entry.getKey(); // Return the Vol object if the NumeroVol matches
            }
        }
        return null; // Return null if no matching NumeroVol is found
    }

    // ----------------------- GETTERS AND SETTERS -----------------------------

    /**
     * Récupère le nom de la compagnie.
     * @return Le nom de la compagnie.
     */
    public String getName() {
        return name;
    }

    /**
     * Récupère une liste des numéros de vol associés à la compagnie.
     * @return Une liste des numéros de vol associés à la compagnie.
     */
    public ArrayList<NumeroVol> getNumerosVols() {
        return new ArrayList<>(this.vols.values());
    }

    /**
     * Récupère la liste des vols de la compagnie.
     * @return La liste des vols de la compagnie.
     */
    public HashMap<Vol, NumeroVol> getVols() {
        return vols;
    }

    /**
     * Modifie le nom de la compagnie.
     * @param name Le nouveau nom de la compagnie.
     */
    public void setName(String name) {
        this.name = name;
    }
}
