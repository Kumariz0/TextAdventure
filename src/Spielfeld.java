package src;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

// energie = Leben
// zkraft = Angrifskraft
public class Spielfeld {

  public void initSpiel() {

    Scanner eingabe = new Scanner(System.in);

    // Initialize player outside of while loop
    Spieler spieler = new Spieler(0, 0, 100, 100);

    // Declare monsters
    Monster feuergeist = new Monster("glühender Robert", false, 40, 30, 20);
    Monster schlafräuber = new Monster("tim", false, 50, 20, 20);
    Monster giftigekoch = new Monster("verbrannte Zunge", false, 70, 40, 20);
    Monster toilettengeist = new Monster("Toilettengeist", false, 80, 50, 20);
    Monster schlafräuber2 = new Monster("tom", false, 70, 60, 5);
    Monster buchfresser = new Monster("Buchfresser", false, 90, 70, 20);
    // Declare items
    Item feuerstab = new Item("feuerstab", 30, true);
    Item zauberumhang = new Item("zauberumhang", 50, true);
    Item zauberbuch = new Item("Zauberbuch", 20, true);

    Raum[][] raum = new Raum[3][3];
    raum[0][0] = new Raum("Wohnzimmer", false, true, true, false, feuergeist, feuerstab, false);
    raum[0][1] = new Raum("Kueche", true, true, false, false, giftigekoch, null, false);
    raum[0][2] = new Raum("Bad", false, true, false, false, toilettengeist, null, false);
    raum[1][0] = new Raum("Stube", false, true, true, true, null, null, false);
    raum[2][2] = new Raum("Bibliothek", true, false, false, false, buchfresser, zauberbuch, true);
    raum[1][1] = new Raum("Flur", true, true, true, true, null, null, false);
    raum[2][1] = new Raum("Flur2", false, false, true, true, null, zauberumhang, true);
    raum[2][0] = new Raum("Gemach", false, false, false, true, schlafräuber, null, false);
    raum[1][2] = new Raum("Gemach2", true, false, false, true, schlafräuber2, null, false);

    // defining colors for sysout
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_BLACK = "\u001B[30m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_PURPLE = "\u001B[35m";
    final String ANSI_CYAN = "\u001B[36m";
    final String ANSI_WHITE = "\u001B[37m";

    // Perform player actions within while loop
    // For example:
    // - Move player to another room
    // - Attack monster
    // - Pick up item
    while (spieler.getEnergie() > 0) {
      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out
          .println("Du bist in " + ANSI_PURPLE + raum[spieler.getXPos()][spieler.getYPos()].getName() + ANSI_RESET + " Was moechtest du machen?");
      System.out.println("- " + ANSI_CYAN + "go" + ANSI_RESET + "\n    Go to another room");
      System.out.println("- " + ANSI_CYAN + "take" + ANSI_RESET + "\n    Try to take item from the room");
      System.out.println("- " + ANSI_CYAN + "search" + ANSI_RESET + "\n    Try to search the room for items and monsters");
      System.out.println("- " + ANSI_CYAN + "status" + ANSI_RESET + "\n    Display you current stats");
      System.out.println("- " + ANSI_CYAN + "fight" + ANSI_RESET + "\n    Fight the Monster in the room you are in");
      System.out.println("- " + ANSI_CYAN + "exit" + ANSI_RESET + "\n    Exit the game");
      String befehl = eingabe.next();

      switch (befehl) {
        case "go":
        System.out.print("\033[H\033[2J");
        System.out.flush();
          System.out.println("In welche Richtung willst du gehen (up, down, left, right)?");
          String antwort = eingabe.next();
          // Check if player can move in the selected direction
          switch (antwort) {
            case "up":
              if (spieler.getYPos() > 0 && raum[spieler.getXPos()][spieler.getYPos() - 1].getSued() == true) {
                spieler.setYPos(spieler.getYPos() - 1);
                System.out.println("Du bist jetzt in " + raum[spieler.getXPos()][spieler.getYPos()].getName());
              } else {
                System.out.println("Du kannst nicht in diese Richtung gehen!");
              }
              try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              }
              break;

            case "down":
              if (spieler.getYPos() < 2 && raum[spieler.getXPos()][spieler.getYPos() + 1].getNord() == true) {
                spieler.setYPos(spieler.getYPos() + 1);
                System.out.println("Du bist jetzt in " + raum[spieler.getXPos()][spieler.getYPos()].getName());
              } else {
                System.out.println("Du kannst nicht in diese Richtung gehen!");
              }
              try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              }
              break;

            case "left":
              if (spieler.getXPos() > 0 && raum[spieler.getXPos() - 1][spieler.getYPos()].getOst() == true) {
                spieler.setXPos(spieler.getXPos() - 1);
                System.out.println("Du bist jetzt in " + raum[spieler.getXPos()][spieler.getYPos()].getName());
              } else {
                System.out.println("Du kannst nicht in diese Richtung gehen!");
              }
              try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              }
              break;

            case "right":
              if (spieler.getXPos() < 2 && raum[spieler.getXPos() + 1][spieler.getYPos()].getWest() == true) {
                spieler.setXPos(spieler.getXPos() + 1);
                System.out.println("Du bist jetzt in " + raum[spieler.getXPos()][spieler.getYPos()].getName());
              } else {
                System.out.println("Du kannst nicht in diese Richtung gehen!");
              }
              try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              }
              break;

            default:
              System.out.println(ANSI_RED + "Ungültiger Befehl!" + ANSI_RESET);
              try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              }
              break;

          }
          break;

        case "take":
          Item item = raum[spieler.getXPos()][spieler.getYPos()].getItem();
          boolean takeable = raum[spieler.getXPos()][spieler.getYPos()].ItemTakeable();
          if (takeable) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(ANSI_RED + "Hier gibt es kein Item zum Aufheben." + ANSI_RESET);
            try {
              Thread.sleep(2000);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          } else {
            spieler.pickup(item);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(ANSI_GREEN + "Du hast das Item " + item.getName() + " aufgehoben." + ANSI_RESET);
            raum[spieler.getXPos()][spieler.getYPos()].setitemIsTaken(true);
            try {
              Thread.sleep(2000);
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
          }
          break;

        case "search":
          System.out.print("\033[H\033[2J");
          System.out.flush();
          // Search for monsters and items in the room
          if (raum[spieler.getXPos()][spieler.getYPos()].getMonster() != null) {
            System.out.println("Im Raum befindet sich ein Monster: "
                + raum[spieler.getXPos()][spieler.getYPos()].getMonster().getName());
          } else {
            System.out.println("Im Raum befindet sich kein Monster.");
          }
          if (!(raum[spieler.getXPos()][spieler.getYPos()].ItemTakeable())) {
            System.out.println(
                "Im Raum befindet sich ein Item: " + raum[spieler.getXPos()][spieler.getYPos()].getItem().getName());
          } else {
            System.out.println("Im Raum befindet sich kein Item.");
          }
          try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
          break;

        case "status":
          System.out.print("\033[H\033[2J");
          System.out.flush();
          // Display player's energy and currently held item
          System.out.println("Energie: " + spieler.getEnergie());
          System.out.println("Gehaltenes Item: " + spieler.gethand());
          try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
          break;

        case "fight":
          System.out.print("\033[H\033[2J");
          System.out.flush();
          // Check if there is a monster in the room
          if (raum[spieler.getXPos()][spieler.getYPos()].getMonster() == null) {
            System.out.println("Hier ist kein Monster!");
            try {
              Thread.sleep(2000);
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
            break;
          }

          // Attack the monster
          Monster monster = raum[spieler.getXPos()][spieler.getYPos()].getMonster();
          int damage = spieler.getZKraft() - monster.getDefence();
          if (damage <= 0) {
            System.out.println("Dein Angriff hat keine Wirkung auf das Monster!");
            try {
              Thread.sleep(1000);
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
          } else {
            monster.setEnergie(monster.getEnergie() - damage);
            System.out.println("Du hast dem Monster " + damage + " Schaden zugefügt!");
            try {
              Thread.sleep(1000);
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }

            // Check if the monster is defeated
            if (monster.getEnergie() <= 0) {
              raum[spieler.getXPos()][spieler.getYPos()].setMonster(null);
              System.out.println("Das Monster wurde besiegt!");
              try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              }

              // Generate a random item drop
              int dropChance = (int) (Math.random() * 100);
              if (dropChance < 50) {
                int healthgain = (int) (Math.random() * 15);
                spieler.setEnergie(healthgain + spieler.getEnergie());
                System.out.println(
                    "Das Monster hat einen Heiltrank fallen gelassen und du wurdest um" + healthgain + " geheilt!");
                try {
                  Thread.sleep(1000);
                } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
                }
              } else {
                System.out.println("Das Monster hat nichts fallen gelassen.");
                try {
                  Thread.sleep(1000);
                } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
                }
              }
            }
          }
          break;
        case "exit":
          System.out.print("\033[H\033[2J");
          System.out.flush();
          System.out.println(ANSI_BLUE + "Spiel beendet."+ ANSI_RESET);
          return;

        default:
          System.out.print("\033[H\033[2J");
          System.out.flush();
          System.out.println(ANSI_RED + "Ungültiger Befehl." + ANSI_RESET);
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
          break;

      } // end of switch
    } // end of while

  }

}
