package UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class TypeProduct extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * launch the application.
	 */
	public static void main(String[] args) {
		try {
			TypeProduct dialog = new TypeProduct();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TypeProduct() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
	    contentPanel.add(panel_1, BorderLayout.CENTER);
	    
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			
			
				JLabel lblNewLabel = new JLabel("Produkt kategori");
				panel.add(lblNewLabel);
				
				
		
			String[] testKomboFunktionalitet = {"Søm", "Hammer", "Skovl", "Toilet"};
		    JComboBox<String> comboBox = new JComboBox<>(testKomboFunktionalitet);
		    comboBox.setMaximumSize(new Dimension(400, 30)); // Full width
			
		    comboBox.setPreferredSize(new Dimension(0, 30));
		    comboBox.setAlignmentX(Component.CENTER_ALIGNMENT); 
		    panel_1.add(Box.createRigidArea(new Dimension(0, 5)));
		    panel_1.add(comboBox);
		    
		    
		    
//		    JComboBox comboBox_1 = new JComboBox();
//		    panel_1.add(comboBox_1);
			
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
