/*
 * Shipment.java
 *
 * This class represents a shipment, allowing for the management and retrieval of shipment information.
 *
 * DMA-CSD-V252 group 5 first semester project
 */

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