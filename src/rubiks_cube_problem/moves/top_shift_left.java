package rubiks_cube_problem.moves;

import rubiks_cube_problem.Rubiks_cube_Color;
import rubiks_cube_problem.Rubiks_cube_move;
import rubiks_cube_problem.Rubiks_cube_state;

/**
 *
 * @author Alexa
 */
public class top_shift_left extends Rubiks_cube_move {

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

        // get parent side 2 row 1 (ACopy)
        System.arraycopy(parentState.getCube().getSides()[1].getRow(1), 0, ACopy, 0, 3);
        // copy ACopy to child side 1 row 1
        childState.getCube().getSides()[0].replaceRow(1, ACopy);

        // get parent side 1 row 1 (ACopy)
        System.arraycopy(parentState.getCube().getSides()[0].getRow(1), 0, ACopy, 0, 3);
        // copy ACopy to child side 4 row 1
        childState.getCube().getSides()[3].replaceRow(1, ACopy);

        //get parent side 4 row 1 (ACopy
        System.arraycopy(parentState.getCube().getSides()[3].getRow(1), 0, ACopy, 0, 3);
        // copy ACopy to child side 3 row 1
        childState.getCube().getSides()[2].replaceRow(1, ACopy);

        //get parent side 3 row 1 (ACopy
        System.arraycopy(parentState.getCube().getSides()[2].getRow(1), 0, ACopy, 0, 3);
        // copy ACopy to child side 2 row 1
        childState.getCube().getSides()[1].replaceRow(1, ACopy);

        childState.getCube().retrieveASide(5).transpose(-1);

        return childState;
    }

    @Override
    public String getName() {
        return "top_shift_left";
    }

}
