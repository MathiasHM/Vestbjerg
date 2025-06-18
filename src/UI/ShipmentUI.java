package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import Containers.Shipment;

import javax.swing.event.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class ShipmentUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField textField;
	private List<Shipment> shipments;
	private TableRowSorter<TableModel> rowSorter;
	private Shipment selectedShipment;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ShipmentUI dialog = new ShipmentUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ShipmentUI() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{12, 0, -420, 0, 0, 0, 0, 0, 0, -128, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 25, 0, 70, -53, 42, -17, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Fragt");
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 0;
		contentPanel.add(panel_1, gbc_panel_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		contentPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		// kig ned
		textField.getDocument().addDocumentListener(new DocumentListener() {
		    private void updateFilter() {
		        String text = textField.getText();
		        if (text.trim().length() == 0) {
		            rowSorter.setRowFilter(null);  
		        } else {
		        	rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^"+ text));
		        }
		    }
		    public void insertUpdate(DocumentEvent e) {
		        updateFilter();
		    }

		    public void removeUpdate(DocumentEvent e) {
		        updateFilter();
		    }

		    public void changedUpdate(DocumentEvent e) {
		        updateFilter();
		    }
		});
		// kig op
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 2;
		contentPanel.add(scrollPane, gbc_scrollPane);
		
		//tabel ned
		shipments = new ArrayList<>();
		
        
		String columns[] = {"navn", "Adresse", "email"};
		Object[][] data = new Object[shipments.size()][3];
		for (int i = 0; i < shipments.size(); i++) {
            Shipment s = shipments.get(i);
            data[i][0] = s.getShipmentInformation()[0];
            data[i][1] = s.getShipmentInformation()[1];
            data[i][2] = s.getShipmentInformation()[2];
        }
		model = new DefaultTableModel(data, columns) {
            
			private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		
		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		
		JLabel Navn = new JLabel("Navn");
		GridBagConstraints gbc_Navn = new GridBagConstraints();
		gbc_Navn.insets = new Insets(0, 0, 5, 5);
		gbc_Navn.anchor = GridBagConstraints.EAST;
		gbc_Navn.gridx = 5;
		gbc_Navn.gridy = 2;
		contentPanel.add(Navn, gbc_Navn);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 6;
		gbc_textField_1.gridy = 2;
		contentPanel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Adresse");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 5;
		gbc_lblNewLabel_1.gridy = 3;
		contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 6;
		gbc_textField_2.gridy = 3;
		contentPanel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 4;
		contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 6;
		gbc_textField_3.gridy = 4;
		contentPanel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Tilføj");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 5;
		contentPanel.add(btnNewButton, gbc_btnNewButton);
		
		// tabel up
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
			
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
			
		okButton.addActionListener(e -> {
		int selectedRow = table.getSelectedRow();
		    if (selectedRow != -1) {
		    	int modelRow = table.convertRowIndexToModel(selectedRow);
		    	String name = (String) table.getModel().getValueAt(modelRow, 0);
				String address = (String) table.getModel().getValueAt(modelRow, 1);
				String email = (String) table.getModel().getValueAt(modelRow, 2);
		        selectedShipment = new Shipment(name, address, email);
				//returner værdier
		    }
		    dispose();    
		});
		cancelButton.addActionListener(e -> {
			dispose();	
		});
		btnNewButton.addActionListener(e -> {
		    String navn = textField_1.getText().trim();
		    String adresse = textField_2.getText().trim();
		    String email = textField_3.getText().trim();

		    if (navn.isEmpty() || adresse.isEmpty() || email.isEmpty()) {
		        JOptionPane.showMessageDialog(this, "Alle felter skal udfyldes!", "Fejl", JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    Shipment nyShipment = new Shipment(navn, adresse, email);
		    shipments.add(nyShipment);
		    
		    model.addRow(new Object[]{navn, adresse, email});  

		    textField_1.setText("");
		    textField_2.setText("");
		    textField_3.setText("");
		});
	}
	
	
	public Shipment getSelectedShipment() {
	    return selectedShipment;
	}
}