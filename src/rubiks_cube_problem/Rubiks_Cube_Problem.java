package rubiks_cube_problem;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Alexa
 */
public class Rubiks_Cube_Problem implements Problem {

    /**
     *
     */
    public Rubiks_cube_state startState;

    /**
     *
     */
    public Rubiks_cube_state goalState;

    /**
     *
     */
    public Rubiks_cube_state currentState;

    private final Cube goalCube;

    private LinkedList<Rubiks_cube_state> solutionPath;

    public Rubiks_Cube_Problem() {
        //this.currentState = new Rubiks_cube_state();
        solutionPath = new LinkedList<Rubiks_cube_state>();
        this.goalCube = new Cube();

        this.goalState = null;
        // set goal state
        Rubiks_cube_Color[] colors = Rubiks_cube_Color.values();

        for (int i = 0; i < 6; i++) {
            Rubiks_cube_Color[][] sideX = new Rubiks_cube_Color[3][3];
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    sideX[row][col] = colors[i];
                }
            }
            this.goalCube.initSide(i + 1, sideX);
        }

        //this.startState = new Rubiks_cube_state(this.goalCube);
    }

    @Override
    public void printInstructions() {
        System.out.println("Welcome to the Rubik's Cube Problem!\n");
    }

    @Override
    public void getStartStateFromUser() {
        Cube startingCube = new Cube();
        Rubiks_cube_Color[][] side = new Rubiks_cube_Color[3][3];

        System.out.println("Enter in your cube. Each color has a corresponding"
                + " number: 1(White) 2(Green) 3(Yellow) 4(Blue) 5(Red) "
                + " 6(Orange).");

        // init white side 
        side = this.getSideFromUser("Start on the side that has the white\n"
                + "center tile. Make sure the \"Rubik's\" logo is facing rightside "
                + " up. For each side, start at the top left corner and enter in"
                + " each row going from left to right, top to bottom. Separate"
                + " color numbers by commas. Press \"Enter\" when you've entered"
                + " in all tiles on one side. Let's start with the WHITE side: ");
        startingCube.initSide(1, side);

        // get green side
        side = this.getSideFromUser("From the WHITE side, rotate the cube 90 degrees to "
                + " the left. The center tile should be GREEN.");
        startingCube.initSide(2, side);

        // get yellow side
        side = this.getSideFromUser("From the GREEN side, rotate the cube 90 degrees to "
                + " the left. The center tile should be YELLOW.");
        startingCube.initSide(3, side);

        // get blue side
        side = this.getSideFromUser("From the YELLOW side, rotate the cube 90 degrees to "
                + " the left. The center tile should be BLUE.");
        startingCube.initSide(4, side);

        // get red side 
        side = this.getSideFromUser("From the WHITE starting position, rotate the cube 90 degrees down "
                + " The center tile should be RED.");
        startingCube.initSide(5, side);

        // get orange side
        side = this.getSideFromUser("From the WHITE starting position, rotate the cube 90 degrees up. "
                + " The center tile should be ORANGE.");
        startingCube.initSide(6, side);

        this.startState = new Rubiks_cube_state(startingCube, goalCube);
        this.currentState = new Rubiks_cube_state(startState, null);
        this.currentState.setDepth(0);
    }

    public Rubiks_cube_Color[][] getSideFromUser(String instruction) {
        Scanner sc = new Scanner(System.in);
        Rubiks_cube_Color[][] sideX = new Rubiks_cube_Color[3][3];
        Rubiks_cube_Color colors[] = Rubiks_cube_Color.values();

        System.out.println(instruction);

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
        return sideX;
    }

    /**
     *
     */
    @Override
    public void displayStartState() {
        Cube startCube = this.startState.getCube();

        //display each side one by one
        for (Side side : startCube.getSides()) {
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
     */
    @Override
    public void solve() {
        // Start a list<rubikscubestates> fringe. init with startState. start with this and add all children to list
        Queue<Rubiks_cube_state> fringe
                = new PriorityQueue<Rubiks_cube_state>(10, new Comparator<Rubiks_cube_state>() {
                    @Override
                    public int compare(Rubiks_cube_state s1, Rubiks_cube_state s2) {
                        if (s1.getFScore() < s2.getFScore()) {
                            return -1;
                        }
                        if (s1.getFScore() > s2.getFScore()) {
                            return 1;
                        }
                        return 0;
                    }
                });
        boolean add = fringe.add(startState);

// do while soln not found and cutoff is not INF
        // set cutoff = f(startstate)
        boolean solnFound = false;
        double cutoff = startState.getFScore();
        do {
            // set c^t = DFS(startState, cutoff)
            double ct = depth_first_search(startState, cutoff, solnFound);

            // set c = ct and go back to step 2
            cutoff = ct;
        } while (cutoff > -1 && cutoff != Double.POSITIVE_INFINITY);

        this.solutionPath = this.constructSolutionPath();

    }

    private double depth_first_search(Rubiks_cube_state state, double c, boolean solnFound) {
        if (state.getFScore() > c) {
            return state.getFScore();
        }

        // visit state. If the cube is equal to goal cube, exit as soln
        // compare state's cube to goal cube
        boolean match = true;
        for (int side = 1; side <= 6; side++) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (!state.getCube().retrieveASide(side).getTiles()[row][col]
                            .equals(state.getGoalCube().retrieveASide(side).getTiles()[row][col])) {
                        match = false;
                    }
                }
            }
        }
        if (match) {
            // this state is the goal state!
            this.goalState = state;
            return -1;
        }

        double newCutoffs[] = new double[12];
        state.calculateChildren();
        LinkedList<Rubiks_cube_state> children = (LinkedList<Rubiks_cube_state>) state.getChildren();
        if (children.isEmpty()){
            return Double.POSITIVE_INFINITY;
        }
        for (int i = 0; i < newCutoffs.length; i++) {
            children.get(i).display();
            newCutoffs[i] = this.depth_first_search(children.get(i), c, solnFound);
        }

        return this.getMinValue(newCutoffs);
    }

    /**
     *
     * @return
     */
    private LinkedList<Rubiks_cube_state> constructSolutionPath() {
        LinkedList<Rubiks_cube_state> solutionPath = new LinkedList<Rubiks_cube_state>();
        if(goalState == null){
            return solutionPath;
        }
        solutionPath.add(goalState);
        Rubiks_cube_state temp = goalState;
        while (temp.getParentState() != null) {
            temp = solutionPath.peek().getParentState();
            solutionPath.push(temp);
        }
        return solutionPath;
    }

    /**
     *
     */
    public void printSolution() {
        if(solutionPath.isEmpty()){
            System.out.println("NO SOLUTION POSSIBLE");
        }
        else if (solutionPath.size() == 1) {
            System.out.println("NO ACTION NECESSARY. START STATE WAS GOAL STATE");
        } else {
            for (Rubiks_cube_state state : solutionPath) {
                if(state.getOriginatingMove() != null){      
                    System.out.println(state.getOriginatingMove().getName());
                }
            }
        }
    }

    /**
     *
     * @param array
     * @return
     */
    public double getMinValue(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public Rubiks_cube_state getStartState() {
        return this.startState;
    }

    public Rubiks_cube_state getCurrentState() {
        return this.currentState;
    }

    public Rubiks_cube_state getGoalState() {
        return this.goalState;
    }

    public void setStartState(Rubiks_cube_state start) {
        this.startState = start;
    }

    public void setCurrentState(Rubiks_cube_state current) {
        this.currentState = current;
    }

    public void setGoalState(Rubiks_cube_state goal) {
        this.goalState = goal;
    }

}
