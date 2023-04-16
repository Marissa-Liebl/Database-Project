import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class ProjectLoginPage extends JFrame{

	JTextField email;
	JPasswordField password;
	JButton login;
	JButton createAccount;
	
	Color gold = new Color(212,175,55);
	Color purple = new Color(162,107,243);
	Color orange = new Color(241,125,120);
	public ProjectLoginPage()
	{
		setSize(560, 500);
		setTitle("SuperNova Login");	
		this.setIconImage(new ImageIcon(getClass().getResource("supernova.jpg")).getImage());
		
		//Main Panel
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setPreferredSize(new Dimension(700,300));
		this.add(mainPanel);
		
		
		//TextInput Panel
		JPanel textInputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 32, 24));
		textInputPanel.setBackground(gold);
		email = new JTextField(30);
		password = new JPasswordField(30);
		
		textInputPanel.add(email);
		textInputPanel.add(password);
		textInputPanel.setPreferredSize(new Dimension(400,300));
		mainPanel.add(textInputPanel, BorderLayout.CENTER);
		
		//Titles
		JPanel textTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 32, 27));
		textTitlePanel.setPreferredSize(new Dimension(170,200));
		textTitlePanel.setBackground(purple);
		JLabel emailAdress = new JLabel("Enter Your Email");
		JLabel pass = new JLabel("Enter Your Password");
		
		textTitlePanel.add(emailAdress);
		textTitlePanel.add(pass);
		mainPanel.add(textTitlePanel, BorderLayout.WEST);
		
		//Buttons
		login = new JButton("Log In");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String ema = email.getText();
				String cPW = "";
				char[] holdCP = password.getPassword();
				for(int i = 0; i < holdCP.length; i ++)
				{
				cPW += holdCP[i];
				} 
				//User n = new User(ema, cPW);
				System.out.println("Welcome back " + ema);
				
				ProjectLoginPage.this.dispose();
			}
		});
		createAccount = new JButton("Create Account");
		createAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new ProjectAccountPage();
				ProjectLoginPage.this.dispose();
			}
		});
		
		
		//Buttons to go Places
		textInputPanel.add(createAccount);
		textInputPanel.add(login);
		
		
		//Picture
		JPanel picPanel = new JPanel();
		picPanel.setBackground(orange);
		picPanel.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("supernova 2.jpg"))));
		picPanel.setPreferredSize(new Dimension(560,300));
		mainPanel.add(picPanel, BorderLayout.SOUTH);
		
		
		//Important
		this.setLocationRelativeTo(null);  
		this.setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		new ProjectLoginPage();
	}

}
