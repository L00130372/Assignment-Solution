/*Aaron McNamee - L00130372
Software Implementation Assignment - Serialization*/
package ie.lyit.testers;

import ie.lyit.serialize.CustomerSerializer;
import ie.lyit.hotel.Menu;
import ie.lyit.hotel.CustomerDAO;
public class CustomerSerializerTester {
   public static void main(String[] args) {
			CustomerDAO CustomerDAO1 = new CustomerSerializer();

					// Deserialize the ArrayList from the File,
					// i.e. read the customers ArrayList from the file back into the ArrayList
					CustomerDAO1.readRecordsFromFile();
					
				    // Create a Menu Object
					Menu menuObj = new Menu();
					
					do{
						// Call it's display() method
						menuObj.display();
						// Call it's readOption() method
						menuObj.readOption();
						// switch on the option and call the appropriate method
						switch(menuObj.getOption()){
						   case 1:CustomerDAO1.add();break;
						   case 2:CustomerDAO1.list();break;
						   case 3:CustomerDAO1.view();break;
						   case 4:CustomerDAO1.edit();break;
						   case 5:CustomerDAO1.delete();break;
						   case 6:break;				
						   default:System.out.println("INVALID OPTION...");
						}
					}while(menuObj.getOption() != 6);	
																						
					// Serialize the ArrayList to the File
					// i.e. write the customer ArrayList back into the the file		
					CustomerDAO1.writeRecordsToFile();
				}
			
           /* Add two records to the ArrayList
			customerSerializer.add();
			customerSerializer.add();
					
			// Write the ArrayList to File
			customerSerializer.writeRecordsToFile();
	
			
			// Read the ArrayList from the File
			customerSerializer.readRecordsFromFile();
			
			// List all the books in the ArrayList
			customerSerializer.list();*/
		}
	


