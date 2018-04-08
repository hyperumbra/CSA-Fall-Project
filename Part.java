package application;

public class Part {

	//Fields
	String partType;
	String partName;
	String brandName;
	String itemID;
	String material;
	String price;
	
	//Default Constructor
	Part(){
		partType = "";
		partName = "";
		brandName = "";
		itemID = "";
		material = "";
		price = "";
	}
	
	//Full Constructor
	Part(String partType, String partName, String brandName, String itemID, String material, String price){
		this.partType = partType;
		this.partName = partName;
		this.brandName = brandName;
		this.itemID = itemID;
		this.material = material;
		this.price = price;
	}

	public String getPartType() {
		return partType;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}