package Containers;

public class Shipment {
	
	private String name;
	private String address;
	private String email;
	
	public Shipment(String deliveryName, String deliveryAddress,
			String deliveryEmail) {
		setShipmentInformation(deliveryName, deliveryAdress, deliveryEmail);
	}
	
	public String[] getShipmentInformation() {
		String[] shipmentInformation = { name, adress, email };
		return shipmentInformation;
	}
	
	public void setShipmentInformation (String deliveryName, String deliveryAdress,
		String deliveryEmail) {
		this.deliveryName = deliveryName;
		this.deliveryAdress = deliveryAdress;
		this.deliveryEmail = deliveryEmail;
	}
	
}