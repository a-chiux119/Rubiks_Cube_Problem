package rubiks_cube_problem.moves;

import javafx.scene.paint.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rubiks_cube_problem.Rubiks_cube_state;
import rubiks_cube_problem.Rubiks_cube_Color;

/**
 *
 * @author Alexa
 */
public class back_shift_leftTest {

    public back_shift_leftTest() {
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

    /**
     * Test of action method, of class back_shift_left.
     */
    @Test
    public void testAction() {
        System.out.println("action");
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

        back_shift_left instance = new back_shift_left();

        Rubiks_cube_state expResult = new Rubiks_cube_state();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sideInput[row][col] = Rubiks_cube_Color.WHITE;
            }
        }
        expResult.getCube().initSide(1, sideInput);
        
        sideInput[0][0] = Rubiks_cube_Color.GREEN;
        sideInput[0][1] = Rubiks_cube_Color.GREEN;
        sideInput[0][2] = Rubiks_cube_Color.ORANGE;
        sideInput[1][0] = Rubiks_cube_Color.GREEN;
        sideInput[1][1] = Rubiks_cube_Color.GREEN;
        sideInput[1][2] = Rubiks_cube_Color.ORANGE;
        sideInput[2][0] = Rubiks_cube_Color.GREEN;
        sideInput[2][1] = Rubiks_cube_Color.GREEN;
        sideInput[2][2] = Rubiks_cube_Color.ORANGE;
        expResult.getCube().initSide(2, sideInput);
        
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sideInput[row][col] = Rubiks_cube_Color.YELLOW;
            }
        }
        expResult.getCube().initSide(3, sideInput);

       
        sideInput[0][0] = Rubiks_cube_Color.RED;
        sideInput[0][1] = Rubiks_cube_Color.BLUE;
        sideInput[0][2] = Rubiks_cube_Color.BLUE;
        sideInput[1][0] = Rubiks_cube_Color.RED;
        sideInput[1][1] = Rubiks_cube_Color.BLUE;
        sideInput[1][2] = Rubiks_cube_Color.BLUE;
        sideInput[2][0] = Rubiks_cube_Color.RED;
        sideInput[2][1] = Rubiks_cube_Color.BLUE;
        sideInput[2][2] = Rubiks_cube_Color.BLUE;
        expResult.getCube().initSide(4, sideInput);
        
       
        sideInput[0][0] = Rubiks_cube_Color.GREEN;
        sideInput[0][1] = Rubiks_cube_Color.GREEN;
        sideInput[0][2] = Rubiks_cube_Color.GREEN;
        sideInput[1][0] = Rubiks_cube_Color.RED;
        sideInput[1][1] = Rubiks_cube_Color.RED;
        sideInput[1][2] = Rubiks_cube_Color.RED;
        sideInput[2][0] = Rubiks_cube_Color.RED;
        sideInput[2][1] = Rubiks_cube_Color.RED;
        sideInput[2][2] = Rubiks_cube_Color.RED;
        expResult.getCube().initSide(5, sideInput);
        
       
        sideInput[0][0] = Rubiks_cube_Color.ORANGE;
        sideInput[0][1] = Rubiks_cube_Color.ORANGE;
        sideInput[0][2] = Rubiks_cube_Color.ORANGE;
        sideInput[1][0] = Rubiks_cube_Color.ORANGE;
        sideInput[1][1] = Rubiks_cube_Color.ORANGE;
        sideInput[1][2] = Rubiks_cube_Color.ORANGE;
        sideInput[2][0] = Rubiks_cube_Color.BLUE;
        sideInput[2][1] = Rubiks_cube_Color.BLUE;
        sideInput[2][2] = Rubiks_cube_Color.BLUE;
        expResult.getCube().initSide(6, sideInput);
        
        Rubiks_cube_state result = instance.action(parentState);
        System.out.println(expResult.getCube().retrieveASide(1).getTiles()[0][0]);
        System.out.println(result.getCube().retrieveASide(1).getTiles()[0][0]);
       result.display();
        //Assert.assertArrayEquals(sideInput, sideInput);
      //Assert.assertEquals(expResult, result);
   for(int side = 1; side < 6; side++){
       for (int row = 0; row < 3; row++){
           for(int col = 0; col < 3; col++){
               assertEquals(expResult.getCube().retrieveASide(side).getTiles()[row][col],
                       result.getCube().retrieveASide(side).getTiles()[row][col]);
           }
       }
   }
      //assertEquals(expResult.getCube(), result.getCube());
        //assertEquals(expResult.getCube().retrieveASide(1).getTiles()[0][0], 
          //      result.getCube().retrieveASide(1).getTiles()[0][0]);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

}
