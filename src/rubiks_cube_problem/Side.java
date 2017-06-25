package rubiks_cube_problem;

/**
 *
 * @author Alexa
 */
public class Side {

    int sideNumber;
    Rubiks_cube_Color color; // This field indicates the central tile, which is constant
    Rubiks_cube_Color[][] tiles;

    /**
     * Unless otherwise specified, tiles is a 2D array of colors 3x3
     */
    public Side() {
        tiles = new Rubiks_cube_Color[3][3];
    }

    public Rubiks_cube_Color[][] getTiles() {
        return this.tiles;
    }

    /**
     *
     * @param copy
     * @return
     */
    protected Rubiks_cube_Color[] reverseArray(Rubiks_cube_Color[] copy) {
        // When columns are copied onto rows, they need to be reversed first
        /*Rubiks_cube_Color temp = copy[2];
        copy[2] = copy[1];
        copy[1] = copy[0];
        copy[0] = temp;*/
        Rubiks_cube_Color[] tempCopy = new Rubiks_cube_Color[3];
        System.arraycopy(copy, 0, tempCopy, 0, 3);

        int j = 0;
        for (int i = copy.length; i > 0; i--) {
            copy[j] = tempCopy[i - 1];
            j++;
        }

        return copy;
    }

    /**
     * This is a simple replacement. Setting the column on a side to the copy
     * array
     *
     * @param copy Color array to be copied onto the column
     * @param col column number to be updated
     */
    public void replaceColumn(int col, Rubiks_cube_Color[] copy) {
        for (int i = 0; i < 3; i++) {
            this.tiles[i][col - 1] = copy[i];
        }
    }

    /**
     * Use this to retrieve a column
     *
     * @param col the column number being retrieved
     * @return column, an array of Colors with this side's col values
     */
    public Rubiks_cube_Color[] getColumn(int col) {

        Rubiks_cube_Color[] column = new Rubiks_cube_Color[3];
        for (int row = 0; row < 3; row++) {
            column[row] = tiles[row][col - 1];
        }
        return column;
    }

    /**
     * This is a simple replacement.
     *
     * @param copy An array of Rubiks cube colors (a row)
     * @param row the row that will be changed
     */
    public void replaceRow(int row, Rubiks_cube_Color[] copy) {
        System.arraycopy(copy, 0, this.getRow(row), 0, 3);
    }

    /**
     * Use this method to retrieve a row
     *
     * @param row the row number being retrieved
     * @return
     */
    public Rubiks_cube_Color[] getRow(int row) {
        return this.tiles[row - 1];
    }

    public void initRow(Rubiks_cube_Color[] r, int rowNum) {
        System.arraycopy(r, 0, this.tiles[rowNum - 1], 0, 3);
    }

    /**
     * Transposes this side.
     *
     * @param sort indicates which way to transpose. Sort depends on which side
     * was moved and which direction. If sort == -1, transpose C1 --> R1. If
     * sort == 1 transpose C3 --> R1
     */
    public void transpose(int sort) {
        Rubiks_cube_Color[] colHolder = new Rubiks_cube_Color[3];
        Rubiks_cube_Color[] rowHolder = new Rubiks_cube_Color[3];

        Rubiks_cube_Color[] col1Copy = this.getColumn(1);
        Rubiks_cube_Color[] col2Copy = this.getColumn(2);
        Rubiks_cube_Color[] col3Copy = this.getColumn(3);

        if (sort < 0) { // c1 to r1

            // c1 -> r1
            col1Copy = this.reverseArray(col1Copy);
            System.arraycopy(col1Copy, 0, this.tiles[0], 0, 3);

            // c2 -> r2
            col2Copy = this.reverseArray(col2Copy);
            System.arraycopy(col2Copy, 0, this.tiles[1], 0, 3);

            // c3 -> r3
            col3Copy = this.reverseArray(col3Copy);
            System.arraycopy(col3Copy, 0, this.tiles[2], 0, 3);

        } else { // C3 to R1

            // c3 - > r1
            System.arraycopy(col3Copy, 0, this.tiles[0], 0, 3);

            // c2 -> r2
            System.arraycopy(col2Copy, 0, this.tiles[1], 0, 3);

            // c1 -> r3
            System.arraycopy(col1Copy, 0, this.tiles[2], 0, 3);
            /*
            System.arraycopy(this.getRow(1), 0, rowHolder, 0, 3); // copy R1 to rowHolder
            System.arraycopy(this.getColumn(3), 0, this.tiles[0], 0, 3); // move C3 to R1

            System.arraycopy(this.getColumn(1), 0, colHolder, 0, 3); // copy C1 to colHolder
            for (int row = 0; row < 3; row++) {
                this.tiles[row][0] = rowHolder[row]; // copy rowHolder(R1) into C1

            }

            System.arraycopy(this.getRow(3), 0, rowHolder, 0, 3); // copy R3 to rowHolder
            System.arraycopy(colHolder, 0, this.tiles[2], 0, 3); // copy colHolder(C1) to row 3

            for (int row = 0; row < 3; row++) {
                this.tiles[row][2] = rowHolder[row]; // move rowHolder(R3) into C3

            }

            System.arraycopy(this.getRow(2), 0, rowHolder, 0, 3); // copy R2 into rowHolder
            System.arraycopy(this.getColumn(2), 0, this.tiles[1], 0, 3); // move C2 into R2
            for (int row = 0; row < 3; row++) {
                this.tiles[row][1] = rowHolder[row]; // copy rowHolder(R2) into C2
            }
        }
             */
        }
    }
}
