
public class LineSegment {
	
	private Point startingPoint;
	private Point endingPoint;
	private double a,b,c;
	
	public LineSegment (Point stPoint, Point edPoint) {
		
		startingPoint = stPoint;
		endingPoint = edPoint;
		
		double slope = (startingPoint.y - endingPoint.y) / (startingPoint.x - endingPoint.x);
		// b = y-mx
		double y_intercept = startingPoint.y - slope * startingPoint.x;
		a = -1 * slope;
		c = -1 * y_intercept;
		
		if (Math.abs(startingPoint.x - endingPoint.x) < 0.000000001){
			//in the case vertical line 
			a = 1;
			b = 0;
			c = -1 * startingPoint.x;
			
		} else {
			
			b = 1;
			
		}
		
		
	}
	
	
	public String toString() {
		
		
		return "A = " + a + "; " + "B = " + b + "; " + "C = " + c;
	}
	
	
	public double distanceToLine (Point pt) {
		
		return Math.abs(a * pt.x + b * pt.y + c) / Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		
	}
	
	public boolean projectionOnSegment (Point testPoint){
		
		double slope;
		
		if (a == 0) {
			
			slope = 0;
			
		} else {
			
			//Opposite and reciprical
			slope = (a / Math.pow(a, 2));
			
		}
		double y_intercept = testPoint.y - slope * testPoint.x;

		double ap = -1 * slope;
		double bp;
		
		if (slope == 0) {
			
			bp = 0;
			
		} else {
			
			bp = 1;
		} 
		double cp = -1 * y_intercept;
		
		double someValue = ap * b - a * bp;
		double projX = (-1*cp * b + bp * c)/someValue;
		double projY = (-1 * c * ap + a * cp)/someValue;
		
		Point pointOfPro = new Point(projX,projY);
		
		double d1p = startingPoint.distanceBetweenPoints(pointOfPro);
		double d2p = endingPoint.distanceBetweenPoints(pointOfPro);
		double d12 = startingPoint.distanceBetweenPoints(endingPoint);
		

		if (d1p <= d12 && d2p <= d12){
			
			return true;
		} else {
			
			return false;
		}
	}
	
	
	public double distanceToSegment(Point tp){
		
		if (projectionOnSegment(tp) == true) {
			
			return distanceToLine(tp);
		
		} else {
			
			double fromStartingPoint = tp.distanceBetweenPoints(startingPoint);
			double fromEndingPoint = tp.distanceBetweenPoints(endingPoint);
			
			if (fromStartingPoint <= fromEndingPoint) {
				
				return fromStartingPoint;
			} else {
				
				return fromEndingPoint;
			}
			
		}
		
		
	}
	
	
}
