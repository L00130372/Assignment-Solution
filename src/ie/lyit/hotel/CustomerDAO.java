/*Aaron McNamee - L00130372
Software Implementation Assignment - DAO Patterns*/
package ie.lyit.hotel;

public interface CustomerDAO {
	public void add();
	public void list();
	Customer view();
	public void delete();
	public void edit();
	public void writeRecordsToFile();
	public void readRecordsFromFile();
	}
