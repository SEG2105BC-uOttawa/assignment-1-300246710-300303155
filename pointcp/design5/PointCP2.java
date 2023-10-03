package design5;

public class PointCP2 extends PointCP{
	
	private double rho;
	private double theta;
	
	PointCP2(double xOrRho, double yOrTheta){
		
		super(xOrRho, yOrTheta);
		this.rho = xOrRho;
		this.theta = yOrTheta;
	}

	public double getRho() {
		return rho;//(Math.cos(Math.toRadians(theta)) * rho);
	}
	
	public double getTheta() {
		return theta;//(Math.sin(Math.toRadians(theta)) * rho);
	}
	
	public double getX() {
		return (Math.cos(Math.toRadians(theta)) * rho);
	}
	
	public double getY() {
		return (Math.sin(Math.toRadians(theta)) * rho);
	}
	
	public void convertStorageToCartesian(){
		//double temp = getX();
		theta = getY();
		rho = getX();
		
	}
	public String toStringCart() {
		return "Stored as Cartesian (" + getX() + "," + getY() + ")";
	}
	public String toStringPolar() {
		return "Stored as Polar [" + getRho() + "," + getTheta() + "]\n";
	}
}
