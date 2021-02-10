package test;

import java.util.List;

import trafficlight.Road;

/**
 * TODO description
 */
public class MainTests {

	private static final String LEFT = "left";

	int vehiclesL = 0;
	String colorL = "g";
	String previousColorL = "g";
	
	CustomTest addVehicle(CustomTest test) {
		test.input += "vehicle left\n";
		vehiclesL++;
		return original(test);
	}
	
	void switchColor() {
		List<String> colors = switchColor(Road.LEFT, colorL, previousColorL);
		colorL = colors.get(0);
		previousColorL = colors.get(1);
		original();
	}
	
	String createRoad() {
		if(colorL.equals("g")) {
			vehiclesL = Math.max(0, vehiclesL - 1);
		}
		
		return  original() + "LV" + colorL + vehiclesL + " ";
	}

	
	public Road parseRoad(String roadString) {
		if (roadString.equals(LEFT)) {
			return Road.LEFT;
		}
		return original(roadString);
	}
}