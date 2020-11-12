package edu.westga.cs3152.worldnav.controller;

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

public class Controller {

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
    void closeInventory(ActionEvent event) {

    }

    @FXML
    void createGame(ActionEvent event) {

    }

    @FXML
    void loadGame(ActionEvent event) {

    }

    @FXML
    void loadGameMenu(ActionEvent event) {

    }

    @FXML
    void openInventory(ActionEvent event) {

    }

    @FXML
    void pickupItem(ActionEvent event) {

    }

    @FXML
    void quitGameMenu(ActionEvent event) {

    }

    @FXML
    void saveGameMenu(ActionEvent event) {

    }

    @FXML
    void useItem(ActionEvent event) {

    }

}
