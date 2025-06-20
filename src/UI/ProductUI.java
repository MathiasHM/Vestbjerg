package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;

public class ProductUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private int amount = 1;
	private boolean isAccepted = false;
	private JFormattedTextField textField;
	private String oldText;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProductUI dialog = new ProductUI(new String[4]);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProductUI(String[] info) {
		
		
		int max = Integer.parseInt(info[3]);
		int min = 1;
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel(info[1]);
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
				{
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2);
					panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.RIGHT);
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_1 = new JLabel("Produkt ID:");
							panel_3.add(lblNewLabel_1);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.RIGHT);
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_2 = new JLabel("Pris:");
							panel_3.add(lblNewLabel_2);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.RIGHT);
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_3 = new JLabel("Max antal:");
							panel_3.add(lblNewLabel_3);
						}
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2);
					panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_4 = new JLabel(info[0]);
							panel_3.add(lblNewLabel_4);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_5 = new JLabel(info[2] + " kr.");
							panel_3.add(lblNewLabel_5);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_6 = new JLabel(info[3]);
							panel_3.add(lblNewLabel_6);
						}
					}
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
				{
					JPanel panel_2 = new JPanel();
					FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
					flowLayout.setAlignment(FlowLayout.RIGHT);
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_7 = new JLabel("Antal:");
						panel_2.add(lblNewLabel_7);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
					flowLayout.setAlignment(FlowLayout.LEFT);
					panel_1.add(panel_2);
					
						textField = new JFormattedTextField();
						panel_2.add(textField);
						textField.setColumns(10);
						textField.setText("" + min);
				}
								
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Tilføj");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						setIsAccepted(true);
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Annullér");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
			setVisible(true);
		}
	}
	
	public void setIsAccepted(boolean state) {
		isAccepted = state;
	}
	
	public boolean getIsAccepted() {
		return isAccepted;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void updateOldText() {
		oldText = textField.getText();
	}

}
