package src;
public class Spieler {

  private String name;
  private int energie;
  private int zKraft;
  private int xPos;
  private int yPos;
  private Item hand;

  public Spieler(int x, int y, int energie, int zKraft) {
    this.energie = energie;
    this.zKraft = zKraft;
    this.xPos = x;
    this.yPos = y;
    this.hand = null;
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

  public int getZKraft() {
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
    this.energie = e;
  }

  public void setZKraft(int zK) {
    this.zKraft = zK;
  }
  public void pickup(Item item) {
    this.hand = item;
  }
  public Item gethand() {
    return this.hand;
  }
}