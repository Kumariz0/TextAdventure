package src.vscode;

public class Item {

    // Attribute
    private String name;
    private int nutzen;
    private double energieIncrease;

    // Konstruktor
    public Item(String name, int nutzen, double energieIncrease) {
        this.name = name;
        this.nutzen = nutzen;
        this.energieIncrease = energieIncrease;
    }

    // get Methoden
    public String getName() {
        return this.name;
    }

    public int getNutzen() {
        return this.nutzen;
    }

    // set Methoden
    public void setName(String name) {
        this.name = name;
    }

    public void setNutzen(int nutzen) {
        this.nutzen = nutzen;
    }

    public void setenergieIncrease(double energieIncrease) {
        this.energieIncrease = energieIncrease;
    }

    public double getenergieIncrease() {
        return this.energieIncrease;
    }
}
