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
    private String type;
    private int hunger;
    private int happiness;
    private int energy;

    // creates the pet with their own starting values
    public Pet() {
        type = "Dog";
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

    // TODO: add feed()

    // TODO: add play()

    // TODO: add sleep()

    // TODO: get status

    // TODO: add reset()

}
