# ACS-5139-FinalProject-JavaFX-Virtual-Pet

A simple virtual pet game that is similar to a Tamagotchi handheld game. 

The user will be able to feed, play with and let the pet rest to maintain the pet's status.

## Project Status

The main game is functional. The pet is represented by a red circle and all of the feeding, playing and sleeping mechanics are implemented.

## Features

- Enter a pet name before the pet appears
- Feed the pet to reduce hunger and increase happiness
- Play with the pet using the zoomies button to increase happiness
- Let the pet rest to restore energy also looses happiness
- Progress bars to visually track the pet metrics
- See messages that reflect the pets status
- shows action icons so that the action can be seen
- reset button to reset the stats of the pet
- quit button allows for easy closing of the game

The game uses a a fixed triangular window this is to mimic the handheld experience.

## How to Play

1. User is prompted to enter a name fore their pet then press enter.
2. Using the Feed, Zoomies, and Sleep buttons take care of you pet and make them happy!
3. Keep an eye on the progress bars to make sure the pet is healthy!
4. Cling the reset button to resset the stats or quit button to close the game.

   Default stats are 50 out of a scale from 0 to 100 for all stats

| Action | Hunger | Happiness | Energy |
| --- | --- | --- | --- |
| Feed | Decreases by 20 | Increases by 5 | No change |
| Zoomies | Increases by 10 | Increases by 15 | Decreases by 20 |
| Sleep | Increases by 10 | Decrease by 15 | Increases by 25 |
| Reset | Returns to 50 | Returns to 50 | Returns to 50 |

- There needs ot be at least 20 energy fot the pet to play.
- Stats change when a button is clicked and an action icpon appears until another action is picked

## Project Structure

- 'src/Pet.java' stroes all of the pets information and handles the caring logic
- 'src/VirtualPetGame.java creates the triangular game window and handles the user input, buttons and updates the display to show updates the the pets stats
- 'README.md' describes the game and how to run it
- 'DEVELOPMENT.md'
- '.vscode/' contains the VS code project and launch settings
  
## Tools

- Java
- JavaFX
- Visual Studio Code
- Git and GitHub
- Classes, Constructors, Private Feilds, and Methods
- Conditional Statements
- Lambda expression and event handlers

## Running the Game

1. Clone the repository and open the project
2. Make sure JDK 21, JavaFX 21 SDK and the Microsoft Extension Pack for Java
3. Update the file path for JavaFX library in '.vscode/setting.json'
4. Update the module path in '.vscode/launch.json' to point to the correct SDKs lib folder
5. launch the game and play!

## Learned from Project

This project give me valuable experience with a way to combine the Java and JavaFX concepts into a funtional game. 
I started by developming the window and controls, the I added the pets behavior and game actions one at a time. 
I am using GitHub to track the develpoment and backup

## Author

Cody William Van Dyke  
University of Oklahoma  
ACS-5113 — Fall 2026
