package PetProject_1.one;

public class VirtualPet {
    private String name;
    private int hunger;
    private int thirst;
    private int energy;
    private int happiness;

    public VirtualPet(String name) {
        this.name = name;
        hunger = 50;
        thirst = 50;
        energy = 50;
        happiness = 50;
    }

    public void feed() {
        hunger -= 10;
        if (hunger < 0) {
            hunger = 0;
        }
    }

    public void water() {
        thirst -= 10;
        if (thirst < 0) {
            thirst = 0;
        }
    }

    public void sleep() {
        energy += 10;
        if (energy > 100) {
            energy = 100;
        }
    }

    public void play() {
        happiness += 10;
        if (happiness > 100) {
            happiness = 100;
        }
    }

    public void tick() {
        hunger += 5;
        thirst += 5;
        energy -= 5;
        happiness -= 5;
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHappiness() {
        return happiness;
    }
}



