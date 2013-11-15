package org.ups.weather;

public interface IWeather {

	public void addListener(IWeatherListener listener);

	public void removeListener(IWeatherListener listener);

	WeatherType getCurrentWeather();

	WeatherType getWeather(int nbHoursFromNow);

}
