package org.ups.dressingengine;

import java.util.ArrayList;
import java.util.Collection;

import org.ups.weather.IWeatherListener;
import org.ups.weather.WeatherType;

public class DressingSuggestionImpl implements IDressingSuggestion,
		IWeatherListener {

	private final Collection<IDressingSuggestionListener> listeners = new ArrayList<IDressingSuggestionListener>();

	private boolean sunGlassesNeeded = false;
	private boolean umbrellaNeeded = false;
	private boolean coatNeeded = false;

	public void weatherChanged(WeatherType newWeather) {
		updateNeededClothes(newWeather);
	}

	private void updateNeededClothes(WeatherType newWeather) {
		switch (newWeather) {
		case CLOUDY:
			setNothingNeeded();
			this.coatNeeded = true;
			break;
		case SHOWERS:
		case RAINY:
			this.sunGlassesNeeded = false;
			this.umbrellaNeeded = true;
			this.coatNeeded = true;
		case SHINY:
			setNothingNeeded();
			this.sunGlassesNeeded = true;
			break;
		case SNOW:
			setNothingNeeded();
			this.coatNeeded = true;
		default:
			setNothingNeeded();
			break;
		}
		fireSuggestionChanged();
	}

	private void setNothingNeeded() {
		this.sunGlassesNeeded = false;
		this.umbrellaNeeded = false;
		this.coatNeeded = false;
	}

	private void fireSuggestionChanged() {
		System.out.println("Les suggestions ont changé ...");

		for (IDressingSuggestionListener listener : listeners) {
			listener.dressingSuggestionChanged(this);
		}
	}

	public void addListener(IDressingSuggestionListener listener) {
		if (null != listeners) {
			listeners.add(listener);
		}
	}

	public void removeListener(IDressingSuggestionListener listener) {
		if (null != listeners) {
			listeners.remove(listener);
		}
	}

	public boolean sunGlassesNeeded() {
		return sunGlassesNeeded;
	}

	public boolean umbrellaNeeded() {
		return umbrellaNeeded;
	}

	public boolean coatNeeded() {
		return coatNeeded;
	}

	@Override
	public String toString() {
		return "   sunGlassesNeeded=" + sunGlassesNeeded + ", umbrellaNeeded="
				+ umbrellaNeeded + ", coatNeeded=" + coatNeeded;
	}

}
