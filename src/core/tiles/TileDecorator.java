/**
 * @author Ian McMahon
 */

package core.tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;





import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.Timer;

import core.characters.GameElement;

public class TileDecorator extends Tile {

    private final Tile decoratedPlatform;


    public TileDecorator(Tile decoratedPlatform) {
        this.decoratedPlatform = decoratedPlatform;
        this.myGame = decoratedPlatform.getGame();
    }

    public void afterHitFromBottomBy(GameElement e) {	
        decoratedPlatform.afterHitFromBottomBy(e);
    }

    public void afterHitFromTopBy(GameElement e) {  
        decoratedPlatform.afterHitFromTopBy(e);
    }

    public void afterHitFromRightBy(GameElement e) {  
        decoratedPlatform.afterHitFromRightBy(e);
    }

    public void afterHitFromLeftBy(GameElement e) {  
       decoratedPlatform.afterHitFromLeftBy(e);
    }


    /*
     * The following methods allow the PlatformDecorator to act as a ConcretePlatform
     * (Sprite) by allowing access to the inner sprite's methods.
     */    	
    	protected void addGravity() {
            if (decoratedPlatform.isUnmovable() == false) {
            	decoratedPlatform.addAcceleration(0, -this.getGravitationalAcceleration());
            }
        }
        
        public void givenAForceOf(double fx, double fy) {
        	decoratedPlatform.givenAForceOf(fx, fy);
        }
    
        public double getMass() {
            return decoratedPlatform.getMass();
        }
    
        public double getCoefficintOfFrictionInXDirection() {
            return decoratedPlatform.getCoefficintOfFrictionInXDirection();
        }
    
        public double getCoefficintOfFrictionInYDirection() {
            return decoratedPlatform.getCoefficintOfFrictionInYDirection();
        }
    
        public double getCoefficintOfRestitutionInXDirection() {
            return decoratedPlatform.getCoefficintOfRestitutionInXDirection();
        }
    
        public double getCoefficintOfRestitutionInYDirection() {
            return decoratedPlatform.getCoefficintOfRestitutionInYDirection();
        }
    
        public boolean isUnmovable() {
            return decoratedPlatform.isUnmovable();
        }
    
        public boolean isPenetrable() {
            return decoratedPlatform.isPenetrable();
        }
    
        public double getGravitationalAcceleration() {
            return decoratedPlatform.getGravitationalAcceleration();
        }
    
        public void setMovable(boolean movable) {
        	decoratedPlatform.setMovable(movable); 
        }
        
        public void setPenetrable(boolean penetrable) {
        	decoratedPlatform.setPenetrable(penetrable);
        }
        
        public double getDragCoefficient() {
            return decoratedPlatform.getDragCoefficient();
        }
    
        public double getDensity() {
            return decoratedPlatform.getDensity();
        }
        
        public void setDensity(double density) {
        	decoratedPlatform.setDensity(density);
        }
        
        public void setCoefficientOfFrictionInX(double coef) {
        	decoratedPlatform.setCoefficientOfFrictionInX(coef);
        }
        
        public void setCoefficientOfFrictionInY(double coef) {
        	decoratedPlatform.setCoefficientOfFrictionInY(coef);
        }
        
        public void setCoefficientOfRestitutionInX(double coef) {
        	decoratedPlatform.setCoefficientOfRestitutionInX(coef);
        }
        
        public void setCoefficientOfRestitutionInY(double coef) {
        	decoratedPlatform.setCoefficientOfRestitutionInY(coef);
        }
        
        public void setDragCoefficient(double coef) {
            decoratedPlatform.setDragCoefficient(coef);
        }
    	
    	
    	public void addHorizontalSpeed(long elapsedTime, double accel, double maxSpeed){
    		decoratedPlatform.addHorizontalSpeed(elapsedTime, accel, maxSpeed);
    	}
    	
    	public void addVerticalSpeed(long elapsedTime, double accel, double maxSpeed){
    		decoratedPlatform.addVerticalSpeed(elapsedTime, accel, maxSpeed);
    	}
    	
    	public void forceX(double xs){
    		decoratedPlatform.forceX(xs);
    	}
    	
    	public void forceY(double ys){
    		decoratedPlatform.forceY(ys);
    	}
    	
    	public Background getBackground(){
    		return decoratedPlatform.getBackground();
    	}
    	
    	public Object getDataId(){
    		return decoratedPlatform.getDataID();
    	}
    	
    	public double getDistance(Sprite other){
    		return decoratedPlatform.getDistance(other);
    	}
    	
    	public int getHeight(){
    		return decoratedPlatform.getHeight();
    	}
    	
    	public double getHorizontalSpeed(){
    		return decoratedPlatform.getHorizontalSpeed();
    	}
    	
    	public int getID(){
    		return decoratedPlatform.getID();
    	}
    	
    	public BufferedImage getImage(){
    		return decoratedPlatform.getImage();
    	}
    	
    	public int getLayer(){
    		return decoratedPlatform.getLayer();
    	}
    	
    	public double getOldX(){
    		return decoratedPlatform.getOldX();
    	}
    	
    	public double getOldY(){
    		return decoratedPlatform.getOldY();
    	}
    	
    	public double getScreenX(){
    		return decoratedPlatform.getScreenX();
    	}
    	
    	public double getScreenY(){
    		return decoratedPlatform.getScreenY();
    	}
    	
    	public double getVerticalSpeed(){
    		return decoratedPlatform.getVerticalSpeed();
    	}
    	
