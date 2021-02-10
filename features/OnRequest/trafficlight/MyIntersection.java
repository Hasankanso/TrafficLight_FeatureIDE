package trafficlight;

import java.util.Collection;

/**
 * TODO description
 */
public class MyIntersection extends Intersection {

	int switchSize;
	int counter;
	boolean twentySecNoRequests;

	public MyIntersection() {
		counter = 0;
		switchSize = 10;
		twentySecNoRequests = false;
	}

	private void lightstoOpposite() {
		for (RoadState rs : statesCollection) {
			rs.step();
		}
	}


	public void advanceTime() {
		boolean isTransitioning = changeLightOnTransition();

		if (!isTransitioning) {

			if (twentySecNoRequests) {
				counter += 1;

				if (counter == switchSize) {
					lightstoOpposite();
				}

				else if (counter == 2 * switchSize) {
					counter = 0;
					twentySecNoRequests = false;
				}
			}

			if (!twentySecNoRequests) {
				for (RoadState rs : statesCollection) {
					if (rs.requestGreenLight()) {
						lightstoOpposite();
						twentySecNoRequests = true;
						break;
					}
				}
			}
		}
		original();
	}

}