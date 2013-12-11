package org.ups.dressingengine;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.ups.location.ILocation;
import org.ups.weather.IWeather;
import org.ups.weather.WeatherType;

public class DressEngineActivator implements BundleActivator,
		IDressingSuggestionListener {

	private ILocation locationService;
	private IWeather weatherService;
	private DressingSuggestionImpl dressingService;

	public void start(BundleContext context) throws Exception {
		System.out.println("*** Dressing engine started !");

		// On écoute ici les changements de suggestions
		dressingService = new DressingSuggestionImpl();
		dressingService.addListener(this);

		// On récupère les modules de localisation et de météo
		ServiceReference<ILocation> locSvcReference = context
				.getServiceReference(ILocation.class);

		ServiceReference<IWeather> weatherSvcReference = context
				.getServiceReference(IWeather.class);

		locationService = context.getService(locSvcReference);
		weatherService = context.getService(weatherSvcReference);

		// Le module de suggestion écoute les changements de météo
		weatherService.addListener(dressingService);

		printCurrentInfo();
		System.out.println("Changement de position dans 10 secondes ...");
	}

	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
	}

	private void printCurrentInfo() {
		float lat = locationService.getLatitude();
		float lng = locationService.getLongitude();

		WeatherType weather = weatherService.getCurrentWeather();

		System.out
				.println("-------------------------------------------------------------------------------------");

		System.out.println("Position actuelle :");
		System.out.println("   lat = " + lat + ", lng = " + lng);

		System.out.println("Météo actuelle :");
		System.out.println("   " + weather);

		System.out.println("Suggestions d'habillement :");
		System.out.println(dressingService.toString());
		System.out
				.println("-------------------------------------------------------------------------------------");
	}

	public void dressingSuggestionChanged(IDressingSuggestion newSuggestion) {
		printCurrentInfo();
	}

}
