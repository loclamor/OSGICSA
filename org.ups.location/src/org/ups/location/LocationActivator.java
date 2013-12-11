package org.ups.location;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class LocationActivator implements BundleActivator {

	private static final ScheduledExecutorService worker = Executors
			.newSingleThreadScheduledExecutor();

	private static final float TOULOUSE_LAT = 43.6047f;
	private static final float TOULOUSE_LNG = 1.4442f;
	private static final float NYC_LAT = 40.71448f;
	private static final float NYC_LNG = -74.00598f;

	private LocationImpl locationService;

	public void start(BundleContext context) {
		locationService = new LocationImpl();
		locationService.setPosition(TOULOUSE_LAT, TOULOUSE_LNG);

		context.registerService(ILocation.class.getName(), locationService,
				null);

		// On change la position dans 10 secondes ...
		worker.schedule(locationChanger, 10, TimeUnit.SECONDS);
	}

	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
	}

	private Runnable locationChanger = new Runnable() {

		public void run() {
			// Nous voilˆ ˆ New York City
			locationService.setPosition(NYC_LAT, NYC_LNG);
		}
	};

}
