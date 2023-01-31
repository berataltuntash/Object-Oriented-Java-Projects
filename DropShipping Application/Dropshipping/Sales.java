package Dropshipping;

public class Sales {
	private String id;
	private Customer customer;
	private Product product;
	private String salesDate;
	private double salesPrice;

	public Sales(){
		this.id = "-1";
	}

	public Sales(String id, Customer customer, Product product, String salesDate, double salesPrice ){
		this.id = id;
		this.customer = customer;
		this.product = new Product(product);
		this.salesDate = salesDate;
		this.salesPrice = salesPrice;
	}
	public Sales(Sales toCopy){
		if(toCopy == null || toCopy.id == null || toCopy.product == null || toCopy.salesDate == null || toCopy.salesPrice == 0){
			System.out.println("Wonk");
			System.exit(0);
		}else {

			this.id = toCopy.id;
			this.customer = toCopy.customer;
			this.product = new Product(toCopy.product);
			this.salesDate = toCopy.salesDate;
			this.salesPrice = toCopy.salesPrice;
		}
	}

	public String getId(){
		return this.id;
	}
	public Customer getCustomer(){
		
		return this.customer;
	}
	public Product getProduct(){
		return new Product(this.product);
	}
	public String getSalesDate(){
		return this.salesDate;
	}
	public double getSalesPrice(){
		return this.salesPrice;
	}

	public String toString(){
		return "Id: "+this.getId()+"\nCustomer: "+this.getCustomer()+"\nProduct: "+this.getProduct()+"\nSale Date: "+this.getSalesDate()+"\nSale Price: "+this.getSalesPrice();
	}
}
