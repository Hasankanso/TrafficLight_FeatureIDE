package trafficlight;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap; 

/**
 * This is the interface of the intersection your traffic light manages.
 * 
 * You have to provide your implementation in a subclass implementing this
 * abstract class. Do not edit this interface besides implementing the factory
 * function!
 */
public class MyIntersection extends Intersection {

	LinkedHashMap<Road, RoadState> states;
	Collection<RoadState> statesCollection;
	
	public MyIntersection() {
		states = new LinkedHashMap<Road, RoadState>();
		statesCollection = states.values();
	}

	/**
	 * Enqueue a vehicle on the given road.
	 * 
	 * @param road the road where the vehicle gets enqueued.
	 */
	public void enqueueVehicle(Road road) {
		assert (road != null);
		assert (!road.equals(Road.NONE));
		addCar(road);
	}

	/**
	 * Advances the time of the simulation by one step.
	 */

	private void addCar(Road road) {
		states.get(road).addCar();
	}


	public void advanceTime() {

		for (RoadState rs : statesCollection) {
				rs.tryRemoveCar();
		}
	}
	
	private boolean changeLightOnTransition() {
		boolean oneTransition = false;
		for (RoadState rs : statesCollection) {
			if (rs.isTransition()) {
				rs.step();
				oneTransition = true;
			}
		}
		return oneTransition;
	}
	
	/**
	 * Get the state of the traffic lights as a string.
	 * 
	 * The String is built as follows depending on the active features: - for each
	 * active direction, there is a substring: * a single uppercase letter for the
	 * road (L, R, B, T) * a uppercase V (for vehicles) * a single lowercase letter
	 * for the traffic light color (r, o, g) * the number of queued vehicles on this
	 * road * ONLY IF PEDESTRIANS ARE ACTIVE: a uppercase P (for pedestrians)
	 * followed by the number of queued pedestrians on this road - the substrings
	 * for the roads must occur in the following order: Left, Right, Bottom, Top -
	 * roads that are not included in the current configuration are left out - the
	 * remaining substrings are separated by a single space
	 * 
	 * For example, given the configuration {TL, Base, Left, Right, Top,
	 * Pedestrians, Timed} the initial state of the intersection is "LVg0Pr0 RVg0Pr0
	 * TVr0Pg0".
	 * 
	 * @return
	 */
	public String getIntersectionState() {
		String state = "";
		Iterator<RoadState> iter = states.values().iterator();
		
		if(iter.hasNext()) {
			state += iter.next().toString();
		}
		while(iter.hasNext()){
			state += " " + iter.next().toString();
		}

		return state;
	}
}