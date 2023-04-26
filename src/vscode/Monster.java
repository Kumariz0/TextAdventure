package src.vscode;

public class Monster {

    private String name;
    private boolean besiegt;
    private int energie;
    private int zKraft;
    private int defence;

    // Konstruktor
    public Monster(String name, boolean besiegt, int energie, int zKraft, int defence) {
        this.name = name;
        this.besiegt = besiegt;
        this.energie = energie;
        this.zKraft = zKraft;
        this.defence = defence;
    }

    // Getter-Methoden
    public String getName() {
        return name;
    }

    public boolean getBesiegt() {
        return besiegt;
    }

    public int getEnergie() {
        return energie;
    }

    public int getZKraft() {
        return zKraft;
    }

    // Setter-Methoden
    public void setName(String name) {
        this.name = name;
    }

    public void setBesiegt(boolean besiegt) {
        this.besiegt = besiegt;
    }

    public void setEnergie(int energie) {
        this.energie = energie;
    }

    public void setZKraft(int zKraft) {
        this.zKraft = zKraft;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getDefence() {
        return defence;
    }
}