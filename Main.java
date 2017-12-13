/*	Joshua Donegal
 * 	Period 2
 * 	Pset 3-5
 * 	Phase 2
 */
package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private Stage primaryStage;
	private AnchorPane guiLayout;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//Set main application and provide title and an icon
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Dead Celebrities Database");
			this.primaryStage.getIcons().add(new Image("file:resources/wallhaven-273142.jpg"));
			
			
			initPhaseTwoLayout();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Single call to the JavaFX Launch method with arguments from system launch
	public static void main(String[] args) {
		launch(args);
	}
	
	public void initPhaseTwoLayout() {
		try {
			//Create an FXML Loader object to load our scene builder file
			FXMLLoader loader = new FXMLLoader();
			
			//Point the loader at the FXML file
			loader.setLocation(Main.class.getResource("/application/GUI.fxml"));
			
			//Set the Pane layout field
			guiLayout = (AnchorPane) loader.load();
			
			//Set the scene object
			Scene scene = new Scene(guiLayout);
			
			//Apply CSS styling to the scene
			scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
			
			//Giving the controller access to the main program
			GuiController controller = loader.getController();
			
			//Put the scene onto the stage
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
