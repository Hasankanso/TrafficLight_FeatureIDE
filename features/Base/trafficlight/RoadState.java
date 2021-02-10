package trafficlight;
/**
 * TODO description
 */
public class RoadState {

	private Light light;
	private int cars;
	private Road road;
	private boolean transition;
	private boolean isLeftRightRoad;

	public RoadState(Road road) {
		this.cars = 0;
		this.road = road;
		transition = false;
		initLight(road);
	}

	public void addCar() {
		cars += 1;
	}

	public String lightToString() {
		if (light.equals(Light.GREEN)) {
			return "g";
		} else if (light.equals(Light.RED)) {
			return "r";
		}
		return "NOCOLOR";
	}

	public void tryRemoveCar() {
		if (cars <= 0)
			return;

		if (isGreen()) {
			cars -= 1;
		}
	}

	public int getCars() {
		return cars;
	}

	public boolean isTransition() {
		transition = false;
		return transition;
	}

	private void setLight(Light value) {
		this.light = value;
	}

	public void step() {
		switch (light) {
		case RED:
			setLight(Light.GREEN);
			break;
		case GREEN:
			setLight(Light.RED);
			break;
		default:
			assert (false);
		}
	}

	public void switchToGreen() {
		setLight(Light.GREEN);
	}

	public void switchToRed() {
		setLight(Light.RED);
	}

	public boolean isGreen() {
		return light == Light.GREEN;
	}

	public boolean isRed() {
		return light == Light.RED;
	}

	private void initLight(Road road) {
	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	public int hashCode() {
		return 0;
	}

	public boolean requestGreenLight() {
		if (!isLeftRightRoad) {
			return cars > 0 && light.equals(Light.RED);
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof RoadState))
			return false;

		RoadState other = (RoadState) o;
		return other.road.equals(this.road);
	}
}