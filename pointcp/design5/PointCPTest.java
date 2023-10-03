package design5;
import java.io.*;
public class PointCPTest {
	public static void main(String[] args) {
		String coordType = null;
		PointCP3 pointCart;
		PointCP2 pointPolar;
		System.out.println("Cartesian-Polar Coordinates Conversion Program");

	    // Check if the user input coordinates from the command line
	    // If he did, create the PointCP object from these arguments.
	    // If he did not, prompt the user for them.
		byte typeCoord[] = new byte[1024];
		System.out.print("Enter the type of Coordinates you "
	            + "are inputting ((C)artesian / (P)olar): ");
		try {
			System.in.read(typeCoord);
			coordType = new String(typeCoord).trim().toUpperCase();
			if(coordType.equals("C")) {
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
			  } if(coordType.equals("P")) {
				
			    try
			    {
			      pointPolar = new PointCP2(Double.valueOf(args[0]).doubleValue(), 
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
					pointPolar = getPolarInput();
					}
					catch(IOException ex)
					{
					System.out.println("Error getting input. Ending program.");
					return;
					}
			    }
			    System.out.println("\nYou entered:\n" + pointPolar.toStringPolar());
				System.out.println("\nAfter asking to store as Cartesian:\n" + pointPolar.toStringCart());
				System.out.println("\nAfter asking to store as Polar:\n" + pointPolar.toStringPolar());
			  }

		} catch (IOException e) {
			// TODO Auto-generated catch block
			if (coordType != "C" || coordType != "P") {
			System.out.println("Please use a valid character");
			}
		}
		
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


		private static PointCP2 getPolarInput() throws IOException
		{
		byte[] bufferRho = new byte[1024];  //Buffer to hold byte input
		byte[] bufferTheta = new byte[1024];  //Buffer to hold byte input
		String inputRho = "";  // Input information
		String inputTheta = "";  // Input information
	    
	    double a = 0.0;
	    double b = 0.0;
	    // Allow the user to enter the three different arguments
	    
	          
	        // Prompt the user
	        System.out.print("Enter the value of Rho using a decimal point(.): ");
	        
	        // Get the user's input      
	       
	        // Initialize the buffer before we read the input
	        for(int k=0; k<1024; k++)
	        	bufferRho[k] = '\u0020';        
	             
	        System.in.read(bufferRho);
	        inputRho = new String(bufferRho).trim();
	        
	        // Verify the user's input
	        
	        
	        a = Double.valueOf(inputRho).doubleValue();
			  
	        
			for(int k=0; k<1024; k++)
				bufferTheta[k] = '\u0020';
			try{
				System.out.print("Enter the value of Theta using a decimal point(.): ");         
				System.in.read(bufferTheta);
				inputTheta = new String(bufferTheta).trim();
				b = Double.valueOf(inputTheta).doubleValue();
			}
			catch(IOException e){
				System.out.println("Please enter a valid unit");
			}

	      
	      //Reset flag so while loop will prompt for other arguments
	    
	    
	    //Return a new PointCP object
	    return (new PointCP2(a, b));
	  	}
}
