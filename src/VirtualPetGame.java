import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 * ACS - 5113 - Virtual Pet Game
 *
 * Creates a JavaFX window to display the pet's stats and lets
 * the user feed, play, sleep, and start over
 *
 * @author Cody William Van Dyke
 */

public class VirtualPetGame extends Application {

    // creates the pet
    private Pet myPet = new Pet();

    // creates the labels for displaying the pet's information
    private Label hungerLabel = new Label();
    private Label happinessLabel = new Label();
    private Label energyLabel = new Label();
    private Label statusLabel = new Label("Your pet is awake!");

    public void start(Stage primaryStage) {

        // create the title of the game
        Label titleLabel = new Label("Virtual Pet by Cody Van Dyke");
        titleLabel.setFont(Font.font(30));

        // uses a circle for the pet until an image is added
        Circle petShape = new Circle(45);
        petShape.setFill(Color.LIGHTBLUE);
        petShape.setStroke(Color.BLACK);

        hungerLabel.setFont(Font.font(15));
        happinessLabel.setFont(Font.font(15));
        energyLabel.setFont(Font.font(15));
        statusLabel.setFont(Font.font(15));

        // creates the buttons to care for the pet
        Button feedButton = new Button("Feed");
        Button playButton = new Button("Zoomies");
        Button sleepButton = new Button("Sleep");
        Button resetButton = new Button("Reset");
    }
}