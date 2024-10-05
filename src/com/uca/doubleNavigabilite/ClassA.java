package com.uca.doubleNavigabilite;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente la classe A, qui maintient une relation bidirectionnelle avec plusieurs instances de Classe B.
 */
public class ClassA {
    private List<ClassB> classBs = new ArrayList<>();

    // --------------------------- MÉTHODES ---------------------------------
    /**
     * Ajoute une instance de Classe B à la relation si elle n'est pas déjà présente.
     * Assure la bidirectionalité en ajoutant cette instance de Classe A à Classe B.
     * @param classB L'instance de Classe B à ajouter.
     */
    public void addClassB(ClassB classB) {
        if (classB != null && !this.classBs.contains(classB)) {
            this.classBs.add(classB);
            classB.addClassA(this);  // Ajoute cette instance de ClassA dans la liste de ClassB
        }
    }

    /**
     * Retire une instance de Classe B de la relation.
     * Assure la bidirectionalité en retirant cette instance de Classe A de Classe B.
     * @param classB L'instance de Classe B à retirer.
     */
    public void removeClassB(ClassB classB) {
        if (classB != null && this.classBs.contains(classB)) {
            this.classBs.remove(classB);
            classB.removeClassA(this);  // Retire cette instance de ClassA de la liste de ClassB
        }
    }

    /**
     * Récupère la liste actuelle des instances de Classe B associées à cette Classe A.
     * @return Une copie de la liste des relations avec Classe B.
     */
    public List<ClassB> getClassBs() {
        return new ArrayList<>(classBs);
    }
}
