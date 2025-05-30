package Containers;

public class Customer {
	
    //private String name;		**TO BE REMOVED
    private String email;
    //private String phone;    	**TO BE REMOVED
    //private String category; 	**TO BE REMOVED
	private int CVR;
    
	public Customer(String email, int CVR) {
		
		this.email = email;
		this.CVR = CVR;
	}
    
    public String getEmail() {
        return email;
    }
    
    public int getCVR() {
    	return CVR;
    }
}
