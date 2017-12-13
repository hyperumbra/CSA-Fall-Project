package application;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

public class DeadCelebrity {
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private LocalDate deathDate;
	private String occupation;
	private String obituary;
	private String causeOfDeath;
	private double netWorth;
	private double waistSize;
	private int heightInFeet;
	private int heightInInches;
	private int weight;
	private boolean isMale;
	
	
	//Default Constructor
	public DeadCelebrity() {
		firstName = "";
		lastName = "";
		birthDate = LocalDate.of(0, 0, 0);
		deathDate = LocalDate.of(0, 0, 0);
		occupation = "";
		obituary = "";
		causeOfDeath = "";
		netWorth = 0;
		waistSize = 0;
		heightInFeet = 0;
		heightInInches = 0;
		weight = 0;
		isMale = false;
	}
	 	
	//Full Constructor
	public DeadCelebrity(String firstName, String lastName, LocalDate birthDate,
						   LocalDate deathDate, String occupation, 
						   String obituary, String causeOfDeath, double netWorth,
						   Double waistSize, int heightInFeet, int heightInInches, 
						   int weight, boolean isMale) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.deathDate = deathDate;
		this.occupation = occupation;
		this.obituary = obituary;
		this.causeOfDeath = causeOfDeath;
		this.netWorth = netWorth;
		this.waistSize = waistSize;
		this.heightInFeet = heightInFeet;
		this.heightInInches = heightInInches;
		this.weight = weight;
		this.isMale = isMale;
	}

	//Getters & Setters
	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(LocalDate deathDate) {
		this.deathDate = deathDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getObituary() {
		return obituary;
	}

	public void setObituary(String obituary) {
		this.obituary = obituary;
	}

	public String getCauseOfDeath() {
		return causeOfDeath;
	}

	public void setCauseOfDeath(String causeOfDeath) {
		this.causeOfDeath = causeOfDeath;
	}

	public double getNetWorth() {
		return netWorth;
	}

	public void setNetWorth(double netWorth) {
		this.netWorth = netWorth;
	}
	
	public double getWaistSize() {
		return waistSize;
	}
	
	public void setWaistSize(double waistSize) {
		this.waistSize = waistSize;
	}

	public int getHeightInFeet() {
		return heightInFeet;
	}

	public void setHeightInFeet(int height) {
		this.heightInFeet = heightInFeet;
	}
	
	public int getHeightInInches() {
		return heightInInches;
	}
	
	public void setHeightInInches(int heightInInches) {
		this.heightInInches = heightInInches;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean getIsMale() {
		return isMale;
	}

	public void setIsMale(boolean isMale) {
		this.isMale = isMale;
	}
	

}