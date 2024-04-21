package gui;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;

public class SimpleFrame extends JFrame {
	public static final int DEFAULT_WIDTH = 900;
	public static final int DEFAULT_HEIGHT = 600;
	public SimpleFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setLocation((screenWidth-DEFAULT_WIDTH) / 2, (screenHeight-DEFAULT_HEIGHT) / 2);
		setResizable(false);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		getContentPane().add(chckbxNewCheckBox, BorderLayout.WEST);
	}
	
	public static void main(String[] args) {
		SimpleFrame frame = new SimpleFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
