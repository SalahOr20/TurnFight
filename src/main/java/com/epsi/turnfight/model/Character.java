package com.epsi.turnfight.model;

public class Character {
    private String name;
    private int hp = 10;
    private int attack = 1;

    public Character(String name) {
        this.name = name;
    }

    public void takeDamage(int damage) {
        if (this.isAlive()) {
            this.hp = Math.max(0, this.hp - damage);
        }
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public String getName() {
        return name;
    }
}
