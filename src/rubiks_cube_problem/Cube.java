package rubiks_cube_problem;

/**
 *
 * @author Alexa
 */
public class Cube {

    private Side[] sides; 

    /**
     * Initialize sides and central tiles, which are constants
     */
    public Cube() {
        sides = new Side[6];
        
        // initialize central tiles
        Rubiks_cube_Color[] colorValues = Rubiks_cube_Color.values();
        for(int i = 0; i < 6; i++){
            sides[i] = new Side();
            sides[i].tiles[1][1] = colorValues[0];
        }
    }

    /**
     * Returns all sides of the cube
     * @return 
     */
    public Side[] getSides() {
        return this.sides;
    }
    
    /**
     * Use this method to fetch a certain side of the cube
     * @param sideNum The number of the desired side
     * @return 
     */
    public Side retrieveASide(int sideNum){
        return this.sides[sideNum - 1];
    }

    /**
     * Use this method to set the tiles of a side
     * @param sideNum The side that is being updated
     * @param sideInput A 2D Color array of row/col of a side
     */
    public void initSide(int sideNum, Rubiks_cube_Color[][] sideInput) {
        for (int row = 0; row < 3; row++) {
            int length = sideInput[row].length;
            this.sides[sideNum - 1].tiles[row] = new Rubiks_cube_Color[length];
            System.arraycopy(sideInput[row], 0, sides[sideNum - 1].tiles[row], 0, length);
        }
    }

}
