package application;

import javafx.scene.control.TextArea;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn.CellEditEvent;

public class GuiController {

	private Main mainApp;
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	//Constructor
	public GuiController() {
		
	}
	
	//Variables used in the GUI
	String firstName;
	String lastName;
	String occupation;
	String obituary;
	String causeOfDeath;
	LocalDate birthDate;
	LocalDate deathDate;
	double waistSize;
	double netWorth;
	int heightInFeet = -10;
	int heightInInches;
	int weight;
	boolean isMale = false;
	
	//Creates a list of Celebrities that can be modified by the user in the GUI
	ObservableList<DeadCelebrity> deadCelebrities = FXCollections.observableArrayList();
	
	//Creating an number that indexes the list of Celebrities
	int celebCount = 0;

	
	//Fields for the scene
	//TabPane
	@FXML
	private TabPane tabPane;
	
	//Tabs
	@FXML
	private Tab insertTab;
	@FXML
	private Tab indexTab;
	@FXML
	private Tab helpTab;
	
	//Labels
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label dobLabel;
	@FXML
	private Label dodLabel;
	@FXML
	private Label occupationLabel;
	@FXML
	private Label heightLabel;
	@FXML
	private Label weightLabel;
	@FXML
	private Label genderLabel;
	@FXML
	private Label netWorthLabel;
	@FXML
	private Label causeOfDeathLabel;
	@FXML
	private Label obituaryLabel;
	@FXML
	private Label picturePathLabel;
	@FXML
	private Label waistSizeLabel;
	@FXML
	private Label helpLabel1;
	@FXML
	private Label helpLabel2;
	@FXML
	private Label helpLabel3;
	@FXML
	private Label helpLabel4;
	@FXML
	private Label warningLabel;
	
	//Single-Line Text Fields
	@FXML
	private TextField firstNameText;
	@FXML
	private TextField lastNameText;
	@FXML
	private TextField occupationText;
	@FXML
	private TextField heightFeetText;
	@FXML
	private TextField heightInchesText;
	@FXML
	private TextField weightText;
	@FXML
	private TextField netWorthText;
	@FXML
	private TextField causeOfDeathText;
	@FXML
	private TextField picturePathText;
	@FXML
	private TextField waistSizeText;
	
	//Multiple Lines of Text/Text Area
	@FXML
	private TextArea obituaryText;
	
	//Check Boxes for Determining if the Celebrity is Male or not
	@FXML
	private CheckBox maleCheckBox;
	
	//Buttons
	@FXML
	private Button addButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button dummyAddButton;
	@FXML
	private Button dummyDeleteButton;
	@FXML
	private Button dismissButton;
	
	//Date Pickers
	@FXML
	private DatePicker birthDatePicker;
	@FXML
	private DatePicker deathDatePicker;
	
	//Table of Data on Celebrities
	@FXML
	private TableView<DeadCelebrity> indexTable;
	
	//Columns of the Table
	@FXML
	private TableColumn<DeadCelebrity, String> firstNameColumn;
	@FXML
	private TableColumn<DeadCelebrity, String> lastNameColumn;
	@FXML
	private TableColumn<DeadCelebrity, LocalDate> birthColumn;
	@FXML
	private TableColumn<DeadCelebrity, LocalDate> deathColumn;
	@FXML
	private TableColumn<DeadCelebrity, String> occupationColumn;
	@FXML
	private TableColumn<DeadCelebrity, String> obituaryColumn;
	@FXML
	private TableColumn<DeadCelebrity, String> causeOfDeathColumn;
	@FXML
	private TableColumn<DeadCelebrity, Double> moneyColumn;
	@FXML
	private TableColumn<DeadCelebrity, Double> waistColumn;
	@FXML
	private TableColumn<DeadCelebrity, Integer> heightInFeetColumn;
	@FXML
	private TableColumn<DeadCelebrity, Integer> heightInInchesColumn;
	@FXML
	private TableColumn<DeadCelebrity, Integer> weightColumn;
	@FXML
	private TableColumn<DeadCelebrity, Boolean> genderColumn;
	
