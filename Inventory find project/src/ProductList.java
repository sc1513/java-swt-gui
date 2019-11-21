package itemlist;

public class ProductList {
	
	// Create variables of type string
	protected String UPC;
	protected String Style;
	protected String Description;
	protected String color;
	protected String Size;
	protected String itemFound;
	
	// Constructor to auto set values
	public ProductList () {
		UPC = "0";
		Style = "Style";
		Description = "Description";
		color = "0";
		Size = "No Size";
		itemFound = "No";
		
	}
	
	// set and get values for each protected variable above, except itemFound
	public void setUPC (String a) {
		UPC = a;
	}
	public String getUPC() {
		return UPC;
	}
	
	public void setColor (String a) {
		color = a;
	}	
	public String getColor () {
		return color;
	}
	
	public void setStyle (String s) {
		Style = s;
	}
	public String getStyle () {
		return Style;
	}
	public void setDescription (String s) {
		Description = s;
	}
	public String getDescription () {
		return Description;
	}
	public void setSize (String s) {
		Size = s;
	}
	public String getSize () {
		return Size;
	}
	public void setitemFound (String s) {
		itemFound = s;
	}
	public String getitemFound () {
		return itemFound;
	}
	
	
}
