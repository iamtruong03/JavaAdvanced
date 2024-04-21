package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import javax.swing.*;

public class MyJPanel extends JPanel {
	JLabel jl = new JLabel (new ImageIcon("111.png"));
	{
		add(jl); // instance initializer just for fun
		addKeyListener(new KeyAdapter() {
			public void keyPressed (KeyEvent e) {
				char c = e.getKeyChar();
				System.out.println("Got char " + c);
			}
		});
	}
	
	public static void main(String[] args) {
		JFrame jframe = new JFrame("PanelTest");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(600, 400);
		jframe.setLocationRelativeTo(null); // Hiển thị cửa sổ ra giữa màn hình

		
		MyJPanel mjp = new MyJPanel();
		jframe.getContentPane().add(mjp);
		jframe.setVisible(true);
		mjp.requestFocus();
	}
}
