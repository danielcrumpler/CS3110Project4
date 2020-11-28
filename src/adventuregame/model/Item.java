package adventuregame.model;

/**
 * The Class Item
 * 
 * @author Group 7
 */
public class Item {
	private String name;
	private String description;

	/**
	 * Creates a new Item with the a name and description
	 * 
	 * @precondition !name.isEmpty() && !description.isEmpty() && name != null &&
	 *               description != null
	 * @postcondition getName() = name && getDescription() = description
	 * @param name        The name of the item
	 * @param description The description of the item
	 */
	public Item(String name, String description) {
		if (name == null) {
			throw new IllegalArgumentException("name cannot be null");
		}
		if (description == null) {
			throw new IllegalArgumentException("description cannot be null");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("name cannot be empty");
		}
		if (description.isEmpty()) {
			throw new IllegalArgumentException("description cannot be empty");
		}
		this.name = name;
		this.description = description;
	}

	/**
	 * Gets the name of the item
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the description of the item
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}
}
