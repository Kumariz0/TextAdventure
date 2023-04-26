package src.vscode;

import java.util.Scanner;

// energie = Lebenu
// zkraft = Angrifskraft
public class Spielfeld {

  public void initSpiel() {

    Scanner _eingabe = new Scanner(System.in);

    // Initialize player outside of while loop
    Spieler spieler = new Spieler(1, 0, 100, 100);

    // Declare monsters
    Monster feuergeist = new Monster("gluehender Robert", false, 90, 30, 20);
    Monster schlafraeuber = new Monster("tim", false, 50, 70, 20);
    Monster giftigekoch = new Monster("verbrannte Zunge", false, 70, 50, 20);
    Monster toilettengeist = new Monster("Toilettengeist", false, 80, 60, 20);
    Monster schlafraeuber2 = new Monster("tom", false, 70, 60, 5);
    Monster buchfresser = new Monster("Buchfresser", false, 200, 70, 20);

    // Declare items
    Item feuerstab = new Item("feuerstab", 30, 0);
    Item zauberumhang = new Item("zauberumhang", 50, 50);
    Item zauberbuch = new Item("Zauberbuch", 20, 50);

    Raum[][] raum = new Raum[3][3];
    raum[0][0] = new Raum("Wohnzimmer", false, true, true, false, feuergeist, feuerstab, false);
    raum[0][1] = new Raum("Kueche", true, true, false, false, giftigekoch, null, false);
    raum[0][2] = new Raum("Bad", false, true, false, false, toilettengeist, null, false);
    raum[1][0] = new Raum("Stube", false, true, true, true, null, null, false);
    raum[1][1] = new Raum("Flur", true, true, true, true, null, null, false);
    raum[1][2] = new Raum("Gemach2", true, false, false, true, schlafraeuber2, null, false);
    raum[2][0] = new Raum("Gemach", false, false, false, true, schlafraeuber, null, false);
    raum[2][1] = new Raum("Flur2", false, false, true, true, null, zauberumhang, true);
    raum[2][2] = new Raum("Bibliothek", true, false, false, false, buchfresser, zauberbuch, true);

    // defining colors for sysout
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_PURPLE = "\u001B[35m";
    final String ANSI_CYAN = "\u001B[36m";
    String fW = "\033[47m \033[0m";
    String fG = "\033[42m \033[0m";

    System.out.print("\033[H\033[2J");
    System.out.flush();
    System.out.println("Herzlich willkommen im " + ANSI_PURPLE + "Gruselschloss Frankenstein" + ANSI_RESET
        + ". \nDu wurdest beauftragt das Schloss wieder bewohnbar zu machen und es von verschiedenen Monstern zu befreien, \nhierfuer stehen in verschiedenen Raeumen Hilfsmittel bereit.");
    _eingabe.nextLine();

    while (spieler.getEnergie() > 0) {
      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out
          .println("Du bist in " + ANSI_PURPLE + raum[spieler.getXPos()][spieler.getYPos()].getName() + ANSI_RESET
              + " Was moechtest du machen?");
      System.out.println("- " + ANSI_CYAN + "go" + ANSI_RESET + "\n    Go to another room");
      System.out.println("- " + ANSI_CYAN + "take" + ANSI_RESET + "\n    Try to take item from the room");
      System.out
          .println("- " + ANSI_CYAN + "search" + ANSI_RESET + "\n    Try to search the room for items and monsters");
      System.out.println("- " + ANSI_CYAN + "status" + ANSI_RESET + "\n    Display you current stats");
      System.out.println("- " + ANSI_CYAN + "fight" + ANSI_RESET + "\n    Fight the Monster in the room you are in");
      System.out.println("- " + ANSI_CYAN + "exit" + ANSI_RESET + "\n    Exit the game");
      String befehl = _eingabe.next();

      switch (befehl) {
        case "go":
          System.out.print("\033[H\033[2J");
          System.out.flush();
          System.out.println("In welche Richtung willst du gehen (up, down, left, right)?");
          String antwort = _eingabe.next();
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
              System.out.println(ANSI_RED + "Ungueltiger Befehl!" + ANSI_RESET);
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
          if (takeable == false) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(ANSI_RED + "Hier gibt es kein Item zum Aufheben." + ANSI_RESET);
            try {
              Thread.sleep(2000);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          } else {
            if (raum[spieler.getXPos()][spieler.getYPos()].getmonsterBeaten() == true) {
              spieler.pickup(item);
              System.out.print("\033[H\033[2J");
              System.out.flush();
              System.out.println(ANSI_GREEN + "Du hast das Item " + ANSI_YELLOW + item.getName() + ANSI_GREEN
                  + " aufgehoben." + ANSI_RESET);
              raum[spieler.getXPos()][spieler.getYPos()].setitemIsTaken(true);
              try {
                Thread.sleep(2000);
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              }
            } else {
              System.out.print("\033[H\033[2J");
              System.out.flush();
              System.out.println(ANSI_RED + "Das Item wird derzeit noch von einem Moster verteidigt." + ANSI_RESET);
              try {
                Thread.sleep(2000);
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              }
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
            System.out.println("Im Raum befindet sich kein Monster." + ANSI_RESET);
          }
          if ((raum[spieler.getXPos()][spieler.getYPos()].ItemTakeable())) {
            System.out.println(
                "Im Raum befindet sich ein Item: " + raum[spieler.getXPos()][spieler.getYPos()].getItem().getName());
          } else {
            System.out.println("Im Raum befindet sich kein Item." + ANSI_RESET);
          }

          try {
            Thread.sleep(3000);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
          break;

        case "status":
          System.out.print("\033[H\033[2J");
          System.out.flush();
          // Display player's energy and currently held item
          System.out.println("Energie: " + spieler.getEnergie());
          System.out.println("Angriffskraft:" + spieler.getZKraft());
          System.out.println("Gehaltenes Item: " + ANSI_YELLOW + spieler.gethand() + ANSI_RESET);

          int x = spieler.getXPos();
          int y = spieler.getYPos();

          switch (x * 10 + y) {
            case 0:
              // Wohnzimmer
              System.out.println(" " + fG.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fG.repeat(3) + fW.repeat(10) + " \n" +
                  " " + fG.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  "  " + fW + "    " + fW + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(13) + " \n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  "  " + " " + "    " + fW + "    " + fW + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(8) + "  " + fW.repeat(3) + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3));
              break;
            case 1:
              // Kueche
              System.out.println(" " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(13) + " \n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  "  " + fW + "    " + fW + "\n" +
                  " " + fG.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fG.repeat(3) + fW.repeat(10) + " \n" +
                  " " + fG.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  "  " + " " + "    " + fW + "    " + fW + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(8) + "  " + fW.repeat(3) + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3));
              break;
            case 2:
              // Bad
              System.out.println(" " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(13) + " \n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  "  " + fW + "    " + fW + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(13) + " \n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  "  " + " " + "    " + fW + "    " + fW + "\n" +
                  " " + fG.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fG.repeat(3) + fW.repeat(5) + "  " + fW.repeat(3) + "\n" +
                  " " + fG.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3));
              break;
            case 10:
              // Stube
              System.out.println(" " + fW.repeat(3) + "  " + fG.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(5) + fG.repeat(3) + fW.repeat(5) + " \n" +
                  " " + fW.repeat(3) + "  " + fG.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  "  " + fW + "    " + fW + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(13) + " \n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  "  " + " " + "    " + fW + "    " + fW + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(8) + "  " + fW.repeat(3) + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3));
              break;
            case 11:
              // Flur
              System.out.println(" " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(13) + " \n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  "  " + fW + "    " + fW + "\n" +
                  " " + fW.repeat(3) + "  " + fG.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(5) + fG.repeat(3) + fW.repeat(5) + " \n" +
                  " " + fW.repeat(3) + "  " + fG.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  "  " + " " + "    " + fW + "    " + fW + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(8) + "  " + fW.repeat(3) + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3));
              break;
            case 12:
              System.out.println(" " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(13) + " \n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  "  " + fW + "    " + fW + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(13) + " \n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  "  " + " " + "    " + fW + "    " + fW + "\n" +
                  " " + fW.repeat(3) + "  " + fG.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(5) + fG.repeat(3) + "  " + fW.repeat(3) + "\n" +
                  " " + fW.repeat(3) + "  " + fG.repeat(3) + "  " + fW.repeat(3));
              break;
            case 20:
              // Gemach
              System.out.println(" " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fG.repeat(3) + " \n" +
                  " " + fW.repeat(10) + fG.repeat(3) + " \n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fG.repeat(3) + " \n" +
                  "  " + fW + "    " + fW + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(13) + " \n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  "  " + " " + "    " + fW + "    " + fW + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(8) + "  " + fW.repeat(3) + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3));
              break;
            case 21:
              // Flur2
              System.out.println(" " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(13) + " \n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  "  " + fW + "    " + fW + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fG.repeat(3) + " \n" +
                  " " + fW.repeat(10) + fG.repeat(3) + " \n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fG.repeat(3) + " \n" +
                  "  " + " " + "    " + fW + "    " + fW + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(8) + "  " + fW.repeat(3) + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3));
              break;
            case 22:
              // Bibliothek
              System.out.println(" " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(13) + " \n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  "  " + fW + "    " + fW + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  " " + fW.repeat(13) + " \n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fW.repeat(3) + " \n" +
                  "  " + " " + "    " + fW + "    " + fW + "\n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fG.repeat(3) + " \n" +
                  " " + fW.repeat(8) + "  " + fG.repeat(3) + " \n" +
                  " " + fW.repeat(3) + "  " + fW.repeat(3) + "  " + fG.repeat(3));
              break;
            default:
              System.out.println("Invalid position");
          }

          try {
            Thread.sleep(4000);
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
          if (raum[spieler.getXPos()][spieler.getYPos()].getmonsterBeaten() == true) {
            System.out.println("Hier ist kein Monster mehr!");
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
            spieler.setEnergie(spieler.getEnergie() - monster.getZKraft());
            System.out.println("Du hast dem Monster " + damage + " Schaden zugefuegt und das Monster hat dir " + monster.getZKraft() + " hinzugefügt");

            try {
              Thread.sleep(1000);
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }

            // Check if the monster is defeated
            if (monster.getEnergie() <= 0) {
              raum[spieler.getXPos()][spieler.getYPos()].setMonster(null);
              System.out.println("Das Monster wurde besiegt!");
              raum[spieler.getXPos()][spieler.getYPos()].setmonsterBeaten(true);
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
                    "Das Monster hat einen Heiltrank fallen gelassen und du wurdest um " + ANSI_GREEN + healthgain
                        + ANSI_RESET + " geheilt!");
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
          System.out.println(ANSI_BLUE + "Spiel beendet." + ANSI_RESET);
          return;

        default:
          System.out.print("\033[H\033[2J");
          System.out.flush();
          System.out.println(ANSI_RED + "Ungueltiger Befehl." + ANSI_RESET);
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
          break;

      } // end of switch
      if (raum[0][0].getmonsterBeaten() == true) {
        if (raum[0][1].getmonsterBeaten() == true) {
          if (raum[0][2].getmonsterBeaten() == true) {
            if (raum[1][2].getmonsterBeaten() == true) {
              if (raum[2][0].getmonsterBeaten() == true) {
                if (raum[2][2].getmonsterBeaten() == true) {
                  System.out.println(
                      ANSI_GREEN + "Herzlichen glueckwunsch, du hast Schloss wieder Bewohnbar gemacht" + ANSI_RESET);
                  return;
                }
              }
            }
          }
        }
      }
    } // end of while

  }

}
