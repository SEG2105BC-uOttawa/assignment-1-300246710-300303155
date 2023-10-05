package design2;

abstract class PointCP {
	private double xOrRho;
	private double yOrTheta;

	
	public PointCP(double xOrRho, double yOrTheta){
		this.xOrRho = xOrRho;
		this.yOrTheta = yOrTheta;
	}
	/**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
	public PointCP rotatePoint(double rotation){
		double radRotation = Math.toRadians(rotation);
		double X = getX();
		double Y = getY();
			
		return new PointCP('C',
		(Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
		(Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }

}
