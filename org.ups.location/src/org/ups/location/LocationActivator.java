package org.ups.location;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class LocationActivator implements BundleActivator {

	public void start(BundleContext context) {
		context.registerService(ILocation.class.getName(), new LocationImpl(),
				null);
	}

	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
	}

}
