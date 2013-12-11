package org.ups.weather;

import java.util.ArrayList;
import java.util.Collection;

import org.ups.location.ILocationListener;

public class WeatherImpl implements IWeather, ILocationListener {

	private final Collection<IWeatherListener> listeners = new ArrayList<IWeatherListener>();
	private WeatherType currentWeather = WeatherType.UNKNOWN;

	public WeatherType getCurrentWeather() {
		return currentWeather;
	}

	public WeatherType getWeather(int nbHoursFromNow) {
		return WeatherType.UNKNOWN;
	}

	public void setCurrentWeather(WeatherType currentWeather) {
		this.currentWeather = currentWeather;
		fireWeatherChanged();
	}

	public void addListener(IWeatherListener listener) {
		if (null != listeners) {
			listeners.add(listener);
		}
	}

	public void removeListener(IWeatherListener listener) {
		if (null != listeners) {
			listeners.remove(listener);
		}
	}

	private void fireWeatherChanged() {
		System.out.println("La météo a changé ...");

		for (IWeatherListener listener : listeners) {
			listener.weatherChanged(currentWeather);
		}
	}

	public void locationChanged(float lan, float lon) {
		// TODO MàJ météo en fonction de la nouvelle localisation
		// En attendant on va dire qu'il fait beau
		setCurrentWeather(WeatherType.SHINY);
	}

}
