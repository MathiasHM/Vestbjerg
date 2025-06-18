package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Containers.Customer; // lev med det
import Containers.CustomerContainer;
import Controllers.OrderController;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KundeUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private DefaultListModel<String> listModel;
    private JList<String> itemList;
    private JFormattedTextField formattedField;
	DefaultListModel<String> søgResultater;
	public String customerEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			KundeUI dialog = new KundeUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public KundeUI() {
		new TestData().generateTestData();
		søgResultater = new DefaultListModel<>();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		setTitle("find kunde på email");
			formattedField = new JFormattedTextField();
			updateList("");
			
			formattedField.getDocument().addDocumentListener(new DocumentListener() {
	            public void insertUpdate(DocumentEvent e) {
	            	System.out.println(formattedField.getText().trim());
	                updateList(formattedField.getText().trim());
	            }

	            public void removeUpdate(DocumentEvent e) {
	            	System.out.println(formattedField.getText().trim());
	                updateList(formattedField.getText().trim());
	            }

	            public void changedUpdate(DocumentEvent e) {
	            	// Nødvendig, behøves ikke blive brugt
	            }
	        });
			
			
			GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
			gbc_formattedTextField.gridwidth = 9;
			gbc_formattedTextField.insets = new Insets(0, 0, 5, 0);
			gbc_formattedTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextField.gridx = 0;
			gbc_formattedTextField.gridy = 1;
			contentPanel.add(formattedField, gbc_formattedTextField);
			
			
			
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridheight = 5;
			gbc_scrollPane.gridwidth = 9;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 2;
			contentPanel.add(scrollPane, gbc_scrollPane);
			
			JList list = new JList<>(søgResultater);
			list.addListSelectionListener(
					new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent event) {
							formattedField.setText((String) list.getSelectedValue());
							customerEmail = (String) list.getSelectedValue();
						}
				
			});
			
			scrollPane.setViewportView(list);
			
			
			
		
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
					dispose();
					
				});
				cancelButton.addActionListener(e -> {
					customerEmail = null;
					dispose();
					
				});
	}
	
	public void updateList(String filter) {
		søgResultater.clear();
		for (Customer c : CustomerContainer.getInstance().getCustomers()) {
			if (c.getEmail().toLowerCase().contains(filter.toLowerCase())) {
				søgResultater.addElement(c.getEmail());
			}
		}
	}
	
}
