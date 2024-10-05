package com.uca;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.uca.doubleNavigabilite.ClassB;
import com.uca.doubleNavigabilite.ClassA;

/**
 * Tests pour vérifier le comportement bidirectionnel de la relation Many-to-Many entre ClassA et ClassB.
 */
public class TestRelationBidirectionnelleManyToMany {

    /**
     * Teste l'ajout mutuel entre les instances de ClassA et ClassB.
     * Vérifie que les instances sont correctement ajoutées dans les deux sens.
     */
    @Test
    public void testAjoutMutuel() {
        ClassA a1 = new ClassA();
        ClassB b1 = new ClassB();
        ClassA a2 = new ClassA();

        a1.addClassB(b1);
        b1.addClassA(a2);

        assertTrue(a1.getClassBs().contains(b1));  // Vérifie que b1 est bien dans la liste de a1
        assertTrue(b1.getClassAs().contains(a1));  // Vérifie que a1 est bien dans la liste de b1
        assertTrue(b1.getClassAs().contains(a2));  // Vérifie que a2 est bien dans la liste de b1
        assertTrue(a2.getClassBs().contains(b1));  // Vérifie que b1 est bien dans la liste de a2
    }

    /**
     * Teste la suppression mutuelle des relations entre ClassA et ClassB.
     * Vérifie que les relations sont correctement supprimées dans les deux sens.
     */
    @Test
    public void testSuppressionMutuelle() {
        ClassA a1 = new ClassA();
        ClassB b1 = new ClassB();

        a1.addClassB(b1);
        a1.removeClassB(b1);

        assertFalse(a1.getClassBs().contains(b1));  // Vérifie que b1 a été retiré de la liste de a1
        assertFalse(b1.getClassAs().contains(a1));  // Vérifie que a1 a été retiré de la liste de b1
    }
}
