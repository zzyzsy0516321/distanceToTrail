
public class TestPoint {

	public String label;
	public Point point;
	
	public TestPoint(String pointLabel, double x, double y) {
		
		label = pointLabel;
		point = new Point(x,y);
		
	}
	
	public String toString() {
		
		return label + " " + "(" + point.x + ", " + point.y + ")";
		
	}
	
	
}
