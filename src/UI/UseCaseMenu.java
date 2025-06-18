package UI;


import java.awt.event.*;
import java.net.URL;
import java.awt.*;
import javax.swing.*;


public class UseCaseMenu extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UseCaseMenu window = new UseCaseMenu();
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
	public UseCaseMenu() {
		

		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
	    frame = new JFrame();
	    frame.setBounds(100, 100, 450, 400);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
	    // Main vertical layout panel
	    JPanel mainPanel = new JPanel();
	    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	    frame.setContentPane(mainPanel);
	    
	    
	    mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
	    
	    

	    // --- ComboBox centered below the button ---
	    String[] options = {"Create order", "Create offer", "Update order", "Update offer",
	    	    "Read product", "Generate statistics", "Read order", "Read offer", "Complete order",
	    	    "Read customer", "Delete offer", "Delete order", "Update product", "Read inventory",
	    	    "Update customer", "Delete customer", "Delete product", "Create product", "Create customer",
	    	    "Change discounts"};
	    JComboBox<String> comboBox = new JComboBox<>(options);
	    comboBox.setMaximumSize(new Dimension(400, 30)); // Full width
	    // Eventuelt sætte 400 til Integer.MAX_VALUE for set MaxSize
	    comboBox.setPreferredSize(new Dimension(0, 30)); // Set height, let width stretch
	    comboBox.setAlignmentX(Component.CENTER_ALIGNMENT); // Keeps layout happy with BoxLayout
	    mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
	    mainPanel.add(comboBox);

	    // --- Picture area below everything else ---
	    URL imageURL = getClass().getResource("Skærmbillede 2025-06-16 092024.png");
	    ImageIcon imageIcon = new ImageIcon(imageURL);
		Image scaledImg = imageIcon.getImage().getScaledInstance(280, 280, Image.SCALE_SMOOTH);
	    JLabel pictureLabel = new JLabel(new ImageIcon(scaledImg), SwingConstants.CENTER);
	    pictureLabel.setOpaque(true);
	    pictureLabel.setBackground(Color.WHITE);
	    pictureLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    pictureLabel.setVerticalAlignment(SwingConstants.CENTER);
	   
	    pictureLabel.setPreferredSize(new Dimension(300, 0));
	    
	    pictureLabel.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	switch ((String) comboBox.getSelectedItem()) {
	        	case "Create order":
	        		
	        		MainWindow mWindow = new MainWindow();
	        		// TODO forbind med Oliver's UI
	        		frame.dispose();
	        		break;
	        	default:
	        		System.out.println("Ikke implementeret endnu");
	        	}
	        	
	        	}

	        
	    });
	    

	    JPanel picturePanel = new JPanel(new BorderLayout());
	    picturePanel.add(pictureLabel, BorderLayout.CENTER);
	    picturePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    
	    
	    mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
	    mainPanel.add(picturePanel);
	    
	    JPanel panel = new JPanel();
	    picturePanel.add(panel, BorderLayout.SOUTH);
	    
	    JButton btnNewButton_1 = new JButton("Gå videre");
	    panel.add(btnNewButton_1);
	    
	    JButton btnNewButton = new JButton("Log ud");
	    panel.add(btnNewButton);
	    frame.setVisible(true);
	    
	    btnNewButton_1.addActionListener(e -> {
	    	switch ((String) comboBox.getSelectedItem()) {
        	case "Create order":
        		 new MainWindow().setVisible(true);
        		 
        		// TODO forbind med Oliver's UI
        		frame.dispose();
        		break;
        	default:
        		System.out.println("Ikke implementeret endnu");
        	}
        	
        	
			
		});

	    btnNewButton.addActionListener(e -> {
	    	LogIn logUd = new LogIn();
			logUd.setVisible(true);
			frame.dispose();
		});
	    
	}
	

}
