package collision;

import java.awt.Graphics2D;

import charactersprites.CollectibleItem;
import charactersprites.Player;

import com.golden.gamedev.object.CollisionManager;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.CollisionGroup;

public class PlayerCollectibleItemCollision extends CollisionGroup {

	private static CollisionManager collisionType;
	private static SpriteGroup PlAYER_GROUP;
	private static SpriteGroup COLLECTIBLE_GROUP;
	
	@Override
    public void collided(Sprite character, Sprite item) {
	    character.setActive(true);
	    item.setActive(false);
	    ((Player) character).getMyInventory().add((CollectibleItem) item);
    }

	public CollisionManager makeCollision(SpriteGroup character, SpriteGroup colletibles) {
		collisionType = new PlayerCollectibleItemCollision();
		collisionType.setCollisionGroup(character, colletibles);
		return collisionType;
	}

	public static void update(long elapsedTime) {
		PlAYER_GROUP.update(elapsedTime);
		COLLECTIBLE_GROUP.update(elapsedTime);
	}
	
	public static void render(Graphics2D g) {
		PlAYER_GROUP.render(g);
		COLLECTIBLE_GROUP.render(g);
	}
	
	
	
}