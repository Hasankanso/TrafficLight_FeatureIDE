package trafficlight;

/**
 * TODO description
 */
public class RoadState {
	private int pedestrians;
	
	RoadState(Road road){
		this.pedestrians = 0;
	}
	
	public void addPedestrian() {
		pedestrians += 1;
	}
	
	public void tryRemovePedestrian() {
		if(pedestrians <= 0) return;
		
		if(isRed()) {
		pedestrians -= 1;
		}
	}
	
	public int getPedestrians() {
		return pedestrians;
	}
	
	
	public boolean requestGreenLight() {
		if(isLeftRightRoad) {
			return pedestrians > 0 && light.equals(Light.GREEN);
		} else {
			return original();
		}
	}
	
	public String toString() {
		return original() + "P" + (isRed()? "g" : "r") + pedestrians;
	}
}