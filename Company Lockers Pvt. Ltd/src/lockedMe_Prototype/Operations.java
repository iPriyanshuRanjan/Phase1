package lockedMe_Prototype;

import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class Operations {
	Instrumentation ins = null ;
	private Scanner scan = new Scanner(System.in); 
	int choice;
	protected ArrayList<String> arr = new ArrayList<String>();
	
	
	@Override
	public String toString() {
		return "Files [arr=" + arr + "]";
	}
	
	public boolean isDocEmpty() {
		Serialization s = new Serialization(arr);
		var num = s.deserialize();
		if(ins.getObjectSize(num) == 0)
			return true;
		return false;
		
	}
	
	public boolean isEmpty() {
		if(arr.size() == 0)
			return true;
		return false;
		
	}
	public long length() {
		if(isEmpty() && isDocEmpty())
			return 0;
		else {
			if(! isEmpty())
				return(arr.size());
			else if ( ! isDocEmpty()) {
				Serialization s = new Serialization(arr);
				var num = s.deserialize();
				return(ins.getObjectSize(num));
			}
		}
		return 0;
	}

	public void display() {
		try {
			if(isEmpty() && isDocEmpty())
				throw new FNF_Exception("No Files To Display");
			else {
				if(! isEmpty())
					for (String string : arr) {
						System.out.println(string);
					}
				else if ( ! isDocEmpty()) {
					Serialization s = new Serialization(arr);
					var num = s.deserialize();
					System.out.println(num);
				}


			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}


	
	public void execute() {
		boolean ans = true;
		boolean flag=false;
		while(ans) {
		System.out.println("\nEnter Your choice: \n 1. Add File \n 2. Delete File \n 3. Search File \n 4. Go to main menu");
		String FileName;
		inputCheck.inp();
		switch(inputCheck.x) {
		case "1" :
			System.out.println("Enter the filename to be added: ");
			FileName = scan.next();
			AddFile(FileName);
			break;
		case "2":
			System.out.println("Enter the filename to be deleted: \n NOTE : File Names Are Case-Sensitive ");
			FileName = scan.next();
			DeleteFile(FileName);
			break;
		case "3":
			System.out.println("Enter the filename to be searched: \n NOTE: File Names Are Case-Sensitive ");
			FileName = scan.next();
			SearchFile(FileName);
			break;
		case "4":
			System.out.println("Redirectring");
			WelcomeClass.welcome();
			ans=false;
			break;
		default: 
			System.out.println("Enter a valid option");
		}
		}
	}
	public void AddFile(String name) {
		arr.add(name);
		System.out.println("Added Successfully..");
		Collections.sort(arr);
		Serialization s = new Serialization(arr);
		s.serialize();
	}
	public void DeleteFile(String name) {
		try {
			boolean num =false ;
			for (String str : arr) {
				if(str.equals(name))
					num =true;
			}
		if(num) {
			arr.remove(name);
			System.out.println(name +" was removed successfully \n The New List is " + arr.toString());
		}
		else 
			throw new FNF_Exception("File Not Found");
		}
		catch(FNF_Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void SearchFile(String Name) {
		try {
			boolean num =false ;
			for (String str : arr) {
				if(str.equals(Name))
					num =true;
			}
			if(num) {
				System.out.println(Name + " is found at : " +arr.indexOf(Name));
			}
			else 
				throw new FNF_Exception("File Not Found");
		}
			catch(FNF_Exception e) {
				System.out.println(e.getMessage());
			}
	}
	public void exit() {
		Serialization s = new Serialization(arr);
		System.out.println(s.deserialize());
		System.out.println("Exitted");
		System.exit(0);
	}
}

