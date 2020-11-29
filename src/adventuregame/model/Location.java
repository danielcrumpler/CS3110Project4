package adventuregame.model;

import java.util.ArrayList;

/**
 * The Class Location
 * 
 * @author Group 7
 */
public class Location {
	private static final String DESCRIPTION_CANNOT_BE_EMPTY = "description cannot be empty";
	private static final String NAME_CANNOT_BE_EMPTY = "name cannot be empty";
	private static final String DESCRIPTION_CANNOT_BE_NULL = "description cannot be null";
	private static final String NAME_CANNOT_BE_NULL = "name cannot be null";
	private ArrayList<Item> items;
	private ArrayList<String> paths;
	private boolean locked;
	private String name;

	/**
	 * Create a new Location
	 * 
	 * @param name   the name of the location
	 * @param locked if the location is accessible
	 */
	public Location(String name, boolean locked) {
		this.items = new ArrayList<Item>();
		this.paths = new ArrayList<String>();
		this.setLocked(locked);
		this.name = name;
	}

	/**
	 * Gets the name of the location
	 * 
	 * @return the name of the location
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the List of Items in a Location
	 * 
	 * @return ArrayList of Items
	 */
	public ArrayList<Item> getItems() {
		return this.items;
	}

	/**
	 * Gets the List of Locations accessible from the Location
	 * 
	 * @return ArrayList of Locations accessible from the Location
	 */
	public ArrayList<String> getPaths() {
		return this.paths;
	}

	/**
	 * Gets the value of locked from a Location
	 * 
	 * @return locked
	 */
	public boolean isLocked() {
		return this.locked;
	}

	/**
	 * Sets Locked Value of a Location
	 * 
	 * @precondition none
	 * @postcondition isLocked() = locked
	 * @param locked if the location is inaccessible
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	/**
	 * Adds a new item to a list of items at the location with a name and
	 * description
	 * 
	 * @precondition !name.isEmpty() && !description.isEmpty() && name != null &&
	 *               description != null
	 * @postcondition getItems().size += 1 && getItems().contains(new Item(name,
	 *                description))
	 * @param name        the name of the item
	 * @param description the description of the item
	 * @return if added to items
	 */
	public boolean addItem(String name, String description) {
		if (name == null) {
			throw new IllegalArgumentException(NAME_CANNOT_BE_NULL);
		}
		if (description == null) {
			throw new IllegalArgumentException(DESCRIPTION_CANNOT_BE_NULL);
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException(NAME_CANNOT_BE_EMPTY);
		}
		if (description.isEmpty()) {
			throw new IllegalArgumentException(DESCRIPTION_CANNOT_BE_EMPTY);
		}
		return this.items.add(new Item(name, description));
	}

	/**
	 * Removes item for the list of items at the Location
	 * 
	 * @precondition !name.isEmpty() && !description.isEmpty() && name != null &&
	 *               description != null
	 * @postcondition getItems().size -= 1 && !getItems().contains(Item(name,
	 *                description))
	 * @param name        the name of the item
	 * @param description the description of the item
	 * @return if removed from items
	 */
	public boolean removeItem(String name, String description) {
		if (name == null) {
			throw new IllegalArgumentException(NAME_CANNOT_BE_NULL);
		}
		if (description == null) {
			throw new IllegalArgumentException(DESCRIPTION_CANNOT_BE_NULL);
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException(NAME_CANNOT_BE_EMPTY);
		}
		if (description.isEmpty()) {
			throw new IllegalArgumentException(DESCRIPTION_CANNOT_BE_EMPTY);
		}
		Item objectToRemove = null;
		for (Item currItem : this.items) {
			if (currItem.getName() == name && currItem.getDescription() == description) {
				objectToRemove = currItem;
			}
		}
		return this.items.remove(objectToRemove);
	}

	/**
	 * Adds the name of a location that can be accessed from a current location
	 * 
	 * @precondition !locationName.isEmpty() && locationName != null
	 * @postcondition getItems().size += 1 && getPaths().contains(locationName)
	 * @param locationName the location name
	 * @return if added to paths
	 */
	public boolean addPath(String locationName) {
		if (locationName == null) {
			throw new IllegalArgumentException("the location name cannot be null");
		}
		if (locationName.isEmpty()) {
			throw new IllegalArgumentException("the location name cannot be empty");
		}
		return this.paths.add(locationName);
	}
}
