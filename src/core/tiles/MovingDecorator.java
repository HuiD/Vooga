package core.tiles;


import io.annotations.Decorator;
import io.annotations.Modifiable;
import core.characters.GameElement;

@Decorator(target = Tile.class)
public class MovingDecorator extends TileDecorator{
    
    /**
     * 
     */
    private static final long serialVersionUID = -3246310429913082407L;
    @Modifiable(classification = "Gameplay", type = "Individual")
	private double startX, startY, endX, endY, speed;
	
	public MovingDecorator(Tile decoratedPlatform) {
		super(decoratedPlatform);
		startX = 0;
		startY = 0;
		endX = getWidth();
		endY = getHeight();
	}
	
	@Override
	public void setLocation(double xs, double ys){
		startX = xs;
		startY = ys;
		super.setLocation(xs, ys);
	}
	
	public void setEndLocation (double endX, double endY){
		this.endX = endX;
		this.endY = endY;
	}
	
	public void setMoveSpeed(double speed){
		this.speed = speed;
	}
	
	@Override
	public void afterHitFromBottomBy(GameElement e, String tag) {
		//Will only affect the vertical factor of a sprite beneath
		e.move(0, getY()-getOldY());
		super.afterHitFromBottomBy(e, tag);
	}

	@Override
	public void afterHitFromTopBy(GameElement e, String tag) {
		//Will carry player on top
		e.move(getX()-getOldX(), getY()-getOldY());
		super.afterHitFromTopBy(e, tag);
	}
	
	@Override
	public void afterHitFromLeftBy(GameElement e, String tag) {
		e.move(getX()-getOldX(), 0);
		super.afterHitFromLeftBy(e, tag);
	}
	
	@Override
	public void afterHitFromRightBy(GameElement e, String tag) {
		e.move(getX()-getOldX(), 0);
		super.afterHitFromRightBy(e, tag);
	}
	
	@Override
	public void update(long elapsedTime){
		super.update(elapsedTime);
		if(moveTo(elapsedTime, endX, endY, speed)){
			double tempX = endX;
			double tempY = endY;
			endX = startX;
			endY = startY;
			startX = tempX;
			startY = tempY;
		}		
	}
}
