package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

public class KundeUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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

	/**
	 * Create the dialog.
	 */
	public KundeUI() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
		
			JLabel lblNewLabel_3 = new JLabel("Kunde");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 1;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
			JPanel panel3 = new JPanel();
			GridBagConstraints gbc_panel3 = new GridBagConstraints();
			gbc_panel3.insets = new Insets(0, 0, 5, 5);
			gbc_panel3.fill = GridBagConstraints.BOTH;
			gbc_panel3.gridx = 0;
			gbc_panel3.gridy = 2;
			contentPanel.add(panel3, gbc_panel3);
		
			JLabel lblNewLabel = new JLabel("Email");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 2;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		
			textField_1 = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 5);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 3;
			gbc_textField_1.gridy = 2;
			contentPanel.add(textField_1, gbc_textField_1);
			textField_1.setColumns(10);
		
			JPanel panel1 = new JPanel();
			GridBagConstraints gbc_panel1 = new GridBagConstraints();
			gbc_panel1.insets = new Insets(0, 0, 5, 5);
			gbc_panel1.fill = GridBagConstraints.BOTH;
			gbc_panel1.gridx = 0;
			gbc_panel1.gridy = 4;
			contentPanel.add(panel1, gbc_panel1);
		
			JLabel lblNewLabel_1 = new JLabel("CVR");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 4;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 3;
			gbc_textField.gridy = 4;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		
			JPanel panel2 = new JPanel();
			GridBagConstraints gbc_panel2 = new GridBagConstraints();
			gbc_panel2.insets = new Insets(0, 0, 0, 5);
			gbc_panel2.fill = GridBagConstraints.BOTH;
			gbc_panel2.gridx = 0;
			gbc_panel2.gridy = 6;
			contentPanel.add(panel2, gbc_panel);
		
			JLabel lblNewLabel_2 = new JLabel("Muligvis navn her (følger ikke programmet)");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 6;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
			textField_2 = new JTextField();
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.insets = new Insets(0, 0, 0, 5);
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.gridx = 3;
			gbc_textField_2.gridy = 6;
			contentPanel.add(textField_2, gbc_textField_2);
			textField_2.setColumns(10);
		
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
					//returner værdier
					
				});
				cancelButton.addActionListener(e -> {
					dispose();
					// TODO ¨åben Oliver's UI.
					
				});
	}

}
