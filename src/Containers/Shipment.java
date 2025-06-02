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
		String[] shipmentInformation = { name, address, email };
		return shipmentInformation;
	}
	
	public void setInformation (String deliveryName, String deliveryAdress,
		String deliveryEmail) {
		this.name = deliveryName;
		this.address = deliveryAdress;
		this.email = deliveryEmail;
	}
	
}