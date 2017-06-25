package rubiks_cube_problem;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import rubiks_cube_problem.moves.back_shift_left;
import rubiks_cube_problem.moves.back_shift_right;
import rubiks_cube_problem.moves.bottom_shift_left;
import rubiks_cube_problem.moves.bottom_shift_right;
import rubiks_cube_problem.moves.front_shift_left;
import rubiks_cube_problem.moves.front_shift_right;
import rubiks_cube_problem.moves.left_shift_down;
import rubiks_cube_problem.moves.left_shift_up;
import rubiks_cube_problem.moves.right_shift_down;
import rubiks_cube_problem.moves.right_shift_up;
import rubiks_cube_problem.moves.top_shift_left;
import rubiks_cube_problem.moves.top_shift_right;

/**
 *
 * @author Alexa
 */
public class Rubiks_cube_state implements State {

    private Cube cube;
    private final Cube goalCube;
    private double fScore;
    private int depth;
    private double hScore;
    private Rubiks_cube_state parent;
    private Rubiks_cube_move originatingMove;
    private List<Rubiks_cube_state> children;
    private List<Rubiks_cube_move> moves;

    public Rubiks_cube_state() {
        this.cube = new Cube();
        this.goalCube = new Cube();
    }

    /**
     * Constructor for root state, test states, and clone states
     *
     * @param cube
     * @param goalCube
     */
    public Rubiks_cube_state(Cube cube, Cube goalCube) {

        this.moves = new LinkedList<Rubiks_cube_move>();
        this.children = new LinkedList<Rubiks_cube_state>();
        this.originatingMove = null;
        this.cube = cube;
        this.goalCube = goalCube;
        this.depth = 0;
        this.hScore = this.calculateHScore(goalCube);
        this.fScore = this.depth + this.hScore;
        this.parent = null;
        this.initializeMoves();
        //this.calculateChildren();

    }

    /**
     * Needed for when deep copies of a state must be made from a parent state
     * Note: Not sure if System.arraycopy is a shallow copy or deep copy.
     * Sources on stack overflow were adamant that it's shallow, but I tested it
     * out on a simple 1D array and it seemed to work as a deep copy just fine.
     *
     * @param parentState
     * @param originatingMove
     */
    public Rubiks_cube_state(Rubiks_cube_state parentState, Rubiks_cube_move originatingMove) {

        this.moves = new LinkedList<Rubiks_cube_move>();
        this.children = new LinkedList<Rubiks_cube_state>();
        this.originatingMove = originatingMove;
        this.parent = parentState;
        this.goalCube = parentState.goalCube;
        this.cube = new Cube();
        this.initializeMoves();

        // Deep copy the tiles of each side from parent cube to this cube
        Cube parentCube = parentState.getCube();
        Side[] parentSides = parentCube.getSides();
        for (int i = 0; i < parentSides.length; i++) { // for each side
            for (int j = 0; j < parentSides[i].tiles.length; j++) { // for each row in that side
                // copy the column values
                this.cube.getSides()[i].initRow(parentSides[i].tiles[j], j + 1);
            }
        }

        this.depth = parent.depth + 1;
        this.hScore = this.calculateHScore(goalCube);
        this.fScore = this.depth + this.hScore;
        //this.calculateChildren();
    }

    /**
     *
     * @param side
     * @param centerTile
     */
    public void initCube(int side, String centerTile) {

        // make a scanner for input
        Scanner sc = new Scanner(System.in);
        Rubiks_cube_Color[][] sideX = new Rubiks_cube_Color[3][3];
        Rubiks_cube_Color colors[] = Rubiks_cube_Color.values();

        // try with a regex
        System.out.println("Enter the " + centerTile + " side.");
        String input = sc.next();
        input = input.trim(); // strip preceding and succeeding white spaces

        //System.out.println("Input is: " + input);
        String[] tiles = input.split(",");

        int tile = 0;
        for (int row = 0; row < 3; row++) { // GET THE SIDE
            for (int col = 0; col < 3; col++) {
                int nextInt;
                nextInt = Integer.parseInt(tiles[tile]);
                sideX[row][col] = colors[nextInt - 1]; // REMEMBER TO COUNT FROM 0! 
                tile++;
                //TODO clean and validate input System.out.println(); }
            }
        }

        this.cube.initSide(side, sideX);

    }

