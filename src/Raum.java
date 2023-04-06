package src;
public class Raum {

  //Attribute
  private String name;
  private boolean nord;
  private boolean ost;
  private boolean sued;
  private boolean west;
  private Monster monster;
  private Item item;
  private boolean itemIsTaken;
  //Ende Attribute
  
  public Raum(String name, boolean nord, boolean ost, boolean sued, boolean west,Monster monster,Item item,boolean itemIsTaken) {
    this.name = name;
    this.nord = nord;
    this.ost = ost;
    this.sued = sued;
    this.west = west;
    this.monster = monster;
    this.item = item;
    this.itemIsTaken = false;
  }
  
  
  // get Methoden
  public String getName() {
    return this.name;
  }
  
  public boolean getNord() {
    return this.nord;
  }
  
  public boolean getOst() {
    return this.ost;
  }
  
  public boolean getSued() {
    return this.sued;
  }
  
  public boolean getWest() {
    return this.west;
  }
  
  public Monster getMonster() {
    return this.monster;
  }
  public void setMonster(Monster monster) {
    this.monster = monster;
  }
  
  public Item getItem() {
    return this.item;
  }
  public boolean ItemTakeable() {
  if (itemIsTaken) {
    return false;
  }
  else {
    return true;
  } // end of if-else // end of if  
    }
  public void setitemIsTaken(boolean value) { 
    this.itemIsTaken = value;
  }


}  