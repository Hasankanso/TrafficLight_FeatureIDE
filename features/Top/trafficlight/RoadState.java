package trafficlight;

/**
 * TODO description
 */
public class RoadState {
	
	private void initLight(Road road){
		if(this.road.equals(Road.TOP)) {
			light = Light.RED;
			isLeftRightRoad = false;
		} else {
			original(road);
		}
	}
	
	@Override
	public int hashCode() {
		if(this.road.equals(Road.TOP)) {
		return 3;
		} else {
			return original();
		}
	}
	
	public String toString() {
		if(road.equals(Road.TOP)) {
		return "TV" + lightToString() + cars;
		}
		return original();
	}


}