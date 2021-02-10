package trafficlight;

/**
 * TODO description
 */
public class MyIntersection {

	int switchSize;
	int counter;
	
	public MyIntersection() {
		counter = 0;
		switchSize = 10;
	}

	
	public void advanceTime() {
		boolean isTransitioning = changeLightOnTransition();
		
		if(!isTransitioning) {
			counter++;
			if(counter == switchSize) {
				for (RoadState rs : statesCollection) {
					rs.step();
				}
				counter =0;
			}
		}
		original();
	}

}