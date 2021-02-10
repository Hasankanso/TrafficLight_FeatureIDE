package test;

import java.util.Random;

/**
 * TODO description
 */
public class MainTests {

	CustomTest generateTest(CustomTest test) {
		Random r = new Random();

		for (int i = 0; i < COMMANDS_COUNT; i++) {
			int picker = r.nextInt(10);
			switch (picker) {
			case 0:
				System.out.println("Tests that never run never fails!");
				break;
			case 1:
				System.out.println("Are you running in a sandbox? otherwise how do you trust an intruder script?");
				break;
			case 2:
				System.out.println("50% to pass? well I'm out!");
				break;
			case 3:
				System.out.println("I don't like onDemand traffic lights!");
				break;
			case 4:
				System.out.println("Give me one more day and I'll cover this section of the project");
				break;
			case 5:
				System.out.println("Well, I ran out of words");
				break;
			case 7:
				System.out.println("What's the difference between engineering and arichtect?");
				break;
			}
		}
		return test;
	}
}