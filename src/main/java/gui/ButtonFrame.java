package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ButtonFrame extends JFrame {
	public static final int DEFAULT_WIDTH = 900;
	public static final int DEFAULT_HEIGHT = 600;

	public ButtonFrame() {
		setTitle("Hiện thị màu nền");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		// get screem dimensions
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setLocation((screenWidth - DEFAULT_WIDTH) / 2, (screenHeight - DEFAULT_HEIGHT) / 2);
		
		setResizable(false);
		// add panel to frame
		ButtonPanel panel = new ButtonPanel();
		super.add(panel);
	}

	public static void main(String[] args) {
		ButtonFrame frame = new ButtonFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
