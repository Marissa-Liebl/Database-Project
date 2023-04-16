import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ProjectGuestLoginPage extends JFrame {
	
		JTextField username;
		JButton submit;
		JButton createAccount;
		
		Color gold = new Color(212,175,55);
		Color purple = new Color(162,107,243);
		Color orange = new Color(241,125,120);
		public ProjectGuestLoginPage()
		{
			setSize(560, 700);
			setTitle("SuperNova Guest Login");	
			this.setIconImage(new ImageIcon(getClass().getResource("supernova.jpg")).getImage());
			
			//Main Panel
			JPanel mainPanel = new JPanel(new BorderLayout());
			mainPanel.setPreferredSize(new Dimension(700,300));
			this.add(mainPanel);
			
			
			//TextInput Panel
			JPanel textInputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 24));
			textInputPanel.setBackground(gold);
			username = new JTextField(30);
			textInputPanel.add(username);
			
			textInputPanel.setPreferredSize(new Dimension(400,300));
			mainPanel.add(textInputPanel, BorderLayout.CENTER);
			
			
			
			//age drop down
			String[] ages = new String[100];
			for(int i = 1, a = 0; a < ages.length; i ++, a ++)
			{
				String h = i + "";
				ages[a] = h;
			}
			
			JComboBox<String> age = new JComboBox(ages);
			textInputPanel.add(age);
			
			// CheckBox
			JCheckBox tos = new JCheckBox("I Agree to the TOS");
			textInputPanel.add(tos);
			
			
			//Buttons
			submit = new JButton("Submit");
			createAccount = new JButton("Create Account");
			createAccount.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					new ProjectAccountPage();
					ProjectGuestLoginPage.this.dispose();
				}
			});
			textInputPanel.add(submit);
			textInputPanel.add(createAccount);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					if(tos.isSelected())
					{
					String un = username.getText();
					String a = (String)age.getSelectedItem();
					int hA = Integer.parseInt(a);
					
					
					User n = new User(un, hA);
					System.out.println("You have logged in as a guest with the username: " + un + " and an age of " + a);
					ProjectGuestLoginPage.this.dispose();
					}
					else 
					{
						JFrame popup = new JFrame();
						JOptionPane.showMessageDialog(popup,"Please Accept the Terms of Service");  
					}
					
				}
			});
			
			//Titles
			JPanel textTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 32, 27));
			textTitlePanel.setPreferredSize(new Dimension(170,150));
			textTitlePanel.setBackground(purple);
			JLabel emailAdress = new JLabel("Enter a Usename");
			JLabel a = new JLabel("Select an Age");
			
			textTitlePanel.add(emailAdress);
			textTitlePanel.add(a);
			mainPanel.add(textTitlePanel, BorderLayout.WEST);
			
			//Picture
			JPanel picPanel = new JPanel();
			picPanel.setBackground(Color.BLACK);
			picPanel.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("supernovaGL.jpg"))));
			picPanel.setPreferredSize(new Dimension(560,500));
			mainPanel.add(picPanel, BorderLayout.SOUTH);
			
			
			
			
			//Important
			this.setLocationRelativeTo(null);  
			this.setResizable(false);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	public static void main(String[] args) {
		new ProjectGuestLoginPage();
		
	}

}
