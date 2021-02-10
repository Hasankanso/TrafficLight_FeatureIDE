package test;

import java.util.List;
import trafficlight.Road;

/**
 * TODO description
 */
public class MainTests {
	
	private static final String BOTTOM = "bottom";

	int vehiclesB = 0;
	String colorB = "r";
	String previousColorB = "r";
	
	CustomTest addVehicle(CustomTest test) {
		test.input += "vehicle bottom\n";
		vehiclesB++;
		return original(test);
	}
	
	void switchColor() {
		List<String> colors = switchColor(Road.BOTTOM, colorB, previousColorB);
		colorB = colors.get(0);
		previousColorB = colors.get(1);
		original();
	}
	
	
	String createRoad() {
		if(colorB.equals("g")) {
			vehiclesB = Math.max(0, vehiclesB - 1);
		}
		
		return  original() + "BV" + colorB + vehiclesB + " ";
	}
	
	String extendIntersection(String state) {
		String color = "g";
		String bottomRoad = "";
		String newState = "";
		boolean bottomRoadAdded =false;
		
		if (state.contains("LVg")) {
			color = "r";
		}
		bottomRoad += " BV" + color + "0";
		
		String[] roads = state.split(" ");
		for (int i = 0; i < roads.length; i++) {

			if (roads[i].startsWith("T")) {
				newState += bottomRoad + " " + roads[i];
				bottomRoadAdded = true;
			} else {
				newState += " " + roads[i];
			}
		}

		if (!bottomRoadAdded) {
			newState += bottomRoad;
		}

		return original(newState.trim());
	}

	private Road parseRoad(String roadString) {
		if (roadString.equals(BOTTOM)) {
			return Road.BOTTOM;
		}
		return original(roadString);
	}
}