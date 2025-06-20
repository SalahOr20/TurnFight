package com.epsi.turnfight;

import com.epsi.turnfight.model.Character;
import com.epsi.turnfight.service.BattleService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OverkillScenarioTest {
    @Test
    void hpNeverGoesNegativeEvenWithMassiveAttacks() {
        Character c = new Character("Tank");
        BattleService battleService = new BattleService();

        // On inflige 50 attaques, soit bien plus que les HP initiaux
        for (int i = 0; i < 50; i++) {
            battleService.attack(new Character("Attacker"), c);
        }

        assertEquals(0, c.getHp());
    }
}
