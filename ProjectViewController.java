package application;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.control.TableView;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.Observable;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ProjectViewController{
	
	private Main mainApp;
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	//Constructor
	public ProjectViewController() {
		
	}
	
	//Variables used in the Scene
	String partType = "";
	String partName = "";
	String brandName = "N/A";
	String itemID = "N/A";
	String material = "N/A";
	String price = "";
	
	//Creates Observable Lists to be used within the program
	ObservableList<Part> PartList = FXCollections.observableArrayList();
	ObservableList<String> PartType = FXCollections.observableArrayList("Aero", "Paint", "Bumper", "Fender",
			"Lights", "Steering Wheel", "Gauges", "Seats", "Cage", "Shifter", "Frame", "Sub-Frame", "Axle",
			"Differential", "Flywheel", "Clutch", "Gearbox", "Torque Converter", "Catalytic Converter",
			"Exhuast", "Downpipe", "Fluids", "Injector", "Block", "Head", "Camshaft", "Pison",
			"Valve Cover", "Connecting Rod", "Intake", "Manifold", "Radiator", "Battery", "Turbocharger",
			"Supercharger", "Intercooler", "Wastegate", "Miscellaneous Piping");
	
	//Creating a number that indexes the PartList
	int partListIndex = 0;
	
	//Fields for the scene
	//Buttons
	@FXML
	private Button googleButton;
	@FXML
	private Button amazonButton;
	@FXML
	private Button eBayButton;
	@FXML
	private Button carpartButton;
	@FXML
	private Button addPartButton;
	@FXML
	private Button dismissButton;
	@FXML
	private Button editButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button projectButton;
	@FXML
	private Button quitButton;
	
	//Labels
	@FXML
	private Label partTypeLabel;
	@FXML
	private Label partNameLabel;
	@FXML
	private Label brandNameLabel;
	@FXML
	private Label itemIDLabel;
	@FXML
	private Label materialLabel;
	@FXML
	private Label priceLabel;
	@FXML
	private Label warningLabel;
	
	//TextFields
	@FXML
	private TextField partNameText;
	@FXML
	private TextField brandNameText;
	@FXML
	private TextField itemIDText;
	@FXML
	private TextField materialText;
	@FXML
	private TextField priceText;

	//ChoiceBox
	@FXML
	private ChoiceBox<String> partTypeChoice;
	
	//Tabs
	@FXML
	private Tab webPageTab;
	@FXML
	private Tab partListTab;
	@FXML
	private Tab newPartTab;
	
	//TabPane
	@FXML
	private TabPane projectViewTabpane;
	
	//WebView
	@FXML
	private WebView internet;
	@FXML
	private WebEngine webEngine;
	
	//HBox
	@FXML
	private HBox hBox;
	
	//StackPane
	@FXML
	private StackPane webPageStackpane;
	
	//TableView
	@FXML
	private TableView<Part> partListTable;
	
	//TableColumns
	@FXML
	private TableColumn<Part, String> partTypeColumn;
	@FXML
	private TableColumn<Part, String> partNameColumn;
	@FXML
	private TableColumn<Part, String> brandNameColumn;
	@FXML
	private TableColumn<Part, String> itemIDColumn;
	@FXML
	private TableColumn<Part, String> materialColumn;
	@FXML
	private TableColumn<Part, String> priceColumn;
	
	@FXML
	private void initialize() {
		//Sets the text for the tabs
		webPageTab.setText("Webpage Access");	
		partListTab.setText("Part List");
		newPartTab.setText("Add New Part");
		
		//Sets the initial text of the Labels that may be changed
		partTypeLabel.setText("Part Type");
		partNameLabel.setText("Part Name");
		
		//Sets the initial colors of the Labels of the Required Fields
		partTypeLabel.setTextFill(javafx.scene.paint.Color.BLACK);
		partNameLabel.setTextFill(javafx.scene.paint.Color.BLACK);
		
		//Changes the default zoom of the Web View to be seen more easily by the user
		internet.setZoom(0.75);
		
		//Allows the WebView to Load the generic home page of Google
		webEngine = internet.getEngine();
		webEngine.load("https://www.google.com");
		
		//Sets the initial state of the Warning label and Dismiss Button
		warningLabel.setTextFill(javafx.scene.paint.Color.RED);
		warningLabel.setVisible(false);
		dismissButton.setVisible(false);
		
		//Sets the items able to be selected in the Part Type Box
		partTypeChoice.setItems(PartType);
		
		//Sets the data that each column receives from each Part from the Observable List and SQL Table
		partTypeColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("PartType"));
		partNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("PartName"));
		brandNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("BrandName"));
		itemIDColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("ItemID"));
		materialColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("Material"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("Price"));
		
		//Makes sure the user cannot edit the contents of the table
		partListTable.setEditable(false);
		
		//Sets it so the user can only select a single line at one time
		partListTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}
	
	//
	@FXML
	private void handlePartType() {
		partType = partTypeChoice.getValue();
	}

	//
	@FXML
	private void handlePartName() {
		partName = partNameText.getText();
	}
	
	//
	@FXML
	private void handleBrandName() {
		brandName = brandNameText.getText();
	}
	
	//
	@FXML
	private void handleItemID() {
		itemID = itemIDText.getText();
	}
	
	//
	@FXML
	private void handleMaterial() {
		material = materialText.getText();
	}
	
	//
	@FXML
	private void handlePrice() {
		price = priceText.getText();
	}
	
	//
	@FXML
	private void newPart() {
		//
		if((partTypeChoice.getValue().isEmpty() == false)&&(partNameText.getText().isEmpty() == false)) {
			//
			PartList.add(partListIndex, new Part(partType, partName, brandName, itemID, material, price));
			partListIndex++;
			
			//
			partListTable.setItems(PartList);
		}
		else {
			//Changes the text of the Required labels
			partTypeLabel.setText("*Part Type");
			partNameLabel.setText("*Part Name");
			
			//Changes the color of the Required Labels
			partTypeLabel.setTextFill(javafx.scene.paint.Color.RED);
			partNameLabel.setTextFill(javafx.scene.paint.Color.RED);
			
			//Displays the warning
			warningLabel.setVisible(true);
			dismissButton.setVisible(true);
		}
	}
	
	//hides the warning and button until necessary
	@FXML
	private void dismissWarning() {
		warningLabel.setVisible(false);
		dismissButton.setVisible(false);
	}
	
	//Goes back to the SelectProject scene after saving
	@FXML
	private void backToSelection() throws IOException {
		Stage stage = (Stage)projectButton.getScene().getWindow();
		Scene selectProjectScene = new Scene(FXMLLoader.load(getClass().getResource("SelectProject.fxml")));
		stage.setScene(selectProjectScene);
	}
	
	//Force saves all parts to the Database and quits the application
	@FXML
	private void quitProject() {
		Platform.exit();
	}
	
	//
	@FXML
	private void routeGoogle() {
		webEngine.load("https://www.google.com");
	}
	
	//
	@FXML
	private void routeAmazon() {
		webEngine.load("https://www.amazon.com");
	}
	
	//
	@FXML
	private void routeEBay() {
		webEngine.load("https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334");
	}
	
	//
	@FXML
	private void routeCarPart() {
		webEngine.load("http://www.car-part.com");
	}
	
}