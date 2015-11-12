import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**Class: Book.java
 * @author Conner Layson
 * @version 1.0
 * Course: ITEC 3150 Spring 2015
 * Written: Feb 1, 2015
 *
 *
 * This Class - A subclass of the media class and is used for creating book objects.
 *
 * Purpose: Inherits instance variables and methods from the superclass and uses String property fields so the objects fields are updated when the table model data changes.
 */

public class Book extends Media
{
	private SimpleStringProperty author;
	private SimpleStringProperty bookFormat;

	public Book(String itemNumber, String name, String type, String bookFormat, String author)
	{
		super(itemNumber, name, type);
		this.author = new SimpleStringProperty(author);
		this.bookFormat = new SimpleStringProperty(bookFormat);
	}

	/**	Method: getAuthor
	 * @return the string value of the SimpleStringProperty author field 
	 */
	public String getAuthor() 
	{
		return author.get();
	}

	/**	Method: setAuthor
	 * @param author the the String value to set the SimpleStringProperty author field to
	 */
	public void setAuthor(String author)
	{
		this.author.set(author);
	}

	/**	Method: getBookFormat
	 * @return the string value of the SimpleStringProperty bookFormat field 
	 */
	public String getBookFormat() 
	{
		return bookFormat.get();
	}

	/**	Method: setBookFormat
	 * @param bookFormat the String value to set the SimpleStringProperty bookFormat field to
	 */
	public void setBookFormat(String bookFormat) 
	{
		this.bookFormat.set(bookFormat);
	}
	
	/**	Method: getAuthorProperty
	 * @return author the SimpleStringProperty of the author field
	 */
	public StringProperty getAuthorProperty()
	{
		return this.author;
	}
	
	/**	Method: getBookFormatProperty
	 * @return bookFormat the SimpleStringProperty of the bookFormat field
	 */
	public StringProperty getBookFormatProperty()
	{
		return this.bookFormat;
	}
	
}
