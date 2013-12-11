package org.ups.location;

import java.util.ArrayList;
import java.util.Collection;

public class LocationImpl implements ILocation {

	private final Collection<ILocationListener> listeners = new ArrayList<ILocationListener>();

	private float latitude = 0.0f;
	private float longitude = 0.0f;

	public float getLatitude() {
		return latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setPosition(float newLatitude, float newLongitude) {
		this.latitude = newLatitude;
		this.longitude = newLongitude;
		fireLocationChanged();
	}

	public void addListener(ILocationListener listener) {
		if (null != listeners) {
			listeners.add(listener);
		}
	}

	public void removeListener(ILocationListener listener) {
		if (null != listeners) {
			listeners.remove(listener);
		}
	}

	private void fireLocationChanged() {
		System.out.println("La position a changé ...");
		for (ILocationListener listener : listeners) {
			listener.locationChanged(latitude, longitude);
		}
	}

}
