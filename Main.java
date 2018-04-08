package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private Stage primaryStage;
	private AnchorPane selectProject;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//Set main application and provide title and an icon
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Project Car Designer");
			//this.primaryStage.getIcons().add(new Image(""));
			
			
			indexLayout();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Single call to the JavaFX Launch method with arguments from system launch
	public static void main(String[] args) {
		launch(args);
	}
	
	public void indexLayout() {
		try {
			//Create an FXML Loader object to load our scene builder file
			FXMLLoader loader = new FXMLLoader();
			
			//Point the loader at the FXML file
			loader.setLocation(Main.class.getResource("/application/ProjectView.fxml"));
			
			//Set the Pane layout field
			selectProject = (AnchorPane) loader.load();
			
			//Set the scene object
			Scene scene = new Scene(selectProject);
			
			//Apply CSS styling to the scene
			//scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
			
			//Giving the controller access to the main program
			//SelectProjectController controller = loader.getController();
			ProjectViewController controller = loader.getController();
			
			//Put the scene onto the stage
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}