package com.epsi.turnfight;

import com.epsi.turnfight.model.Character;
import com.epsi.turnfight.service.BattleService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattleServiceTest {

    private final BattleService battleService = new BattleService();

    @Test
    void attackReducesHpByOne() {
        Character hero = new Character("Hero");
        Character enemy = new Character("Enemy");

        battleService.attack(hero, enemy);

        assertEquals(9, enemy.getHp());
    }

    @Test
    void deadCharacterCannotAttack() {
        Character dead = new Character("Dead");
        Character target = new Character("Target");

        for (int i = 0; i < 10; i++) {
            dead.takeDamage(1);
        }

        battleService.attack(dead, target);
        assertEquals(10, target.getHp());
    }
}
