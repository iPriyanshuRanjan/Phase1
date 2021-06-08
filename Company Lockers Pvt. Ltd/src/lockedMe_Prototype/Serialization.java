package lockedMe_Prototype;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialization {
ArrayList<String> arr = new ArrayList<String>();
	
	String filename = "file.ser";
	
	public Serialization(ArrayList<String> s_array) {
		this.arr = s_array;
	}
	
	public void serialize() {
		try
	    {    
	        FileOutputStream file = new FileOutputStream(filename); 
	        ObjectOutputStream out = new ObjectOutputStream(file); 
	          
	        out.writeObject(arr); 
	          
	        out.close(); 
	        file.close(); 
	          
	        System.out.println("Object has been serialized"); 

	    } 
	      
	    catch(IOException ex) 
	    { 
	        System.out.println("IOException is caught"); 
	    } 
		
		
	}
	
	Object object1 = null;
	public Object deserialize() {
		try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(filename); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            try {
				object1 = in.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
              
            in.close(); 
            file.close();        
            System.out.println("Object has been deserialized "); 
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        }
		return object1; 
	}


}
