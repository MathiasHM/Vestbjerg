package Containers;

public class Customer {
	
    private String customerID;
    private String name;
    private String email;
    private String phone;
    private String category;
	
	public Customer(String customerID, String name, 
		String email, String phone, String category) {
		this.customerID = customerID;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.category = category;
	}
	
    
    public String getCustomerID() {
        return customerID;
    }
}
