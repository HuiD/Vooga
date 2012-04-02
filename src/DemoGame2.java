/**
 * @author Kuang Han
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import mario.Mario;
import mario.MarioCollision;
import mario.Water;


import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.background.ColorBackground;

import characterSprites.Brick;
import characterSprites.Player;

public class DemoGame2 extends Game{

    PlayField        playfield;  
    Background       background;

    @Override
    public void initResources() {
        playfield = new PlayField();

        background = new ColorBackground(Color.gray, 640, 480);
        playfield.setBackground(background);

        BufferedImage[] images = this.getImages("resources/Mario1.png", 1, 1);
        Player mario = new Mario(this);
        mario.setImages(images);
        mario.setLocation(25, 20);

        images = this.getImages("resources/Water.png", 1, 1);
        Brick water = new Water(this);
        water.setMovable(false);
        water.setPenetrable(true);
        water.setDensity(1);
        water.setDragCoefficient(.2);
        water.setImages(images); 
        water.setLocation(0, 240);

        images = this.getImages("resources/Bar.png", 1, 1);
        Brick floor = new Brick(this);
        floor.setMovable(false);
        floor.setImages(images);
        floor.setLocation(0, 440);
        
        Brick ceiling = new Brick(this);
        ceiling.setMovable(false);
        ceiling.setImages(images);
        ceiling.setLocation(70, -20);

        images = this.getImages("resources/Block1.png", 1, 1);
        Brick block1 = new Brick(this);
        block1.setMovable(false);
        block1.setImages(images);
        block1.setLocation(100, 200);

        images = this.getImages("resources/Block2.png", 1, 1);
        Brick block2 = new Brick(this);
        block2.setMovable(false);
        block2.setImages(images);
        block2.setLocation(160, 200);
        
        images = this.getImages("resources/SmallBar.png", 1, 1);
        Brick middleBar = new Brick(this);
        middleBar.setMovable(false);
        middleBar.setImages(images);
        middleBar.setLocation(260, 260);


        images = this.getImages("resources/Wall.png", 1, 1);
        Brick wall1 = new Brick(this);
        wall1.setMovable(false);
        wall1.setImages(images);
        wall1.setLocation(0, 0);
        
        Brick wall2 = new Brick(this);
        wall2.setMovable(false);
        wall2.setImages(images);
        wall2.setLocation(620, 0);

        SpriteGroup blocks = new SpriteGroup("block");
        blocks.add(water);
        blocks.add(floor);
        blocks.add(ceiling);
        blocks.add(block1);
        blocks.add(block2);
        blocks.add(middleBar);
        blocks.add(wall1);
        blocks.add(wall2);

        SpriteGroup characters = new SpriteGroup("characters");
        characters.add(mario);

        playfield.addGroup(blocks);
        playfield.addGroup(characters);

        MarioCollision collision = new MarioCollision();
        playfield.addCollisionGroup(characters, blocks, collision);
    }

    @Override
    public void render(Graphics2D g) {
        playfield.render(g);
    }

    @Override
    public void update(long t) {
        playfield.update(t);
    }

    public static void main(String[] args) {
        GameLoader game = new GameLoader();
        game.setup(new DemoGame2(), new Dimension(640,480), false);
        game.start();
    }


}