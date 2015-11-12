import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**Class: Media.java
 * @author Conner Layson
 * @version 1.0
 * Course: ITEC 3150 Spring 2015
 * Written: Jan 20, 2015
 *
 *
 * This Class - The superclass for the book, music, and video classes. 
 *
 * Purpose: To allow all 3 subclasses to inherit common attributes along with their getters and setters. Also uses SimpleStringProperty to allow the object's fields to be updated
 * when the table data is edited.
 */

public class Media
{
	private SimpleStringProperty itemNumber;
	private SimpleStringProperty name;
	private SimpleStringProperty type;

	public Media(String itemNumber, String name, String type) 
	{
		this.itemNumber = new SimpleStringProperty(""+ itemNumber);
		this.name = new SimpleStringProperty(name);
		this.type = new SimpleStringProperty(type);
	}

	/**	Method: getItemNumber 
	 * @return the string representation of the SimpleStringProperty itemNumber field
	 */
	public String getItemNumber()
	{
		return itemNumber.get();
	}

	/**	Method: setItemNumber
	 * @param itemNumber the String itemNumber to set the SimpleStringProperty itemNumber to.
	 */
	public void setItemNumber(String itemNumber)
	{
		this.itemNumber.set(itemNumber);
	}

	/**	Method: getName
	 * @return the string representaion of the SimpleStringProperty name field
	 */
	public String getName()
	{
		return this.name.get();
	}

	/**	Method: setName 
	 * @param name the string value to set the SimpleStringProperty name field to
	 */
	public void setName(String name)
	{
		this.name.set(name);
	}

	/**	Method: getType 
	 * @return the string representation of the SimpleStringProperty type field
	 */
	public String getType()
	{
		return this.type.get();
	}

	/**	Method: setType
	 * @param type the string value to set the SimpleStringProperty type field to.
	 */
	public void setType(String type)
	{
		this.type.set(type);
	}
	
	/**	Method: getNameProperty 
	 * @return name the name to get 
	 */
	public StringProperty getNameProperty()
	{
		return this.name;
	}
	
	/**	Method: getItemNumberProperty
	 * @return itemNumber the itemNumber to get
	 */
	public StringProperty getItemNumberProperty()
	{
		return this.itemNumber;
	}
	
	/**	Method: getTypeProperty
	 * @return type the type to get
	 */
	public StringProperty getTypeProperty()
	{
		return this.type;
	}
}
