package Dropshipping;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;

import FileReader.FileIO;

public class ProgramExecuter {
    private String[] paths;
    // Object Holders
    private Customer[] customerHolder = new Customer[500];
    private Supplier supplier = new Supplier();
    private SalesManagement sales2DArray = new SalesManagement();
    
    public ProgramExecuter(String[] paths){
    	
    	this.paths = paths.clone();
    }
    public ProgramExecuter(ProgramExecuter _programExecuter){
        this.paths = _programExecuter.paths.clone();
    }

	// Acts as the main method
    public void start() throws FileNotFoundException, IOException{
        this.assigner();
        this.displayer();
    }
    
    // Assigns the output Arrays from csv files
    private void assigner() throws FileNotFoundException, IOException{
        FileIO reader = new FileIO();

        assignCustomers(reader.readCsv(paths[0]));

        assignSuppliers(reader.readCsv(paths[1]));
        assignSales(reader.readCsv(paths[2]), 1);

        assignSuppliers(reader.readCsv(paths[3]));
        assignSales(reader.readCsv(paths[4]), 2);

        assignSuppliers(reader.readCsv(paths[5]));
        assignSales(reader.readCsv(paths[6]), 3);     
    }

	// Calls the salesQuery & passes the needed data inside for the output
    private void displayer(){
        SalesQuery saleQuery = new SalesQuery();
        saleQuery.printMostProfitable(supplier);
        saleQuery.printMostExpensive(supplier);
        saleQuery.printMostPurchasingCustomer(sales2DArray);
        saleQuery.printTotalProtit(supplier);
        saleQuery.printLeastProfitableOfS1(sales2DArray);
    }

    // Creates a Customer object & appends it to the customerHolder for each element of the FileIO return array
    private void assignCustomers(String[] stringCustomers){
        int index = 0;

        for(String stringCustomer: stringCustomers){
            if(stringCustomer != null){

                StringTokenizer strToken = new StringTokenizer(stringCustomer);
    
                this.customerHolder[index] = new Customer(strToken.nextToken(","), strToken.nextToken(","), strToken.nextToken(","), strToken.nextToken(","), strToken.nextToken(",")); 
                index++;
            }
        }
    }
    
    // Creates a Project object & appends it to the supplier for each element of the FileIO return array
    private void assignSuppliers(String[] stringProducts){
        for(String stringProduct: stringProducts){
            if(stringProduct != null){
                StringTokenizer strToken = new StringTokenizer(stringProduct, ",");
                
                supplier.addProduct(new Product(strToken.nextToken(),strToken.nextToken(),Double.parseDouble(strToken.nextToken()),Integer.parseInt(strToken.nextToken()),Double.parseDouble(strToken.nextToken())));
            }
        }
    }
    
    // Creates a Sales object & appends it to the SalesManagement array for each element of the FileIO return array
    private void assignSales(String[] stringSales, int supplierNumber){
        this.sales2DArray.changeSupplier(supplierNumber);

        for(String stringSale: stringSales ){
            if(stringSale != null){
            	// Finds the customer & project first then initializes a new Sales object to be passed inside the salesManagement 2D array
                StringTokenizer strToken = new StringTokenizer(stringSale, ",");
                String id = strToken.nextToken();
                Customer customer = this.findCustomer(strToken.nextToken());
                Product product = this.findProduct(strToken.nextToken());
    
                this.sales2DArray.addProductToSupplier(new Sales(id, customer, product, strToken.nextToken(), product.calculateSalesPrice()));
            }
        }
    }

    private Product findProduct(String _prodId){
        for(Product eachProduct : supplier.getProductArray()){
            if(eachProduct.getProductId().equals(_prodId)){
                return eachProduct;
            }
        }
        return null;
    }
    private Customer findCustomer(String _custId){
        for(Customer eachCustomer : customerHolder){
            if(eachCustomer.getCustomerId().equals(_custId)){
                return eachCustomer;
            }
        }
        return null;
    }
}
