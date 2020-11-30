package adventuregame.model;

import java.util.ArrayList;

/**
 * The Class Game
 * 
 * @author Group 7
 */
public class Game {
	private World world;
	private Location currentLocation = null;
	private ArrayList<Item> collectedItems;

	/**
	 * Creates a new game object
	 */
	public Game() {
		this.world = new World();
		this.collectedItems = new ArrayList<Item>();
	}

	/**
	 * Gets the world
	 * 
	 * @return the world
	 */
	public World getWorld() {
		return this.world;
	}

	/**
	 * Gets the Current Location
	 * 
	 * @return the current location
	 */
	public Location getCurrentLocation() {
		return this.currentLocation;
	}

	/**
	 * Sets the Current Location
	 * 
	 * @param location location to be set
	 */
	public void setCurrentLocation(Location location) {
		if (location == null) {
			throw new IllegalArgumentException();
		}
		this.currentLocation = location;
	}
	
	/**
	 * Gets the collected items
	 * 
	 * @return ArrayList of collected items
	 */
	public ArrayList<Item> getCollectedItems() {
		return this.collectedItems;
	}

	/**
	 * Loads the first world
	 */
	public void loadWorldOne() {
		World newWorld = new World();
		newWorld.addLocation("The Beach", "images/beach.jpg", true, "Plank");
		newWorld.getLocations().get(0).addItem("Sea Shell", "A sea shell");
		newWorld.getLocations().get(0).addPath("The Path");
		newWorld.getLocations().get(0).addPath("The End");
		newWorld.addLocation("The Path", "images/path.jpg", true, "Axe");
		newWorld.getLocations().get(1).addItem("Plank", "A plank");
		newWorld.getLocations().get(1).addPath("The Beach");
		newWorld.getLocations().get(1).addPath("The Street");
		newWorld.addLocation("The Street", "images/street.jpg", false, "Nothing");
		newWorld.getLocations().get(2).addItem("Bottle", "A plastic bottle that looks to be trash.");
		newWorld.getLocations().get(2).addItem("Napkin", "A paper napkin that looks to be trash.");
		newWorld.getLocations().get(2).addItem("Axe", "A metal axe.");
		newWorld.getLocations().get(2).addPath("The Path");
		newWorld.addLocation("The End", "images/end.jpg", true, "Sea Shell");
		this.world = newWorld;
		this.currentLocation = this.world.getLocations().get(2);
	}
}