    public void calculateFScore() {
        this.fScore = this.depth + this.hScore;
    }

    public Rubiks_cube_move getOriginatingMove() {
        return this.originatingMove;
    }

    public Rubiks_cube_state getParentState(){
        return this.parent;
    }
    public Cube getGoalCube() {
        return this.goalCube;
    }

    private void initializeMoves() {
        back_shift_left backLeft = new back_shift_left();
        this.moves.add(backLeft);

        back_shift_right backRight = new back_shift_right();
        this.moves.add(backRight);

        bottom_shift_left bottomLeft = new bottom_shift_left();
        this.moves.add(bottomLeft);

        bottom_shift_right bottomRight = new bottom_shift_right();
        this.moves.add(bottomRight);

        front_shift_left frontLeft = new front_shift_left();
        this.moves.add(frontLeft);

        front_shift_right frontRight = new front_shift_right();
        this.moves.add(frontRight);

        left_shift_down leftDown = new left_shift_down();
        this.moves.add(leftDown);

        left_shift_up leftUp = new left_shift_up();
        this.moves.add(leftUp);

        right_shift_down rightDown = new right_shift_down();
        this.moves.add(rightDown);

        right_shift_up rightUp = new right_shift_up();
        this.moves.add(rightUp);

        top_shift_left topLeft = new top_shift_left();
        this.moves.add(topLeft);

        top_shift_right topRight = new top_shift_right();
        this.moves.add(topRight);
    }

    public Cube getCube() {
        return this.cube;
    }

    public List<Rubiks_cube_state> getChildren() {
        return this.children;
    }

    public double getFScore() {
        return this.fScore;
    }

    public int getDepth() {
        return this.depth;
    }

    public double getHScore() {
        return this.hScore;
    }

    public void calculateChildren() {

        for (Rubiks_cube_move move : this.moves) {
            Rubiks_cube_state child = move.action(this);
            this.children.add(child);
            this.children.sort((Rubiks_cube_state s1, Rubiks_cube_state s2) -> {
                if (s1.getFScore() < s2.getFScore()) {
                    return -1;
                }
                if (s1.getFScore() > s2.getFScore()) {
                    return 1;
                }
                return 0;
            });
        }

    }

    public void setCube(Cube cube) {
        this.cube = cube;
    }

    public void setFScore(double fscore) {
        this.fScore = fscore;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setHScore(double hscore) {
        this.hScore = hscore;
    }

    public void display() {
        //display each side one by one
        for (Side side : this.getCube().getSides()) {
            //print an obscenely ugly string

            System.out.println("------------------------------");
            System.out.println("|  " + side.tiles[0][0] + "   |   " + side.tiles[0][1] + "   |   "
                    + side.tiles[0][2] + "   |");
            System.out.println("------------------------------");
            System.out.println("|  " + side.tiles[1][0] + "   |   " + side.tiles[1][1] + "   |   "
                    + side.tiles[1][2] + "   |");
            System.out.println("------------------------------");
            System.out.println("|  " + side.tiles[2][0] + "   |   " + side.tiles[2][1] + "   |   "
                    + side.tiles[2][2] + "   |");
            System.out.println("------------------------------");
            System.out.println("\n\n\n");

        }
    }

    /**
     *
     * @param goalCube
     * @return
     */
    private double calculateHScore(Cube goalCube) {
        // get the number of misplaced movable tiles in this cube
        int numMisplacedTiles = 0;
        for (int side = 1; side <= 6; side++) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (!this.cube.retrieveASide(side).getTiles()[row][col].equals(
                            goalCube.retrieveASide(side).getTiles()[row][col])) {
                        numMisplacedTiles++;
                    }
                }
            }
        }

        return numMisplacedTiles / 48; // on a 3x3x3 cube there are 48 movable tiles
    }
}
