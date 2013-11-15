package org.ups.dressingengine;


public interface IDressingSuggestion {

	public void addListener(IDressingSuggestionListener listener);

	public void removeListener(IDressingSuggestionListener listener);

	boolean sunGlassesNeeded();

	boolean umbrellaNeeded(); // Rihanna inside!

	boolean coatNeeded();
}
