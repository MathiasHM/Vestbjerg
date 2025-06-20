package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controllers.OrderController;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

public class OrderConfirmationUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private boolean isAccepted = false;
	List<String[]> list = new ArrayList<>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OrderConfirmationUI dialog = new OrderConfirmationUI(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */	
	public OrderConfirmationUI(OrderController orderControllerCopy) {
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setTitle("Ordrebekræftelse");
		setLocationRelativeTo(null);
		
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			
			String[] columnNames = {"Beskrivelse","Antal", "Enhed", "stk. pris", "pris"};
		
			JPanel panel1 = new JPanel();
			contentPanel.add(panel1, BorderLayout.NORTH);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{35, 209, 195, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			panel1.setLayout(gbl_panel);
			
				JLabel lblNewLabel = new JLabel("VestBjerg Byggecenter ");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
				gbc_lblNewLabel.gridx = 3;
				gbc_lblNewLabel.gridy = 0;
				panel1.add(lblNewLabel, gbc_lblNewLabel);
				
				String[] shipmentInfo = orderControllerCopy.getShipmentInformation();
				String modtagernavn = shipmentInfo[0];
				String adresse = shipmentInfo[1]; 
			
				JLabel lblNewLabel_1 = new JLabel("Navn:" + modtagernavn);
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.gridwidth = 2;
				gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.gridx = 0;
				gbc_lblNewLabel_1.gridy = 1;
				panel1.add(lblNewLabel_1, gbc_lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("Adresse: " + adresse);
				
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.gridwidth = 2;
				gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_2.gridx = 0;
				gbc_lblNewLabel_2.gridy = 2;
				panel1.add(lblNewLabel_2, gbc_lblNewLabel_2);
			
				JLabel lblNewLabel_3 = new JLabel("CVR: " + orderControllerCopy.getCustomerCVR());
				GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
				gbc_lblNewLabel_3.gridwidth = 2;
				gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_3.gridx = 0;
				gbc_lblNewLabel_3.gridy = 3;
				panel1.add(lblNewLabel_3, gbc_lblNewLabel_3);
				
				JLabel lblNewLabel_5 = new JLabel("Email: " + orderControllerCopy.getCustomerEmail());
				GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
				gbc_lblNewLabel_5.gridwidth = 2;
				gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_5.gridx = 0;
				gbc_lblNewLabel_5.gridy = 4;
				panel1.add(lblNewLabel_5, gbc_lblNewLabel_5);
				
				JLabel lblNewLabel_10 = new JLabel("");
				GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
				gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_10.gridx = 1;
				gbc_lblNewLabel_10.gridy = 5;
				panel1.add(lblNewLabel_10, gbc_lblNewLabel_10);
			
				JLabel lblNewLabel_8 = new JLabel("");
				GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
				gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_8.gridx = 0;
				gbc_lblNewLabel_8.gridy = 6;
				panel1.add(lblNewLabel_8, gbc_lblNewLabel_8);
				
				LocalDate dato = LocalDateTime.now().toLocalDate();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String datoTekst = dato.format(formatter);
				
				JLabel lblNewLabel_6 = new JLabel("Dato: " + datoTekst);
				GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
				gbc_lblNewLabel_6.gridwidth = 2;
				gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_6.gridx = 0;
				gbc_lblNewLabel_6.gridy = 8;
				panel1.add(lblNewLabel_6, gbc_lblNewLabel_6);
				
				JLabel lblNewLabel_9 = new JLabel("");
				GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
				gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_9.gridx = 1;
				gbc_lblNewLabel_9.gridy = 9;
				panel1.add(lblNewLabel_9, gbc_lblNewLabel_9);
			
				JLabel lblNewLabel_7 = new JLabel("");
				GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
				gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_7.gridx = 0;
				gbc_lblNewLabel_7.gridy = 10;
				panel1.add(lblNewLabel_7, gbc_lblNewLabel_7);
			
				JLabel lblNewLabel_4 = new JLabel("OrdreBekræftelse");
				GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
				gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel_4.gridx = 1;
				gbc_lblNewLabel_4.gridy = 12;
				panel1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
				JButton okButton = new JButton("færdiggøre ");
				okButton.setActionCommand("færdiggøre ");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			
			
				JButton cancelButton = new JButton("Annullér");
				cancelButton.setActionCommand("Annullér");
				buttonPane.add(cancelButton);
				
//	------------oprettelse af jtable og funktion i tablen -------------------
				String[] lines = orderControllerCopy.displayLines();
				
				int antalLinjer = lines.length;
				String[][] data = new String[antalLinjer + 4][5];
			
				for (int i = 0; i < antalLinjer; i++) {
					 String[] split = lines[i].split("/");
					 data[i] = split;
				}
				
				data[antalLinjer] = new String[] {"", "", "", "", ""};
				
				double[] total1 = orderControllerCopy.getTotalPrice();
				String subtotal = Double.toString(total1[0]);
				String discount = Double.toString(total1[1]);
				String totalprice = Double.toString(total1[2]);
				
				data[antalLinjer + 1] = new String[] {"", "", "Subtotal", "", subtotal};
				data[antalLinjer + 2] = new String[] {"", "", "Discount", "", discount};
				data[antalLinjer + 3] = new String[] {"", "", "Total DKK", "", totalprice};
						

				table = new JTable(data, columnNames);
				JScrollPane scrollPane1 = new JScrollPane(table);
				panel.add(scrollPane1);
//	------------tablen op ----------------------------------------------------
				
// ------------ ændre vinduest størelse dynamisk i højden --------------------
				pack();
				int packedHeight = getWidth();
				setSize(600, packedHeight); 
				
//        --------------------------------------------------------------------
				
				okButton.addActionListener(e -> {
					isAccepted = true;	
				    dispose();    
				});
				
				cancelButton.addActionListener(e -> {
					// slet alt i mainwindow
					isAccepted = false;
					// åben mainwindow
					// new MainWindow();
				    dispose();    
				});
				setVisible(true);
				
	}
	public boolean getIsAccepted() {
		return isAccepted;
	}
}
