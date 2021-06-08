package lockedMe_Prototype;

import java.util.Scanner;

class inputCheck{
	private static Scanner scan = new Scanner(System.in);
	public static String x;
	static void inp() {
		x = scan.next();
	}
	
}


public class WelcomeClass {
	static Scanner scan = new Scanner(System.in);
	static Operations op = new Operations();
	public static void welcome() {
		boolean cond = true;
		while(cond) {
		System.out.println("\nEnter Your Choice :");
		System.out.println("1. View List");
		System.out.println("2. Business Operations");
		System.out.println("3. Exit");
		var choice = scan.next();
		switch(choice) {
		
		case "1":
			op.display();
			break;
		case "2":
			op.execute();
			break;
		case "3":
			op.exit();
			cond = false ;
		
		}
		}
	}
	
	
	public static void main(String[] args) {

		System.out.println("Welcome");
		System.out.println("**********************          ***********************************");
		System.out.println("*********************            **********************************");
		System.out.println("******************** LockedMe.COM *********************************");
		System.out.println("********************              *********************************");
		System.out.println("*********************           ***********************************");
		System.out.println("**********************        *************************************");
		System.out.println("");
		System.out.println("A product of Company Lockers Pvt Ltd.\n");
		System.out.println("Developed by Priyanshu Ranjan - Full Stack Developer at Company Lockers \n");
		System.out.println("To Commence the operations Your input is required, Provide the Number corresponding to your choice \n");

		welcome();
		
	}

}
