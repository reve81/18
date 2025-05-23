package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class OverspendFrame extends JFrame {
	// Overspending amount
	private Double amount;
	// Background image label
	private JLabel backgroundLabel;

	public OverspendFrame(Double amount) {
		super("Overspending Alert");
		this.amount = amount;
		// Initialize components
		initComponents();
	}

	// Initialize UI components
	private void initComponents() {
		// Set window background color
		getContentPane().setBackground(Color.WHITE);
		// Make window non-resizable
		this.setResizable(false);
		// Set window icon
		setIconImage(getImage("alarm.jpg"));

		// Set window size
		setSize(400, 400);
		// Center window on screen
		centerFrameOnScreen();

		// Create main panel with flow layout
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		mainPanel.setBackground(Color.WHITE);

		// Create overspending alert label
		JLabel overspendLabel = new JLabel("You have overspent. Current overspending amount:");
		overspendLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		mainPanel.add(overspendLabel);

		// Create amount label
		JLabel amountLabel = new JLabel("            " + amount + "            ");
		amountLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		amountLabel.setForeground(Color.RED);
		mainPanel.add(amountLabel);

		// Create background image label
		backgroundLabel = new JLabel(new ImageIcon(getImage(myjpg())));
		mainPanel.add(backgroundLabel);

		// Create confirm button
		JButton confirmButton = new JButton("    Confirm    ");
		confirmButton.setForeground(Color.BLACK);
		confirmButton.setFont(new Font("Arial", Font.PLAIN, 24));
		confirmButton.setBackground(Color.WHITE);
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Close window
				closeFrame();
			}
		});
		mainPanel.add(confirmButton);

		// Add main panel to content pane
		getContentPane().add(mainPanel);

		// Make window visible
		setVisible(true);
	}

	// Get image file
	private Image getImage(String imagePath) {
		ImageIcon icon = null;
		try {
			icon = new ImageIcon(imagePath);
		} catch (Exception e) {
			// Show error message if image loading fails
			JOptionPane.showMessageDialog(this, "Failed to load image: " + imagePath, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return icon != null ? icon.getImage() : null;
	}

	// Randomly select an image
	public String myjpg() {
		double random = Math.random();
		int index = (int) (random * 3);
		switch (index) {
			case 0:
				return "poor1.jpg";
			case 1:
				return "poor2.jpg";
			case 2:
				return "poor3.jpg";
			default:
				return "";
		}
	}

	// Center window on screen
	private void centerFrameOnScreen() {
		Dimension screen = this.getToolkit().getScreenSize();
		this.setLocation((screen.width - this.getSize().width) / 2, (screen.height - this.getSize().height) / 2);
	}

	// Close window
	private void closeFrame() {
		this.dispose();
	}

	// Test method
	public static void main(String[] args) {
		new OverspendFrame(-10000.0);
	}
}
