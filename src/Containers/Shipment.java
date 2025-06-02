package Containers;

public class Shipment {
	
	private String name;
	private String address;
	private String email;
	
	public Shipment(String deliveryName, String deliveryAddress,
			String deliveryEmail) {
		setInformation(deliveryName, deliveryAddress, deliveryEmail);
	}
	
	public String[] getShipmentInformation() {
		return new String[] { name, address, email };
	}
	
	public void setInformation (String deliveryName, String deliveryAddress,
		String deliveryEmail) {
		this.name = deliveryName;
		this.address = deliveryAddress;
		this.email = deliveryEmail;
	}
	
}