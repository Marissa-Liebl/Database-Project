
public class User {

	private static int totalNum = 0;
	private int id;
	
	private String firstName, lastName, email, password;
	
	private int age;
	private boolean tos = true;
	
	enum Gender{MALE, FEMALE, NO}
	private Gender myGender;
//	private String gender;
	
	
	public User(String e, int a)
	{
		email = e;
		age = a;
		totalNum++;
		id = totalNum;
	}
	
	public User(String e, String pw)
	{
		email = e;
		password = pw;
		totalNum++;
		id = totalNum;
	}
	
	public User(String f, String l, String e, String p, String g, String a)
	{
		firstName = f;
		lastName = l;
		email= e;
		password = p;
		
		if(g.equals("M"))
		{
			myGender = Gender.MALE;
		}
		else if(g.contentEquals("F"))
		{
			myGender = Gender.FEMALE;
		}
		else
		{
			myGender = Gender.NO;
		}
		
		age = Integer.parseInt(a);
		totalNum++;
		id = totalNum;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Gender getGender() {
		return myGender;
	}
	
	
//	public void setGender(String gender) {
//		this.gender = gender;
//	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	public String toString()
	{
		// Name Gender Email Password Age
		return String.format("%-10s%-40s%-20s%-40s%-30s%-4s","ID", "Name", "Gender", "Email", "Password", "Age") + "\n" + 	// not sure if this part is needed but it is here all the same
			   String.format("%-10s%-40s%-20s%-40s%-30s%-4s",id, firstName + " " + lastName, myGender, email, password, age);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
