package test;

import trafficlight.Intersection;
import trafficlight.Road;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class MainTests {

	private static final String STEP = "step";
	private static final String STATE = "state";
	private static final String VEHICLE = "vehicle";
	

	//Hyper parameters
	private final int COMMANDS_COUNT = 200;
	
	private class CustomTest {
		private String input;
		private String output;

		CustomTest(String input, String output) {
			this.input = input;
			this.output = output;
		}

		public CustomTest addInput(String input) {
			this.input += input;
			return this;
		}

		public CustomTest addOutput(String output) {
			this.output += output;
			return this;
		}

		public String toString() {
			return "Input:\n" + input + "Output:\n" + output;
		}
	}

	@Test
	void mainTests() {
		CustomTest ctest = generateTest(new CustomTest("", ""));
		System.out.print(ctest.toString());
		compare(ctest, false);
	}

	CustomTest generateStepCommands(CustomTest test) {
		return new CustomTest("", "");
	}

	String extendIntersection(String state) {
		return state;
	}

	CustomTest extendRoads(CustomTest test) {
		return test;
	}
	
	CustomTest generateTest(CustomTest test) {
		return test;
	}

	CustomTest addVehicle(CustomTest test) {
		return test;
	}
	
	void switchColor() {
		
	}
	
	int resetClock(){
		return 0;
	}
	
	List<String> switchColor(Road road, String color, String previousColor) {
		if(color.equals("g") ) {
			color = "r";
		} else {
			color = "g";
		}
		
		ArrayList<String> colors = new ArrayList<String>();
		colors.add(color);
		colors.add(previousColor);
		
		return colors;
	}
	
	String createRoad() {
		return "\n";
	}
	
	private void compare(CustomTest test, boolean print) {
		String input = test.input;
		String output = test.output;
		System.out.print("Test begins:\n");
		Intersection intersection = Intersection.createIntersection();
		Scanner scanner = new Scanner(input);
		Scanner outputScanner = new Scanner(output);

		try {
			while (scanner.hasNext()) {

				String line = scanner.nextLine();

				if (line.equals(STATE)) {
					assertTrue(outputScanner.hasNext());
					String truth = outputScanner.nextLine();
					boolean assertion = intersection.getIntersectionState().equals(truth);

					if (!assertion) {
						System.out.println("difference(program <-> reference): " + intersection.getIntersectionState()
								+ " <-> " + truth);
					} else if (print) {
						System.out.println(intersection.getIntersectionState() + " <-> " + truth);
					}
					assertTrue(assertion);
				} else {
					handleInput(line, intersection);
				}

			}
		} finally

		{
			outputScanner.close();
			scanner.close();
		}
	}

	public void handleInput(String input, Intersection intersection) {
		if (input.startsWith(VEHICLE)) {
			Road road = parseRoad(input.substring(VEHICLE.length()).trim());
			intersection.enqueueVehicle(road);
			return;
		}
		if (input.equals(STEP)) {
			intersection.advanceTime();
			return;
		}
		throw new IllegalArgumentException("Cannot parse command: " + input);
	}

	public Road parseRoad(String roadString) {
		throw new IllegalArgumentException("Cannot parse road: " + roadString);
	}
	
}