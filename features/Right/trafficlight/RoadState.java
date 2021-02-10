package trafficlight;

/**
 * TODO description
 */
public class RoadState {

	private void initLight(Road road){
		if(this.road.equals(Road.RIGHT)) {
			light = Light.GREEN;
			isLeftRightRoad = true;
		} else {
			original(road);
		}
	}
	
	@Override
	public int hashCode() {
		if(this.road.equals(Road.RIGHT)) {
		return 2;
		} else {
			return original();
		}
	}
	
	public String toString() {
		if(this.road.equals(Road.RIGHT)) {
		return "RV" + lightToString() + cars;
		}
		return original();
	}

}