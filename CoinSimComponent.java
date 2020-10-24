import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;
import java.lang.Math;


/**
 * class CoinSimComponent
 *
 * This class extends class JComponent to run the simulation and constructs three
 * bar graphs representing the results of all three possible scenarios during 
 * coin toss trials.
 * 
 * Depends on  classes : CoinTossSimulator and Bar 
 *
 *
 */

public class CoinSimComponent extends JComponent {

   private int numberTrials ;
   private int tempTrial;
   private int tempHead;
   private int tempTail;
   private int tempHeadTail;
   
   
   
   /**
    * This constructor creates an object of class CoinTossSimulator and uses the 'trials'  
    * parameter to invoke the run () method of CoinTossSimulator class. 
    *
    * @ param trials : 'Number of trials' input provided by the user 
    *
   */
      
   public CoinSimComponent (int trials) {

      CoinTossSimulator CTSimulator = new CoinTossSimulator ();  
  
      numberTrials = trials;
  
      // Runs the simulation by invoking run() and passing parameter
      
      CTSimulator.run (numberTrials);    
      
      // Returned values are stored in private variables to make them accessible in the paintComponent() method.
  
      tempTrial = CTSimulator.getNumTrials();
      tempHead= CTSimulator.getTwoHeads();
      tempTail= CTSimulator.getTwoTails();
      tempHeadTail= CTSimulator.getHeadTails();
      
   }

   
   
   /**
    *
    * This method of class JComponent contains a sequence of instructions and calculations to draw 
    * the simulation bars.
    *
    * It is called automatically whenever component is shown for the first time, or when window is resized 
    *  or when it is shown again after it was hidden.
    *
    * @ param g the graphics context 
    *
    */
   
   public void paintComponent(Graphics g) {
 
      Graphics2D g2 = (Graphics2D) g;
    
      // Named Constants , specified as 'final' 
      
      final int BAR_WIDTH = 50;                                              
      final int BUFFER = 50;
      final Color TWO_HEAD_COLOR = Color.RED;
      final Color HEAD_TAIL_COLOR = Color.GREEN;
      final Color TWO_TAIL_COLOR = Color.BLUE;
      
      
      /*  Variable declarations to be used while bars creation . Denom means denominator for percentage calculation */
      
      int denom= tempHead + tempHeadTail + tempTail ;
      int baseLabel = getHeight()-BUFFER;
      
      double scale1,scale2,scale3;
      
      double headPercent = (double) (tempHead*100) / denom;
      double headTailPercent =(double) (tempHeadTail*100) / denom;
      double tailPercent = (double) (tempTail*100) / denom;
      
     
      
      
      // Labels to be displayed containing the respective outcome numbers and percentages
      
      String msg1 ="Two Heads: " + tempHead + " (" + Math.round(headPercent) + "%)";
      
      String msg2 ="A Head and a Tail: " + tempHeadTail + " (" + Math.round(headTailPercent) + "%)";
      
      String msg3 ="Two Tails: "+tempTail + " (" + Math.round(tailPercent) + "%)";
     
      
      /* Below is the check to handle 'Divide by 0' failure in case denominator becomes 0 while calculating 'scale' variables. 
         It was detected during simulation testing . Scale is a function of component height at a given time */
      
      if (tempHead == 0 ) {
         
         scale1 = 0.0;
      }

      else {
         
         scale1 = (double)(getHeight() - (2* BUFFER ))/tempTrial;
      }
      
      
      
      
      if (tempHeadTail == 0 ) {
         
         scale2 = 0.0;
      }
      
       else {
          
         scale2 = (double)(getHeight() - (2* BUFFER )) /tempTrial;
      }
      
      
      
      
       if (tempTail == 0 ) {
          
          scale3 = 0.0;
      }
       else {
          
          scale3 = (double)(getHeight() - (2* BUFFER )) /tempTrial;
      }
   
        
      // Three bar objects created by passing parameters based on above calculations
      
      Bar bar1 = new Bar (baseLabel , (int)(getWidth()/4)-(BAR_WIDTH/2) , BAR_WIDTH , tempHead , scale1 , TWO_HEAD_COLOR , msg1); 
      
      Bar bar2 = new Bar (baseLabel , (int)(getWidth()/2)-(BAR_WIDTH/2) , BAR_WIDTH , tempHeadTail , scale2 , HEAD_TAIL_COLOR , msg2); 
       
      Bar bar3 = new Bar (baseLabel , (int)((getWidth()*3)/4)-(BAR_WIDTH/2) , BAR_WIDTH , tempTail , scale3 , TWO_TAIL_COLOR , msg3); 
      
      
      
      bar1.draw(g2);
      bar2.draw(g2);
      bar3.draw(g2);
      
   }
   
}
   