package vehiclePriceCalculator;

import InputOutput.FileIO;
import InputOutput.KeyboardIO;
import vehiclePriceCalculator.vehicle.Vehicle;

public class ProgramExecuter {
    private String path;
    private SalesRecord salesRecord;
    private boolean exit; 
    
    public ProgramExecuter(){
        this.path = "";
        this.exit = false;
    }
    public ProgramExecuter(String _path){
        this.path = _path;
        this.exit = false;
    }
    
    //Starts the file reading and user input
    public void start(){
        this.readVehicleCSV();
        this.inputHandler(); // need to fill this method btw
        
    }
    //initializes csv reading
    public void readVehicleCSV() {
        FileIO fileReader = new FileIO();
        salesRecord = new SalesRecord(fileReader.readCsvFile(this.path)); 

    }


    /* input handler recursively creates KeyboardIO objects and displays/ exits/ re-asks for input if the input is invalid,
     * For each time inputHandler calls the necessary methods, or doesn't if the option is invalid or the user wants to exit
     */
    public void inputHandler(){
        
        while (exit == false) {
        	KeyboardIO keyReader = new KeyboardIO();
            String inputKey = keyReader.readUserInput();
        	switch (inputKey) {
            case "q":
                System.out.println("You have decided to exit the program. Thank you for using it! GoodBye!");
                exit = true;
                System.exit(-1);
                break;
            case "1": // Calling the responsible method for sold vehicle list
                for (Vehicle eachVehicle : this.salesRecord.getVehicles()) {
                    System.out.println(eachVehicle.toString());
                }
                
                break;
            case "2": // Call the responsible method for sold sedan list
            	for (Vehicle eachVehicle :this.salesRecord.getVehicles("Sedan")) {
            		System.out.println(eachVehicle.toString());
            	}
                
                
                break;
            case "3":  // Call the responsible method for sold hatchback list
            	for (Vehicle eachVehicle :this.salesRecord.getVehicles("HatchBack")) {
            		System.out.println(eachVehicle.toString());
            	}
               
                
                break;
            case "4": // Call the responsible method for sold minivan list
            	for (Vehicle eachVehicle :this.salesRecord.getVehicles("Minivan")) {
            		System.out.println(eachVehicle.toString());
            	}
               
                
                break;
            case "5": // Call the responsible method for sold pickup track list
            	for (Vehicle eachVehicle :this.salesRecord.getVehicles("PickupTruck")) {
            		System.out.println(eachVehicle.toString());
            	}
                
                
                break;
            case "6":  // Call the responsible method for sold bicycle list
            	for (Vehicle eachVehicle :this.salesRecord.getVehicles("Bicycle")) {
            		System.out.println(eachVehicle.toString());
            	}
                
                
                break;

            default:  //For invalid inputs
                System.out.println("Unfortunately the option " + inputKey + " is not a valid option");
                break;
        }
        }
        
    }
}