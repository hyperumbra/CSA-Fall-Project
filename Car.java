package application;

public class Car {

	private String projectName;
	private String manufacturer;
	private String model;
	private String chassisCode;
	private int modelYear;
	
	//Full Constructor
	public Car(String projectName, String manufacturer, String model, String chassisCode, int modelYear) {
		this.projectName = projectName;
		this.manufacturer = manufacturer;
		this.model = model;
		this.chassisCode = chassisCode;
		this.modelYear = modelYear;
	}
	
	//Default Constructor
	public Car() {
		projectName = "";
		manufacturer = "";
		model = "";
		chassisCode = "";
		modelYear = 0;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getChassisCode() {
		return chassisCode;
	}

	public void setChassisCode(String chassisCode) {
		this.chassisCode = chassisCode;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	
	
}