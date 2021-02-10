package trafficlight;

/**
 * TODO description
 */
public class MyIntersection extends Intersection{
	
	public MyIntersection() {		
		states.put(Road.TOP, new RoadState(Road.TOP));
	}

}