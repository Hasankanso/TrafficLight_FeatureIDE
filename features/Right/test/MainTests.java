package test;

import java.util.List;

import trafficlight.Road;

/**
 * TODO description
 */
public class MainTests {

	private static final String RIGHT = "right";
	int vehiclesR = 0;
	String colorR = "g";
	String previousColorR = "g";
	
	CustomTest addVehicle(CustomTest test) {
		test.input += "vehicle right\n";
		vehiclesR++;
		return original(test);
	}

	void switchColor() {
		List<String> colors = switchColor(Road.RIGHT, colorR, previousColorR);
		colorR = colors.get(0);
		previousColorR = colors.get(1);
		original();
	}
	

	String createRoad() {
		if (colorR.equals("g")) {
			vehiclesR = Math.max(0, vehiclesR - 1);
		}
		return original() + "RV" + colorR + vehiclesR + " ";
	}

	private Road parseRoad(String roadString) {
		if (roadString.equals(RIGHT)) {
			return Road.RIGHT;
		}
		return original(roadString);
	}

}