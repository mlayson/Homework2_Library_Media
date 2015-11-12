import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**Class: Music.java
 * @author Conner Layson
 * @version 1.0
 * Course: ITEC 3150 Spring 2015
 * Written: Jan 20, 2015
 *
 *
 * This Class - A subclass of the media class. Used for creating music objects
 *
 * Purpose: To create music objects along with their getters and setters.
 */

public class Music extends Media
{
	private SimpleStringProperty artist;
	private SimpleStringProperty musicFormat;
	
	public Music(String itemNumber, String name, String type, String musicFormat, String artist) 
	{
		super(itemNumber, name, type);
		this.artist = new SimpleStringProperty(artist);
		this.musicFormat = new SimpleStringProperty(musicFormat);
	}

	/**	Method: getArtist
	 * @return the string representation of the SimpleStringProperty artist field
	 */
	public String getArtist() 
	{
		return artist.get();
	}

	/**	Method: setArtist
	 * @param artist the string value to set the SimpleStringProperty artist field to
	 */
	public void setArtist(String artist) 
	{
		this.artist.set(artist);
	}

	/**	Method: getMusicFormat
	 * @return the string representation of the SimpleStringProperty musicFormat field
	 */
	public String getMusicFormat() 
	{
		return musicFormat.get();
	}

	/**	Method: setMusicFormat
	 * @param musicFormat the string value to set the SimpleStringProperty musicFormat field to
	 */
	public void setMusicFormat(String musicFormat) 
	{
		this.musicFormat.set(musicFormat);
	}
	
	/**	Method: getArtistProperty
	 * @return artist the artist to get
	 */
	public StringProperty getArtistProperty()
	{
		return this.artist;
	}
	
	/**	Method: getMusicFormatPropert
	 * @return musicFormat the musicFormat to get
	 */
	public StringProperty getMusicFormatProperty()
	{
		return this.musicFormat;
	}
}
