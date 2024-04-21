package ux;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login to Your Account");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setBounds(205, 22, 314, 63);
		contentPane.add(lblNewLabel);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUsername.setBounds(47, 181, 516, 43);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Enter your username & password to login");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(193, 88, 284, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(47, 142, 96, 25);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(47, 249, 96, 25);
		contentPane.add(lblPassword);

		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPassword.setColumns(10);
		txtPassword.setBounds(47, 290, 516, 43);
		contentPane.add(txtPassword);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Remember me");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxNewCheckBox.setBounds(47, 371, 165, 21);
		contentPane.add(chckbxNewCheckBox);

		JLabel lblCreat = new JLabel("Create an account");

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = txtUsername.getText();
				String pass = txtPassword.getText();

				if (name != null && !name.equalsIgnoreCase("") && pass != null && !pass.equalsIgnoreCase("")) {
					lblCreat.setText(name + "" + pass);
				} else {
					lblCreat.setText("Please ....");
				}

			}
		});
		btnLogin.setBackground(new Color(0, 0, 255));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBounds(205, 412, 227, 63);
		contentPane.add(btnLogin);
		btnLogin.setBorder(null);

		JLabel lblNewLabel_3 = new JLabel("Don't have account ?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(47, 508, 148, 13);
		contentPane.add(lblNewLabel_3);

		lblCreat.setForeground(new Color(0, 0, 255));
		lblCreat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCreat.setBounds(182, 508, 154, 13);

		contentPane.add(lblCreat);
	}
}
