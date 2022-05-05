package main.com.teamalfa.blindvirologists.city.fields;
import main.com.teamalfa.blindvirologists.equipments.Equipment;
import main.com.teamalfa.blindvirologists.virologist.Virologist;

import java.util.ArrayList;

public class Field {
    /**
     * Virologists on the field
     */
    protected ArrayList<Virologist> virologists = new ArrayList<>();
    /**
     * Neighbouring fields
     * */
    protected ArrayList<Field> neighbours = new ArrayList<>();

    /**
     * Constructor without parameter
     */
    public Field(){ }

    /**
     * Constructor with neighbours
     */
    public Field(ArrayList<Field> nbrs){
        this.setNeighbours(nbrs);
    }

    /**
     * Getters
     */
    public ArrayList<Virologist> getVirologists(){
        return virologists;
    }
    public ArrayList<Field> getNeighbours(){
        return neighbours;
    }

    /**
     * Adding and removing a virologist
     */
    public void accept(Virologist virologist){
        virologists.add(virologist);
        virologist.setField(this);
    }

    /**
     * removes the virologist from the field
     * @param virologist the virologist that's being removed.
     */
    public void remove(Virologist virologist){
        virologists.remove(virologist);
    }

    /**
     * Gives back the virologists on the field
     * except the one calling it
     */
    public ArrayList<Virologist> searchForVirologist(Virologist v){
        ArrayList<Virologist> v_copy = (ArrayList<Virologist>) virologists.clone();
        v_copy.remove(v);
        return v_copy;
    }

    /**
     * This method is called when a virologist searches a Field.
     * Doesn't do anything cause field is always empty.
     * @param virologist The Virologist who stands on the Field and searches it.
     */
    public void searchedBy(Virologist virologist){}

    /**
     * Tells the Virologist if it's possible to change or toss any equipment on this Field.
     * Default: it's not possible.
     * @return false
     */
    public boolean canChangeEquipment() {
        return false;
    }

    /**
     * doesn't do anything
     * @param e the equipment that gets put down to the field.
     */
    public void add(Equipment e) { }

    /**
     * Setters
     */
    public void setNeighbour(Field f1) {
        this.neighbours.add(f1);
    }

    public void setNeighbours(ArrayList<Field> neighbours) {
        if(neighbours != null) {
            this.neighbours = neighbours;
            for (Field neighbour : neighbours) {
                neighbour.setNeighbour(this);
            }
        }
    }

    /**
     * doesn't do anything
     * only have effect in StoreHouse
     */
    public void destroy() {}
}