	//Initializing the GUI
	@FXML
	private void initialize() {
		//Sets the text displayed on the tabs at the top of the screen
		insertTab.setText("Celebrity Information");
		indexTab.setText("Celebrity Index");
		helpTab.setText("Help");
		
		//Sets a warning for the user to be invisible until necessary
		warningLabel.setVisible(false);
		dismissButton.setVisible(false);
		
		//Sets the data that each column receives from the each Celebrity in the Observable List
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<DeadCelebrity, String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<DeadCelebrity, String>("lastName"));
		birthColumn.setCellValueFactory(new PropertyValueFactory<DeadCelebrity, LocalDate>("birthDate"));
		deathColumn.setCellValueFactory(new PropertyValueFactory<DeadCelebrity, LocalDate>("deathDate"));
		occupationColumn.setCellValueFactory(new PropertyValueFactory<DeadCelebrity, String>("occupation"));
		obituaryColumn.setCellValueFactory(new PropertyValueFactory<DeadCelebrity, String>("obituary"));
		causeOfDeathColumn.setCellValueFactory(new PropertyValueFactory<DeadCelebrity, String>("causeOfDeath"));
		moneyColumn.setCellValueFactory(new PropertyValueFactory<DeadCelebrity, Double>("netWorth"));
		waistColumn.setCellValueFactory(new PropertyValueFactory<DeadCelebrity, Double>("waistSize"));
		heightInFeetColumn.setCellValueFactory(new PropertyValueFactory<DeadCelebrity, Integer>("heightInFeet"));
		heightInInchesColumn.setCellValueFactory(new PropertyValueFactory<DeadCelebrity, Integer>("heightInInches"));
		weightColumn.setCellValueFactory(new PropertyValueFactory<DeadCelebrity, Integer>("weight"));
		genderColumn.setCellValueFactory(new PropertyValueFactory<DeadCelebrity, Boolean>("isMale"));
	
		//Allows the Index to be editable
		indexTable.setEditable(true);
		
