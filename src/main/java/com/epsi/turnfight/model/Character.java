package com.epsi.turnfight.model;

public class Character {
    private String name;
    private int hp = 10;

    public Character(String name) {
        this.name = name;
    }

    public void takeDamage(int damage) {
        if (isAlive()) {
            this.hp = Math.max(0, this.hp - damage);
        }
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }
}
