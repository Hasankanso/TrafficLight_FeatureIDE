package trafficlight;

/**
 * TODO description
 */
public class RoadState {

	private Light previous;

	final int redDelay = 2;
    final int orangeDelay = 1;
    
    int redDelayCounter = redDelay;
    int orangeDelayCounter = orangeDelay;
    
	private void setLight(Light value) {
		this.previous = this.light;
		original(value);
	}

	public boolean isTransition() {
		return transition;
	}
	
	public String lightToString() {
		if (light.equals(Light.ORANGE)) {
			return "o";
		} else {
			return original();
		}
	}

	private void resetCounters() {
		redDelayCounter = redDelay;
		orangeDelayCounter = orangeDelay;
	}
	
	public void step() {
		switch (light) {
		case RED:
			if (redDelayCounter == 0) {
				setLight(Light.ORANGE);
				resetCounters();
				break;
			}
			redDelayCounter--;
			transition = true;
			break;
		case GREEN:
			setLight(Light.ORANGE);
			transition = true;
			resetCounters();
			break;
		case ORANGE:
			if (orangeDelayCounter == 0) {
				resetCounters();
				switch (previous) {
				case RED:
					setLight(Light.GREEN);
					transition = false; 
					break;
				case GREEN:
					setLight(Light.RED);
					transition = false;
					break;
				default:
					assert (false);
					break;
				}
			}
			orangeDelayCounter--;
			break;
		}
	}
}