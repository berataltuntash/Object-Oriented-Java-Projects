package vehiclePriceCalculator;

import java.util.ArrayList;
import java.util.StringTokenizer;

import vehiclePriceCalculator.vehicle.Automobile;
import vehiclePriceCalculator.vehicle.Bicycle;
import vehiclePriceCalculator.vehicle.HatchBack;
import vehiclePriceCalculator.vehicle.Minivan;
import vehiclePriceCalculator.vehicle.PickupTruck;
import vehiclePriceCalculator.vehicle.Sedan;
import vehiclePriceCalculator.vehicle.Vehicle;

public class SalesRecord {
    private ArrayList<Vehicle> storageArray = new ArrayList<>();
    private String[] inputVehicles;

    public SalesRecord() {
        this.inputVehicles = null;
    }

    public SalesRecord(String[] _inputVehicles) {
        this.inputVehicles = _inputVehicles;
        this.arrayListConverter();
    }

    public SalesRecord(SalesRecord _salesRecord) {
        this.inputVehicles = _salesRecord.inputVehicles;
        this.arrayListConverter();
    }
    
    // Private method for conversion from String array input to arrayList
    private void arrayListConverter() {
        for (String vehicle : this.inputVehicles) {
        	if (vehicle != null) {
        		char firstLetter = vehicle.charAt(0);
                StringTokenizer st = new StringTokenizer(vehicle, ",");
            	switch(firstLetter) {
            		case 'B':
            			storageArray.add((Vehicle) new Bicycle(st.nextToken(),st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken())));
            			break;
            		case 'P':
            			storageArray.add((Vehicle)new PickupTruck(st.nextToken(),st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken())));
            			break;
            		case 'S':
            			storageArray.add((Vehicle)new Sedan(st.nextToken(),st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),st.nextToken(),Double.parseDouble(st.nextToken()),Integer.parseInt(st.nextToken())));
            			break;
            		case 'M':
            			storageArray.add((Vehicle)new Minivan(st.nextToken(),st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Double.parseDouble(st.nextToken()),Integer.parseInt(st.nextToken())));
            			break;
            		case 'H':
            			storageArray.add((Vehicle)new HatchBack(st.nextToken(),st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),st.nextToken(),Double.parseDouble(st.nextToken()),Integer.parseInt(st.nextToken())));
            			break;
            		default:
            			break;
            	}
        	}
        }
     }
    
    //to return all sales ArrayList
    public ArrayList<Vehicle> getVehicles(){
    	ArrayList<Vehicle> newArray = new ArrayList<>();
    	for(int i = 0; i < storageArray.size();i++) {
    		newArray.add(storageArray.get(i));
    	}
    	return newArray;
    }
    
    //to return an ArrayList of a specific type of vehicle 
    public ArrayList<Vehicle> getVehicles(String type){
    	ArrayList<Vehicle> newList = new ArrayList<Vehicle>();
    	for (Vehicle vehicle:storageArray) {
    		switch(type) {
    		case "Automobile":
    			if ((vehicle instanceof Automobile )&& vehicle != null) {
    				newList.add(vehicle);
    			}
    		break;
    		case "Bicycle":
    			if ((vehicle instanceof Bicycle)&& vehicle != null) {
    				newList.add(vehicle);
    			}
    		break;
	    	case "HatchBack":
				if ((vehicle instanceof HatchBack)&& vehicle != null) {
					newList.add(vehicle);
				}
			break;
    		case "Minivan":
    			if ((vehicle instanceof Minivan)&& vehicle != null) {
    				newList.add(vehicle);
    			}
    		break;
			case "PickupTruck":
				if ((vehicle instanceof PickupTruck)&& vehicle != null) {
					newList.add(vehicle);
				}
			break;
			case "Sedan":
				if ((vehicle instanceof Sedan)&& vehicle != null) {
					newList.add(vehicle);
				}
			break;
    		}
    	}
    	return newList;
    }
}
