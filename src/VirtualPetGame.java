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
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

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
        petShape.setFill(Color.RED);
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
        double windowWidth = 800;
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

        // adding the pet into the scene and naming the pet
        double petCenterX = windowWidth / 2 + 20;
        double petCenterY = 20 + barHeight + (windowHeight - barHeight) / 3;

        petShape.setCenterX(petCenterX);
        petShape.setCenterY(petCenterY);
        petShape.setVisible(false);

        // gets the pet's name from the user
        TextField petNameField = new TextField();
        petNameField.setPromptText("Please enter your new pet's name!");
        petNameField.setAlignment(Pos.CENTER);
        petNameField.setPrefSize(280, 35);
        petNameField.setLayoutX(petCenterX - 140);
        petNameField.setLayoutY(petCenterY - 17.5);

        // displays the pet's name below the pet
        Label petNameLabel = new Label();
        petNameLabel.setFont(Font.font(18));
        petNameLabel.setAlignment(Pos.CENTER);
        petNameLabel.setPrefWidth(280);
        petNameLabel.setLayoutX(petCenterX - 140);
        petNameLabel.setLayoutY(petCenterY + 55);
        petNameLabel.setVisible(false);

        // saves the pet's name and shows the pet when Enter is pressed
        petNameField.setOnAction(event -> {

            String petName = petNameField.getText().trim();

            // checks that the user entered a name
            if (petName.isEmpty()) {
                petNameField.clear();
                petNameField.setPromptText("Please enter a name!");
            } else {
                myPet.setName(petName);
                petNameLabel.setText(myPet.getName());

                // hides the name field
                petNameField.setVisible(false);

                // shows the pet and its name
                petShape.setVisible(true);
                petNameLabel.setVisible(true);
            }
        });

        // places the quit button on the right
        Button quitButton = new Button("Quit");
        quitButton.setPrefSize(65, 30);
        quitButton.setLayoutX(windowWidth - 85);
        quitButton.setLayoutY(32);
        quitButton.setOnAction(event -> primaryStage.close());

        // place the feedButton in the left corner
        feedButton.setPrefSize(80, 35);
        feedButton.setLayoutX(85);
        feedButton.setLayoutY(85);

        // place the playButton in the right corner
        playButton.setPrefSize(80, 35);
        playButton.setLayoutX(windowWidth + 40 - 85 - 80);
        playButton.setLayoutY(85);

        // place the sleepButton in the bottom
        sleepButton.setPrefSize(80, 35);
        sleepButton.setLayoutX((windowWidth + 40 - 80) / 2);
        sleepButton.setLayoutY(windowHeight - 100);

        // TODO: add game content: pet data and status, buttons, ect

        // changes the interactive buttons to triangles
        buttonStyle(feedButton);
        buttonStyle(playButton);
        buttonStyle(sleepButton);

        // display the pets status
        hungerLabel.setText("Hunger: " + myPet.getHunger() + "%");
        happinessLabel.setText("Happiness: " + myPet.getHappiness() + "%");
        energyLabel.setText("Energy: " + myPet.getEnergy() + "%");

        // creates the bars to display the status
        ProgressBar hungerBar = new ProgressBar(myPet.getHunger() / 100.0);
        ProgressBar happinessBar = new ProgressBar(myPet.getHappiness() / 100.0);
        ProgressBar energyBar = new ProgressBar(myPet.getEnergy() / 100.0);

        // places happiness on top in the center
        VBox happinessBox = createStatusBar(happinessLabel, happinessBar);
        happinessBox.setLayoutX(windowWidth / 2 + 20 - 90);
        happinessBox.setLayoutY(90);

        // places hunger along the left edge
        VBox hungerBox = createStatusBar(hungerLabel, hungerBar);
        hungerBox.setLayoutX(160);
        hungerBox.setLayoutY(310);
        hungerBox.setRotate(60);

        // places energy along the right edge
        VBox energyBox = createStatusBar(energyLabel, energyBar);
        energyBox.setLayoutX(windowWidth + 40 - 160 - 180);
        energyBox.setLayoutY(310);
        energyBox.setRotate(-60);

        // adds the title and buttons over the black top bar
        mainPane.getChildren().addAll(
                titleLabel, resetButton, quitButton, feedButton, playButton, sleepButton,
                petShape, petNameField, petNameLabel,
                happinessBox, hungerBox, energyBox);

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

    private VBox createStatusBar(Label label, ProgressBar bar) {

        label.setPrefWidth(180);

        bar.setPrefSize(180, 14);
        bar.maxWidth(180);

        VBox statusBox = new VBox(5);
        statusBox.setPrefSize(180, 45);
        statusBox.getChildren().addAll(label, bar);

        return statusBox;
    }

    // match the shape of the buttons to frame
    private void buttonStyle(Button button) {
        double buttonWidth = 80;
        double buttonHeight = buttonWidth * Math.sqrt(3) / 2;

        Polygon buttonShape = new Polygon(
                0.0, 0.0,
                buttonWidth, 0.0,
                buttonWidth / 2, buttonHeight);

        button.setShape(buttonShape);
        button.setScaleShape(true);

        // keeps the button's size proportional to the triangle
        button.setMinSize(buttonWidth, buttonHeight);
        button.setPrefSize(buttonWidth, buttonHeight);
        button.setMaxSize(buttonWidth, buttonHeight);

        button.setAlignment(Pos.CENTER);
        button.setPadding(new Insets(0, 0, buttonWidth / 3, 0));

    }

    // game start
    public static void main(String[] args) {
        launch(args);
    }
}