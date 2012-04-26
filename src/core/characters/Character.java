/**
 * @author Kathleen Oshima
 * @author Eric Mercer (JacenLakiir)
 */

package core.characters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.golden.gamedev.GameObject;

import core.characters.ai.State;
import core.items.CollectibleItem;
import core.items.ItemInventory;
import core.physicsengine.physicsplugin.PhysicsAttributes;

@SuppressWarnings("serial")
public class Character extends GameElement {
	
	private transient ItemInventory inventory;
	
	private transient Map<String, Double> myAttributeValues, myBaseAttributeValues;
	private transient Map<String, State> myPossibleStates;

	public Character(GameObject game, PhysicsAttributes physicsAttribute) {
		super(game, physicsAttribute);
		inventory = new ItemInventory();
		myBaseAttributeValues = new HashMap<String, Double>();
		myAttributeValues = new HashMap<String, Double>();
		myPossibleStates = new HashMap<String, State>();
	}

	public Character() {
		super();
		myBaseAttributeValues = new HashMap<String, Double>();
		myAttributeValues = new HashMap<String, Double>();
		inventory = new ItemInventory();
		myPossibleStates = new HashMap<String, State>();
	}
	
	@Override
    public void update(long milliSec) {
        updateAbilities();
        updateState(milliSec);              
        super.update(milliSec);
        checkIfDead();
    }
    
    public void updateAbilities() {
        for (CollectibleItem item : inventory.getMyInventory()) {
            if (item.isInUse()) {
                inventory.getMyActiveInventory().add(item);
            } else {
                inventory.getMyActiveInventory().remove(item);
            }
        }
        for (CollectibleItem item : inventory.getMyActiveInventory()) {
            item.updatePlayerAttributes(this);
//            for (String state : myAttributeValues.keySet()) {
//                System.out.print(state + myAttributeValues.get(state));
//                System.out.println();
//            }
        }
    }

    public void updateState (long milliSec)
    {
        List<State> myCurrentStates = new ArrayList<State>();
        for (State s : myPossibleStates.values())
            if (s.isActive())
                myCurrentStates.add(s);
        for (State s : myCurrentStates)
            s.execute(milliSec);
    }
    
    public void checkIfDead ()
    {
        Double currHP = getAttributeValue("hitPoints");
        if (currHP != null && currHP <= 0) {
            updateBaseValue("lives", -1);
            addAttribute("hitPoints", 10);
            this.setLocation(0, 0);
            System.out.println("dead");
        }
    }
	
	public void addAttribute(String attribute, double defaultValue) {
		myBaseAttributeValues.put(attribute, defaultValue);
		myAttributeValues.put(attribute, myBaseAttributeValues.get(attribute));
	}
	
    public void addPossibleState(String label, State state) {
        myPossibleStates.put(label, state);
    }
    
    public void removePossibleState(String label) {
        myPossibleStates.remove(label);
    }
    
    public void activatePossibleState(String label) {
        myPossibleStates.get(label).setActive(true);
    }
    
    public void deactivatePossibleState(String label) {
        myPossibleStates.get(label).setActive(false);
    }

    public void deactivateAllOtherStates(State toRemainActive) {
        for (State s : myPossibleStates.values())
            if (!s.equals(toRemainActive))
                s.setActive(false);
    }

	public void updateBaseValue(String attribute, double newValue) {
		if (!myBaseAttributeValues.containsKey(attribute)) {
			return;
		}
		myBaseAttributeValues.put(attribute, myBaseAttributeValues.get(attribute) + newValue);
		myAttributeValues.put(attribute, myBaseAttributeValues.get(attribute));
	}

	public void updateAttributeValue(String attribute, double newValue) {
		if (!myBaseAttributeValues.containsKey(attribute)) {
			return;
		}
		myAttributeValues.put(attribute, myBaseAttributeValues.get(attribute) + newValue);
	}
	
	public double getBaseValue(String attribute) {
        return myBaseAttributeValues.get(attribute);
    }
	
	public Double getAttributeValue(String attribute) {
        if (myAttributeValues.get(attribute) == null )
            return null;
        return myAttributeValues.get(attribute);
    }
	
	public List<CollectibleItem> getInventory() {
		return inventory.getMyInventory();
	}
	
	public List<CollectibleItem> getActiveInventory() {
		return inventory.getMyActiveInventory();
	}
	
    public State getPossibleState(String label) {
        return myPossibleStates.get(label);
    }

	public Collection<State> getPossibleStates() {
		return myPossibleStates.values();
	}

}
