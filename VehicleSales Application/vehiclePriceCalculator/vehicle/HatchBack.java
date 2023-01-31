package vehiclePriceCalculator.vehicle;

import vehiclePriceCalculator.vehicle.Automobile;

public class HatchBack extends Automobile {
	private String type;
	private String cityMode;
	private double sct;
	private double total;
	public HatchBack() {
		super();
		this.cityMode = "";
		this.type = "HatchBack";
	}

	public HatchBack(String vehicleId, String monthOfSale, String cityOfSale, int productionYear, String cityMode,
			double engineVolume, int VAT) {
		super(vehicleId, monthOfSale, cityOfSale, productionYear, VAT, engineVolume);
		if (!this.nullChecker(cityMode)) {
			this.cityMode = cityMode;
		} else {
			this.cityMode = "";
		}
		this.type = "HatchBack";
		this.calculateSct();
		this.calculateTotal();
	}
	
	public double getTotal() {
		return this.total;
	}
	public String getCityMode() {
		return this.cityMode;
	}
	public double getSct() {
		return this.sct;
	}
	public String getVehicleType() {
		return this.type;
	}
	
	private boolean nullChecker(String _cityMode) {
		return _cityMode == null;
	}
	
	public String toString() {
		return (
			"Vehicle: " + this.getVehicleType() +
			super.toString() + 
			"SCT: " + this.getSct() + "\n" +
			"The total price paid for " + this.getVehicleId() +
			" is: " + getTotal() + "TL"
		);
		
	}
	                                    /*Private methods for Calculation of SCT and Total Price for HatchBacks*/
	private double calculateCitySct() {
		double city = 0;
		switch(cityMode) {
			case "yes":
				city = 0.15f;
				break;
			case "no":
				city = 0.1f;
				break;
			default:
				System.exit(-1);
		}
		return city;
	}
	private void calculateSct() {
		double year = calculateProductionYearSct();
		double city = calculateCitySct();
		this.sct = (getEngineVolume() * 0.3 * year) + city;
	}
	private void calculateTotal() {
		total = (200000)*(1+ getSct()*0.8) + (1+ getVAT()/100);
	}
}
