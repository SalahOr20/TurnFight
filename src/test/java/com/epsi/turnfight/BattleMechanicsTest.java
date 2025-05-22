package com.epsi.turnfight;

import com.epsi.turnfight.model.Character;
import com.epsi.turnfight.service.BattleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BattleMechanicsTest {

    private BattleService battleService;

    @BeforeEach
    void setUp() {
        battleService = new BattleService();
    }

    @Test
    void attackerDoesNotHurtIfDefenderIsAlreadyDead() {
        Character attacker = new Character("Warrior");
        Character dead = new Character("Ghost");

        for (int i = 0; i < 10; i++) {
            dead.takeDamage(1);
        }

        battleService.attack(attacker, dead);

        assertEquals(5, dead.getHp()); // Ne descend pas en dessous de 0
    }

    @Test
    void characterCanBeAttackedUntilDeath() {
        Character attacker = new Character("A");
        Character defender = new Character("B");

        for (int i = 0; i < 10; i++) {
            battleService.attack(attacker, defender);
        }

        assertEquals(0, defender.getHp());
        assertFalse(defender.isAlive());
    }

    @Test
    void attackDoesNotAffectAttacker() {
        Character attacker = new Character("A");
        Character defender = new Character("B");

        battleService.attack(attacker, defender);

        assertEquals(10, attacker.getHp());
        assertEquals(9, defender.getHp());
    }

    @Test
    void bothCharactersAliveAfterOneAttack() {
        Character attacker = new Character("A");
        Character defender = new Character("B");

        battleService.attack(attacker, defender);

        assertTrue(attacker.isAlive());
        assertTrue(defender.isAlive());
    }
}
