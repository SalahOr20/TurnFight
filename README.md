
TurnFight est un mini-jeu Java de combat en tour par tour dans lequel deux personnages s'affrontent.
Ce projet pédagogique a pour objectif de :
- Mettre en pratique la programmation orientée objet (POO) en Java
- Implémenter des tests unitaires avec JUnit 5
- Mettre en place une intégration continue (CI) avec GitHub Actions
Structure du projet
turnfight/
■■■ src/
■ ■■■ main/
■ ■ ■■■ java/com/epsi/turnfight/
■ ■ ■■■ model/
■ ■ ■ ■■■ Character.java
■ ■ ■■■ service/
■ ■ ■ ■■■ BattleService.java
■ ■ ■■■ TurnFightApplication.java
■ ■■■ test/
■ ■■■ java/com/epsi/turnfight/
■ ■■■ BattleServiceTest.java
■ ■■■ CharacterBehaviorTest.java
■ ■■■ DeadCharacterBehaviorTest.java
■ ■■■ NoNegativeHpLoopTest.java
■ ■■■ BattleMechanicsTest.java
■ ■■■ TurnFightApplicationTests.java
Lancer le projet
Prérequis :
- Java 17 (version utilisée dans le pipeline CI)
Lancer les tests avec Maven Wrapper :
./mvnw test
Tests disponibles :
- Règles de combat : BattleServiceTest
- Comportement des personnages : CharacterBehaviorTest, DeadCharacterBehaviorTest
- Cas limites (HP négatif, attaque d’un personnage mort, etc.) : NoNegativeHpLoopTest, BattleMechanicsTest
- Vérification du lancement de l’application : TurnFightApplicationTests
Intégration Continue (CI) – GitHub Actions
Le workflow CI automatise les étapes suivantes à chaque push sur la branche dev :
- Lancement des tests avec JUnit
- Si tous les tests réussissent : fusion automatique de dev dans main
- Si un ou plusieurs tests échouent :
 - Création automatique d'une branche failure-<commit>
 - Rollback de la branche dev à l'état précédent
- Exception : si le commit modifie un fichier dans .github/workflows/, aucun rollback n’est effectué
Auteurs
Projet développé dans le cadre de l’école EPSI, par :
- Salah Eddine OURAMDAN
- Abdelah AINAK
