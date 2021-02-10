package test;

import java.util.Random;
import java.util.Scanner;


/**
 * TODO description
 */
public class MainTests {

	int clock =0;
	
	CustomTest generateStepCommands(CustomTest test) {
		String input = "step\nstate\n";
		clock++;
		String state = "";
		
		if(clock % 10 ==0) {
			switchColor();
			clock = resetClock();
		}
		
		state = createRoad();		
		state = state.trim();
		state += "\n";
		test.addOutput(state);
		return test.addInput(input);
	}

	CustomTest generateTest(CustomTest test) {

		Random ran = new Random();
		
		for (int i = 0; i < COMMANDS_COUNT; i++) {
			int picker = ran.nextInt(100);
			
			if(picker < 50) {
			test = generateStepCommands(test);
			} else if(picker < 100) {
			test = addVehicle(test);
			}		
		}
		test = extendRoads(test);
		return test;
	}

}