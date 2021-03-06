package core.items;

import com.golden.gamedev.GameObject;
import com.golden.gamedev.object.Timer;
import core.characters.Character;
import core.physicsengine.physicsplugin.PhysicsAttributes;
/**
 * 
 * @author Kathleen Oshima
 *
 *For one-time-use items that automatically disable after they have been used
 */
@SuppressWarnings("serial")
public abstract class AutoNotInUseItem extends CollectibleItem {

	Timer timerStart;
	Timer timerEnd;
	long timePassed;
	
	public void update(long elapsedTime) {
		super.update(elapsedTime);
		timePassed = elapsedTime;
	}
	
	public AutoNotInUseItem(GameObject game, PhysicsAttributes physicsAttribute) {
	    super(game, physicsAttribute);
	    setTimerStart(0);
		setTimerEnd(0);
    }

	@Override
	public void updatePlayerAttributes(Character player) {
		if (timerStart.action(timePassed))
		{
			for (String state : myAttributeValues.keySet()) {
				updateBaseValues(player, state, myAttributeValues.get(state));
			}
		}
		if (timerEnd.action(timePassed)) {
			timerStart.setActive(false);
			timerEnd.setActive(false);
			this.setIsInUse(false);
			player.getInventory().remove(this);
		}
	}
	
	public void setTimerStart(int time) {
		this.timerStart = new Timer(time);
	}
	
	public void setTimerEnd(int time) {
		this.timerEnd = new Timer(time);
	}

    public abstract boolean canSetInUse();
	
}