		//Allows specific columns within the Index to be editted by users
		firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		occupationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		obituaryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		causeOfDeathColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		//Allows users to have multiple rows of entries in the Index selected at once
		indexTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
	}
	
	//Stores the First Name of the Celebrity from the text field to a local variable
	@FXML
	private void handleFirstName() {
		firstName = firstNameText.getText();
	}
	
	//Stores the last Name of the Celebrity from the text field to a local variable
	@FXML
	private void handleLastName() {
		lastName = lastNameText.getText();
	}
	
	//Stores the Date of Birth of the Celebrity from the text field to a local variable
	@FXML
	private void handleBirth() {
		birthDate = birthDatePicker.getValue();
	}
	
	//Stores the Date of Death of the Celebrity from the text field to a local variable
	@FXML
	private void handleDeath() {
		deathDate = deathDatePicker.getValue();
	}
	
	//Stores the Occupation of the Celebrity from the text field to a local variable
	@FXML
	private void handleOccupation() {
		occupation = occupationText.getText();
	}
	
	//Stores the Height (ft) of the Celebrity from the text field to a local variable
	@FXML
	private void handleHeightInFeet() {
		String heightFeetString = heightFeetText.getText();
		//Converts the text from the local variable into a number
		heightInFeet = Integer.parseInt(heightFeetString);
	}
	
	//Stores the Height (in) of the Celebrity from the text field to a local variable
	@FXML
	private void handleHeightInInches() {
		String heightInchesString = heightInchesText.getText();
		//Converts the text from the local variable into a number
		heightInInches = Integer.parseInt(heightInchesString);
	}
	
	//Stores the Weight (lbs) of the Celebrity from the text field to a local variable
	@FXML
	private void handleWeight() {
		String weightString = weightText.getText();
		//Converts the text from the local variable into a number
		weight = Integer.parseInt(weightString);
	}
	
	//Stores the Net Worth ($) of the Celebrity from the text field to a local variable
	@FXML
	private void handleNetWorth() {
		String netWorthString = netWorthText.getText();
		//Converts the text from the local variable into a number
		netWorth = Double.parseDouble(netWorthString);
	}
	
	//Stores the Cause of Death of the Celebrity from the text field to a local variable
	@FXML
	private void handleCauseOfDeath() {
		causeOfDeath = causeOfDeathText.getText();
	}
	
	//Stores the Obituary of the Celebrity from the text field to a local variable
	@FXML
	private void handleObituary() {
		obituary = obituaryText.getText();
	}
	
	//Determines whether the Celebrity is Male or Female
	@FXML
	private void handleMaleCheck() {
		isMale = maleCheckBox.isSelected();
	}
	
	//Stores the Waist Size of the Celebrity from the text field to a local variable
	@FXML
	private void handleWaistSize() {
		String waistSizeString = waistSizeText.getText();
		//Converts the text from the local variable into a number
		waistSize = Double.parseDouble(waistSizeString);
	}
	
	//Adds A Celebrity to the Index via 'New Celebrity' Tab
	@FXML
	private void newCelebrity() {
		
	//Checks if First Name, Last Name, Cause of Death, and Height are input
	if(((firstNameText.getText() == "") == true)&&((lastNameText.getText() == "") == true)&&((causeOfDeathText.getText() == "") == true)
			&&((Integer.parseInt(heightFeetText.getText()) >= 0))&&((Integer.parseInt(heightInchesText.getText())) >= 0)) {
		
		//Adds the data taken from the user and adds it to the Observable List for the Celebrities
		deadCelebrities.add(celebCount, new DeadCelebrity(firstName, lastName,
				birthDate, deathDate, occupation, obituary, causeOfDeath,
				netWorth, waistSize, heightInFeet, heightInInches, weight, isMale));
		//Adds the newest entry from the List to the Index
		indexTable.setItems(deadCelebrities);
		//Moves the data to the next indexing
		celebCount++;
		
		//Resets the values within the table after data has been stored
		firstNameText.setText("");
		lastNameText.setText("");
		birthDatePicker.setValue(LocalDate.of(18, 10, 1999));
		deathDatePicker.setValue(LocalDate.of(12, 31, 3000));
		occupationText.setText("");
		heightFeetText.setText("");
		heightInchesText.setText("");
		weightText.setText("");
		maleCheckBox.setSelected(false);
		netWorthText.setText("");
		causeOfDeathText.setText("");
		obituaryText.setText("");
		
		//Resets the local variables back to their default values
		firstName = "";
		lastName = "";
		occupation = "";
		obituary = "";
		causeOfDeath = "";
		netWorth = 0;
		waistSize = 0;
		heightInFeet = -1;
		heightInInches = -1;
		weight = 0;
		isMale = false;
		}
	
	//If the user does not enter the required fields
	else {
			//Displays the warning and the button to dismiss the warning
			warningLabel.setVisible(true);
			dismissButton.setVisible(true);
		}
	}
	
	//Hides the warning and the button until necessary
	@FXML
	private void dismissWarning() {
		warningLabel.setVisible(false);
		dismissButton.setVisible(false);
	}
	
	//Updates the data of the First Name entry in the Index 
	@FXML
	private void handleChangeFirstName(CellEditEvent edittedCell) {
		//Gets the value of the updated entry
		DeadCelebrity selectedCelbrity = indexTable.getSelectionModel().getSelectedItem();
		//Sets the value within the entry to the updated value
		selectedCelbrity.setFirstName(edittedCell.getNewValue().toString());
	}
	
	//Updates the data of the Last Name entry in the Index 
	@FXML
	private void handleChangeLastName(CellEditEvent edittedCell) {
		//Gets the value of the updated entry
		DeadCelebrity selectedCelebrity = indexTable.getSelectionModel().getSelectedItem();
		//Sets the value within the entry to the updated value
		selectedCelebrity.setLastName(edittedCell.getNewValue().toString());
	}
	
	//Updates the data of the Occupation entry in the Index 
	@FXML
	private void handleChangeOccupation(CellEditEvent edittedCell) {
		//Gets the value of the updated entry
		DeadCelebrity selectedCelebrity = indexTable.getSelectionModel().getSelectedItem();
		//Sets the value within the entry to the updated value
		selectedCelebrity.setOccupation(edittedCell.getNewValue().toString());
	}
	
	//Updates the data of the Obituary entry in the Index 
	@FXML
	private void handleChangeObituary(CellEditEvent edittedCell) {
		//Gets the value of the updated entry
		DeadCelebrity selectedCelebrity = indexTable.getSelectionModel().getSelectedItem();
		//Sets the value within the entry to the updated value
		selectedCelebrity.setObituary(edittedCell.getNewValue().toString());	
	}
	
	//Updates the data of the Cause of Death entry in the Index 
	@FXML
	private void handleChangeCauseOfDeath(CellEditEvent edittedCell) {
		//Gets the value of the updated entry
		DeadCelebrity selectedCelebrity = indexTable.getSelectionModel().getSelectedItem();
		//Sets the value within the entry to the updated value
		selectedCelebrity.setCauseOfDeath(edittedCell.getNewValue().toString());
	}
	
	//Allows the deletion of one or more row(s) of entries in the Index
	@FXML
	public void deleteRowsButton() {
		//Creates new Lists for the entries selected and the entire Index
		ObservableList<DeadCelebrity> selectedRows, completeIndex;
		//Makes the temporary Index have all of the values of the actual Index
		completeIndex = indexTable.getItems();
		//Gets the highlighted entries and puts them into a temporary List
		selectedRows = indexTable.getSelectionModel().getSelectedItems();
		//Deletes the entries from the List and the Index
		for(DeadCelebrity deadCelebrities : selectedRows) {
			completeIndex.remove(deadCelebrities);
		}
	
	}

}