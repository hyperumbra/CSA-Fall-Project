package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SelectProjectController {

	
	//Constructor
	public SelectProjectController() {
		
	}
	
	//Variables used within the Screen
	String projectName = "";
	String manufacturer = "";
	String model = "";
	String chassisCode = "";
	int modelYear = 0;
	
	//Creates an Observable List to read and store data
	ObservableList<Car> Car = FXCollections.observableArrayList();
	
	//Fields and Controls for the Scene
	//Buttons
	@FXML
	private Button selectButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button newButton;
	
	//TableView
	@FXML
	private TableView<Car> selectProjectTable;
	
	//Table Columns
	@FXML
	private TableColumn<Car, String> projectNameColumn;
	@FXML
	private TableColumn<Car, String> manufacturerColumn;
	@FXML
	private TableColumn<Car, String> modelColumn;
	@FXML
	private TableColumn<Car, String> chassisColumn;
	@FXML
	private TableColumn<Car, Integer> modelYearColumn;
	
	//Initializing the GUI
	@FXML
	private void initialize() {
		//Sets the data that each column receives from each Car from the Observable List and SQL Table
		projectNameColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("projectName"));
		manufacturerColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("manutfacturer"));
		modelColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("model"));
		chassisColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("chassisCode"));
		modelYearColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("modelYear"));
		
		//Makes sure the user cannot edit the contents of the table
		selectProjectTable.setEditable(false);
		
		//Sets it so the user can only select a single Line at one time
		selectProjectTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}
	
	//
	@FXML
	private void deleteProject() {
		//Creates new Lists for the entries selected and the entire Index
		ObservableList<Car> selectedRows, completeTable;
		//Makes the temporary Index have all of the values of the actual Index
		completeTable = selectProjectTable.getItems();
		//Gets the highlighted entries and puts them into a temporary List
		selectedRows = selectProjectTable.getSelectionModel().getSelectedItems();
		//Deletes the entries from the List and the Index
		for(Car project : selectedRows) {
			completeTable.remove(project);
		}
	}
	
	//
	@FXML
	private void selectProject() {
		
	}
	
	//
	@FXML
	private void createProject() throws IOException{
		Stage stage = (Stage)newButton.getScene().getWindow();
		Scene selectProjectScene = new Scene(FXMLLoader.load(getClass().getResource("CreateProject.fxml")));
		stage.setScene(selectProjectScene);
	}
	
}