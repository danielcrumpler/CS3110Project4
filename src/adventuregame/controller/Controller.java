package adventuregame.controller;

import adventuregame.model.Game;
import adventuregame.model.Item;
import adventuregame.model.Location;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Controller {

	private Game game;

	@FXML
	private AnchorPane guiPane;

	@FXML
	private ImageView locationImage;

	@FXML
	private Label locationLabel;

	@FXML
	private ScrollPane locationItemsScrollPane;

	@FXML
	private VBox locationItemsVBox;

	@FXML
	private ScrollPane inventoryItemsScrollPane;

	@FXML
	private VBox inventoryItemsVBox;

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
		this.inventoryItemsScrollPane.setVisible(false);
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
		this.locationItemsScrollPane.setVisible(true);
		this.routesFromLocationScrollPane.setVisible(true);
		this.openInventoryButton.setVisible(true);
		this.pickupItemButton.setVisible(true);
		this.menuBar.setVisible(true);
		this.locationImage.setVisible(true);
	}

	@FXML
	public void loadGame(ActionEvent event) {
		this.titleLabel.setVisible(false);
		this.loadGameButton.setVisible(false);
		this.createGameButton.setVisible(false);
		this.locationItemsLabel.setVisible(true);
		this.locationLabel.setVisible(true);
		this.routesLabel.setVisible(true);
		this.locationItemsScrollPane.setVisible(true);
		this.routesFromLocationScrollPane.setVisible(true);
		this.openInventoryButton.setVisible(true);
		this.pickupItemButton.setVisible(true);
		this.menuBar.setVisible(true);
		this.locationImage.setVisible(true);
	}

	@FXML
	public void loadGameMenu(ActionEvent event) {

	}

	@FXML
	public void openInventory(ActionEvent event) {
		this.openInventoryButton.setVisible(false);
		this.closeInventoryButton.setVisible(true);
		this.inventoryItemsScrollPane.setVisible(true);
		this.inventoryItemsLabel.setVisible(true);
		this.useItemButton.setVisible(true);
	}

	@FXML
	public void pickupItem(ActionEvent event) {
		this.game.getCollectedItems().add(this.game.getCurrentLocation().getItems().get(0));
		this.game.getCurrentLocation().getItems().clear();
		this.update();

	}

	@FXML
	public void quitGameMenu(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	public void saveGameMenu(ActionEvent event) {

	}

	@FXML
	public void useItem(ActionEvent event) {

	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	private void update() {
		this.locationLabel.textProperty().set(this.game.getCurrentLocation().getName());
		this.locationItemsVBox.getChildren().clear();
		for (Item currItem : this.game.getCurrentLocation().getItems()) {
			Label label = new Label(currItem.getName() + ": " + currItem.getDescription());
			this.locationItemsVBox.getChildren().add(label);
		}
		for (Item currItem : this.game.getCollectedItems()) {
			Label label = new Label(currItem.getName() + ": " + currItem.getDescription());
			this.inventoryItemsVBox.getChildren().add(label);
		}
		this.routesFromLocationVBox.getChildren().clear();
		for (String currLocation : this.game.getCurrentLocation().getPaths()) {
			Button button = new Button(currLocation);
			button.setMinWidth(250);
			button.setFont(Font.font(16));
			button.setOnAction(event -> {
				for (Location location : this.game.getWorld().getLocations()) {
					if (location.getName() == currLocation) {
						this.game.setCurrentLocation(location);
						this.update();
					}
				}
			});
			this.routesFromLocationVBox.getChildren().add(button);
		}
	}
}
