package application;

import javafx.scene.control.TextArea;
import java.time.LocalDate;
import java.util.Observable;	
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
	int celebCount = 0;
	ObservableList<DeadCelebrity> deadCelebrities = FXCollections.observableArrayList();
	//private java.util.List<DeadCelebrity> deadCelebrities = new ArrayList<DeadCelebrity>();
	//ObservableList<DeadCelebrity> observableDeadCelebrities = FXCollections.observableArrayList(deadCelebrities);
	
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
	
	//Single-Line Text Fields
	@FXML
	private TextField firstNameText;
	@FXML
	private TextField lastNameText;
	@FXML
	private TextField birthMonthText;
	@FXML
	private TextField birthDayText;
	@FXML
	private TextField birthYearText;
	@FXML
	private TextField deathMonthText;
	@FXML
	private TextField deathDayText;
	@FXML
	private TextField deathYearText;
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
	
	//Check Boxes for Choosing Gender
	@FXML
	private CheckBox maleCheckBox;
	@FXML
	private CheckBox femaleCheckBox;
	
	//Buttons
	@FXML
	private Button addButton;
	@FXML
	private Button helpButton;
	@FXML
	private Button deleteButton;
	
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
		insertTab.setText("Celebrity Information");
		indexTab.setText("Celebrity Index");
		helpTab.setText("Help");
		//indexTable.setItems(observableDeadCelebrities);
		
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
	
		indexTable.setEditable(true);
		firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		occupationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		obituaryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		causeOfDeathColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		indexTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
	}
	
	//
	@FXML
	private void handleFirstName() {
		firstName = firstNameText.getText();
	}
	
	//
	@FXML
	private void handleLastName() {
		lastName = lastNameText.getText();
	}
	
	//
	@FXML
	private void handleBirth() {
		birthDate = birthDatePicker.getValue();
	}
	
	//
	@FXML
	private void handleDeath() {
		deathDate = deathDatePicker.getValue();
	}
	
	//
	@FXML
	private void handleOccupation() {
		occupation = occupationText.getText();
	}
	
	//
	@FXML
	private void handleHeightInFeet() {
		String heightFeetString = heightFeetText.getText();
		
		heightInFeet = Integer.parseInt(heightFeetString);
	}
	
	//
	@FXML
	private void handleHeightInInches() {
		String heightInchesString = heightInchesText.getText();
		
		heightInInches = Integer.parseInt(heightInchesString);
	}
	
	//
	@FXML
	private void handleWeight() {
		String weightString = weightText.getText();
		
		weight = Integer.parseInt(weightString);
	}
	//
	@FXML
	private void handleNetWorth() {
		String netWorthString = netWorthText.getText();
		
		netWorth = Double.parseDouble(netWorthString);
	}
	
	//
	@FXML
	private void handleCauseOfDeath() {
		causeOfDeath = causeOfDeathText.getText();
	}
	
	//
	@FXML
	private void handleObituary() {
		obituary = obituaryText.getText();
	}
	
	//Sets the Celebrity's Gender to Male
	@FXML
	private void handleMaleCheck() {
		isMale = maleCheckBox.isSelected();
	}
	
	//
	@FXML
	private void handleWaistSize() {
		String waistSizeString = waistSizeText.getText();
		waistSize = Double.parseDouble(waistSizeString);
	}
	
	//Adds A Celebrity to the Index via 'New Celebrity' Tab
	@FXML
	private void newCelebrity() {
		
	if(heightInFeet > 0) {
		
		/*DeadCelebrity newDeadCelebrity = new DeadCelebrity(firstName, lastName,
				birthDate, deathDate, occupation, obituary, causeOfDeath,
				netWorth, waistSize, heightInFeet, heightInInches, weight, isMale);
				*/
		
		deadCelebrities.add(celebCount, new DeadCelebrity(firstName, lastName,
				birthDate, deathDate, occupation, obituary, causeOfDeath,
				netWorth, waistSize, heightInFeet, heightInInches, weight, isMale));
		indexTable.setItems(deadCelebrities);
		celebCount++;
		
		firstNameText.setText("");
		lastNameText.setText("");
		birthDatePicker.setValue(LocalDate.of(0, 0, 0));
		deathDatePicker.setValue(LocalDate.of(0, 0, 0));
		occupationText.setText("");
		heightFeetText.setText("");
		heightInchesText.setText("");
		weightText.setText("");
		maleCheckBox.setSelected(false);
		netWorthText.setText("");
		causeOfDeathText.setText("");
		obituaryText.setText("");
		
		firstName = "";
		lastName = "";
		occupation = "";
		obituary = "";
		causeOfDeath = "";
		netWorth = 0;
		waistSize = 0;
		heightInFeet = -10;
		heightInInches = 0;
		weight = 0;
		isMale = false;
		}
	else {
		
		}
	}
	
	//Moves to the "Help" Tab when the "Help" button is clicked
	@FXML
	private void windowAssist() {
		tabPane.getSelectionModel().select(helpTab);
	}
	
	//
	@FXML
	private void handleChangeFirstName(CellEditEvent edittedCell) {
		DeadCelebrity selectedCelbrity = indexTable.getSelectionModel().getSelectedItem();
		selectedCelbrity.setFirstName(edittedCell.getNewValue().toString());
	}
	
	//
	@FXML
	private void handleChangeLastName(CellEditEvent edittedCell) {
		DeadCelebrity selectedCelebrity = indexTable.getSelectionModel().getSelectedItem();
		selectedCelebrity.setLastName(edittedCell.getNewValue().toString());
	}
	
	//
	@FXML
	private void handleChangeOccupation(CellEditEvent edittedCell) {
		DeadCelebrity selectedCelebrity = indexTable.getSelectionModel().getSelectedItem();
		selectedCelebrity.setOccupation(edittedCell.getNewValue().toString());
	}
	
	//
	@FXML
	private void handleChangeObituary(CellEditEvent edittedCell) {
		DeadCelebrity selectedCelebrity = indexTable.getSelectionModel().getSelectedItem();
		selectedCelebrity.setObituary(edittedCell.getNewValue().toString());	
	}
	
	//
	@FXML
	private void handleChangeCauseOfDeath(CellEditEvent edittedCell) {
		DeadCelebrity selectedCelebrity = indexTable.getSelectionModel().getSelectedItem();
		selectedCelebrity.setCauseOfDeath(edittedCell.getNewValue().toString());
	}
	
	//
	@FXML
	private void handleChangeNetWorth(CellEditEvent edittedCell) {
		DeadCelebrity selectedCelebrity = indexTable.getSelectionModel().getSelectedItem();
		selectedCelebrity.setNetWorth(Double.parseDouble(edittedCell.getNewValue().toString()));
	}
	
	//
	@FXML
	private void handleChangeWaistSize(CellEditEvent edittedCell) {
		DeadCelebrity selectedCelebrity = indexTable.getSelectionModel().getSelectedItem();
		selectedCelebrity.setWaistSize(Double.parseDouble(edittedCell.getNewValue().toString()));
	}
	
	//
	@FXML
	private void handleChangeHeightInFeet(CellEditEvent edittedCell) {
		DeadCelebrity selectedCelebrity = indexTable.getSelectionModel().getSelectedItem();
		selectedCelebrity.setHeightInFeet(Integer.parseInt(edittedCell.getNewValue().toString()));
	}
	
	//
	@FXML
	private void handleChangeHeightInInches(CellEditEvent edittedCell) {
		DeadCelebrity selectedCelebrity = indexTable.getSelectionModel().getSelectedItem();
		selectedCelebrity.setHeightInInches(Integer.parseInt(edittedCell.getNewValue().toString()));
	}
	
	//
	@FXML
	private void handleChangeWeight(CellEditEvent edittedCell) {
		DeadCelebrity selectedCelebrity = indexTable.getSelectionModel().getSelectedItem();
		selectedCelebrity.setWeight(Integer.parseInt(edittedCell.getNewValue().toString())); 
	}
	
	//
	@FXML
	private void handleChangeIsMale(CellEditEvent edittedCell) {
		DeadCelebrity selectedCelebrity = indexTable.getSelectionModel().getSelectedItem();
		selectedCelebrity.setIsMale(Boolean.parseBoolean(edittedCell.getNewValue().toString()));
	}
	
	public ObservableList<DeadCelebrity> getDeadCelebrities(){
		ObservableList<DeadCelebrity> deadCelebrities = FXCollections.observableArrayList();
		return deadCelebrities;
	}
	
	
	//
	@FXML
	public void deleteRowsButton() {
		ObservableList<DeadCelebrity> selectedRows, completeIndex;
		completeIndex = indexTable.getItems();
		
		selectedRows = indexTable.getSelectionModel().getSelectedItems();
		
		for(DeadCelebrity deadCelebrities : selectedRows) {
			completeIndex.remove(deadCelebrities);
		}
	}

}
