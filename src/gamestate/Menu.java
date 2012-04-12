package gamestate;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import keyconfiguration.KeyAnnotation;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.background.ImageBackground;
/**
 * 
 * @author Hui Dong
 *
 */
public class Menu extends MenuGameObject{
    private int optionID = 0;
    GameEngine2D engine;
    private Background background;
    private BufferedImage arrow;
    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    static{
        map.put(0, GameEngine2D.GAME);
        map.put(1, GameEngine2D.GAME2);
        map.put(2, GameEngine2D.GAME3);
        map.put(3, GameEngine2D.GAME4);
        
    }

    public Menu(GameEngine2D engine) {
        super(engine);
        this.engine = engine;
    }

    @Override
    public void initResources() {
        super.initResources();
        background = new ImageBackground(getImage("resources/StarDust.jpg"), 640, 480);
        arrow = getImage("resources/MenuArrow.png");
    }

    @Override
    public void render(Graphics2D graphic) {
        background.render(graphic);
        graphic.setColor( Color.WHITE );

        graphic.drawString("Demo1", 320, 240);
        graphic.drawString("Demo2", 320, 260);
        graphic.drawString("Demo3", 320, 280);
        graphic.drawString("Demo4", 320, 300);        
        graphic.drawString("EXIT", 320, 320);
        graphic.drawImage(arrow, 300, 230 + optionID*20, null);
    }

    @Override
    public void update(long arg0) {
        super.update(arg0);
    }

    @KeyAnnotation(action = "down")
    public void  down(){
        if(optionID < 4){
            optionID++;
        }
    }
    
    @KeyAnnotation(action = "up")
    public void up(){
        if(optionID > 0){
            optionID--;
        }
    }
    
    @KeyAnnotation(action = "enter")
    public void nextGameObject(){
        if(optionID == 4){
            finish();
            return;
        }
        engine.nextGameID = map.get(optionID);
        engine.setPreivousGameID(map.get(optionID));
        finish();
    }
    

}
