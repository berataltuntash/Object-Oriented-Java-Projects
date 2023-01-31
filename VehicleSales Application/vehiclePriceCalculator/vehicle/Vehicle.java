package vehiclePriceCalculator.vehicle;

public class Vehicle {
	private String vehicleId;
	private String monthOfSale;
	private String cityOfSale;
	private int productionYear;
	private int VAT;

	// Instance Variables that got carried up in the inheritance hierarchy
	private double sct;
	private double total;


	public Vehicle() {
		this("", "","",0,0);
	}
	public Vehicle(String vehicleId, String monthOfSale, String cityOfSale, int productionYear, int VAT) {
		if(!nullChecker(vehicleId, monthOfSale, cityOfSale)) {	
			this.vehicleId = vehicleId;
			this.monthOfSale = monthOfSale;
			this.cityOfSale = cityOfSale;
			this.productionYear = productionYear;
			this.VAT = VAT;
		}else {
			this.vehicleId = "";
			this.monthOfSale = "";
			this.cityOfSale = "";
			this.productionYear = 0;
			this.VAT = 0;
		}
	}
	public Vehicle(Vehicle _vehicle) {
		if (!this.nullChecker(_vehicle)) {
			this.vehicleId = _vehicle.vehicleId;
			this.monthOfSale = _vehicle.monthOfSale;
			this.cityOfSale = _vehicle.cityOfSale;
			this.productionYear = _vehicle.productionYear;
			this.VAT = _vehicle.VAT;
		}
	}
	public String getVehicleId() {
		return this.vehicleId;
	}
	public String getMonthOfSale() {
		return this.monthOfSale;
	}
	public String getCityOfSale() {
		return this.cityOfSale;
	}
	public int getProductionYear() {
		return this.productionYear;
	}
	public int getVAT() {
		return this.VAT;
	}
	
	//protected method for Production Year Calculation
	protected double calculateProductionYearSct() {
		double calculatedSctValue = 0;
		if ((this.productionYear>=2001)&&(this.productionYear<=2008)){
			calculatedSctValue = 1;
		}else if((this.productionYear>=2012)&&(this.productionYear<=2017)) {
			calculatedSctValue = 1.2;
		}else if((this.productionYear>=2018)&&(this.productionYear<=2022)) {
			calculatedSctValue = 1.6;
		}
		return calculatedSctValue;
	}
	
	private boolean nullChecker(Vehicle _vehicle) {
		return (_vehicle == null);
	}
	private boolean nullChecker(String vehicleId, String monthOfSale, String cityOfSale) {
		return (vehicleId == null 
				|| monthOfSale == null 
				|| cityOfSale == null);
	}

	public String toString() {
		return (
			" Vehicle ID: " + this.getVehicleId() +
			" Month: " + this.getMonthOfSale() +
			" City: " + this.getCityOfSale() +
			" Production Year: " + this.getProductionYear()
		);
	}
	


	
}
