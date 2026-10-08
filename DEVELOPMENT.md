# Final Project Development Plan

## Project Goal

The goal is to create a simple virtual pet game. The user will feed the pet, play with the pet, and tuck it in.

## Design Decisions

- The game window is an upside down equilateral triangle.
- The care buttons are the same shape as the window.
- Pet.java stores the pet's information and care logic.
- VirtualPetGame.java handles the window, user input, and display updates.
- The user names the pet at the start of the game.
- Care buttons become available after the pet's name is entered.
- The pet appears when a valid name is given.
- Stats change when action buttons are clicked.
- Sleeping restores energy but increases hunger and decreases happiness.
- Action icons show the most recent interaction.
- Reset restores the starting stats while keeping the pet's name.

## Completed Tasks

- [x] Set up the JavaFX project and GitHub repository.
- [x] Created the triangular window and top bar.
- [x] Added the title, Reset, and Quit buttons.
- [x] Created triangular care buttons.
- [x] Added the pet class and starting stats.
- [x] Let the user name the pet.
- [x] Displayed the pet after a valid name is entered.
- [x] Added labeled progress bars.
- [x] Implemented feeding, playing, and sleeping.
- [x] Connected the buttons to the pet's methods.
- [x] Added status messages and action icons.
- [x] Added reset behavior.
- [x] Set sleeping to decrease happiness by 15.

## Action Rules

| Action | Hunger | Happiness | Energy |
| --- | --- | --- | --- |
| Feed | Decreases by 20 | Increases by 5 | No change |
| Zoomies | Increases by 10 | Increases by 15 | Decreases by 20 |
| Sleep | Increases by 10 | Decreases by 15 | Increases by 25 |
| Reset | Returns to 50 | Returns to 50 | Returns to 50 |

### Rules

- The pet needs at least 20 energy to play.
- If energy is below 20, clicking Zoomies shows a message and leaves all stats unchanged.
- After an action, values below 0 become 0 and values above 100 become 100.

## Pet.java

Stores the pet's information and handles the care logic.

FIELDS:

- `private String name`
- `private int hunger`
- `private int happiness`
- `private int energy`

METHODS:

- `Pet()` sets the starting stats by calling reset().
- `getName()` gets the pet's name.
- `setName(String petName)` saves the name entered by the user.
- `getHunger()` gets the pet's hunger.
- `getHappiness()` gets the pet's happiness.
- `getEnergy()` gets the pet's energy.
- `feed()` decreases hunger and increases happiness.
- `play()` checks energy before changing the stats and returns whether the pet could play.
- `sleep()` increases energy and hunger and decreases happiness.
- `checkStats()` keeps the values between 0 and 100.
- `getStatus()` returns a message about the pet.
- `reset()` restores the starting stats while keeping the name.

### Status Messages

These conditions are checked in order. The first matching message is displayed, with the pet's name included.

- Energy is 20 or below: "Awe!! [name] is too sleepy!"
- Hunger is at least 70: "Feed [name]! They are so hungry!"
- Happiness is below 30: "Get up and play! [name]! They need some ZOOMIESS!"
- Otherwise: "Let's GO! [name] is ready for some fun!"

At exactly 20 energy, the pet can still play even though the status message says it is sleepy.

## VirtualPetGame.java

Creates the game window and handles user input and display updates.

FIELDS:

- `private Pet myPet`: stores the pet object.
- `private Label hungerLabel`: displays the pet's hunger.
- `private Label happinessLabel`: displays the pet's happiness.
- `private Label energyLabel`: displays the pet's energy.
- `private Label statusLabel`: displays a message about the pet.
- `private ProgressBar hungerBar`: visually displays hunger.
- `private ProgressBar happinessBar`: visually displays happiness.
- `private ProgressBar energyBar`: visually displays energy.
- `private Pane speechBubble`: holds the pet's action icon.
- `private Label bubbleIcon`: displays the icon for eating, playing, or sleeping.

METHODS:

- `start(Stage primaryStage)`: creates the triangular game window and sets up the controls and event handlers.
- `updateDisplay()`: updates the labels, progress bars, and status message using the pet's current values.
- `showBubbleIcon(String icon)`: changes the action icon and makes it visible.
- `createStatusBar(Label label, ProgressBar bar)`: places a label and progress bar in a VBox and returns it.
- `buttonStyle(Button button)`: gives the button an equilateral triangle shape and positions its text.
- `main(String[] args)`: launches the JavaFX game.

### Game Screen

- The title "Virtual Pet by Cody Van Dyke"
- A field for entering the pet's name
- A red circle representing the pet
- The pet's name below the circle
- A status message above the pet
- Labeled progress bars for hunger, happiness, and energy
- Feed, Zoomies, and Sleep buttons
- Reset and Quit buttons
- An icon showing the most recent action- `checkStats()` keeps the values between 0 and 100
- `getStatus()` returns a message about the pet
- `reset()` restores the starting values

### Status Messages

These will show given varied conditions

- If the pet's energy is 20 or below: "Awe your is tired and needs to be tucked in!"
- If the pet's hunger is at least 70: "Feed the fur baby! It needs some food!"
- If the pet's happiness is below 30: "Get up and play! Your pet needs some zoomies!"
- else, "Your pet is ready for Anything! They are perfect!"

## VirtualPet.java

Create the window for the game and handles all inputs and display updates

FIELDS:

- `private Pet myPet`: stores the pet object
- `private Label hungerLabel`: displays the pet's hunger
- `private Label happinessLabel`: displays the pet's happiness
- `private Label energyLabel`: displays the pet's energy
- `private Label statusLabel`: displays a message about the pet
- `private ProgressBar hungerBar`: visually displays hunger
- `private ProgressBar happinessBar`: visually displays happiness
- `private ProgressBar energyBar`: visually displays energy
- `private Pane speechBubble`: holds the pet's action icon
- `private Label bubbleIcon`: displays the icon for eating, playing, or sleeping

METHODS:

- `start(Stage primaryStage)`: create the game window as a upside down triangle
- `updateDisplay()`: updates all the lables as the values change when the game is being played
- `showBubbleIcon(String icon`: changes the axtion icon to show what action is being done
- `createStatusBar(Label label, ProgressBar bar`: places the labels and progress bars in a VBox and returns the VBox
- `buttonStyle(Button button`: makes the buttins look like the window in shape
- `main(String[] args)`: lauches the JavaFx game

Game Screen:
- VanDykeFinalProject
- Something to represent a pet
- labels for all status
- buttons for feeding, playing, sleeping, and to reset the game
