package com.epsi.turnfight;


import com.epsi.turnfight.model.Character;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CharacterTest {

    @Test
    void characterStartsWith10Hp() {
        Character c = new Character("Hero");
        assertEquals(10, c.getHp());
    }

    @Test
    void characterDiesAtZeroHp() {
        Character c = new Character("Hero");
        for (int i = 0; i < 10; i++) {
            c.takeDamage(1);
        }
        assertFalse(c.isAlive());
        assertEquals(0, c.getHp());
    }

    @Test
    void hpNeverGoesBelowZero() {
        Character c = new Character("Hero");
        c.takeDamage(20);
        assertEquals(0, c.getHp());
    }
}
