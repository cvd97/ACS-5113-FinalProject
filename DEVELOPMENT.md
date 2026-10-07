# Final Project Development Plan

## Project Goal

The goal is to create a simple virtual pet game. The user will feed the pet, play with the pet, and tuck it in. 

## Project Files

- `src/Pet.java` stores the pet's stats and handles its actions
- `src/VirtualPet.java` creates the window and handles button clicks
- `README.md` describes the project and how to run it
- `DEVELOPMENT.md` tracks the work and testing
- `.gitignore` keeps generated files out of the repository

## Java Concepts Utilized

- Private fields, constructors, and getters to store pet information
- Methods to handle feeding, playing, sleeping, and resetting
- JavaFX labels and buttons to display information and accept input
- VBox and HBox to organize the window
- Event handlers to respond to button clicks

## Starting Values

- Hunger starts at 50 out of 100
- Happiness starts at 50 out of 100
- Energy starts at 50 out of 100

## Care Logic

- Higher hunger means the pet is hungrier
- Higher happiness and energy mean the pet is doing better
- All stats must stay between 0 and 100
- The stats only change when an action button is clicked

## Action Rules

| Action | Hunger | Happiness | Energy |
| --- | --- | --- | --- |
| Feed | Decrease by 20 | Increase by 5 | No change |
| Play | Increase by 10 | Increase by 15 | Decrease by 20 |
| Sleep | Increase by 10 | No change | Increase by 25 |
| Reset | Set to 50 | Set to 50 | Set to 50 |

### Rules

- The pet needs at least 20 energy to play
- If it has less than 20 energy, clicking Play will show a message and leave all stats unchanged
- After an action, values below 0 will become 0 and values above 100 will become 100

## Pet.java

Stores all pet information

FIELDS:

- 'private int hunger'
- 'private int happiness'
- 'private int energy'

METHODS:

- `Pet()` sets the starting values
- `getHunger()` gets the pets hunger
- `getHappines()` gets the happiness level of the pet
- `getEngery()` gets the engery of the pet
- `feed()` changes hunger and happiness
- `play()` checks energy before changing the stats
- `sleep()` changes energy and hunger
- `checkStats()` keeps the values between 0 and 100
- `getStatus()` returns a message about the pet
- `reset()` restores the starting values

### Status Messages

These will show given varied conditions

- If the pet's energy is 20 or below: "Awe your is tired and needs to be tucked in!"
- If the pet's hunger is at least 70: "Feed the fur baby! It needs some food!"
- If the pet's happiness is below 30: "Get up and play! Your pet needs some zoomies!"
- else, "Your pet is ready for Anything! They are perfect!"

## VirtualPet.java

This class extends the Application class adn creates the JavaFX window

Game Screen:
- VanDykeFinalProject
- Something to represent a pet
- labels for all status
- buttons for feeding, playing, sleeping, and to reset the game
