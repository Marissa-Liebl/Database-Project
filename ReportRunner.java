import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReportRunner {

	public static int passwordChecker(String pass)
	{
		String hold = pass;
		if(hold.length() >= 6 && hold.length() <= 12)
		{
			if(hold.matches(".*\\W.*"))
			{
				if(hold.matches(".*[A-Z].*"))
				{
					if(hold.matches(".*\\d.*"))
					{
						return 0;
					}
					else return 4;
				}
				else return 3;
			}
			else return 2;
		}
		return 1;
		
	}
	
	public static ArrayList<User> findFemales(String a) throws FileNotFoundException 
	{
		Scanner file = new Scanner(new File(a));
		ArrayList<User> females = new ArrayList<>();
		Pattern pat = Pattern.compile(".*\\|F\\|.*");
		
		while(file.hasNextLine())
		{
			String h = file.nextLine();
			
			Matcher match = pat.matcher(h);
			while(match.find())
			{
				
				String[] hold = match.group().split("\\|");
				females.add(new User(hold[0],hold[1],hold[2],hold[3],hold[4],hold[5]));

			}

		}
		
		return females;
	}
	
	public static ArrayList<User> findFNLetterS(String b) throws FileNotFoundException	// Finds first names that start with S
	{
		Scanner file = new Scanner(new File(b));
		ArrayList<User> firstLetterS = new ArrayList<>();
		Pattern pat = Pattern.compile("^S.*");
		
		while(file.hasNextLine())
		{
			String h = file.nextLine();
			
			Matcher match = pat.matcher(h);
			while(match.find())
			{
				
				String[] hold = match.group().split("\\|");
				firstLetterS.add(new User(hold[0],hold[1],hold[2],hold[3],hold[4],hold[5]));

			}

		}
		
		return firstLetterS;
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.out.println(findFemales("User.dat"));
		System.out.println(findFNLetterS("User.dat"));
		
	}

}
