package design3;

public class PointCP3 extends PointCP{
	private double x;
	private double y;
	
	PointCP3(double xOrRho, double yOrTheta){
		
		super(xOrRho, yOrTheta);
		this.x = xOrRho;
		this.y = yOrTheta;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getRho() {
		return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
	}
	
	public double getTheta() {
		return Math.toDegrees(Math.atan2(y, x));
	}
	
	public void convertStorageToPolar() {
		//double temp = getRho();
		y = getTheta();
		x = getRho();
	}
	
	public String toStringCart() {
		return "Stored as Cartesian (" + getX() + "," + getY() + ")";
	}
	public String toStringPolar() {
		return "Stored as Polar [" + getRho() + "," + getTheta() + "]\n";
	}
}
