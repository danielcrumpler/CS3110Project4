package adventuregame.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * The Class SaveGame
 * 
 * @author Group 7
 */
public class SaveGame {

	private static final String COMMA = ",";

	/**
	 * The method to be called when saving a file begins
	 * 
	 * @param game the game to be saved
	 * @param file the file to be saved to
	 */
	public void writeFile(Game game, File file) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);
			writer.println(this.saveTheGame(game));
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Outputs a formatted String for the game
	 * 
	 * @param game the game
	 * @return a formatted string to save
	 */
	public String saveTheGame(Game game) {
		String output = "";
		output += game.getCurrentLocation().getName() + System.lineSeparator();
		for (Item item : game.getCollectedItems()) {
			output += item.getName() + COMMA + item.getDescription() + COMMA;
		}
		output = this.backspace(output) + System.lineSeparator();
		for (Location location : game.getWorld().getLocations()) {
			output += location.getName() + COMMA + location.getImageUrl() + COMMA + location.isLocked() + COMMA
					+ location.getUnlockItem();
			output += System.lineSeparator();
			for (Item item : location.getItems()) {
				output += item.getName() + COMMA + item.getDescription() + COMMA;
			}
			output = this.backspace(output) + System.lineSeparator();
			for (String path : location.getPaths()) {
				output += path + COMMA;
			}
			output = this.backspace(output) + System.lineSeparator();
		}
		System.out.println(output);
		return output;
	}

	/**
	 * Helper String to remove a character
	 * 
	 * @param str the string to edit
	 * @return a edited string
	 */
	private String backspace(String str) {
		return str.substring(0, str.length() - 1);
	}
}
