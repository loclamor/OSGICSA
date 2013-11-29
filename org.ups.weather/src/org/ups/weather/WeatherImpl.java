package org.ups.weather;

import org.ups.location.ILocationListener;

public class WeatherImpl implements IWeather, ILocationListener {

	public void addListener(IWeatherListener listener) {
		// TODO Auto-generated method stub

	}

	public void removeListener(IWeatherListener listener) {
		// TODO Auto-generated method stub

	}

	public WeatherType getCurrentWeather() {
		return WeatherType.SHINY;
	}

	public WeatherType getWeather(int nbHoursFromNow) {
		return WeatherType.CLOUDY;
	}

	public void locationChanged(float lan, float lon) {
		// TODO Auto-generated method stub
		
	}

}
