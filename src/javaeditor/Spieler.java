package src.javaeditor;

public class Spieler {
  private int energie;
  private int maxEnergie;
  private double zKraft;
  private int xPos;
  private int yPos;
  private Item hand;
  private int _counter;
  private int lastSleept;

  public Spieler(int x, int y, int energie, int zKraft) {
    this.energie = energie;
    this.zKraft = zKraft;
    this.xPos = x;
    this.yPos = y;
    this.hand = null;
    this.maxEnergie = 100;
  }

  // get-Methoden
  public int getXPos() {
    return this.xPos;
  }

  public int getYPos() {
    return this.yPos;
  }

  public int getEnergie() {
    return this.energie;
  }

  public double getZKraft() {
    return this.zKraft;
  }

  // set-Methoden
  public void setXPos(int x) {
    this.xPos = x;
  }

  public void setYPos(int y) {
    this.yPos = y;
  }

  public void setEnergie(int e) {
    if (e > this.maxEnergie) {
      this.energie = this.maxEnergie;
    } else {
      this.energie = e;
    }
  }

  public void setZKraft(double d) {
    this.zKraft = d;
  }

  public void pickup(Item item) {
    this.hand = item;
  }

  public String gethand() {
    if (this.hand != null) {
      return this.hand.getName();
    } else {
      return "Nichts";
    }
  }

  public int getLastSleept() {
    return this.lastSleept;
  }
  public void setLastSleept(int lastSleept) {
    this.lastSleept = lastSleept;
  }
}
