package test;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import trafficlight.Road;

/**
 * TODO description
 */
public class MainTests {

	LinkedHashMap<Road, Integer> orangeDelay;
	LinkedHashMap<Road, Integer> redDelay;
	
	int orangeDelayMax = 1;
	int redDelayMax = 2;

	int clockDelayMax = 4;
	int clockDelay = clockDelayMax;

	MainTests() {
		Road[] roadsOrange = Road.values();

		orangeDelay = new LinkedHashMap<Road, Integer>();
		redDelay = new LinkedHashMap<Road, Integer>();

		for (int i = 1; i < roadsOrange.length; i++) {
			orangeDelay.put(roadsOrange[i], orangeDelayMax);
			redDelay.put(roadsOrange[i], redDelayMax);
		}

	}

	void resetDelays(Road road) {
		redDelay.put(road, redDelayMax);
		orangeDelay.put(road, orangeDelayMax);
	}

	int resetClock() {
		if (clockDelay == 0) {
			clockDelay = clockDelayMax;
			return 0;
		}
		clockDelay -= 1;
		return 9;
	}

	List<String> switchColor(Road road, String color, String previousColor) {
		if (color.equals("g")) {
			previousColor = "g";
			color = "o";
			resetDelays(road);
		} else if (color.equals("r")) {
			if (redDelay.get(road) == 0) {
				previousColor = "r";
				color = "o";
				resetDelays(road);
			} else {
				redDelay.put(road, redDelay.get(road) - 1);
			}
		} else if (color.equals("o")) {
			if (orangeDelay.get(road) == 0) {
				resetDelays(road);
				if (previousColor.equals("r")) {
					color = "g";
				} else if (previousColor.equals("g")) {
					color = "r";
					redDelay.put(road, redDelayMax*2);
				}
			}
			orangeDelay.put(road, orangeDelay.get(road) - 1);
		}

		ArrayList<String> colors = new ArrayList<String>();
		colors.add(color);
		colors.add(previousColor);

		return colors;
	}
}