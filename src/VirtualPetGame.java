import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

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

        // set up triangular window for game
        double windowWidth = 700;
        double windowHeight = windowWidth * Math.sqrt(3) / 2;

        // creates the triangle with room for the thicker border
        Polygon triangle = new Polygon(
                20.0, 20.0,
                windowWidth + 20, 20.0,
                windowWidth / 2 + 20, windowHeight + 20);

        triangle.setFill(Color.AQUA);
        triangle.setStroke(Color.BLACK);
        triangle.setStrokeWidth(15);

        // centers the white title between the buttons
        titleLabel.setFont(Font.font(22));
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setPrefSize(windowWidth - 220, 40);
        titleLabel.setLayoutX(130);
        titleLabel.setLayoutY(27);

        // creates the pane for the game
        Pane mainPane = new Pane();
        mainPane.setStyle("-fx-background-color: transparent;");
        mainPane.getChildren().add(triangle);

        // creates a black top bar that follows the triangle's sides
        double barHeight = 55;
        double sideInset = barHeight / Math.sqrt(3);

        Polygon topBar = new Polygon(
                20.0, 20.0,
                windowWidth + 20, 20.0,
                windowWidth + 20 - sideInset, 20 + barHeight,
                20 + sideInset, 20 + barHeight);

        topBar.setFill(Color.BLACK);
        mainPane.getChildren().add(topBar);

        // places the reset button on the left
        resetButton.setPrefSize(65, 30);
        resetButton.setLayoutX(60);
        resetButton.setLayoutY(32);

        // TODO: reset the pet's stats when the reset button is clicked

        // places the quit button on the right
        Button quitButton = new Button("Quit");
        quitButton.setPrefSize(65, 30);
        quitButton.setLayoutX(windowWidth - 85);
        quitButton.setLayoutY(32);
        quitButton.setOnAction(event -> primaryStage.close());

        // adds the title and buttons over the black top bar
        mainPane.getChildren().addAll(
                titleLabel, resetButton, quitButton);

        // TODO: add game content: pet data and status, buttons, ect

        // creates the scene
        Scene scene = new Scene(
                mainPane, windowWidth + 40, windowHeight + 40);
        scene.setFill(Color.TRANSPARENT);

        // remove original window so that triangle is only visible
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // game start
    public static void main(String[] args) {
        launch(args);
    }
}