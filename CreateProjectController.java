package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CreateProjectController {

	private Main mainApp;
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	//Constructor
	public CreateProjectController() {
		
	}
	
	//Variables used within the Screen
	String projectName = "";
	String manufacturer = "";
	String model = "";
	String chassisCode = "";
	int modelYear = 0;
	
	//Creates an Observable List to more easily work with the data
	ObservableList<Car> Car = FXCollections.observableArrayList();
	
	//Fields for the scene
	//Buttons
	@FXML
	private Button backButton;
	@FXML
	private Button nextButton;
	@FXML
	private Button dismissButton;
	
	//TextFields
	@FXML
	private TextField projectNameTextbox;
	@FXML
	private TextField manufacturerTextbox;
	@FXML
	private TextField modelTextbox;
	@FXML
	private TextField chassisTextbox;
	@FXML
	private TextField modelYearTextbox;
	
	//Labels
	@FXML
	private Label titleLabel;
	@FXML
	private Label projectNameLabel;
	@FXML
	private Label manufacturerLabel;
	@FXML
	private Label modelLabel;
	@FXML
	private Label chassisLabel;
	@FXML
	private Label modelYearLabel;
	@FXML
	private Label warningLabel;
	
	//Initializing the GUI
	@FXML
	private void initialize() {
		
		//Sets the initial text of the Labels that may be changed
		projectNameLabel.setText("Project Name");
		manufacturerLabel.setText("Manufacturer");
		modelLabel.setText("Label");
		
		//Sets the initial color for the warning
		warningLabel.setTextFill(javafx.scene.paint.Color.RED);
		
		//Sets the initial colors of the Labels of the Required Fields
		projectNameLabel.setTextFill(javafx.scene.paint.Color.BLACK);
		manufacturerLabel.setTextFill(javafx.scene.paint.Color.BLACK);
		modelLabel.setTextFill(javafx.scene.paint.Color.BLACK);
		
		//Sets a warning for the user to be invisible until necessary
		warningLabel.setVisible(false);
		dismissButton.setVisible(false);
	}
	
	//
	@FXML
	private void handleProjectName() {
		projectName = projectNameTextbox.getText();
	}

	//
	@FXML
	private void handleManufacturer() {
		manufacturer = manufacturerTextbox.getText();
	}
	
	//
	@FXML
	private void handleModel() {
		model = modelTextbox.getText();
	}

	//
	@FXML
	private void handleChassis() {
		chassisCode = chassisTextbox.getText();
	}

	//
	@FXML
	private void handleModelYear() {
		String modelYearString = modelYearTextbox.getText();
		modelYear = Integer.parseInt(modelYearString);
	}
	//Adds the new Project Details to the Database
	@FXML
	private void newProject() throws IOException {
		//Checks if the required fields are populated
		//if(((projectNameTextbox.getText() == "") == false)&&((manufacturerTextbox.getText() == "") == false)&&((modelTextbox.getText() == "") == false)) {
		if((projectNameTextbox.getText().isEmpty() == false)&&(manufacturerTextbox.getText().isEmpty() == false)&&(modelTextbox.getText().isEmpty() == false)){
			//Adds the data taken from the user to the List
			Car.add(new Car(projectName, manufacturer, model, chassisCode, modelYear));
			
			//SQL Stuff
			
			//Changes Scene
			Stage stage = (Stage)nextButton.getScene().getWindow();
			Scene selectProjectScene = new Scene(FXMLLoader.load(getClass().getResource("ProjectView.fxml")));
			stage.setScene(selectProjectScene);
		}
		else {
			//Changes the text of the Required Labels
			projectNameLabel.setText("*Project Name");
			manufacturerLabel.setText("*Manufacturer");
			modelLabel.setText("*Model");
			
			//Changes the color of the Required Labels
			projectNameLabel.setTextFill(javafx.scene.paint.Color.RED);
			manufacturerLabel.setTextFill(javafx.scene.paint.Color.RED);
			modelLabel.setTextFill(javafx.scene.paint.Color.RED);
			
			//Displays the warning
			warningLabel.setVisible(true);
			dismissButton.setVisible(true);
		}
	}
	
	//Flashes the warning label while it's visible
	@FXML
	private void flashWarning() {
		while(warningLabel.isVisible() == true) {
			//Checks if the Label is Red
			if(warningLabel.getTextFill() == javafx.scene.paint.Color.RED) {
				//Set the Label color to Yellow
				warningLabel.setTextFill(javafx.scene.paint.Color.YELLOW);
				//Makes the function temporarily sleep so is does not cause epileptic flashing
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//Checks if the Label is Yellow
			if(warningLabel.getTextFill() == javafx.scene.paint.Color.YELLOW) {
				//Set the Label Color to Red
				warningLabel.setTextFill(javafx.scene.paint.Color.RED);
				//Makes the function temporarily sleep so is does not cause epileptic flashing
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//Hides the warning and button until necessary
	@FXML
	private void dismissWarning() {
		warningLabel.setVisible(false);
		dismissButton.setVisible(false);
	}
	
	@FXML
	private void backToSelection() throws IOException {
		Stage stage = (Stage)backButton.getScene().getWindow();
		Scene selectProjectScene = new Scene(FXMLLoader.load(getClass().getResource("SelectProject.fxml")));
		stage.setScene(selectProjectScene);
	}
	
}