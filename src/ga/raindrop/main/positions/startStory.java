package ga.raindrop.main.positions;

import ga.raindrop.main.Game;
import java.io.*;

public class startStory {

    // Actual start of the story.
    public static void StartStory(){
        System.out.println("You are lying on a basement floor.");
        System.out.println("There is a book lying next to you to the east.");
        System.out.println("There is an unlocked door in front of you to the north.");
        System.out.println("You may also save the game.");
        System.out.println("HINT: Type 'Read' to read the book. Type 'north' or 'walk north' to continue from the basement.");
        System.out.println("What would you like to do, " + Game.playerName + "?");

        Game.choice = Game.myScanner.next();

        if (Game.choice.equalsIgnoreCase("read")) {
            readJournal1.journalPage1();
        }
        if (Game.choice.equalsIgnoreCase("north")){

        }
        if (Game.choice.equalsIgnoreCase("travel north")){

        }
        if (Game.choice.equalsIgnoreCase("walk north")) {

        }
        if (Game.choice.equalsIgnoreCase("walk")){

        }
        if (Game.choice.equalsIgnoreCase("door")){

        }
        if (Game.choice.equalsIgnoreCase("save")){
            try{

                FileOutputStream saveFile = new FileOutputStream("GameSave.sav");
                ObjectOutputStream save = new ObjectOutputStream(saveFile);

                save.writeObject(Game.playerHP);
                save.writeObject(Game.playerName);
                save.writeObject(Game.item);
                save.writeObject(Game.choice);
                save.writeObject(Game.mainMenu);
                save.writeObject(Game.mainMenu);
                save.writeObject(Game.achievementTracker);
                save.writeObject(Game.bootFirstTime);
                save.writeObject(Game.areCreator);
                save.writeObject(Game.beginJourneyNotebook);
                save.writeObject(Game.beginJourney);

                save.close();

                System.out.println("Save Success!");

            }catch(Exception exc){
                exc.printStackTrace();
            }
        }
    }

}
