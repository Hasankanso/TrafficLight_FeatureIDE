package test;

import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Random;
import java.util.Scanner;
import trafficlight.Road;

/**
 * TODO description
 */
public class MainTests {

	// hyper parameter for random 0 -> 5 (execlusve);

	final int MAX_PEDESTRIANS = 10;
	private static final String PEDESTRIAN = "pedestrian";
	LinkedHashMap<Road, Integer> pedestrians; // it does not know which roads are available

	MainTests() {
		pedestrians = new LinkedHashMap<Road, Integer>();
		Road[] roads = Road.values();

		for (int i = 1; i < roads.length; i++) {
			pedestrians.put(roads[i], 0);
		}
	}

	/*
	 * Handle input commands.
	 * 
	 * Additional commands: - pedestrian $road -> enqueue pedestrian on road
	 */
	private void handleInput(String input, Intersection intersection) {
		if (input.startsWith(PEDESTRIAN)) {
			Road road = parseRoad(input.substring(PEDESTRIAN.length()).trim());
			intersection.enqueuePedestrian(road);
			return;
		}
		original(input, intersection);
	}

	CustomTest extendRoads(CustomTest test) {
		Random ran = new Random();
		String input = test.input;
		String output = test.output;

		CustomTest newTest = new CustomTest("", "");

		Scanner inputScanner = new Scanner(input);
		Scanner outputScanner = new Scanner(output);
		try {
			while (inputScanner.hasNext()) {
				String inputLine = inputScanner.nextLine();
				int pedestriansCount = ran.nextInt(MAX_PEDESTRIANS); // add from 0 to 9 pedestrians for each road

				if (inputLine.equals(STATE)) {
				} else if (inputLine.equals(STEP)) {

					assertTrue(outputScanner.hasNext());
					String outputLine = outputScanner.nextLine();

					for (int i = 0; i < pedestriansCount; i++) { // add n pedestrians
						for (Road key : pedestrians.keySet()) { // add n pedestrians for each road
							Integer value = pedestrians.get(key); // get value
							value += 1;
							pedestrians.put(key, value); // increment value internally
							newTest.addInput("pedestrian " + key.toString().toLowerCase() + "\n"); // increment value in
																									// test
						}
						// int roadIndex = ran.nextInt(roads.length - 1) + 1;
					}

					updatePedestrians(outputLine);
					newTest.addInput(STEP + "\n");
					newTest.addInput(STATE + "\n");
					newTest.addOutput(extendPedestrians(outputLine) + "\n");
				} else {
					newTest.addInput(inputLine + "\n");
				}
			}
		} finally {
			inputScanner.close();
			outputScanner.close();
		}
		return newTest;
	}

	void updatePedestrians(String state) { // update internal state
		String[] roads = state.split(" ");
		Set<Road> keys = pedestrians.keySet();

		int i = 0;
		for (Road key : keys) {
			Integer pCount = pedestrians.get(key);
			if (roads[i].contains("r")) {
				pCount = Math.max(0, pCount - 1);
				pedestrians.put(key, pCount);
			}
			i++;
		}
	}

	String extendPedestrians(String state) { // update output test string

		String[] roads = state.split(" ");
		String newState = "";
		Set<Road> keys = pedestrians.keySet();

		int i = 0;
		for (Road key : keys) {
			Integer pCount = pedestrians.get(key);
			if (roads[i].contains("r")) {
				roads[i] += "Pg" + pCount;
			} else {
				roads[i] += "Pr" + pCount;
			}
			newState += " " + roads[i];
			i++;
		}
		return newState.trim();
	}

}