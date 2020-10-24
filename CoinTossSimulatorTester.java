/**
 * class CoinTossSimulatorTester
 *
 * CoinTossSimulatorTester tests the CoinTossSimulator class independent of its usage in any 
 * other class or program.
 * 
 * It is a console-based, non-interactive and non- GUI unit test program to test the below
 * functionalities of class CoinTossSimulator :
 * 
 * 1) Multiple calls to the run() method to add more trials to current simulation result
 * 2) Calling the reset() method to reset the simulation back to its beginning state
 *
 *
 * How to call (commands) : Compile and run the program from Command Prompt. No GUI needed :
 *                          javac *.java
 *                          java CoinTossSimulatorTester
 *              
 */ 
  


public class CoinTossSimulatorTester {
   
   public static void main(String[] args) {
      
      
      // Creating boolean varaibles to hold true / false results of comparison
      boolean compResult, compResult1;
      
      System.out.println("After constructor:");
      
      // Creating a class instance
      CoinTossSimulator simulator = new CoinTossSimulator();  
      
      // Variable checks if the number of all outcomes add up to match the total number of trials 
      compResult = simulator.getTwoHeads() + simulator.getHeadTails() + simulator.getTwoTails() == simulator.getNumTrials();
   
      
      
      System.out.println("Number of trials [exp:0]: " + simulator.getNumTrials());
      System.out.println("Two-head tosses: " + simulator.getTwoHeads());
      System.out.println("Two-tail tosses: " + simulator.getTwoTails());
      System.out.println("One-head one-tail tosses: " + simulator.getHeadTails());
      System.out.println("Tosses add up correctly? " + compResult);
      System.out.println();
      
      
      //Testing by creating a new class instance 
      CoinTossSimulator simulator1 = new CoinTossSimulator();  
      
      System.out.println("After run(1):");
      
      simulator1.run(1);                                   
      
      compResult1 = simulator1.getTwoHeads() + simulator1.getHeadTails() + simulator1.getTwoTails() == simulator1.getNumTrials();
      
      
      System.out.println("Number of trials [exp:1]: " + simulator1.getNumTrials());
      System.out.println("Two-head tosses: " + simulator1.getTwoHeads());
      System.out.println("Two-tail tosses: " + simulator1.getTwoTails());
      System.out.println("One-head one-tail tosses: " + simulator1.getHeadTails());
      System.out.println("Tosses add up correctly? " + compResult1);
      System.out.println();
      
      
      System.out.println("After run(10):");
      
      simulator1.run(10);                                
                           
       
      // Expected value = 11 (1 added from previous run)
      System.out.println("Number of trials [exp:11]: " + simulator1.getNumTrials());
      System.out.println("Two-head tosses: " + simulator1.getTwoHeads());
      System.out.println("Two-tail tosses: " + simulator1.getTwoTails());
      System.out.println("One-head one-tail tosses: " + simulator1.getHeadTails());
      System.out.println("Tosses add up correctly? " + compResult1);
      System.out.println();
      
      
      System.out.println("After run(100):");
      
      simulator1.run(100);                            
      
      System.out.println("Number of trials [exp:111]: " + simulator1.getNumTrials());
      System.out.println("Two-head tosses: " + simulator1.getTwoHeads());
      System.out.println("Two-tail tosses: " + simulator1.getTwoTails());
      System.out.println("One-head one-tail tosses: " + simulator1.getHeadTails());
      System.out.println("Tosses add up correctly? " + compResult1);
      System.out.println(); 
      
      
      System.out.println("After reset:");
      
      simulator1.reset();   
      
       
      // Simulator reset to beginning state
      System.out.println("Number of trials [exp:0]: " + simulator1.getNumTrials());
      System.out.println("Two-head tosses: " + simulator1.getTwoHeads());
      System.out.println("Two-tail tosses: " + simulator1.getTwoTails());
      System.out.println("One-head one-tail tosses: " + simulator1.getHeadTails());
      System.out.println("Tosses add up correctly? " + compResult1);
      System.out.println(); 
      
      
      System.out.println("After run(1000):");
      
      simulator1.run(1000);   
      
      System.out.println("Number of trials [exp:1000]: " + simulator1.getNumTrials());
      System.out.println("Two-head tosses: " + simulator1.getTwoHeads());
      System.out.println("Two-tail tosses: " + simulator1.getTwoTails());
      System.out.println("One-head one-tail tosses: " + simulator1.getHeadTails());
      System.out.println("Tosses add up correctly? " + compResult1);
      System.out.println(); 
      
     
      System.out.println("After run(21):");
      
      simulator1.run(21);   
     
      System.out.println("Number of trials [exp:1021]: " + simulator1.getNumTrials());
      System.out.println("Two-head tosses: " + simulator1.getTwoHeads());
      System.out.println("Two-tail tosses: " + simulator1.getTwoTails());
      System.out.println("One-head one-tail tosses: " + simulator1.getHeadTails());
      System.out.println("Tosses add up correctly? " + compResult1);
      System.out.println(); 
      
   }
   
}

      