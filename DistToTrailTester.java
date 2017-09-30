	import java.io.*; //necessary for File and IOException
	import java.util.*; //necessary for Scanner

	public class DistToTrailTester {
		public static void main( String args[] ) throws IOException {
			File fl = new File("TrailData.in");  // KEEP THE DOUBLE QUOTES!
			Scanner sf = new Scanner(fl);

			
			Point pts[] = new Point[12];
			TestPoint testPts[] = new TestPoint [4];
			
			int ptCount = 0;
			int testPtsCount = 0;
			
			while(sf.hasNextLine( ) ) {
				String line = sf.nextLine( );
				// Remove whatever you need to so that you can scan the line
				line = line.replace("(", "");
				line = line.replace(")", "" );
				line = line.replace(",", " " );
				//System.out.println(line);

				Scanner rd = new Scanner(line);
				//Scan the data in the line
				double x = rd.nextDouble();
				double y = rd.nextDouble();
				pts[ptCount] = new Point(x,y);
				ptCount++;
				rd.close();
				// Do what you need to do with the data.
				
			} 
			
			fl = new File ("TestData.in");
			sf.close();
			sf = new Scanner (fl);
			
			while (sf.hasNextLine()) {
				String line = sf.nextLine( );
				line = line.replace("(", "");
				line = line.replace(")", "" );
				line = line.replace(",", " " );				
				Scanner rd = new Scanner(line);
				
				String pointLabel =  rd.next();
				double x = rd.nextDouble();
				double y = rd.nextDouble();
				
				testPts[testPtsCount] = new TestPoint (pointLabel,x,y);
				testPtsCount ++;
				
				rd.close();
			}
			
			//for (int k = 0; k < pts.length-1; k++) {
				//System.out.println ("The distance between " + pts[k] + " and " +
				//pts[k+1] + " is " + pts[k].distanceBetweenPoints(pts[k+1]));
				//}
			
			//for (int k = 0; k < testPts.length; k++) {
				//System.out.println (testPts[k]);
				//}
			/*for (int k = 0; k < pts.length - 1; k++) {
				LineSegment ls = new LineSegment(pts[k], pts[k+1]);
				System.out.println(ls);
				}
			for (int k = 0; k < pts.length - 1; k++) {
				LineSegment ls = new LineSegment(pts[k], pts[k+1]);
				System.out.println(testPts[k%4] + " : " + ls.distanceToLine(testPts[k%4].point));
				}*/
			
			/*for (int k = 0; k < pts.length - 1; k++) {
				LineSegment ls = new LineSegment(pts[k], pts[k+1]);
				System.out.println(ls);
				}
			for (int k = 0; k < pts.length - 1; k++) {
				LineSegment ls = new LineSegment(pts[k], pts[k+1]);
				System.out.println(testPts[k%4] + " : " +
				ls.projectionOnSegment (testPts[k%4].point));
				}*/
			/*for (int k = 0; k < pts.length - 1; k++) {
				LineSegment ls = new LineSegment(pts[k], pts[k+1]);
				System.out.println(testPts[k%4] + " : " +
				ls.distanceToSegment(testPts[k%4].point));
				}*/
			
			
			for(TestPoint testPt: testPts){
				
				double shortestDistance = 9999999;
				
				for(int index = 0; index < pts.length -1 ; index ++){
					
					LineSegment ls = new LineSegment(pts[index], pts[index+1]);
					
					if (ls.distanceToSegment(testPt.point) <= shortestDistance){
						shortestDistance = ls.distanceToSegment(testPt.point);
					}
					
				}
				
				System.out.println("Test Point " + testPt.label + " distance to trail >>> " + shortestDistance );
				
			}
			
			
			
			sf.close( ); //We opened a file above, so close it when finished.
			
		}
	}

