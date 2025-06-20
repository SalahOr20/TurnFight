package com.epsi.turnfight;

import com.epsi.turnfight.model.Character;
import com.epsi.turnfight.service.BattleService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeadCharacterBehaviorTest {
    @Test
    void deadCharacterCannotAttackOrBeAttacked() {
        Character dead = new Character("Dead");
        Character target = new Character("Target");
        BattleService battleService = new BattleService();

        // On "tue" le personnage
        dead.takeDamage(10);
        assertFalse(dead.isAlive());

        // Il ne peut plus attaquer
        battleService.attack(dead, target);
        assertEquals(10, target.getHp());

        // Il ne peut plus être attaqué, hp ne descend pas en dessous de 0
        battleService.attack(target, dead);
        assertEquals(0, dead.getHp());
    }
}

