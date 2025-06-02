package Containers;

public class Shipment {
	
	private String name;
	private String address;
	private String email;
	
	public Shipment(String deliveryName, String deliveryAddress, 
			String deliveryEmail) {
		name = deliveryName;
		address = deliveryAddress;
		email = deliveryEmail;
	}
	
	public String getShipmentInformation() {
		String shipmentInformation = name + address + email; //TODO make actual stringbuilder.
		return shipmentInformation;
	}
	
	public String getAddress() {
		return address;
	}
}