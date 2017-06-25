package rubiks_cube_problem.moves;

import rubiks_cube_problem.Rubiks_cube_Color;
import rubiks_cube_problem.Rubiks_cube_move;
import rubiks_cube_problem.Rubiks_cube_state;

/**
 *
 * @author Alexa
 */
public class right_shift_up extends Rubiks_cube_move {

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

        // get parent side 6 col 3 (ACopy)
        System.arraycopy(parentState.getCube().getSides()[5].getColumn(3), 0, ACopy, 0, 3);
        // copy ACopy to child side 1 col 3
        childState.getCube().getSides()[0].replaceColumn(3, ACopy);

        // get parent side 1 col 3 (ACopy)
        System.arraycopy(parentState.getCube().getSides()[0].getColumn(3), 0, ACopy, 0, 3);
        // copy ACopy to child side 5 col 3
        childState.getCube().getSides()[4].replaceColumn(3, ACopy);

        //get parent side 5 col 3 (ACopy
        System.arraycopy(parentState.getCube().getSides()[4].getColumn(3), 0, ACopy, 0, 3);
        // copy ACopy to child side 3 col 1
        ACopy = this.reverseArray(ACopy);
        childState.getCube().getSides()[2].replaceColumn(1, ACopy);

        //get parent side 3 col 1 (ACopy
        System.arraycopy(parentState.getCube().getSides()[2].getColumn(1), 0, ACopy, 0, 3);
        // copy ACopy to child side 6 col 3
        ACopy = this.reverseArray(ACopy);
        childState.getCube().getSides()[5].replaceColumn(3, ACopy);

        childState.getCube().retrieveASide(2).transpose(-1);

        return childState;
    }

    @Override
    public String getName() {
        return "right_shift_up";
    }

}
