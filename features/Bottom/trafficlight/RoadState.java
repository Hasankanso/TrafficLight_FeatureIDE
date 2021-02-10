package trafficlight;

/**
 * TODO description
 */
public class RoadState {
	
	private void initLight(Road road){
		if(this.road.equals(Road.BOTTOM)) {
			light = Light.RED;
			isLeftRightRoad = false;
		} else {
			original(road);
		}
	}
	
	@Override
	public int hashCode() {
		if(this.road.equals(Road.BOTTOM)) {
		return 3;
		} else {
			return original();
		}
	}
	
	public String toString() {
		if(this.road.equals(Road.BOTTOM)) {
		return "BV" + lightToString() + cars;
		}
		return original();
	}

}