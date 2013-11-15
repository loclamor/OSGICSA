package org.ups.location;



/**
 * Provide methods to get the location of a given device.<br>
 * Clients must call {@link ILocation#getLatitude()} and
 * {@link ILocation#getLongitude()} methods as many times as they want to get
 * the current location. No listener mechanism is provided (i.e. clients won't
 * be notified when the location changes)
 * 
 * @author Benjamin Cabe
 * 
 */
public interface ILocation {
	/**
	 * Gets the current latitude
	 * 
	 * @return the current latitude in decimal format,
	 *         <code>-90.0 <= lat <= 90.0</code>
	 * @throws Exception
	 *             if the latitude can't be computed
	 */
	float getLatitude();

	/**
	 * Gets the current longitude
	 * 
	 * @return the current longitude in decimal format,
	 *         <code>-180.0 <= lon <= 180.0</code>
	 * @throws Exception
	 *             if the longitude can't be computed
	 */
	float getLongitude();
	

	public void addListener(ILocationListener listener);

	public void removeListener(ILocationListener listener);
}
