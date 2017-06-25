
package rubiks_cube_problem.moves;

import rubiks_cube_problem.Rubiks_cube_Color;
import rubiks_cube_problem.Rubiks_cube_move;
import rubiks_cube_problem.Rubiks_cube_state;

/**
 *
 * @author Alexa
 */
public class back_shift_left extends Rubiks_cube_move{
    
    /**
     * action performs a 90 degree shift move on a given rubiks cube. It returns
     * the resulting childState.
     *
     * @param parentState the original state. This will not be changed.
     * @return childState the cube resulting from the action
     */
    @Override
    public Rubiks_cube_state action(Rubiks_cube_state parentState) {
        Rubiks_cube_state childState = new Rubiks_cube_state(parentState, this);

        Rubiks_cube_Color[] ACopy = new Rubiks_cube_Color[3];

        // get parent side 5 row 1 (ACopy)
        System.arraycopy(parentState.getCube().getSides()[4].getRow(1), 0, ACopy, 0, 3);
        // copy ACopy to child side 4 col 1
        ACopy = this.reverseArray(ACopy);
        childState.getCube().getSides()[3].replaceColumn(1, ACopy);

        // get parent side 4 col 1 (ACopy)
        System.arraycopy(parentState.getCube().getSides()[3].getColumn(1), 0, ACopy, 0, 3);
        ACopy = reverseArray(ACopy);
        // copy ACopy to child side 6 row 3
        childState.getCube().getSides()[5].replaceRow(3, ACopy);

        //get parent side 6 row 3 (ACopy
        System.arraycopy(parentState.getCube().getSides()[5].getRow(3), 0, ACopy, 0, 3);
        // copy ACopy to child side 2 col 3
        ACopy = this.reverseArray(ACopy);
        childState.getCube().getSides()[1].replaceColumn(3, ACopy);

        //get parent side 2 col 3 (ACopy
        System.arraycopy(parentState.getCube().getSides()[1].getColumn(3), 0, ACopy, 0, 3); 
        // copy ACopy to child side 5 row 1
        childState.getCube().getSides()[4].replaceRow(1, ACopy);
        
        // TODO transpose side 3. it flipped. :(
        childState.getCube().retrieveASide(3).transpose(-1);
        
        return childState;
    }

    @Override
    public String getName() {
       return "back_shift_left";
    }
}
