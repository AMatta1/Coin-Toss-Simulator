import javax.swing.JFrame;
import java.util.Scanner;

/**
 * class CoinSimViewer
 *
 * Displays the Coin Toss Simulation results in the form of three distinct bar  
 * graphs corresponding to the three outcomes on the screen. 
 * 
 * User input is required to trigger the simulator.
 *
*/

public class CoinSimViewer {
   
   private static int numTrials;
   
   
   /**
    *
    * Prompts the user to enter the number of trials for simulation. Keeps throwing an error 
    * message and asking for number of trials till a valid input (non- negative and non - 0) 
    * is provided.
    *
    * Creates a frame with relevant size, title and properties to display the
    * simulation results.
    *
    * Depends on class 'CoinSimComponent' only  
    *  
    *  How to run (commands) : Run below commands on Linux desktop terminal :
    *                          javac *.java
    *                          java CoinSimViewer
    * Then provide valid input and press enter. It displays the simulation.
    * 
    * @param args not used
    *
    */
  
   public static void main(String[] args) {
        
      JFrame frame= new JFrame();
      
      // Setting JFrame properties
      frame.setSize(800,500);
      frame.setTitle("CoinSim");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Prompt for user Input via keyboard
      System.out.print ("Enter number of trials: ");
      Scanner in = new Scanner (System.in);
      
      
      numTrials = in.nextInt();
      
      // Error checking for valid input
      while( numTrials <=0 ) {
         
         System.out.println ("ERROR: Number entered must be greater than 0.");
         System.out.print ("Enter number of trials: ");
         Scanner in2 = new Scanner (System.in);
         numTrials = in2.nextInt();
         
      }
      
      // Passing the number of trials (input) to CoinSimComponent's constructor
      CoinSimComponent component = new CoinSimComponent(numTrials);
      
      // Adding component to frame to display the bar graphs
      frame.add(component);
      
      frame.setVisible(true);
   }
}


