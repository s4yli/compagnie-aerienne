package com.uca.gestionVol;

import java.util.Random;

/**
 * Cette classe est un singleton permettant de générer des numéros aléatoires en s'assurant qu'ils soient (à peu près) uniques.
 * Il est recommandé de sauvegarder le compteur à chaque utilisation dans un fichier pour éviter de recommencer à zéro
 * et donc de perdre l'unicité des numéros.
 */
public class GenerateurNumero {
    private static int                      compteur; // Compteur pour assurer l'unicité des numéros
    private static final long               SEED = 42; // Graine
    private static Random                   randomobj;
    private static GenerateurNumero         instance; // Instance unique de la classe GenerateurNumero

    // Constructeur privé pour empêcher l'instanciation directe
    private GenerateurNumero() {
        // Émule une initialisation lente.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        randomobj   = new Random();
        randomobj.setSeed(SEED); // Initialisation de l'objet Random avec une graine fixe
        compteur    = 0;
    }

    /**
     * Récupère l'instance unique de GenerateurNumero.
     * @return L'instance unique de GenerateurNumero.
     */
    public static GenerateurNumero getInstance(){
        if (instance == null){
            instance = new GenerateurNumero();
        }
        return instance;
    }

    /**
     * Génère un nouveau numéro en combinant le compteur et un nombre aléatoire.
     * Incrémente ensuite le compteur pour garantir l'unicité des numéros.
     * @return Le nouveau numéro généré.
     */
    public static String getNouveauNumero(){
        String compteurString   = String.valueOf(compteur);
        String nombreAleatoire  = String.valueOf(randomobj.nextInt(900000) + 100000);
        compteur                ++;
        return compteurString + nombreAleatoire;
    }
}