    	public int getWidth(){
    		return decoratedPlatform.getWidth();
    	}
    	
    	public double getX(){
    		return decoratedPlatform.getX();
    	}
    	
    	public double getY(){
    		return decoratedPlatform.getY();
    	}
    	
    	public boolean isActive(){
    		return decoratedPlatform.isActive();
    	}
    	
    	public boolean isImmutable(){
    		return decoratedPlatform.isImmutable();
    	}
    	
    	public boolean isOnScreen(){
    		return decoratedPlatform.isOnScreen();
    	}
    	
    	public boolean isOnScreen(int leftOffset, int topOffset, int rightOffset, int bottomOffset){
    		return decoratedPlatform.isOnScreen(leftOffset, topOffset, rightOffset, bottomOffset);
    	}
    	
    	public void move(double dx, double dy){
    		decoratedPlatform.move(dx, dy);
    	}
    	
    	public boolean moveTo(long elapsedTime, double xs, double ys, double speed){
    		return decoratedPlatform.moveTo(elapsedTime, xs, ys, speed);
    	}
    	
    	public void moveX(double dx){
    		decoratedPlatform.moveX(dx);
    	}
    	
    	public void moveY(double dy){
    		decoratedPlatform.moveY(dy);
    	}
    	
    	public void render(Graphics2D g){
    		decoratedPlatform.render(g);
    	}
    	
    	public void render(Graphics2D g, int x, int y){
    		decoratedPlatform.render(g, x, y);
    	}
    	
    	public void setActive(boolean b){
    		decoratedPlatform.setActive(b);
    	}
    	
    	public void setBackground(Background backgr){
    		decoratedPlatform.setBackground(backgr);
    	}
    	
    	public void setDataId(Object dataID){
    		decoratedPlatform.setDataID(dataID);
    	}
    	
    	public void setHorizontalSpeed(double vx){
    		decoratedPlatform.setHorizontalSpeed(vx);
    	}
    	
    	public void setID(int id){
    		decoratedPlatform.setID(id);
    	}
    	
    	public void setImage(BufferedImage image){
    		decoratedPlatform.setImage(image);
    	}
    	
    	public void setImages(BufferedImage[] images){
    		decoratedPlatform.setImages(images);
    	}
    	
    	public void setImmutable(boolean b){
    		decoratedPlatform.setImmutable(b);
    	}
    	
    	public void setLayer(int i){
    		decoratedPlatform.setLayer(i);
    	}
    	
    	public void setLocation(double xs, double ys){
    		decoratedPlatform.setLocation(xs, ys);
    	}
    	
    	public void setMovement(double speed, double angleDir){
    		decoratedPlatform.setMovement(speed, angleDir);
    	}
    	
    	public void setSpeed(double vx, double vy){
    		decoratedPlatform.setSpeed(vx, vy);
    	}
    	
    	public void setVerticalSpeed(double vy){
    		decoratedPlatform.setVerticalSpeed(vy);
    	}
    	
    	public void setX(double xs){
    		decoratedPlatform.setX(xs);
    	}
    	
    	public void setY(double ys){
    		decoratedPlatform.setY(ys);
    	}
    	
    	public Timer getAnimationTimer(){
    		return decoratedPlatform.getAnimationTimer();
    	}
    	
    	public int getFinishAnimationFrame(){
    		return decoratedPlatform.getFinishAnimationFrame();
    	}
    	
    	public int getFrame(){
    		return decoratedPlatform.getFrame();
    	}
    	
    	public BufferedImage getImage(int i){
    		return decoratedPlatform.getImage(i);
    	}
    	
    	public BufferedImage[] getImages(){
    		return decoratedPlatform.getImages();
    	}
    	
    	public int getStartAnimationFrame(){
    		return decoratedPlatform.getStartAnimationFrame();
    	}
    	
    	public boolean isAnimate(){
    		return decoratedPlatform.isAnimate();
    	}
    	
    	public boolean isLoopAnim(){
    		return decoratedPlatform.isLoopAnim();
    	}
    	
    	public void setAnimate(boolean b){
    		decoratedPlatform.setAnimate(b);
    	}
    	
    	public void setAnimationFrame(int start, int finish){
    		decoratedPlatform.setAnimationFrame(start, finish);
    	}
    	
    	public void setAnimationTimer(Timer t){
    		decoratedPlatform.setAnimationTimer(t);
    	}
    	
    	public void setFrame(int i){
    		decoratedPlatform.setFrame(i);
    	}
    	
    	public void setLoopAnim(boolean b){
    		decoratedPlatform.setLoopAnim(b);
    	}
    	
    	public int[] getAnimationFram(){
    		return decoratedPlatform.getAnimationFrame();
    	}
    	
    	public int getDirection(){
    		return decoratedPlatform.getDirection();
    	}
    	
    	public int getStatus(){
    		return decoratedPlatform.getStatus();
    	}
    	
    	public void setAnimation(int stat, int dir){
    		decoratedPlatform.setAnimation(stat, dir);
    	}
    	
    	public void setAnimationFrame(int[] animation){
    		decoratedPlatform.setAnimationFrame(animation);
    	}
    	
    	public void setDirection(int dir){
    		decoratedPlatform.setDirection(dir);
    	}
    	
    	public void setStatus(int stat){
    		decoratedPlatform.setStatus(stat);
    	}
    	
    	public void update(long elapsedTime){
    		decoratedPlatform.update(elapsedTime);
    	}
    	
    	protected Tile getDecoratedPlatform(){
    		return decoratedPlatform;
    	}

}
