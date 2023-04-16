import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ProjectAccountPage extends JFrame {

	
	// Possibly add in some CheckBoxes 
	
	JTextField firstName;
	JTextField lastName;
	JTextField email;
	JPasswordField password;
	JPasswordField confirmPassword;
	

	JButton createAccount;
	JButton login;
	Color gold = new Color(212,175,55);
	Color purple = new Color(162,107,243);
	
	JRadioButton mRadioB = new JRadioButton("Male");
	JRadioButton fRadioB = new JRadioButton("Female");
	JRadioButton pnsRadioB = new JRadioButton("Prefer not to say");
	ButtonGroup genderBG = new ButtonGroup();
	public ProjectAccountPage()
	{
	setSize(500, 650);
	setTitle("SuperNova Create Account");	
	this.setIconImage(new ImageIcon(getClass().getResource("supernova.jpg")).getImage());
	
	//Main Panel
	JPanel mainPanel = new JPanel(new BorderLayout());
	this.add(mainPanel);
	
	
	//Text Input Panel
	JPanel textInputPanel =  new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 19));
	textInputPanel.setBackground(gold);
	mainPanel.add(textInputPanel, BorderLayout.CENTER);
	
	
	firstName = new JTextField(30);
	lastName = new JTextField(30);
	email = new JTextField(30);
	password = new JPasswordField(30);
	confirmPassword = new JPasswordField(30);
	
	
	textInputPanel.add(firstName);
	textInputPanel.add(lastName);
	textInputPanel.add(email);
	textInputPanel.add(password);
	textInputPanel.add(confirmPassword);
	
	
	//Titles
	JPanel textTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 32, 24));
	textTitlePanel.setPreferredSize(new Dimension(150,250));
	textTitlePanel.setBackground(purple);
	
	
	JLabel fn = new JLabel("First Name", JLabel.CENTER);  
	JLabel ln = new JLabel("Last Name", JLabel.CENTER);
	JLabel e = new JLabel("Email", JLabel.CENTER);
	JLabel pw = new JLabel("Password", JLabel.CENTER);
	JLabel cPW = new JLabel("Confirm Password", JLabel.CENTER);
	JLabel g = new JLabel("Select Gender", JLabel.CENTER);
	JLabel a = new JLabel("Select Age", JLabel.CENTER);
	
	textTitlePanel.add(fn);
	textTitlePanel.add(ln);
	textTitlePanel.add(e);
	textTitlePanel.add(pw);
	textTitlePanel.add(cPW);
	textTitlePanel.add(g);
	textTitlePanel.add(a);
	
	mainPanel.add(textTitlePanel, BorderLayout.WEST);
	
	//Gender Panel
	JPanel genderPanel = new JPanel();
    mRadioB = new JRadioButton("Male");
	fRadioB = new JRadioButton("Female");
	pnsRadioB = new JRadioButton("Prefer not to say");
	genderBG = new ButtonGroup();
	genderBG.add(mRadioB);
	genderBG.add(fRadioB);
	genderBG.add(pnsRadioB);
	genderPanel.add(mRadioB);
	genderPanel.add(fRadioB);
	genderPanel.add(pnsRadioB);
	textInputPanel.add(genderPanel);
	

	//Age 
	String[] ages = new String[100];
	for(int i = 1, b = 0; b < ages.length; i ++, b ++)
	{
		String h = i + "";
		ages[b] = h;
	}
	
	JComboBox<String> age = new JComboBox(ages);
	textInputPanel.add(age);
	
	//more buttons
	createAccount = new JButton("Create Account");
	textInputPanel.add(createAccount);
	createAccount.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			String fn = firstName.getText();
			String ln = lastName.getText();
			String em = email.getText();
			String pw = "";
			char[] holdP = password.getPassword();
			for(int i = 0; i < holdP.length; i ++)
			{
				pw += holdP[i];
			}
			
			String cPW = "";
			char[] holdCP = confirmPassword.getPassword();
			for(int i = 0; i < holdCP.length; i ++)
			{
				cPW += holdCP[i];
			}
			String fPass = "";
			if(pw.equals(cPW))
			{
				fPass = pw;
			}
			int err = ReportRunner.passwordChecker(fPass);
			if(err == 1)
			{
				JFrame popup = new JFrame();
				JOptionPane.showMessageDialog(popup,"Please enter a Password with a length between 6-12 characters"); 
				fPass = "";
			}
			else if(err == 2)
			{
				JFrame popup = new JFrame();
				JOptionPane.showMessageDialog(popup,"Please include a special character in your password");  
				fPass = "";
			}
			else if(err == 3)
			{
				JFrame popup = new JFrame();
				JOptionPane.showMessageDialog(popup,"Please Add a Capital Letter to your password"); 
				fPass = "";
			}
			else if(err == 4)
			{
				JFrame popup = new JFrame();
				JOptionPane.showMessageDialog(popup,"Please Add a Digit to your password");  
				fPass = "";
			}
			
			String g;
			if(mRadioB.isSelected())
			{
				g = "M";
			}
			else if(fRadioB.isSelected())
			{
				g = "F";
			}
			else
				g = null;
			if(fn.equals("") || ln.equals("") || em.equals("") || pw.equals("") || cPW.equals(""))
			{
				JFrame popup = new JFrame();
				JOptionPane.showMessageDialog(popup,"You are missing one or more fields, Please check your data.");  
			}
			else
			{
			String a = (String)age.getSelectedItem();
			
			if(!fPass.equals(""))
				{
				User n = new User(fn, ln, em, pw, g, a);
		
				System.out.println(n);
				ProjectAccountPage.this.dispose();
				}
			}
			
			
		}
		
	});
	
	
	//picture Panel
	JPanel picPanel = new JPanel();
	picPanel.setBackground(Color.BLACK);
	picPanel.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("supernovaAP.jpg"))));
	picPanel.setPreferredSize(new Dimension(560,300));
	mainPanel.add(picPanel, BorderLayout.SOUTH);
	
	
	
	//Important
//	this.pack();
	this.setLocationRelativeTo(null);  
	this.setResizable(false);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	}
	public static void main(String[] args) {
		new ProjectAccountPage();

	}

}
