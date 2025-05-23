package main;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AboutFrame extends JFrame {

	public AboutFrame() {
		super("about");
		this.setResizable(false);
		initComponents();
		setSize(500, 400);
		centerFrameOnScreen();
		setVisible(true);
	}

	private void initComponents() {
		setIconImage(getImage("about.jpg"));
		setBackground(Color.WHITE);

		// 创建背景标签
		JLabel backgroundLabel = createBackgroundLabel("B.jpeg");
		getContentPane().add(backgroundLabel, BorderLayout.CENTER);
	}

	private Image getImage(String imagePath) {
		ImageIcon icon = null;
		try {
			File imageFile = new File(imagePath);
			if (imageFile.exists()) {
				icon = new ImageIcon(imagePath);
			} else {
				System.err.println("Image file not found: " + imagePath);
			}
		} catch (Exception e) {
			System.err.println("Error loading image: " + imagePath);
			e.printStackTrace();
		}
		return icon != null ? icon.getImage() : null;
	}

	private JLabel createBackgroundLabel(String imagePath) {
		ImageIcon background = new ImageIcon(getImage(imagePath));
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, getWidth(), getHeight());
		return label;
	}

	private void centerFrameOnScreen() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width - getSize().width) / 2, (screen.height - getSize().height) / 2);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new AboutFrame());
	}
}
