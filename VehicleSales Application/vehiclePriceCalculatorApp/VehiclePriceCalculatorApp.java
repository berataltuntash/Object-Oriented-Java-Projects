package vechilePriceCalculatorApp;

import vehiclePriceCalculator.ProgramExecuter;

public class VehiclePriceCalculatorApp {
	
	public static void main(String[] args) {
		String paths = "\\HW2_SoldVehicles.csv";
		ProgramExecuter executer = new ProgramExecuter(paths); //passing the path to the executer to start entire program
		executer.start();	
	}
}
