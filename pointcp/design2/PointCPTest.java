package design2;
import java.io.*;
public class PointCPTest {
	public static void main(String[] args) {
		PointCP2 pointPolar;
		System.out.println("Cartesian-Polar Coordinates Conversion Program");

	    // Check if the user input coordinates from the command line
	    // If he did, create the PointCP object from these arguments.
	    // If he did not, prompt the user for them.
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
				}
			try
			{
			pointPolar = getPolarInput();
			}
			catch(IOException ex)
			{
			System.out.println("Error getting input. Ending program.");
			return;
			}
			    
		System.out.println("\nYou entered:\n" + pointPolar.toStringPolar());
		System.out.println("\nAfter asking to store as Cartesian:\n" + pointPolar.toStringCart());
		System.out.println("\nAfter asking to store as Polar:\n" + pointPolar.toStringPolar());
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
