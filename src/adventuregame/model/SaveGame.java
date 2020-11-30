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

	public String saveTheGame(Game game) {
		String output = "";
		output += game.getCurrentLocation().getName() + System.lineSeparator();
		for (Item item : game.getCollectedItems()) {
			output += item.getName() + COMMA + item.getDescription() + COMMA;
		}
		output += System.lineSeparator();
		for (Location location : game.getWorld().getLocations()) {
			output += location.getName() + COMMA + location.getImageUrl() + COMMA + location.isLocked() + COMMA
					+ location.getUnlockItem();
			output += System.lineSeparator();
			for (Item item : location.getItems()) {
				output += item.getName() + COMMA + item.getDescription();
			}
			output += System.lineSeparator();
			for (String path : location.getPaths()) {
				output += path + COMMA;
			}
			output += System.lineSeparator();
		}
		return output;
	}
}
