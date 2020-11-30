package adventuregame.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Class LoadGame
 * 
 * @author Group 7
 */
public class LoadGame {

	/**
	 * Loads the Game from file and parses its data
	 * 
	 * @param file the file to be read
	 * @return the saved game state
	 */
	public Game loadGame(File file) {
		Game game = new Game();
		int lineCount = 0;
		String nameOfCurrentLocation = "";
		Location location = null;
		try (Scanner input = new Scanner(file)) {
			while (input.hasNextLine()) {
				String line = input.nextLine();
				if (lineCount == 0) {
					nameOfCurrentLocation = line;
				}
				this.checkLineOne(game, lineCount, line);
				if (lineCount == 2) {
					if (!line.isEmpty()) {
						String[] info = line.split(",");
						boolean parsed = Boolean.getBoolean(info[2]);
						location = new Location(info[0], info[1], parsed, info[3]);
					}
				}
				this.checkLineThree(lineCount, location, line);
				lineCount = this.checkLineFour(game, lineCount, location, line);
				lineCount++;
			}

			for (Location currLocation : game.getWorld().getLocations()) {
				if (currLocation.getName() == nameOfCurrentLocation.strip()) {
					game.setCurrentLocation(currLocation);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return game;
	}

	private void checkLineThree(int lineCount, Location location, String line) {
		if (lineCount == 3) {
			if (!line.isEmpty()) {
				String[] info = line.split(",");
				String itemName = "";
				int innerCount = 0;
				this.checkLineThreeHelperMethod(location, info, itemName, innerCount);
			}
		}
	}

	private void checkLineThreeHelperMethod(Location location, String[] info, String itemName, int innerCount) {
		for (String curr : info) {
			if (innerCount == 0) {
				itemName = curr;
			}
			if (innerCount == 1) {
				location.getItems().add(new Item(itemName, curr));
				System.out.println(itemName + ": " + curr);
				innerCount = -1;
			}
			innerCount++;
		}
	}

	private int checkLineFour(Game game, int lineCount, Location location, String line) {
		if (lineCount == 4) {
			if (!line.isEmpty()) {
				String[] info = line.split(",");
				for (String curr : info) {
					location.getPaths().add(curr);
				}
				game.getWorld().getLocations().add(location);
				lineCount = 1;
			}
		}
		return lineCount;
	}

	private void checkLineOne(Game game, int lineCount, String line) {
		if (lineCount == 1) {
			String[] info = line.split(",");
			String itemName = "";
			int innerCount = 0;
			for (String curr : info) {
				if (innerCount == 0) {
					itemName = curr;
				}
				if (innerCount == 1) {
					game.getCollectedItems().add(new Item(itemName, curr));
					System.out.println(itemName + ": " + curr);
					innerCount = -1;
				}
				innerCount++;
			}
		}
	}
}
