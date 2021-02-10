package trafficlight;

import java.util.Collection;

/**
 * This is the interface of the intersection your traffic light manages.
 * 
 * You have to provide your implementation in a subclass implementing this
 * abstract class. Do not edit this interface besides implementing the factory
 * function!
 */
public class MyIntersection extends Intersection {

	/**
	 * Enqueue a pedestrian on the given road.
	 * 
	 * @param road the road where the pedestrian gets enqueued.
	 */
	public void enqueuePedestrian(Road road) {
		assert (road != null);
		assert (!road.equals(Road.NONE));
		
		states.get(road).addPedestrian();
	}

	public void advanceTime() {

		for (RoadState roadstate : statesCollection) {
			roadstate.tryRemovePedestrian();
		}
		original();
	}
	
}