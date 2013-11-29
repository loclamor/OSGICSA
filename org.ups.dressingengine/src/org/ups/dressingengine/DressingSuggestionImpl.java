package org.ups.dressingengine;

import org.ups.weather.IWeatherListener;
import org.ups.weather.WeatherType;

public class DressingSuggestionImpl implements IDressingSuggestion,
		IWeatherListener {

	public void weatherChanged(WeatherType newWeather) {
		// TODO Auto-generated method stub

	}

	public void addListener(IDressingSuggestionListener listener) {
		// TODO Auto-generated method stub

	}

	public void removeListener(IDressingSuggestionListener listener) {
		// TODO Auto-generated method stub

	}

	public boolean sunGlassesNeeded() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean umbrellaNeeded() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean coatNeeded() {
		// TODO Auto-generated method stub
		return false;
	}

}
