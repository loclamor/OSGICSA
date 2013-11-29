package org.ups.weather;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class WeatherActivator implements BundleActivator {

	public void start(BundleContext context) throws Exception {
		context.registerService(IWeather.class.getName(), new WeatherImpl(), null);
	}

	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
