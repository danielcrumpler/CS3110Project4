package adventuregame.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import adventuregame.model.Game;
import adventuregame.model.Item;
import adventuregame.model.Location;
import adventuregame.model.SaveGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {

	private static final String SECOND_FILTER = "*.advgme";

	private static final String FIRST_FILTER = "Adventure Game (*.advgme)";

	private static final String COLON_SPACE = ": ";

	private Game game;

	@FXML
	private AnchorPane guiPane;

	@FXML
	private ImageView locationImage;

	@FXML
	private Label locationLabel;

    @FXML
    private ListView<String> locationItemsListView;

    @FXML
    private ListView<String> inventoryItemsListView;
	
	@FXML
	private ScrollPane routesFromLocationScrollPane;

	@FXML
	private VBox routesFromLocationVBox;

	@FXML
	private Label routesLabel;

	@FXML
	private Label locationItemsLabel;

	@FXML
	private Label inventoryItemsLabel;

	@FXML
	private Button openInventoryButton;

	@FXML
	private Button pickupItemButton;

	@FXML
	private Button closeInventoryButton;

	@FXML
	private Button useItemButton;

	@FXML
	private MenuBar menuBar;

	@FXML
	private Menu gameMenu;

	@FXML
	private MenuItem loadGameMenuItem;

	@FXML
	private MenuItem saveGameMenuItem;

	@FXML
	private MenuItem quitMenuItem;

	@FXML
	private Menu helpMenu;

	@FXML
	private Label titleLabel;

	@FXML
	private Button createGameButton;

	@FXML
	private Button loadGameButton;

	@FXML
	void initialize() {
		this.game = new Game();
	}

	@FXML
	public void closeInventory(ActionEvent event) {
		this.closeInventoryButton.setVisible(false);
		this.openInventoryButton.setVisible(true);
		this.inventoryItemsListView.setVisible(false);
		this.inventoryItemsLabel.setVisible(false);
		this.useItemButton.setVisible(false);
	}

	@FXML
	public void createGame(ActionEvent event) {
		this.game.loadWorldOne();
		this.update();
		this.titleLabel.setVisible(false);
		this.loadGameButton.setVisible(false);
		this.createGameButton.setVisible(false);
		this.locationItemsLabel.setVisible(true);
		this.locationLabel.setVisible(true);
		this.routesLabel.setVisible(true);
		this.locationItemsListView.setVisible(true);
		this.routesFromLocationScrollPane.setVisible(true);
		this.openInventoryButton.setVisible(true);
		this.pickupItemButton.setVisible(true);
		this.menuBar.setVisible(true);
		this.locationImage.setVisible(true);
	}

	@FXML
	public void loadGame(ActionEvent event) {
		FileChooser chooser = new FileChooser();
	    chooser.setTitle("Load Game");
	    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(FIRST_FILTER, SECOND_FILTER);
        chooser.getExtensionFilters().add(extFilter);
	    File file = chooser.showOpenDialog(new Stage());
		
		this.titleLabel.setVisible(false);
		this.loadGameButton.setVisible(false);
		this.createGameButton.setVisible(false);
		this.locationItemsLabel.setVisible(true);
		this.locationLabel.setVisible(true);
		this.routesLabel.setVisible(true);
		this.locationItemsListView.setVisible(true);
		this.routesFromLocationScrollPane.setVisible(true);
		this.openInventoryButton.setVisible(true);
		this.pickupItemButton.setVisible(true);
		this.menuBar.setVisible(true);
		this.locationImage.setVisible(true);
	}

	@FXML
	public void loadGameMenu(ActionEvent event) {
		FileChooser chooser = new FileChooser();
	    chooser.setTitle("Load Game");
	    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(FIRST_FILTER, SECOND_FILTER);
        chooser.getExtensionFilters().add(extFilter);
	    File file = chooser.showOpenDialog(new Stage());
	}

	@FXML
	public void openInventory(ActionEvent event) {
		this.openInventoryButton.setVisible(false);
		this.closeInventoryButton.setVisible(true);
		this.inventoryItemsListView.setVisible(true);
		this.inventoryItemsLabel.setVisible(true);
		this.useItemButton.setVisible(true);
	}

	@FXML
	public void pickupItem(ActionEvent event) {
		int index = this.locationItemsListView.getSelectionModel().getSelectedIndex();
		this.game.getCollectedItems().add(this.game.getCurrentLocation().getItems().get(index));
		this.game.getCurrentLocation().getItems().remove(index);
		this.update();
	}

	@FXML
	public void quitGameMenu(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	public void saveGameMenu(ActionEvent event) {
		FileChooser chooser = new FileChooser();
	    chooser.setTitle("Save Game");
	    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(FIRST_FILTER, SECOND_FILTER);
        chooser.getExtensionFilters().add(extFilter);
	    File file = chooser.showSaveDialog(new Stage());
		SaveGame saveGame = new SaveGame();
        if (file != null) {
            saveGame.writeFile(this.game, file);
        }
	}

	@FXML
	public void useItem(ActionEvent event) {
		int index = this.inventoryItemsListView.getSelectionModel().getSelectedIndex();
		for (Location location : this.game.getWorld().getLocations()) {
			if (this.game.getCollectedItems().get(index).getName() == location.getUnlockItem()) {
				location.setLocked(false);
			}
		}
		this.update();
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	private void update() {
		this.locationLabel.textProperty().set(this.game.getCurrentLocation().getName());
		this.updateLocationItemsListView();
		this.updateInventoryListView();
		this.updateRoutesVBox();
		this.updateImageView();
	}

	private void updateLocationItemsListView() {
		this.locationItemsListView.getItems().clear();
		for (Item currItem : this.game.getCurrentLocation().getItems()) {
			this.locationItemsListView.getItems().add(currItem.getName() + COLON_SPACE + currItem.getDescription());
		}
	}

	private void updateInventoryListView() {
		this.inventoryItemsListView.getItems().clear();
		for (Item currItem : this.game.getCollectedItems()) {
			this.inventoryItemsListView.getItems().add(currItem.getName() + COLON_SPACE + currItem.getDescription());
		}
	}

	private void updateRoutesVBox() {
		this.routesFromLocationVBox.getChildren().clear();
		for (String currLocation : this.game.getCurrentLocation().getPaths()) {
			for (Location location : this.game.getWorld().getLocations()) {
				if (location.getName() == currLocation && !location.isLocked()) {
					Button button = new Button(currLocation);
					button.setMinWidth(250);
					button.setFont(Font.font(16));
					button.setOnAction(event -> {
						for (Location secondLocation : this.game.getWorld().getLocations()) {
							if (secondLocation.getName() == currLocation) {
								this.game.setCurrentLocation(secondLocation);
								this.update();
							}
						}
					});
					this.routesFromLocationVBox.getChildren().add(button);
				}
			}
		}
	}

	private void updateImageView() {
		if (this.game.getCurrentLocation().getImageUrl() != null) {
			FileInputStream input = null;
			try {
				input = new FileInputStream(this.game.getCurrentLocation().getImageUrl());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Image image = new Image(input);
			this.locationImage.setImage(image);
		}
	}
}
