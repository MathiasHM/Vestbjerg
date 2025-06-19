package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Containers.Order;
import Controllers.OrderController;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

public class OrderConfirmationUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private boolean setStatus = false;
	private OrderController controller;
	List<String[]> list = new ArrayList<>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OrderConfirmationUI dialog = new OrderConfirmationUI(null, args);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	//Order order
	public OrderConfirmationUI(Order orderCopy, String[] lineInformation) {
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setTitle("Ordrebekræftelse");
		setLocationRelativeTo(null);
		
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			
			
// --------------------------------------------------------------------------------------------------

			
			String[] columnNames = {"Beskrivelse","Antal", "Enhed", "stk. pris", "pris"};
//			//	for () {
//				String[][] rawData = {
//						
//					    {"Printerpapir A4", "5", "pakker", "25.00", ""},
//					    {"Blækpatron sort", "2", "stk", "150.00", ""},
//					    {"Hæfteklammer", "3", "æsker", "15.00", "45.00"}
//						
//					};
////				-----------------------------------------------------------------------
//			//	}
//				// virker ------------------------------------------
//				for (int i = 0; i < rawData.length; i++) {
//					float antal = Float.parseFloat(rawData[i][1]);
//					float stk = Float.parseFloat(rawData[i][3].replace(",", "."));
//					float elementPris = antal * stk;
//					rawData[i][4] = Float.toString(elementPris);
//					subTotal += elementPris;
//				}
//				moms = (float) (subTotal * 0.25);
//				total = moms + subTotal;
//			//	total -= discount;
//				System.out.println("virker" + total);
				//-----------------------------------------------------------------
//				for (int i = 0; i < rawData.length; i++) {
//					float antal = Float.parseFloat(rawData[i][1]);
//					float stk = Float.parseFloat(rawData[i][3].replace(",", "."));
//					float elementPris = antal * stk;
//					subTotal += elementPris;
//					subtotal, kald på line getLineSubtotal()
//				}
//				
//				moms = (float) (subTotal * 0.25);
//				total = moms + subTotal;
//				
//				total, skal lave en kald til ordre getTotalPrice();				
//				System.out.println("virker" + total);
				
				// brug igen--------------------------------
//				String newSubTotal = Float.toString(subTotal);
//				String newMoms = Float.toString(moms);
//				String newTotal = Float.toString(total);
			//	String newDiscount = Float.toString(discount);
//				String[][] data = {
//						{"Printerpapir A4", "5", "pakker", "25.00", "125.00"},
//					    {"Blækpatron sort", "2", "stk", "150.00", "300.00"},
//					    {"Hæfteklammer", "3", "æsker", "15.00", "45.00"},
//						{"", "", "", "", ""},
//						{"", "", "Discount", "", ""},//newDiscount},
//					    {"", "", "Subtotal", "", newSubTotal},
//					    {"", "", "Moms (25%)", "", newMoms},
//					    {"", "", "Total DKK", "", newTotal}
//				}; //----------------------------------------------
//				
				// kald data
				
//				for (rawData raw : element) {
//					(float) rawData[2] * (float) rawData[rawData[4] = (String) rawData[5]
//					int length = rawData[0].length()				
//					(float) rawData[5] * length = Subtotal
				//  }
//					25% af SubTotal 
//					total = subtotal + 25%
//				
//				
//				
//				
//				}
				
				
//				
				
			JPanel panel1 = new JPanel();
			contentPanel.add(panel1, BorderLayout.NORTH);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 209, 195, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			panel1.setLayout(gbl_panel);
			
				JLabel lblNewLabel = new JLabel("VestBjerg Byggecenter ");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
				gbc_lblNewLabel.gridx = 3;
				gbc_lblNewLabel.gridy = 0;
				panel1.add(lblNewLabel, gbc_lblNewLabel);
			
				JLabel lblNewLabel_1 = new JLabel("Vestbjerg Renskab");
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.gridwidth = 2;
				gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.gridx = 0;
				gbc_lblNewLabel_1.gridy = 1;
				panel1.add(lblNewLabel_1, gbc_lblNewLabel_1);
			
				JLabel lblNewLabel_2 = new JLabel("addres");
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.gridwidth = 2;
				gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_2.gridx = 0;
				gbc_lblNewLabel_2.gridy = 2;
				panel1.add(lblNewLabel_2, gbc_lblNewLabel_2);
			
				JLabel lblNewLabel_3 = new JLabel("addres 2");
				GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
				gbc_lblNewLabel_3.gridwidth = 2;
				gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_3.gridx = 0;
				gbc_lblNewLabel_3.gridy = 3;
				panel1.add(lblNewLabel_3, gbc_lblNewLabel_3);
			
				JLabel lblNewLabel_5 = new JLabel("att");
				GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
				gbc_lblNewLabel_5.gridwidth = 2;
				gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_5.gridx = 0;
				gbc_lblNewLabel_5.gridy = 4;
				panel1.add(lblNewLabel_5, gbc_lblNewLabel_5);
			
				JLabel lblNewLabel_8 = new JLabel("New label");
				GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
				gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_8.gridx = 0;
				gbc_lblNewLabel_8.gridy = 5;
				panel1.add(lblNewLabel_8, gbc_lblNewLabel_8);
			
				JLabel lblNewLabel_6 = new JLabel("Dato");
				GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
				gbc_lblNewLabel_6.gridwidth = 2;
				gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_6.gridx = 0;
				gbc_lblNewLabel_6.gridy = 7;
				panel1.add(lblNewLabel_6, gbc_lblNewLabel_6);
			
				JLabel lblNewLabel_7 = new JLabel("New label");
				GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
				gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_7.gridx = 0;
				gbc_lblNewLabel_7.gridy = 8;
				panel1.add(lblNewLabel_7, gbc_lblNewLabel_7);
			
				JLabel lblNewLabel_4 = new JLabel("OrdreBekræftelse");
				GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
				gbc_lblNewLabel_4.gridwidth = 2;
				gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel_4.gridx = 0;
				gbc_lblNewLabel_4.gridy = 10;
				panel1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
				JButton okButton = new JButton("Bekræft");
				okButton.setActionCommand("Bekræft");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			
			
				JButton cancelButton = new JButton("Annullér");
				cancelButton.setActionCommand("Annullér");
				buttonPane.add(cancelButton);
			
				
				
				
				
				
//				for (String line : controller.displayLines()) {
//				    String[] split = line.split("/");
//				    String navn = split[0];
//				    String id = split[1];
//				    String pris = split[2];
//				    String antal = split[3];
//				    String subtotal = split[4];
//				}
				
				
				ArrayList<String> lines = orderCopy.displayLines();
				String[] linesArray = lines.toArray(new String[0]);
				
				int antalLinjer = linesArray.length;
				String[][] data = new String[antalLinjer + 4][5];
			
				for (int i = 0; i < antalLinjer; i++) {
					 String[] split = linesArray[i].split("/");
					 data[i] = split;
				}
				
				data[antalLinjer] = new String[] {"", "", "", "", ""};
				
				double[] total1 = orderCopy.getTotalPrice();
				String subtotal = Double.toString(total1[0]);
				String discount = Double.toString(total1[1]);
				String totalprice = Double.toString(total1[2]);
				
				data[antalLinjer + 1] = new String[] {"", "", "Subtotal", "", subtotal};
				data[antalLinjer + 2] = new String[] {"", "", "Discount", "", discount};
				data[antalLinjer + 3] = new String[] {"", "", "Total DKK", "", totalprice};
						

				table = new JTable(data, columnNames);
				JScrollPane scrollPane1 = new JScrollPane(table);
				
				panel.add(scrollPane1);
				okButton.addActionListener(e -> {
				//	order.setStatus(Status.CONFIRMED);
//					public void setOrderPending() {
//				        order.setStatus(Status.PENDING);
//				        order.setDate(LocalDateTime.now());
//				        OrderContainer.getInstance().addOrder(order);
//				    } 
					controller.setOrderPending();
					
					
				    dispose();    
				});
				cancelButton.addActionListener(e -> {
					// slet alt i mainwindow
					new UseCaseMenu();
					// åben usecase menu
				    dispose();    
				});
				setVisible(true);
	}
//
}
