package rubiks_cube_problem;

/**
 *
 * @author Alexa
 */
public abstract class Rubiks_cube_move extends Move {

    /**
     *
     * @param parentState
     * @return
     */
    public abstract Rubiks_cube_state action(Rubiks_cube_state parentState);
      
    /**
     * 
     * @param copy 
     * @return  
     */
    protected Rubiks_cube_Color[] reverseArray(Rubiks_cube_Color[] copy){
        // When columns are copied onto rows, they need to be reversed first
        /*Rubiks_cube_Color temp = copy[2];
        copy[2] = copy[1];
        copy[1] = copy[0];
        copy[0] = temp;*/
        Rubiks_cube_Color[] tempCopy = new Rubiks_cube_Color[3];
        System.arraycopy(copy, 0, tempCopy, 0, 3);
        
        int j = 0;
        for (int i = copy.length; i > 0; i--){
            copy[j] = tempCopy[i - 1];
            j++;
        }
        
        return copy;
    }
    
}
