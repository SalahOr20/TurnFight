package com.epsi.turnfight.service;

import com.epsi.turnfight.model.Character;
import org.springframework.stereotype.Service;

@Service
public class BattleService {

    public void attack(Character attacker, Character defender) {
        if (attacker.isAlive() && defender.isAlive()) {
            defender.takeDamage(attacker.getAttack());
        }
    }
}
