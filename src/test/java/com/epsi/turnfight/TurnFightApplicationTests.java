package com.epsi.turnfight;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TurnFightApplicationTests {

    @Test
    void testHelloTurnFightMessage() throws Exception {
        // Sauvegarde de la sortie standard actuelle
        PrintStream originalOut = System.out;

        // Création d'un flux temporaire pour capturer la sortie
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Lancement de l'application
        TurnFightApplication.main(new String[]{});

        // Restauration de la sortie standard
        System.setOut(originalOut);

        // Vérifie que la sortie contient bien le message attendu
        assertTrue(outContent.toString().contains("Hello, TurnFight!"));
    }
}