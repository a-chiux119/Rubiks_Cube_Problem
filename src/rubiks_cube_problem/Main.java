
package rubiks_cube_problem;

/**
 *
 * @author Alexa
 */
public class Main {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rubiks_Cube_Problem thisProblem = new Rubiks_Cube_Problem();
        thisProblem.printInstructions();
        thisProblem.getStartStateFromUser();
        thisProblem.displayStartState();
        // solve the damn problem!
        thisProblem.solve();
        thisProblem.printSolution();
        
        
  
    }

}
