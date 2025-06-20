package com.epsi.turnfight;

import com.epsi.turnfight.model.Character;
import com.epsi.turnfight.service.BattleService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NoNegativeHpLoopTest {
    @Test
    void neverNegativeHpInMassiveLoop() {
        Character c1 = new Character("A");
        Character c2 = new Character("B");
        BattleService service = new BattleService();

        // 1 million d’attaques (stress test)
        for (int i = 0; i < 1_000_000; i++) {
            service.attack(c1, c2);
            service.attack(c2, c1);
        }

        assertTrue(c1.getHp() >= 0 && c2.getHp() >= 0);
        assertTrue(c1.getHp() <= 10 && c2.getHp() <= 10);
    }
}
