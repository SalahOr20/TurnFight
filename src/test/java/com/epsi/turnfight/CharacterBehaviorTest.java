package com.epsi.turnfight;

import com.epsi.turnfight.model.Character;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class CharacterBehaviorTest {
    @Test
    void characterCanTakeMultipleDamages() {
        Character c = new Character("Hero");
        c.takeDamage(3);
        c.takeDamage(2);
        assertEquals(5, c.getHp());
    }

    @Test
    void isAliveReturnsTrueWhenHpAboveZero() {
        Character c = new Character("Hero");
        c.takeDamage(9);
        assertTrue(c.isAlive());
        assertEquals(1, c.getHp());
    }

    @Test
    void characterWithZeroHpIsNotAlive() {
        Character c = new Character("Hero");
        c.takeDamage(10);
        assertFalse(c.isAlive());
    }

    @Test
    void characterNameIsSetCorrectly() {
        Character c = new Character("TestName");
        assertEquals("TestName", c.getName());
    }
}
