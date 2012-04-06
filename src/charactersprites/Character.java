/**
 * @author Kuang Han
 */

package charactersprites;

import voogaobject.GameElement;

import com.golden.gamedev.Game;


@SuppressWarnings("serial")
public abstract class Character extends GameElement{
    public Character(Game game) {
        super(game);
    }
    
    public Character() {
        super();
    }
}
