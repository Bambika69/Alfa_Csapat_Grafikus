package main.com.teamalfa.blindvirologists.equipments.active_equipments;

import main.com.teamalfa.blindvirologists.turn_handler.TurnHandler;
import main.com.teamalfa.blindvirologists.virologist.Virologist;

public class Axe extends ActiveEquipment{
    boolean blunt;

    public Axe() {
        usetime = 1;
        blunt = false;

        TurnHandler.getInstance().accept(this);
    }

    /**
     * If the axe is sharp it kills the virologist, otherwise it doesn't do anything.
     * @param v
     */
    @Override
    public boolean use(Virologist v) {
        if(usetime == 1){
            v.die();
            startCooldown();
            usetime--;
            return true;
        }
        return false;
    }

    /**
     * doesn't do anything at all.
     */
    @Override
    public void wornOut() {}

    /**
     * Doesn't do anything.
     */
    @Override
    public void step() {
        // Ennek is üresnek kell lennie, mert nincs rajta cooldown.
    }

    @Override
    public String getType() {
        return "Axe";
    }
}
