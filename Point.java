
public class Point {
	public double x;
	public double y;
	
	public Point(double xCoor, double yCoor) {
		
		x = xCoor;
		y = yCoor;
		
	}
	
	
	
	public double distanceBetweenPoints(Point anotherPt) {
		
		return Math.sqrt(Math.pow(x-anotherPt.x, 2) + Math.pow(y-anotherPt.y, 2));
		
	}	
	
	public String toString() {
		return "(" + x + ", " + y + ")";
		
		
	}
}
