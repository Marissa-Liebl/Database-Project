import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.imageio.ImageIO;
import javax.swing.*;
public class ProjectMainPage extends JFrame{

	
	final int WIDTH = 700;
	final int HEIGHT = 1000;
	
	JButton login;
	JButton createAccount;
	JButton guest;
	//Text fields and Components
	JTextField name = new JTextField();
	
	Color pink = new Color(216,27,96);
	
	public ProjectMainPage() throws IOException
	{
		//Frame
		setSize(WIDTH, HEIGHT);
		setTitle("SuperNova");	
		this.setIconImage(new ImageIcon(getClass().getResource("supernova.jpg")).getImage());
		
	//	Border redline = BorderFactory.createLineBorder(Color.red);
		
		
		//Panel
		JPanel mainPanel =  new JPanel(new FlowLayout(FlowLayout.CENTER, 90, 20));
		mainPanel.setPreferredSize(new Dimension(483,580));
		add(mainPanel);
		mainPanel.setBackground(pink);
		
	
		JLabel title = new JLabel("SuperNova", JLabel.CENTER);
		title.setFont(new Font("French Script MT", Font.BOLD, 40));
		mainPanel.add(title);
		//JLabel to identify options
		JLabel options = new JLabel("Create Account, Log in, or Continue as Guest", JLabel.CENTER);
		mainPanel.add(options);
		
		//Buttons
		login = new JButton("Log In");
		createAccount = new JButton("Create Account");
		guest = new JButton("Continue as Guest");
		
		mainPanel.add(createAccount);
		mainPanel.add(login);
		mainPanel.add(guest);
		
		//button listeners
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new ProjectLoginPage();
				ProjectMainPage.this.dispose();
			}
		});
		createAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new ProjectAccountPage();
				ProjectMainPage.this.dispose();
			}
		});
		guest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new ProjectGuestLoginPage();
				ProjectMainPage.this.dispose();
			}
		});
		
		
		//Image Panel
		mainPanel.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("supernova.jpg"))));
		
		//Important stuff
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);  
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		new ProjectMainPage();
		
	}
	
	

}
