package Dropshipping;

public class SalesManagement {
	private int row;
    private int column;
	private Sales[][] salesArray= new Sales[3][500];

    public SalesManagement(){
        this.row = 0;
        this.column = 0;
    }
    public void addSupplier(Sales[] supplier){
        for(Sales supplierSales : supplier){
            this.salesArray[this.row][this.column] = new Sales(supplierSales);
            column++;
        }
        
    }
    public void addProductToSupplier(Sales sale){
        this.salesArray[row][column] = sale;
        column++;
    }

    public void changeSupplier(int supplierNumber){
    	// Manually changes the supplier, and sets the column to the first null element
        if(supplierNumber > 3 || supplierNumber <= 0){
            return;
        }
        this.row = supplierNumber - 1;
        this.column = 0;
        for(Sales singleSale: this.salesArray[this.row]){
            if(singleSale != null){
                this.column++;
            }
        }
    }
    public Customer traverseSales() {
    	// Traveses the salesArray to increment & find the most purchasing customer
    	for (int i =0; i <3 ; i++) {
    		for(int j=0; j<500;j++) {
    			if (this.salesArray[i][j] != null) {
    				Customer customer = this.salesArray[i][j].getCustomer();
        			if (customer != null) {
        				customer.incrementCustomerPurchases();
        			}
    			}
    		}
    	}
    	int maxCount = 0;
    	Customer maxCustomer = new Customer();
    	for (int z =0; z<3;z++) {
    		for (int x = 0; x<500;x++) {
    			if (this.salesArray[z][x] != null) {
    				Customer customer = this.salesArray[z][x].getCustomer();
    				if(customer.getCustomerPurchases() > maxCount) {
        				maxCustomer = new Customer(customer);
        				maxCount = customer.getCustomerPurchases();
    				}    			
    			}
    		}
    	}
    	return maxCustomer;
    }

    public Sales[][] getEverySupplier(){
        return this.salesArray.clone();
    }
    public Sales[] getSpecificSupplier(int supplierIndex){
        return this.salesArray[supplierIndex].clone();
    }

    public Sales getSales(int row, int column) {
    	// to return a spesific sales at salesArray[row][column]
		return new Sales(salesArray[row][column]);
	}
}
