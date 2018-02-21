package ga.raindrop.main;

import ga.raindrop.main.positions.startStory;

import java.util.Scanner;
import java.io.*;

public class Game {

    // Scanner for user input
    public static Scanner myScanner;
    // For tracking Player HP at all times.
    public static int playerHP;
    // To keep the desired username the user desires to play as.
    public static String playerName;
    // Keep track of the items that the user has equipped.
    public static String item;
    // Stores the option chosen.
    public static String choice;
    // Main Menu Options
    public static String mainMenu;

    // Tracks Ending Points (Decides the ending for the player)
    public static int endingPoints = 0;

    // Tracks Achievements that were unlocked.
    public static int achievementTracker = 0;

    // Achievement boolean for "Boot the Game Up for the First Time!"
    public static boolean bootFirstTime = false;

    // Achievement boolean for "Are you the Creator?"
    public static boolean areCreator = false;

    // Achievement boolean for "Begin the Journey with a Notebook."
    public static boolean beginJourneyNotebook = false;

    // Achievement boolean for "Begin the Journey."
    public static boolean beginJourney = false;

    // Achievement boolean for



    public static void main (String[] args) {
        // Main method for running the game properly
        Game game;
        game = new Game();

        game.mainMenu();

    }

    public void mainMenu(){
        System.out.println("-------------------------------");
        System.out.println("           Welcome!            ");
        System.out.println("   By: Alain-Kyle R. Alfonso    ");
        System.out.println("-------------------------------");
        System.out.println("Load, or Start a new Game?");
        System.out.println("HINT: Type 'Load' to load a saved game, or 'Start' to start a new game.");

        myScanner = new Scanner(System.in);
        mainMenu = myScanner.nextLine();

        if(mainMenu.equalsIgnoreCase("load")){
            loadFile();
        }
        if(mainMenu.equalsIgnoreCase("start")){
            playerSetup();
        }

    }

    public void playerSetup(){
        // Setting up basic things for player
        playerHP = 100;
        item = "Fists";

        System.out.println("Your health is at " + playerHP + "%!");
        System.out.println("You have " + item + " equipped.");
        System.out.println("");

        // Username
        myScanner = new Scanner(System.in);

        System.out.println("What is your name, Protagonist?");

        playerName = myScanner.nextLine();

        if (playerName.equalsIgnoreCase("Kyle")) {
            System.out.println("-------------------------------------------------");
            System.out.println("Achievement Unlocked! - Are You the Creator?");
            areCreator = true;
            achievementTracker = achievementTracker + 1;
            endingPoints = endingPoints + 0;
            System.out.println("-------------------------------------------------");
            System.out.println("Creator? Is that you?");
            System.out.println("So, you are " + playerName + "? Nice name!");
            System.out.println("Let us begin your journey!");
            System.out.println("");
            startStory.StartStory();
        } else{
            System.out.println("So, you are " + playerName + "? Nice name!");
            System.out.println("Let us begin your journey!");
            System.out.println("");
            startStory.StartStory();
        }




    }

    public static void loadFile(){

        Game game;
        game = new Game();

        try{
            FileInputStream saveFile = new FileInputStream("GameSave.sav");
            ObjectInputStream save = new ObjectInputStream(saveFile);

            game.playerHP = (int) save.readObject();
            game.playerName = (String) save.readObject();
            game.item = (String) save.readObject();
            game.choice = (String) save.readObject();
            game.mainMenu = (String) save.readObject();
            game.endingPoints = (int) save.readObject();
            game.achievementTracker = (int) save.readObject();
            game.bootFirstTime = (boolean) save.readObject();
            game.areCreator = (boolean) save.readObject();
            game.beginJourneyNotebook = (boolean) save.readObject();
            game.beginJourney = (boolean) save.readObject();

            save.close();
            boolean loadedFile = true;


            startStory.StartStory();

        }catch(Exception exc){
            exc.printStackTrace();
        }

        System.out.println("\nRestored Object Values:\n");
        System.out.println("\tPlayer HP = " + game.playerHP);
        System.out.println("\tPlayer Name = " + game.playerName);
        System.out.println();

    }



}
