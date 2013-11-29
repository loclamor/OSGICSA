package org.ups.dressingengine;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.ups.location.ILocation;
import org.ups.weather.IWeather;
import org.ups.weather.WeatherType;

public class DressEngineActivator implements BundleActivator {

	public void start(BundleContext context) throws Exception {
		System.out.println("Dressing started");

		ServiceReference<ILocation> locSvcReference = context
				.getServiceReference(ILocation.class);

		ServiceReference<IWeather> weatherSvcReference = context
				.getServiceReference(IWeather.class);

		ILocation locationService = context.getService(locSvcReference);
		IWeather weatherService = context.getService(weatherSvcReference);

		float lat = locationService.getLatitude();
		WeatherType weather = weatherService.getCurrentWeather();

		System.out.println("lat = " + lat);
		System.out.println("weather = " + weather);

		return;
	}

	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
	}

}
