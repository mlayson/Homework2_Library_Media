import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**Class: Video.java
 * @author Conner Layson
 * @version 1.0
 * Course: ITEC 3150 Spring 2015
 * Written: Jan 20, 2015
 *
 *
 * This Class - A subclass of the media class. Used for creating video objects.
 *
 * Purpose: To create video objects along with their getters and setters. 
 */

public class Video extends Media
{
	private SimpleStringProperty director;
	private SimpleStringProperty rating;
	private SimpleStringProperty genre;
	private SimpleStringProperty videoFormat;
	
	public Video(String itemNumber, String name, String type, String videoFormat, String director, String rating, String genre) 
	{
		super(itemNumber, name, type);
		this.director = new SimpleStringProperty(director);
		this.rating = new SimpleStringProperty(rating);
		this.genre = new SimpleStringProperty(genre);
		this.videoFormat = new SimpleStringProperty(videoFormat);
	}
	
	/**	Method: getDirector
	 * @return the string representation of the director field
	 */
	public String getDirector() 
	{
		return director.get();
	}

	/**	Method: setDirector
	 * @param director the string value to set the director field to
	 */
	public void setDirector(String director) 
	{
		this.director.set(director);
	}

	/**	Method: getRating
	 * @return the string representation of the rating field
	 */
	public String getRating() 
	{
		return rating.get();
	}

	/**	Method: setRating
	 * @param rating the string value to set the rating field to
	 */
	public void setRating(String rating) 
	{
		this.rating.set(rating);
	}
	
	/**	Method: getGenre 
	 * @return the string representation of the genre field
	 */
	public String getGenre() 
	{
		return genre.get();
	}

	/**	Method: setGenre
	 * @param genre the string value to set the genre field to
	 */
	public void setGenre(String genre) 
	{
		this.genre.set(genre);
	}

	/**	Method: getVideoFormat
	 * @return the string representation of the video format field
	 */
	public String getVideoFormat()
	{
		return videoFormat.get();
	}

	/**	Method: setVideoFormat 
	 * @param videoFormat the string value to set the video format field to
	 */
	public void setVideoFormat(String videoFormat)
	{
		this.videoFormat.set(videoFormat);
	}
	
	/**	Method: getDirectorProperty
	 * @return director the director to get
	 */
	public StringProperty getDirectorProperty()
	{
		return this.director;
	}
	
	/**	Method: getRatingProperty
	 * @return rating the rating to get
	 */
	public StringProperty getRatingProperty()
	{
		return this.rating;
	}
	
	/**	Method: getGenreProperty
	 * @return genre the genre to get 
	 */
	public StringProperty getGenreProperty()
	{
		return this.genre;
	}

	/**	Method: getVideoFormatProperty 
	 * @return videFormat the video format to get
	 */
	public StringProperty getVideoFormatProperty()
	{
		return this.videoFormat;
	}
}
