package org.ups.weather;

public class WeatherImpl implements IWeather {

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

}
