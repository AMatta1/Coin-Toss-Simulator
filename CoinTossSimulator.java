import java.util.Random;

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */


public class CoinTossSimulator {
   
   private int numberTrials;
   private int numTrials;
   private int twoHeads;
   private int twoTails;
   private int headTails;
   
   
   // An object 'generator' created for class Random
   private Random generator= new Random();  



   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      
      numberTrials=0;
      numTrials=0;
      twoHeads=0;
      twoTails=0;
      headTails=0;
      
   }


   
   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) { 
   
      
      /* 'For' loop to generate random numbers corresponding to 2 coin throws for a trial.
         Each call to nextInt() method generates an integer in range 0(inclusive) - 2 (exclusive)
         0 means Heads
         1 means Tails
      */
      
      for (int i=1; i<=numTrials;i++) {
         
         int n= generator.nextInt(2);
         int m= generator.nextInt(2);
         
         
         if ((n==m) && (n==0)) { 
            
            twoHeads = twoHeads+1;
         } 
            
         else if ((n==m) && (n==1)) {
            
            twoTails = twoTails+1;
         }
         
         else { 
            
            headTails = headTails +1;
         }   
         
       }
      
      numberTrials = numberTrials + numTrials;    // Adds trials to current simulation till a reset() call
 
   }

   

   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
      
      numTrials = numberTrials;
      
      return numTrials; 
   }


   
   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
      
      return twoHeads; 
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
   
      return twoTails; 
   }


   
   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
      
      return headTails; 
   }


   
   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      
      numberTrials=0;
      numTrials=0;
      twoHeads=0;
      twoTails=0;
      headTails=0;
      
   }

}


