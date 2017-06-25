
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rubiks_cube_problem.Rubiks_cube_Color;
import rubiks_cube_problem.Rubiks_cube_state;
import rubiks_cube_problem.moves.back_shift_right;
import rubiks_cube_problem.moves.front_shift_left;
import rubiks_cube_problem.moves.front_shift_right;
import rubiks_cube_problem.moves.right_shift_down;
import rubiks_cube_problem.moves.right_shift_up;
import rubiks_cube_problem.moves.top_shift_left;
import rubiks_cube_problem.moves.top_shift_leftTest;
import rubiks_cube_problem.moves.top_shift_right;

/**
 *
 * @author Alexa
 */
public class MiscTests {

    public MiscTests() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testUnscrambled() {

        Rubiks_cube_state parentState = new Rubiks_cube_state();
        Rubiks_cube_Color[][] sideInput = new Rubiks_cube_Color[3][3];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sideInput[row][col] = Rubiks_cube_Color.WHITE;
            }
        }
        parentState.getCube().initSide(1, sideInput);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sideInput[row][col] = Rubiks_cube_Color.GREEN;
            }
        }
        parentState.getCube().initSide(2, sideInput);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sideInput[row][col] = Rubiks_cube_Color.YELLOW;
            }
        }
        parentState.getCube().initSide(3, sideInput);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sideInput[row][col] = Rubiks_cube_Color.BLUE;
            }
        }
        parentState.getCube().initSide(4, sideInput);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sideInput[row][col] = Rubiks_cube_Color.RED;
            }
        }
        parentState.getCube().initSide(5, sideInput);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sideInput[row][col] = Rubiks_cube_Color.ORANGE;
            }
        }
        parentState.getCube().initSide(6, sideInput);

        top_shift_left instance0 = new top_shift_left();
        right_shift_up instance1 = new right_shift_up();
        top_shift_right instance2 = new top_shift_right();
        right_shift_down instance3 = new right_shift_down();
        front_shift_left instance4 = new front_shift_left();
        front_shift_right instance5 = new front_shift_right();

        Rubiks_cube_state expResult = new Rubiks_cube_state();
        //Rubiks_cube_state result = instance1.action(parentState);
        System.out.println("start state: ");
        parentState.display();
        System.out.println("--------------------------------------------------");

        Rubiks_cube_state result = instance0.action(parentState);
        System.out.println("result after top shift left: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance1.action(result);
        System.out.println("result after right shift up: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance2.action(result);
        System.out.println("result after top shift right: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance3.action(result);
        System.out.println("result after riht shift down: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance2.action(result);
        System.out.println("result after top shift right: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance4.action(result);
        System.out.println("result after front shift left: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance0.action(result);
        System.out.println("result after top shift left: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance5.action(result);
        System.out.println("result after front shift right: ");
        result.display();
        System.out.println("--------------------------------------------------");

        sideInput[0][0] = Rubiks_cube_Color.RED;
        sideInput[0][1] = Rubiks_cube_Color.BLUE;
        sideInput[0][2] = Rubiks_cube_Color.WHITE;
        sideInput[1][0] = Rubiks_cube_Color.WHITE;
        sideInput[1][1] = Rubiks_cube_Color.WHITE;
        sideInput[1][2] = Rubiks_cube_Color.WHITE;
        sideInput[2][0] = Rubiks_cube_Color.WHITE;
        sideInput[2][1] = Rubiks_cube_Color.WHITE;
        sideInput[2][2] = Rubiks_cube_Color.WHITE;
        expResult.getCube().initSide(1, sideInput);

        /*
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sideInput[row][col] = Rubiks_cube_Color.GREEN;
            }
        }
         */
        sideInput[0][0] = Rubiks_cube_Color.GREEN;
        sideInput[0][1] = Rubiks_cube_Color.YELLOW;
        sideInput[0][2] = Rubiks_cube_Color.YELLOW;
        sideInput[1][0] = Rubiks_cube_Color.RED;
        sideInput[1][1] = Rubiks_cube_Color.GREEN;
        sideInput[1][2] = Rubiks_cube_Color.GREEN;
        sideInput[2][0] = Rubiks_cube_Color.GREEN;
        sideInput[2][1] = Rubiks_cube_Color.GREEN;
        sideInput[2][2] = Rubiks_cube_Color.GREEN;
        expResult.getCube().initSide(2, sideInput);

        sideInput[0][0] = Rubiks_cube_Color.BLUE;
        sideInput[0][1] = Rubiks_cube_Color.GREEN;
        sideInput[0][2] = Rubiks_cube_Color.RED;
        sideInput[1][0] = Rubiks_cube_Color.YELLOW;
        sideInput[1][1] = Rubiks_cube_Color.YELLOW;
        sideInput[1][2] = Rubiks_cube_Color.YELLOW;
        sideInput[2][0] = Rubiks_cube_Color.YELLOW;
        sideInput[2][1] = Rubiks_cube_Color.YELLOW;
        sideInput[2][2] = Rubiks_cube_Color.YELLOW;
        expResult.getCube().initSide(3, sideInput);

        /*
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sideInput[row][col] = Rubiks_cube_Color.BLUE;
            }
        }
         */
        sideInput[0][0] = Rubiks_cube_Color.BLUE;
        sideInput[0][1] = Rubiks_cube_Color.RED;
        sideInput[0][2] = Rubiks_cube_Color.YELLOW;
        sideInput[1][0] = Rubiks_cube_Color.BLUE;
        sideInput[1][1] = Rubiks_cube_Color.BLUE;
        sideInput[1][2] = Rubiks_cube_Color.BLUE;
        sideInput[2][0] = Rubiks_cube_Color.BLUE;
        sideInput[2][1] = Rubiks_cube_Color.BLUE;
        sideInput[2][2] = Rubiks_cube_Color.BLUE;
        expResult.getCube().initSide(4, sideInput);

        sideInput[0][0] = Rubiks_cube_Color.WHITE;
        sideInput[0][1] = Rubiks_cube_Color.WHITE;
        sideInput[0][2] = Rubiks_cube_Color.RED;
        sideInput[1][0] = Rubiks_cube_Color.GREEN;
        sideInput[1][1] = Rubiks_cube_Color.RED;
        sideInput[1][2] = Rubiks_cube_Color.RED;
        sideInput[2][0] = Rubiks_cube_Color.GREEN;
        sideInput[2][1] = Rubiks_cube_Color.RED;
        sideInput[2][2] = Rubiks_cube_Color.RED;
        expResult.getCube().initSide(5, sideInput);

        sideInput[0][0] = Rubiks_cube_Color.ORANGE;
        sideInput[0][1] = Rubiks_cube_Color.ORANGE;
        sideInput[0][2] = Rubiks_cube_Color.ORANGE;
        sideInput[1][0] = Rubiks_cube_Color.ORANGE;
        sideInput[1][1] = Rubiks_cube_Color.ORANGE;
        sideInput[1][2] = Rubiks_cube_Color.ORANGE;
        sideInput[2][0] = Rubiks_cube_Color.ORANGE;
        sideInput[2][1] = Rubiks_cube_Color.ORANGE;
        sideInput[2][2] = Rubiks_cube_Color.ORANGE;
        expResult.getCube().initSide(6, sideInput);

        result.display();
        expResult.display();

        for (int side = 1; side < 6; side++) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    assertEquals(expResult.getCube().retrieveASide(side).getTiles()[row][col],
                            result.getCube().retrieveASide(side).getTiles()[row][col]);
                }
            }
        }

// TODO add test methods here.
        // The methods must be annotated with annotation @Test. For example:
        //
        // @Test
        // public void hello() {}
    }

    @Test
    public void testScrambled() {

        Rubiks_cube_state parentState = new Rubiks_cube_state();
        Rubiks_cube_Color[][] sideInput = new Rubiks_cube_Color[3][3];

        sideInput[0][0] = Rubiks_cube_Color.BLUE;
        sideInput[0][1] = Rubiks_cube_Color.GREEN;
        sideInput[0][2] = Rubiks_cube_Color.WHITE;
        sideInput[1][0] = Rubiks_cube_Color.RED;
        sideInput[1][1] = Rubiks_cube_Color.WHITE;
        sideInput[1][2] = Rubiks_cube_Color.BLUE;
        sideInput[2][0] = Rubiks_cube_Color.GREEN;
        sideInput[2][1] = Rubiks_cube_Color.YELLOW;
        sideInput[2][2] = Rubiks_cube_Color.GREEN;
        parentState.getCube().initSide(1, sideInput);

        sideInput[0][0] = Rubiks_cube_Color.BLUE;
        sideInput[0][1] = Rubiks_cube_Color.RED;
        sideInput[0][2] = Rubiks_cube_Color.GREEN;
        sideInput[1][0] = Rubiks_cube_Color.ORANGE;
        sideInput[1][1] = Rubiks_cube_Color.GREEN;
        sideInput[1][2] = Rubiks_cube_Color.RED;
        sideInput[2][0] = Rubiks_cube_Color.WHITE;
        sideInput[2][1] = Rubiks_cube_Color.ORANGE;
        sideInput[2][2] = Rubiks_cube_Color.GREEN;
        parentState.getCube().initSide(2, sideInput);

        sideInput[0][0] = Rubiks_cube_Color.WHITE;
        sideInput[0][1] = Rubiks_cube_Color.RED;
        sideInput[0][2] = Rubiks_cube_Color.ORANGE;
        sideInput[1][0] = Rubiks_cube_Color.WHITE;
        sideInput[1][1] = Rubiks_cube_Color.YELLOW;
        sideInput[1][2] = Rubiks_cube_Color.WHITE;
        sideInput[2][0] = Rubiks_cube_Color.RED;
        sideInput[2][1] = Rubiks_cube_Color.BLUE;
        sideInput[2][2] = Rubiks_cube_Color.YELLOW;
        parentState.getCube().initSide(3, sideInput);

        sideInput[0][0] = Rubiks_cube_Color.BLUE;
        sideInput[0][1] = Rubiks_cube_Color.YELLOW;
        sideInput[0][2] = Rubiks_cube_Color.RED;
        sideInput[1][0] = Rubiks_cube_Color.GREEN;
        sideInput[1][1] = Rubiks_cube_Color.BLUE;
        sideInput[1][2] = Rubiks_cube_Color.YELLOW;
        sideInput[2][0] = Rubiks_cube_Color.RED;
        sideInput[2][1] = Rubiks_cube_Color.GREEN;
        sideInput[2][2] = Rubiks_cube_Color.ORANGE;
        parentState.getCube().initSide(4, sideInput);

        sideInput[0][0] = Rubiks_cube_Color.YELLOW;
        sideInput[0][1] = Rubiks_cube_Color.GREEN;
        sideInput[0][2] = Rubiks_cube_Color.ORANGE;
        sideInput[1][0] = Rubiks_cube_Color.ORANGE;
        sideInput[1][1] = Rubiks_cube_Color.RED;
        sideInput[1][2] = Rubiks_cube_Color.BLUE;
        sideInput[2][0] = Rubiks_cube_Color.WHITE;
        sideInput[2][1] = Rubiks_cube_Color.YELLOW;
        sideInput[2][2] = Rubiks_cube_Color.ORANGE;
        parentState.getCube().initSide(5, sideInput);

        sideInput[0][0] = Rubiks_cube_Color.YELLOW;
        sideInput[0][1] = Rubiks_cube_Color.BLUE;
        sideInput[0][2] = Rubiks_cube_Color.RED;
        sideInput[1][0] = Rubiks_cube_Color.ORANGE;
        sideInput[1][1] = Rubiks_cube_Color.ORANGE;
        sideInput[1][2] = Rubiks_cube_Color.WHITE;
        sideInput[2][0] = Rubiks_cube_Color.BLUE;
        sideInput[2][1] = Rubiks_cube_Color.WHITE;
        sideInput[2][2] = Rubiks_cube_Color.YELLOW;
        parentState.getCube().initSide(6, sideInput);

        top_shift_left instance0 = new top_shift_left();
        right_shift_up instance1 = new right_shift_up();
        top_shift_right instance2 = new top_shift_right();
        right_shift_down instance3 = new right_shift_down();
        front_shift_left instance4 = new front_shift_left();
        front_shift_right instance5 = new front_shift_right();

        Rubiks_cube_state expResult = new Rubiks_cube_state();
        //Rubiks_cube_state result = instance1.action(parentState);
        System.out.println("start state: ");
        parentState.display();
        System.out.println("--------------------------------------------------");

        Rubiks_cube_state result = instance0.action(parentState);
        System.out.println("result after top shift left: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance1.action(result);
        System.out.println("result after right shift up: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance2.action(result);
        System.out.println("result after top shift right: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance3.action(result);
        System.out.println("result after riht shift down: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance2.action(result);
        System.out.println("result after top shift right: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance4.action(result);
        System.out.println("result after front shift left: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance0.action(result);
        System.out.println("result after top shift left: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance5.action(result);
        System.out.println("result after front shift right: ");
        result.display();
        System.out.println("--------------------------------------------------");

        sideInput[0][0] = Rubiks_cube_Color.ORANGE;
        sideInput[0][1] = Rubiks_cube_Color.YELLOW;
        sideInput[0][2] = Rubiks_cube_Color.WHITE;
        sideInput[1][0] = Rubiks_cube_Color.RED;
        sideInput[1][1] = Rubiks_cube_Color.WHITE;
        sideInput[1][2] = Rubiks_cube_Color.GREEN;
        sideInput[2][0] = Rubiks_cube_Color.GREEN;
        sideInput[2][1] = Rubiks_cube_Color.YELLOW;
        sideInput[2][2] = Rubiks_cube_Color.GREEN;
        expResult.getCube().initSide(1, sideInput);

        /*
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sideInput[row][col] = Rubiks_cube_Color.GREEN;
            }
        }
         */
        sideInput[0][0] = Rubiks_cube_Color.BLUE;
        sideInput[0][1] = Rubiks_cube_Color.RED;
        sideInput[0][2] = Rubiks_cube_Color.ORANGE;
        sideInput[1][0] = Rubiks_cube_Color.YELLOW;
        sideInput[1][1] = Rubiks_cube_Color.GREEN;
        sideInput[1][2] = Rubiks_cube_Color.RED;
        sideInput[2][0] = Rubiks_cube_Color.WHITE;
        sideInput[2][1] = Rubiks_cube_Color.ORANGE;
        sideInput[2][2] = Rubiks_cube_Color.GREEN;
        expResult.getCube().initSide(2, sideInput);

        sideInput[0][0] = Rubiks_cube_Color.BLUE;
        sideInput[0][1] = Rubiks_cube_Color.ORANGE;
        sideInput[0][2] = Rubiks_cube_Color.WHITE;
        sideInput[1][0] = Rubiks_cube_Color.WHITE;
        sideInput[1][1] = Rubiks_cube_Color.YELLOW;
        sideInput[1][2] = Rubiks_cube_Color.WHITE;
        sideInput[2][0] = Rubiks_cube_Color.RED;
        sideInput[2][1] = Rubiks_cube_Color.BLUE;
        sideInput[2][2] = Rubiks_cube_Color.YELLOW;
        expResult.getCube().initSide(3, sideInput);

        /*
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sideInput[row][col] = Rubiks_cube_Color.BLUE;
            }
        }
         */
        sideInput[0][0] = Rubiks_cube_Color.RED;
        sideInput[0][1] = Rubiks_cube_Color.BLUE;
        sideInput[0][2] = Rubiks_cube_Color.WHITE;
        sideInput[1][0] = Rubiks_cube_Color.GREEN;
        sideInput[1][1] = Rubiks_cube_Color.BLUE;
        sideInput[1][2] = Rubiks_cube_Color.YELLOW;
        sideInput[2][0] = Rubiks_cube_Color.RED;
        sideInput[2][1] = Rubiks_cube_Color.GREEN;
        sideInput[2][2] = Rubiks_cube_Color.ORANGE;
        expResult.getCube().initSide(4, sideInput);

        sideInput[0][0] = Rubiks_cube_Color.BLUE;
        sideInput[0][1] = Rubiks_cube_Color.BLUE;
        sideInput[0][2] = Rubiks_cube_Color.YELLOW;
        sideInput[1][0] = Rubiks_cube_Color.RED;
        sideInput[1][1] = Rubiks_cube_Color.RED;
        sideInput[1][2] = Rubiks_cube_Color.GREEN;
        sideInput[2][0] = Rubiks_cube_Color.GREEN;
        sideInput[2][1] = Rubiks_cube_Color.ORANGE;
        sideInput[2][2] = Rubiks_cube_Color.ORANGE;
        expResult.getCube().initSide(5, sideInput);

        sideInput[0][0] = Rubiks_cube_Color.YELLOW;
        sideInput[0][1] = Rubiks_cube_Color.BLUE;
        sideInput[0][2] = Rubiks_cube_Color.RED;
        sideInput[1][0] = Rubiks_cube_Color.ORANGE;
        sideInput[1][1] = Rubiks_cube_Color.ORANGE;
        sideInput[1][2] = Rubiks_cube_Color.WHITE;
        sideInput[2][0] = Rubiks_cube_Color.BLUE;
        sideInput[2][1] = Rubiks_cube_Color.WHITE;
        sideInput[2][2] = Rubiks_cube_Color.YELLOW;
        expResult.getCube().initSide(6, sideInput);

        result.display();
        expResult.display();

        for (int side = 1; side < 6; side++) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    assertEquals(expResult.getCube().retrieveASide(side).getTiles()[row][col],
                            result.getCube().retrieveASide(side).getTiles()[row][col]);
                }
            }
        }
        

// TODO add test methods here.
        // The methods must be annotated with annotation @Test. For example:
        //
        // @Test
        // public void hello() {}
    }
    
    @Test
    public void testYCross() {

        Rubiks_cube_state parentState = new Rubiks_cube_state();
        Rubiks_cube_Color[][] sideInput = new Rubiks_cube_Color[3][3];

        sideInput[0][0] = Rubiks_cube_Color.ORANGE;
        sideInput[0][1] = Rubiks_cube_Color.YELLOW;
        sideInput[0][2] = Rubiks_cube_Color.WHITE;
        sideInput[1][0] = Rubiks_cube_Color.RED;
        sideInput[1][1] = Rubiks_cube_Color.WHITE;
        sideInput[1][2] = Rubiks_cube_Color.GREEN;
        sideInput[2][0] = Rubiks_cube_Color.GREEN;
        sideInput[2][1] = Rubiks_cube_Color.YELLOW;
        sideInput[2][2] = Rubiks_cube_Color.GREEN;
        parentState.getCube().initSide(1, sideInput);

        /*
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sideInput[row][col] = Rubiks_cube_Color.GREEN;
            }
        }
         */
        sideInput[0][0] = Rubiks_cube_Color.BLUE;
        sideInput[0][1] = Rubiks_cube_Color.RED;
        sideInput[0][2] = Rubiks_cube_Color.ORANGE;
        sideInput[1][0] = Rubiks_cube_Color.YELLOW;
        sideInput[1][1] = Rubiks_cube_Color.GREEN;
        sideInput[1][2] = Rubiks_cube_Color.RED;
        sideInput[2][0] = Rubiks_cube_Color.WHITE;
        sideInput[2][1] = Rubiks_cube_Color.ORANGE;
        sideInput[2][2] = Rubiks_cube_Color.GREEN;
        parentState.getCube().initSide(2, sideInput);

        sideInput[0][0] = Rubiks_cube_Color.BLUE;
        sideInput[0][1] = Rubiks_cube_Color.ORANGE;
        sideInput[0][2] = Rubiks_cube_Color.WHITE;
        sideInput[1][0] = Rubiks_cube_Color.WHITE;
        sideInput[1][1] = Rubiks_cube_Color.YELLOW;
        sideInput[1][2] = Rubiks_cube_Color.WHITE;
        sideInput[2][0] = Rubiks_cube_Color.RED;
        sideInput[2][1] = Rubiks_cube_Color.BLUE;
        sideInput[2][2] = Rubiks_cube_Color.YELLOW;
        parentState.getCube().initSide(3, sideInput);

        /*
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sideInput[row][col] = Rubiks_cube_Color.BLUE;
            }
        }
         */
        sideInput[0][0] = Rubiks_cube_Color.RED;
        sideInput[0][1] = Rubiks_cube_Color.BLUE;
        sideInput[0][2] = Rubiks_cube_Color.WHITE;
        sideInput[1][0] = Rubiks_cube_Color.GREEN;
        sideInput[1][1] = Rubiks_cube_Color.BLUE;
        sideInput[1][2] = Rubiks_cube_Color.YELLOW;
        sideInput[2][0] = Rubiks_cube_Color.RED;
        sideInput[2][1] = Rubiks_cube_Color.GREEN;
        sideInput[2][2] = Rubiks_cube_Color.ORANGE;
        parentState.getCube().initSide(4, sideInput);

        sideInput[0][0] = Rubiks_cube_Color.BLUE;
        sideInput[0][1] = Rubiks_cube_Color.BLUE;
        sideInput[0][2] = Rubiks_cube_Color.YELLOW;
        sideInput[1][0] = Rubiks_cube_Color.RED;
        sideInput[1][1] = Rubiks_cube_Color.RED;
        sideInput[1][2] = Rubiks_cube_Color.GREEN;
        sideInput[2][0] = Rubiks_cube_Color.GREEN;
        sideInput[2][1] = Rubiks_cube_Color.ORANGE;
        sideInput[2][2] = Rubiks_cube_Color.ORANGE;
        parentState.getCube().initSide(5, sideInput);

        sideInput[0][0] = Rubiks_cube_Color.YELLOW;
        sideInput[0][1] = Rubiks_cube_Color.BLUE;
        sideInput[0][2] = Rubiks_cube_Color.RED;
        sideInput[1][0] = Rubiks_cube_Color.ORANGE;
        sideInput[1][1] = Rubiks_cube_Color.ORANGE;
        sideInput[1][2] = Rubiks_cube_Color.WHITE;
        sideInput[2][0] = Rubiks_cube_Color.BLUE;
        sideInput[2][1] = Rubiks_cube_Color.WHITE;
        sideInput[2][2] = Rubiks_cube_Color.YELLOW;
        parentState.getCube().initSide(6, sideInput);

        top_shift_left instance0 = new top_shift_left();
        right_shift_up instance1 = new right_shift_up();
        top_shift_right instance2 = new top_shift_right();
        right_shift_down instance3 = new right_shift_down();
        front_shift_left instance4 = new front_shift_left();
        front_shift_right instance5 = new front_shift_right();

        Rubiks_cube_state expResult = new Rubiks_cube_state();
        //Rubiks_cube_state result = instance1.action(parentState);
        System.out.println("start state: ");
        parentState.display();
        System.out.println("--------------------------------------------------");

        Rubiks_cube_state result = instance1.action(parentState);
        System.out.println("result after right shift up: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance0.action(result);
        System.out.println("result after top shift left: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance3.action(result);
        System.out.println("result after right shift down: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance0.action(result);
        System.out.println("result after top shift left: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance1.action(result);
        System.out.println("result after right shift up: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance0.action(result);
        System.out.println("result after top shift left: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance0.action(result);
        System.out.println("result after top shift left: ");
        result.display();
        System.out.println("--------------------------------------------------");

        result = instance3.action(result);
        System.out.println("result after right shift down: ");
        result.display();
        System.out.println("--------------------------------------------------");
        
        result = instance0.action(result);
        System.out.println("result after top shift left: ");
        result.display();
        System.out.println("--------------------------------------------------");

        sideInput[0][0] = Rubiks_cube_Color.BLUE;
        sideInput[0][1] = Rubiks_cube_Color.BLUE;
        sideInput[0][2] = Rubiks_cube_Color.WHITE;
        sideInput[1][0] = Rubiks_cube_Color.RED;
        sideInput[1][1] = Rubiks_cube_Color.WHITE;
        sideInput[1][2] = Rubiks_cube_Color.GREEN;
        sideInput[2][0] = Rubiks_cube_Color.GREEN;
        sideInput[2][1] = Rubiks_cube_Color.YELLOW;
        sideInput[2][2] = Rubiks_cube_Color.GREEN;
        expResult.getCube().initSide(1, sideInput);

        /*
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sideInput[row][col] = Rubiks_cube_Color.GREEN;
            }
        }
         */
        sideInput[0][0] = Rubiks_cube_Color.ORANGE;
        sideInput[0][1] = Rubiks_cube_Color.RED;
        sideInput[0][2] = Rubiks_cube_Color.BLUE;
        sideInput[1][0] = Rubiks_cube_Color.YELLOW;
        sideInput[1][1] = Rubiks_cube_Color.GREEN;
        sideInput[1][2] = Rubiks_cube_Color.RED;
        sideInput[2][0] = Rubiks_cube_Color.WHITE;
        sideInput[2][1] = Rubiks_cube_Color.ORANGE;
        sideInput[2][2] = Rubiks_cube_Color.GREEN;
        expResult.getCube().initSide(2, sideInput);

        sideInput[0][0] = Rubiks_cube_Color.ORANGE;
        sideInput[0][1] = Rubiks_cube_Color.ORANGE;
        sideInput[0][2] = Rubiks_cube_Color.BLUE;
        sideInput[1][0] = Rubiks_cube_Color.WHITE;
        sideInput[1][1] = Rubiks_cube_Color.YELLOW;
        sideInput[1][2] = Rubiks_cube_Color.WHITE;
        sideInput[2][0] = Rubiks_cube_Color.RED;
        sideInput[2][1] = Rubiks_cube_Color.BLUE;
        sideInput[2][2] = Rubiks_cube_Color.YELLOW;
        expResult.getCube().initSide(3, sideInput);

        /*
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sideInput[row][col] = Rubiks_cube_Color.BLUE;
            }
        }
         */
        sideInput[0][0] = Rubiks_cube_Color.YELLOW;
        sideInput[0][1] = Rubiks_cube_Color.YELLOW;
        sideInput[0][2] = Rubiks_cube_Color.RED;
        sideInput[1][0] = Rubiks_cube_Color.GREEN;
        sideInput[1][1] = Rubiks_cube_Color.BLUE;
        sideInput[1][2] = Rubiks_cube_Color.YELLOW;
        sideInput[2][0] = Rubiks_cube_Color.RED;
        sideInput[2][1] = Rubiks_cube_Color.GREEN;
        sideInput[2][2] = Rubiks_cube_Color.ORANGE;
        expResult.getCube().initSide(4, sideInput);

        sideInput[0][0] = Rubiks_cube_Color.ORANGE;
        sideInput[0][1] = Rubiks_cube_Color.BLUE;
        sideInput[0][2] = Rubiks_cube_Color.WHITE;
        sideInput[1][0] = Rubiks_cube_Color.ORANGE;
        sideInput[1][1] = Rubiks_cube_Color.RED;
        sideInput[1][2] = Rubiks_cube_Color.GREEN;
        sideInput[2][0] = Rubiks_cube_Color.WHITE;
        sideInput[2][1] = Rubiks_cube_Color.RED;
        sideInput[2][2] = Rubiks_cube_Color.GREEN;
        expResult.getCube().initSide(5, sideInput);

        sideInput[0][0] = Rubiks_cube_Color.YELLOW;
        sideInput[0][1] = Rubiks_cube_Color.BLUE;
        sideInput[0][2] = Rubiks_cube_Color.RED;
        sideInput[1][0] = Rubiks_cube_Color.ORANGE;
        sideInput[1][1] = Rubiks_cube_Color.ORANGE;
        sideInput[1][2] = Rubiks_cube_Color.WHITE;
        sideInput[2][0] = Rubiks_cube_Color.BLUE;
        sideInput[2][1] = Rubiks_cube_Color.WHITE;
        sideInput[2][2] = Rubiks_cube_Color.YELLOW;
        expResult.getCube().initSide(6, sideInput);

        result.display();
        expResult.display();

        for (int side = 1; side < 6; side++) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    assertEquals(expResult.getCube().retrieveASide(side).getTiles()[row][col],
                            result.getCube().retrieveASide(side).getTiles()[row][col]);
                }
            }
        }
        

// TODO add test methods here.
        // The methods must be annotated with annotation @Test. For example:
        //
        // @Test
        // public void hello() {}
    }
    
}
