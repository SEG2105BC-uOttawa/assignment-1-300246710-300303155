package design3;
import java.io.*;
public class PointCPTest {
	public static void main(String[] args) {
		PointCP3 pointCart;
		System.out.println("Cartesian-Polar Coordinates Conversion Program");

	    // Check if the user input coordinates from the command line
	    // If he did, create the PointCP object from these arguments.
	    // If he did not, prompt the user for them.
			    try
			    {
			    pointCart = new PointCP3(Double.valueOf(args[0]).doubleValue(), 
			    Double.valueOf(args[1]).doubleValue());
			    }
			    catch(Exception e)
			    {
			      // If we arrive here, it is because either there were no
			      // command line arguments, or they were invalid
			      if(args.length != 0)
			        System.out.println("Invalid arguments on command line");
		
			      try
			      {
			        pointCart = getCartInput();
			      }
			      catch(IOException ex)
			      {
			        System.out.println("Error getting input. Ending program.");
			        return;
			      }
			    }
			    System.out.println("\nYou entered:\n" + pointCart.toStringCart());
			    System.out.println("\nAfter asking to store as Cartesian:\n" + pointCart.toStringCart());
			    System.out.println("\nAfter asking to store as Polar:\n" + pointCart.toStringPolar());
			  

		} 
		
	
		
		
	

	  /**
	   * This method obtains input from the user and verifies that
	   * it is valid.  When the input is valid, it returns a PointCP
	   * object.
	   *
	   * @return A PointCP constructed using information obtained 
	   *         from the user.
	   * @throws IOException If there is an error getting input from
	   *         the user.
	   */
		
		private static PointCP3 getCartInput() throws IOException
		{
		byte[] bufferX = new byte[1024];  //Buffer to hold byte input
		byte[] bufferY = new byte[1024];  //Buffer to hold byte input
		String inputX = "";  // Input information
		String inputY = "";  // Input information
	    
	    double a = 0.0;
	    double b = 0.0;
	    // Allow the user to enter the three different arguments
	    
	          
	        // Prompt the user
	        System.out.print("Enter the value of X using a decimal point(.): ");
	        
	        // Get the user's input      
	       
	        // Initialize the buffer before we read the input
	        for(int k=0; k<1024; k++)
	        	bufferX[k] = '\u0020';        
	             
	        System.in.read(bufferX);
	        inputX = new String(bufferX).trim();
	        
	        // Verify the user's input
	        
	        
	        a = Double.valueOf(inputX).doubleValue();
			  
	        
			for(int k=0; k<1024; k++)
				bufferY[k] = '\u0020';  
			try{  
				System.out.print("Enter the value of Y using a decimal point(.): ");         
				System.in.read(bufferY);
				inputY = new String(bufferY).trim();
				b = Double.valueOf(inputY).doubleValue();
			}
			catch(IOException e){
				System.out.println("Please enter a valid unit");
			}

	      
	      //Reset flag so while loop will prompt for other arguments
	    
	    
	    //Return a new PointCP object
	    return (new PointCP3(a, b));
	  	}
	}