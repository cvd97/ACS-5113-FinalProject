/**
 * ACS - 5113 - FinalProject - VirtualPetGame
 * 
 * Store the pet's hunger, happiness, and energy
 * Handles feeding, playing, tucking in, and resetting
 * 
 * @author Cody William Van Dyke
 *
 */

public class Pet {

    // fields to store the pet's status
    private String name;
    private int hunger;
    private int happiness;
    private int energy;

    // creates the pet with their own starting values
    public Pet() {
        reset();
    }

    // resets all the pets values
    public void reset() {
        hunger = 50;
        happiness = 50;
        energy = 50;
    }

    // gets the pet's hunger
    public int getHunger() {
        return hunger;
    }

    // gets the pet's happiness
    public int getHappiness() {
        return happiness;
    }

    // gets the pet's energy
    public int getEnergy() {
        return energy;
    }

    // gets name
    public String getName() {
        return name;
    }

    // sets pets name
    public void setName(String petName) {
        this.name = petName;
    }

    public void feed() {
        hunger -= 20;
        happiness += 5;
        checkStats();
    }

    public void sleep() {
        energy += 25;
        hunger += 10;
        checkStats();
    }

    // checks if there is enough energy to play
    public boolean play() {

        if (energy < 20) {
            return false;
        } else {
            hunger += 10;
            happiness += 15;
            energy -= 20;
            checkStats();

            return true;
        }
    }

    // keeps values in the 0 to 100 bounds
    private void checkStats() {

        if (hunger < 0) {
            hunger = 0;
        } else if (hunger > 100) {
            hunger = 100;
        }

        if (energy < 0) {
            energy = 0;
        } else if (energy > 100) {
            energy = 100;
        }

        if (happiness < 0) {
            happiness = 0;
        } else if (happiness > 100) {
            happiness = 100;
        }
    }

    // returns a message of the pets status
    public String getStatus() {
        if (energy <= 20) {
            return "Awe!! " + this.getName() + " is soo sleepy and needs to be tucked in!";
        } else if (hunger >= 70) {
            return "Feed " + this.getName() + "! They are so hungry!";
        } else if (happiness < 30) {
            return "Get up and play! " + this.getName() + "! They need some ZOOMIESS!";
        } else {
            return "Let's GO! " + this.getName() + " is ready for some fun!";
        }
    }
}
