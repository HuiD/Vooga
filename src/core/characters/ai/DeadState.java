package core.characters.ai;

import core.characters.Character;

/**
 * @author Eric Mercer (JacenLakiir)
 */
public class DeadState extends State
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 5454257366740705700L;

    public DeadState (Character character)
    {
        super(character);
    }
    
    @Override
    public boolean areConditionsMet ()
    {
        return true;
    }
    
    @Override
    public void execute (long milliSec)
    {
        myCharacter.deactivateAllOtherStates(this);
        myCharacter.setActive(false);
    }

}
