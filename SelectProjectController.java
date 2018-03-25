package application;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;

public class SelectProjectController {

	private Main mainApp;
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	//Constructor
	public SelectProjectController() {
		
	}
	
	//Fields and Controls for the Scene
	//Buttons
	@FXML
	private Button selectButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button newButton;
	//ListView
	@FXML
	private ListView<Car>projectSelectListView;
	
}
