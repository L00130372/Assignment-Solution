/*Aaron McNamee - L00130372
Software Implementation Assignment - Serialization*/
package ie.lyit.serialize;

import java.util.ArrayList;
import java.util.*;
import ie.lyit.hotel.Customer;
import java.io.*;
import ie.lyit.hotel.CustomerDAO;

public class CustomerSerializer implements CustomerDAO {
	private ArrayList<Customer> customers;

	private final String FILENAME = "cust.ser";
	
	// Default Constructor
		public CustomerSerializer(){
			// Construct CustomerList ArrayList
			customers = new ArrayList<Customer>();
}
// Method Name : add()
// Return Type : void
// Parameters : None						
// Purpose : Reads one Customer record from the user    
//           and adds it to the ArrayList customers1     
@Override		
public void add(){
	// Create a Customer object
	Customer Customers1 = new Customer();
	// Read its details
	Customers1.read();	
	// And add it to the customers ArrayList
	customers.add(Customers1);
	
}
//Method Name : list()							    
// Return Type : void			  				      
// Parameters : None						 	      
// Purpose : Lists all Customer records in the ArrayList
@Override
public void list(){
	// for every Customer object in customers
    for(Customer tmpCust:customers)
		// display it
		System.out.println(tmpCust);
}
//Method Name : view()									  
// Return Type : void								      
// Parameters : None								      
// Purpose : Displays the required Customer record on screen  
//         : And returns it, or null if not found  
@Override
public Customer view(){
	Scanner keyboard = new Scanner(System.in);		

	// Read the number of the customer to be viewed from the user
	System.out.println("ENTER NUMBER OF CUSTOMER : ");
	int customerToView=keyboard.nextInt();
	
	// for every Customer object in customers
    for(Customer tmpCust:customers){
	   // if it's number equals the number of the customerToView
	   if(tmpCust.getNumber() == customerToView){
	      // display it
		  System.out.println(tmpCust);
		  return tmpCust;
	   }
	}
    // if we reach this code the customer was not found so return null
    return null;
}
//Method Name : delete()								
// Return Type : void									 
// Parameters : None								
// Purpose : Deletes the required Customer record from customers
@Override
public void delete(){	
	// Call view() to find, display, & return the customer to delete
	Customer tempCustomer = view();
	// If the customer != null, i.e. it was found then...
    if(tempCustomer != null)
	   // ...remove it from customers
       customers.remove(tempCustomer);
}
//Method Name : edit()			  					     
// Return Type : void									 
// Parameters : None									 
// Purpose : Edits the required Customer record in customers 
@Override
public void edit(){	
	// Call view() to find, display, & return the customer to edit
	Customer tmpCust = view();
	// If the customer != null, i.e. it was found then...
    if(tmpCust != null){
	   // get it's index
	   int index=customers.indexOf(tmpCust);
	   // read in a new customer and...
	   tmpCust.read();
	   // reset the object in customers
	   customers.set(index, tmpCust);
    }
}


// This method will serialize the customers ArrayList when called, 
// i.e. it will write it to a file called cust.ser
@Override
public void writeRecordsToFile(){
	ObjectOutputStream os=null;
	try {
		// Serialize the ArrayList...
		FileOutputStream fileStream = new FileOutputStream(FILENAME);
	
		os = new ObjectOutputStream(fileStream);
			
		os.writeObject(customers);
	}
	catch(FileNotFoundException fNFE){
		System.out.println("Cannot create file to store customer details.");
	}
	catch(IOException ioE){
		System.out.println(ioE.getMessage());
	}
	finally {
		try {
			os.close();
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
	}
}
//This method will deserialize the customers ArrayList when called, 
	// i.e. it will restore the ArrayList from the file cust.ser
    @Override
	public void readRecordsFromFile(){
		ObjectInputStream is=null;
		
		try {
			// Deserialize the ArrayList...
			FileInputStream fileStream = new FileInputStream(FILENAME);
		
			is = new ObjectInputStream(fileStream);
				
			customers = (ArrayList<Customer>)is.readObject();	
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store customer details.");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally {
			try {
				is.close();
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
		}
	}
}