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
import java.awt.Color;
import javax.swing.JList;

import Controllers.OrderController;
import javax.swing.JScrollBar;
import java.awt.Component;

public class MainWindow {

	private JFrame frame;
	private OrderController oC;

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
		oC = new OrderController();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnNewButton_4 = new JButton("Bekræft");
		btnNewButton_4.setForeground(Color.BLACK);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_3_1 = new JButton("Annullér");
		panel.add(btnNewButton_3_1);
		
		JSplitPane splitPane_1 = new JSplitPane();
		frame.getContentPane().add(splitPane_1, BorderLayout.CENTER);
		splitPane_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel panel_2 = new JPanel();
		splitPane_1.setLeftComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.setBounds(1, 1, 1280, 1280);

		JTable table = new JTable();
		panel_2.add(table, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton btnNewButton_1 = new JButton("Tilføj produkt");
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Fjern Produkt(er)");
		btnNewButton_2.setBackground(new Color(255, 128, 128));
		btnNewButton_2.setForeground(new Color(64, 0, 0));
		panel_3.add(btnNewButton_2);
		
		JScrollBar scrollBar = new JScrollBar();
		panel_2.add(scrollBar, BorderLayout.EAST);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setRightComponent(splitPane);
		splitPane.setAlignmentY(Component.CENTER_ALIGNMENT);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		splitPane.setLeftComponent(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Kunde");
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		splitPane.setRightComponent(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Fragt");
		panel_4.add(lblNewLabel_1);
		
		frame.setVisible(true);
	}

}
