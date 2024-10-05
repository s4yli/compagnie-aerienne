package com.uca.doubleNavigabilite;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente la classe B, qui maintient une relation bidirectionnelle avec plusieurs instances de Classe A.
 */
public class ClassB {
    private List<ClassA> classAs = new ArrayList<>();

    // --------------------------- MÉTHODES ---------------------------------
    /**
     * Ajoute une instance de Classe A à la relation si elle n'est pas déjà présente.
     * Assure la bidirectionalité en ajoutant cette instance de ClassB à Classe A.
     * @param classA L'instance de Classe A à ajouter.
     */
    public void addClassA(ClassA classA) {
        if (classA != null && !this.classAs.contains(classA)) {
            this.classAs.add(classA);
            classA.addClassB(this);  // Ajoute cette instance de ClassB dans la liste de ClassA
        }
    }

    /**
     * Retire une instance de Classe A de la relation.
     * Assure la bidirectionalité en retirant cette instance de ClassB de Classe A.
     * @param classA L'instance de Classe A à retirer.
     */
    public void removeClassA(ClassA classA) {
        if (classA != null && this.classAs.contains(classA)) {
            this.classAs.remove(classA);
            classA.removeClassB(this);  // Retire cette instance de ClassB de la liste de ClassA
        }
    }

    /**
     * Récupère la liste actuelle des instances de Classe A associées à cette Classe B.
     * @return Une copie de la liste des relations avec Classe A.
     */
    public List<ClassA> getClassAs() {
        return new ArrayList<>(classAs);
    }
}
