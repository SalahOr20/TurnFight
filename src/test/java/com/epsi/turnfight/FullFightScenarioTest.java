package com.epsi.turnfight;

import com.epsi.turnfight.model.Character;
import com.epsi.turnfight.service.BattleService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FullFightScenarioTest {

    @Test
    void fullFightUntilOneDies() {
        Character hero = new Character("Hero");
        Character villain = new Character("Villain");
        BattleService battleService = new BattleService();

        while (hero.isAlive() && villain.isAlive()) {
            battleService.attack(hero, villain);
            // Le vilain attaque en retour si toujours vivant
            if (villain.isAlive()) {
                battleService.attack(villain, hero);
            }
        }
        // a la fin l'un des deux doit être mort
        assertTrue(!hero.isAlive() || !villain.isAlive());
        // Et la vie d’un personnage est à 0
        assertTrue(hero.getHp() == 0 || villain.getHp() == 0);
    }
}
