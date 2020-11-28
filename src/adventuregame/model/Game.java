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
	 * @param location location to be se
	 */
	public void setCurrentLocation(Location location) {
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
		newWorld.addLocation("The Beach", false);
		newWorld.getLocations().get(0).addItem("Sea Shell", "A sea shell");
		newWorld.getLocations().get(0).addPath("The Boardwalk");
		newWorld.addLocation("The Boardwalk", false);
		newWorld.getLocations().get(1).addItem("Plank", "A plank");
		newWorld.getLocations().get(1).addPath("The Beach");
		newWorld.getLocations().get(1).addPath("The Street");
		newWorld.addLocation("The Street", false);
		newWorld.getLocations().get(2).addItem("Car", "A car");
		newWorld.getLocations().get(2).addPath("The Boardwalk");
		this.world = newWorld;
		this.currentLocation = this.world.getLocations().get(2);
	}
}
