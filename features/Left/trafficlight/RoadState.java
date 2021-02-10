package trafficlight;

/**
 * TODO description
 */
public class RoadState {
	
	private void initLight(Road road){
		if(this.road.equals(Road.LEFT)) {
			light = Light.GREEN;
			isLeftRightRoad = true;
		} else {
			original(road);
		}
	}
	
	@Override
	public int hashCode() {
		if(this.road.equals(Road.LEFT)) {
		return 1;
		} else {
			return original();
		}
	}
	
	public String toString() {
		if(this.road.equals(Road.LEFT)) {
		return "LV" + lightToString() + cars;
		}
		return original();
	}

}