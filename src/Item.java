package src;
public class Item {

    // Attribute
    private String name;
    private int nutzen;
    private boolean istVersteckt;

    // Konstruktor
    public Item(String name, int nutzen, boolean istVersteckt) {
        this.name = name;
        this.nutzen = nutzen;
        this.istVersteckt = istVersteckt;
    }

    // get Methoden
    public String getName() {
        return this.name;
    }

    public int getNutzen() {
        return this.nutzen;
    }

    public boolean istVersteckt() {
        return this.istVersteckt;
    }

    // set Methoden
    public void setName(String name) {
        this.name = name;
    }

    public void setNutzen(int nutzen) {
        this.nutzen = nutzen;
    }

    public void setIstVersteckt(boolean istVersteckt) {
        this.istVersteckt = istVersteckt;
    }

}
