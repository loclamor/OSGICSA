package org.ups.location;

public class LocationImpl implements ILocation {

	private static final float TOULOUSE_LAT = 43.6047f;
	private static final float TOULOUSE_LNG = 1.4442f;

	public float getLatitude() {
		return TOULOUSE_LAT;
	}

	public float getLongitude() {
		return TOULOUSE_LNG;
	}

	public void addListener(ILocationListener listener) {
		// TODO Auto-generated method stub
	}

	public void removeListener(ILocationListener listener) {
		// TODO Auto-generated method stub

	}

}
