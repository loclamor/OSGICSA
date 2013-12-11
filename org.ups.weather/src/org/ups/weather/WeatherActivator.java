package org.ups.weather;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.ups.location.ILocation;

public class WeatherActivator implements BundleActivator {

	public void start(BundleContext context) throws Exception {
		// On cr�e et enregistre une instance du module de m�t�o
		WeatherImpl weatherImpl = new WeatherImpl();
		context.registerService(IWeather.class.getName(), weatherImpl, null);

		// R�cup�re le module de localisation
		ServiceReference<ILocation> locSvcReference = context
				.getServiceReference(ILocation.class);
		ILocation locationService = context.getService(locSvcReference);

		// Le module m�t�o �coute les changements de position
		locationService.addListener(weatherImpl);
	}

	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
	}

}
