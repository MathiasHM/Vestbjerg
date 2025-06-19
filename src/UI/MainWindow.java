package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Color;
import javax.swing.JList;

import Controllers.OrderController;
import Controllers.ProductController;
import Enums.Result;

import javax.swing.JScrollBar;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Containers.Order;
import Containers.Product;

import javax.swing.JCheckBox;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;

public class MainWindow {

	private JFrame frame;
	private OrderController oC;
	private JTable table;
	private JTextField textField;
	private TableRowSorter<TableModel> rowSorter;
	private DefaultTableModel model;
	private ArrayList<Product> products;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TestData.generate();
		OrderController oC = new OrderController();
		ProductController pC = new ProductController();
		oC.createOrder();
		frame = new JFrame();
		frame.setBounds(400, 300, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnNewButton_4 = new JButton("Bekræft");
				btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Order orderCopy = oC.getOrder();
				new OrderConfirmationUI(orderCopy, oC.displayLines());
			}
		});
		btnNewButton_4.setForeground(Color.BLACK);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_3_1 = new JButton("Annullér");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UseCaseMenu useCaseMenu = new UseCaseMenu();
			}
		});
		panel.add(btnNewButton_3_1);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(192, 192, 192));
		FlowLayout flowLayout_4 = (FlowLayout) panel_15.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_6.add(panel_15, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Produktsøgning");
		panel_15.add(lblNewLabel);
		
		JPanel panel_31 = new JPanel();
		panel_6.add(panel_31, BorderLayout.CENTER);
		panel_31.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		panel_31.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		//kig ned
		textField.getDocument().addDocumentListener(new DocumentListener() {
		    private void updateFilter() {
		        String text = textField.getText();
		        if (text.trim().length() == 0) {
		            rowSorter.setRowFilter(null); 
		        } else {
		        	rowSorter.setRowFilter(new RowFilter<DefaultTableModel, Integer>() {
		        		@Override
		        		public boolean include(Entry<? extends DefaultTableModel, ? extends Integer> entry) {
		        			for (int i = 0; i <= 1; i++) {
		        				Object value = entry.getValue(i);
		        				if (value != null && value.toString().toLowerCase().contains(text.toLowerCase())) {
		        					return true;
		        				}
		        			}
		        			
		        			return false;
		        		}
		        	});
		        
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
		
		//kig op
		
		//kig ned
		
		products = new ArrayList<>();
		for (Product p : pC.getProducts()) {
			products.add(p);
		}

		String columns[] = {"Produkt ID", "Navn", "Pris", "Max antal"};
		Object[][] data = new Object[products.size()][4];
		int i = 0;
		for (Product p : products) {
			data[i][0] = p.getID();
			data[i][1] = p.getName();
			data[i][2] = p.getPrice();
			data[i][3] = p.getMaxThreshold();
			i ++;
		}
		
		model = new DefaultTableModel(data, columns) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		JScrollPane scrollPane = new JScrollPane();
		panel_31.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		
		//kig op
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(192, 192, 192));
		FlowLayout flowLayout_5 = (FlowLayout) panel_16.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panel_7.add(panel_16, BorderLayout.NORTH);
		
		JLabel lblNewLabel_9 = new JLabel("Kurv");
		panel_16.add(lblNewLabel_9);
		
		JPanel panel_24 = new JPanel();
		panel_7.add(panel_24, BorderLayout.SOUTH);
		panel_24.setLayout(new BoxLayout(panel_24, BoxLayout.X_AXIS));
		
		JPanel panel_25 = new JPanel();
		panel_24.add(panel_25);
		panel_25.setLayout(new BoxLayout(panel_25, BoxLayout.X_AXIS));
		
		JPanel panel_29 = new JPanel();
		FlowLayout flowLayout_13 = (FlowLayout) panel_29.getLayout();
		flowLayout_13.setAlignment(FlowLayout.LEFT);
		panel_25.add(panel_29);
		
		JButton btnNewButton_2 = new JButton("Fjern produkt(er)");
		btnNewButton_2.setForeground(new Color(255, 128, 128));
		btnNewButton_2.setBackground(new Color(128, 0, 0));
		panel_29.add(btnNewButton_2);
		
		JPanel panel_30 = new JPanel();
		panel_25.add(panel_30);
		
		JPanel panel_26 = new JPanel();
		panel_24.add(panel_26);
		panel_26.setLayout(new BoxLayout(panel_26, BoxLayout.X_AXIS));
		
		JPanel panel_27 = new JPanel();
		FlowLayout flowLayout_14 = (FlowLayout) panel_27.getLayout();
		flowLayout_14.setAlignment(FlowLayout.LEFT);
		panel_26.add(panel_27);
		
		JLabel lblNewLabel_10 = new JLabel("Pris:");
		panel_27.add(lblNewLabel_10);
		
		JPanel panel_28 = new JPanel();
		FlowLayout flowLayout_15 = (FlowLayout) panel_28.getLayout();
		flowLayout_15.setAlignment(FlowLayout.RIGHT);
		panel_26.add(panel_28);
		
		JLabel lblNewLabel_12 = new JLabel("1799,95");
		panel_28.add(lblNewLabel_12);
		
		JLabel lblNewLabel_11 = new JLabel("DKK");
		panel_28.add(lblNewLabel_11);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_7.add(scrollPane_1, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(163, 163, 163));
		FlowLayout flowLayout_1 = (FlowLayout) panel_9.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_4.add(panel_9, BorderLayout.SOUTH);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(128, 128, 128));
		FlowLayout flowLayout = (FlowLayout) panel_10.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_4.add(panel_10, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Kunde");
		panel_10.add(lblNewLabel_1);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(163, 163, 163));
		panel_4.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		panel_11.add(verticalBox);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(163, 163, 163));
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setAlignment(FlowLayout.RIGHT);
		verticalBox.add(panel_8);
		
		JLabel lblNewLabel_3 = new JLabel("Navn:");
		panel_8.add(lblNewLabel_3);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(new Color(163, 163, 163));
		FlowLayout flowLayout_9 = (FlowLayout) panel_20.getLayout();
		flowLayout_9.setAlignment(FlowLayout.RIGHT);
		verticalBox.add(panel_20);
		
		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setBackground(new Color(255, 255, 255));
		panel_20.add(lblNewLabel_5);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBackground(new Color(163, 163, 163));
		FlowLayout flowLayout_11 = (FlowLayout) panel_22.getLayout();
		flowLayout_11.setAlignment(FlowLayout.RIGHT);
		verticalBox.add(panel_22);
		
		JLabel lblNewLabel_7 = new JLabel("CVR-nr:");
		panel_22.add(lblNewLabel_7);
		
		Box verticalBox_1 = Box.createVerticalBox();
		panel_11.add(verticalBox_1);
		
		JPanel panel_19 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_19.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		verticalBox_1.add(panel_19);
		
		JLabel lblNewLabel_4 = new JLabel("Kunde mangler");
		panel_19.add(lblNewLabel_4);
		
		JPanel panel_21 = new JPanel();
		FlowLayout flowLayout_10 = (FlowLayout) panel_21.getLayout();
		flowLayout_10.setAlignment(FlowLayout.LEFT);
		verticalBox_1.add(panel_21);
		
		JLabel lblNewLabel_6 = new JLabel("Kunde mangler");
		panel_21.add(lblNewLabel_6);
		
		JPanel panel_23 = new JPanel();
		FlowLayout flowLayout_12 = (FlowLayout) panel_23.getLayout();
		flowLayout_12.setAlignment(FlowLayout.LEFT);
		verticalBox_1.add(panel_23);
		
		JLabel lblNewLabel_8 = new JLabel("Ingen CVR");
		panel_23.add(lblNewLabel_8);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(163, 163, 163));
		panel_5.add(panel_12, BorderLayout.SOUTH);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.X_AXIS));
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(163, 163, 163));
		FlowLayout flowLayout_6 = (FlowLayout) panel_17.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panel_12.add(panel_17);
		
		JButton btnNewButton_1 = new JButton("Tilføj levering");
			btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FragtUI fUI = new FragtUI();
				String[] shipInfo = fUI.getShipInfo();
				if (fUI.getShipInfo() != null) {
				System.out.println(shipInfo[0] + shipInfo[1] + shipInfo[2]); // for debugging
				oC.setShippingInformation(shipInfo[0], shipInfo[1], shipInfo[2]);
				}
			}
		});
		panel_17.add(btnNewButton_1);
		
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(163, 163, 163));
		FlowLayout flowLayout_3 = (FlowLayout) panel_18.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		panel_12.add(panel_18);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Ingen levering");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected()) {
					System.out.println("Implementér en NO SHIPMENT "
							+ "OPTION IDIOT");
				} //TODO implement no-shipment option. Ideally greyed out
				//Shipment info.
			}
		});
		panel_18.add(chckbxNewCheckBox);
		
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(128, 128, 128));
		FlowLayout flowLayout_2 = (FlowLayout) panel_13.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_5.add(panel_13, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("Fragtoplysninger");
		panel_13.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Tilføj kunde");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KundeUI kUI = new KundeUI();
				if (oC.addCustomerByEmail(kUI.getCustomerEmail()) == Result.CUSTOMERALREADYASSOCIATED 
					&& kUI.getCustomerEmail() != null && kUI.isDisposed) {
					System.out.println("Kunde allerede tilføjet.");
				} else if (kUI.isDisposed && kUI.getCustomerEmail() != null) {
					oC.addCustomerByEmail(kUI.getCustomerEmail());
					System.out.println("Indtastet Email: " + kUI.getCustomerEmail());
					System.out.println("Associeret Email: " + oC.getCustomerEmail());
					
					lblNewLabel_4.setText("Dummy navn");
					lblNewLabel_6.setText(oC.getCustomerEmail());
					if (oC.getCustomerCVR() != 0) {
						lblNewLabel_8.setText("" + oC.getCustomerCVR());
					}
				}
				//TODO håndtér customerEmail fra KundeUI.
			}
		});
		panel_9.add(btnNewButton);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(163, 163, 163));
		panel_5.add(panel_14, BorderLayout.CENTER);
		panel_3.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panel_4, 
			panel_5, panel_9, panel_10, panel_11, panel_12, panel_13, panel_14, lblNewLabel_1, 
			btnNewButton, lblNewLabel_2, panel_17, panel_18, btnNewButton_1, chckbxNewCheckBox, 
			verticalBox, verticalBox_1, panel_8, lblNewLabel_3, panel_19, lblNewLabel_4, panel_20, 
			panel_21, lblNewLabel_5, lblNewLabel_6, panel_22, panel_23, 
			lblNewLabel_7, lblNewLabel_8}));
		frame.setVisible(true);
		}

}
