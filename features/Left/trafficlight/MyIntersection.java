package trafficlight;

/**
 * TODO description
 */
public class MyIntersection extends Intersection {
	
	public MyIntersection() {
		states.put(Road.LEFT, new RoadState(Road.LEFT));
	}
	
}