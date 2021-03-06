package core.characters;

import io.annotations.Modifiable;
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

/**
 * @author Kathleen Oshima
 * @author Eric Mercer (JacenLakiir)
 */
@SuppressWarnings("serial")
public class Character extends GameElement {
	
	private ItemInventory inventory;
	
	@Modifiable(classification = "Gameplay", type = "Map")
	private Map<String, Double> myAttributeValues;
	
	private Map<String, Double> myBaseAttributeValues;
	
	private Map<String, State> myPossibleStates;
	//private Set<Projectile> myProjectiles;
	    

	public Character(GameObject game, PhysicsAttributes physicsAttribute) {
		this(physicsAttribute);
		setGame(game);
	}

	public Character(PhysicsAttributes physicsAttribute) {
		super(physicsAttribute);
		setTag("Character");
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
        List<CollectibleItem> activeInventory = new ArrayList<CollectibleItem>();
        for (CollectibleItem item : inventory.getInventory()) {
            if (item.isInUse())
                activeInventory.add(item);
        }
        for (CollectibleItem item : activeInventory)
            item.updatePlayerAttributes(this);
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
            setLocation(0, 0);
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
		return inventory.getInventory();
	}
	
    public State getPossibleState(String label) {
        return myPossibleStates.get(label);
    }

	public Collection<State> getPossibleStates() {
		return myPossibleStates.values();
	}


}
