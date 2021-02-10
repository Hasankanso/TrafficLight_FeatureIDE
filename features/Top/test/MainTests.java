package test;

import java.util.List;
import trafficlight.Road;

/**
 * TODO description
 */
public class MainTests {

	private static final String TOP = "top";

	int vehiclesT = 0;
	String colorT = "r";
	String previousColorT = "r";

	CustomTest addVehicle(CustomTest test) {
		test.input += "vehicle top\n";
		vehiclesT++;
		return original(test);
	}

	void switchColor() {
		List<String> colors = switchColor(Road.TOP, colorT, previousColorT);
		colorT = colors.get(0);
		previousColorT = colors.get(1);
		original();
	}

	String createRoad() {
		if (colorT.equals("g")) {
			vehiclesT = Math.max(0, vehiclesT - 1);
		}
		return original() + "TV" + colorT + vehiclesT + " ";
	}

	String extendIntersection(String state) {
		String color = "g";
		if (state.contains("LVg")) {
			color = "r";
		}
		state += " TV" + color + "0";

		return original(state.trim());
	}

	private Road parseRoad(String roadString) {
		if (roadString.equals(TOP)) {
			return Road.TOP;
		}
		return original(roadString);
	}

}