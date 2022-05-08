package main.com.teamalfa.blindvirologists.turn_handler;

import main.com.teamalfa.blindvirologists.agents.virus.BearVirus;
import main.com.teamalfa.blindvirologists.city.City;
import main.com.teamalfa.blindvirologists.city.fields.Field;
import main.com.teamalfa.blindvirologists.virologist.Virologist;

import java.util.ArrayList;

public class Game implements Steppable{
    private static Game instance;
    private City city;
    private ArrayList<Virologist> bears;

    static {
        instance = new Game();
    }

    private Virologist virologist;

    private Game() {
        bears = new ArrayList<>();
    }

    public static Game getInstance() {
        return instance;
    }

    public void startGame() {
        City.getInstance().GenerateMap();
    }

    public void endGame(ArrayList<Virologist> winners) {}

    /**
     * Adds the virologist to the bears.
     * @param v The virologist that turned into a bear.
     */
    public void accept(Virologist v) {
        bears.add(v);
    }

    /**
     * Removes the virologist from the bears.
     * @param v The bear that died.
     */
    public void remove(Virologist v) {
        bears.remove(v);
    }

    /**
     * Controls the bears.
     * Every bear steps into a new field, they infect every virologist on said field
     * with bearvirus, then if they are inside a store they destroy every element in there.
     */

    public void controlBears() {
        for (Virologist bear : bears) {
            Field f = bear.getField();
            bear.move(f);
            for (Virologist enemy : bear.searchForVirologist()) {
                bear.use(new BearVirus(), enemy);
            }
            bear.getField().destroy();
        }
    }

    private void printMovement(Virologist bear, Field origin, Field destination) {
        System.out.println("Bear moved: ");
        System.out.println("ID: ");
    }

    /**
     * Calls the controlbears method.
     */
    public void step() {
        controlBears();
    }

    public ArrayList<Virologist> getBears() {
        return bears;
    }

}
