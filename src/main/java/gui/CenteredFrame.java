package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CenteredFrame extends JFrame {
	public CenteredFrame() {
		// get screem dimensions
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		//setLocation((screenWidth-DEFAULT_WIDTH) / 2, (screenHeight-DEFAULT_HEIGHT) / 2);
		//center frame in screen
		
	}
	public static void main(String[] args) {
		CenteredFrame frame = new CenteredFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
