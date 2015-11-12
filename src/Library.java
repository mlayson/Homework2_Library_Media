import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**Class: Library.java
 * @author Conner Layson
 * @version 1.0
 * Course: ITEC 3150 Spring 2015
 * Written: Jan 20, 2015
 *
 *
 * This Class - The main GUI class for the application. 
 *
 * Purpose: Creates all the objects needed for the application. Also includes file input/output methods to save and read the data from a CSV file.
 */

public class Library extends Application 
{
	private Group root;
	private Scene scene;
	private BorderPane borderPane;
	private TabPane pane;
	private BookTab bookTab;
	private VideoTab videoTab;
	private MusicTab musicTab;
	private LibraryMenuBar libraryMenuBar;

	/** Method: getRoot
	 * @return the root group for the scene
	 */
	public Group getRoot()
	{
		return root;
	}

	/** Method: setRoot
	 * @param root the root to set
	 */
	public void setRoot(Group root)
	{
		this.root = root;
	}

	/** Method: getScene
	 * @return the scene to get
	 */
	public Scene getScene()
	{
		return scene;
	}

	/** Method: setScene
	 * @param scene the scene to set
	 */
	public void setScene(Scene scene)
	{
		this.scene = scene;
	}

	/** Method: getBorderPane
	 * @return the borderPane
	 */
	public BorderPane getBorderPane()
	{
		return borderPane;
	}

	/** Method: setBorderPane
	 * @param borderPane the borderPane to set
	 */
	public void setBorderPane(BorderPane borderPane)
	{
		this.borderPane = borderPane;
	}

	/** Method: getPane
	 * @return the pane
	 */
	public TabPane getPane()
	{
		return pane;
	}

	/** Method: setPane
	 * @param pane the pane to set
	 */
	public void setPane(TabPane pane)
	{
		this.pane = pane;
	}

	/** Method: getBookTab
	 * @return the bookTab
	 */
	public BookTab getBookTab()
	{
		return bookTab;
	}

	/** Method: setBookTab
	 * @param bookTab the bookTab to set
	 */
	public void setBookTab(BookTab bookTab)
	{
		this.bookTab = bookTab;
	}

	/** Method: getVideoTab
	 * @return the videoTab
	 */
	public VideoTab getVideoTab()
	{
		return videoTab;
	}

	/** Method: setVideoTab
	 * @param videoTab the videoTab to set
	 */
	public void setVideoTab(VideoTab videoTab)
	{
		this.videoTab = videoTab;
	}

	/** Method: getMusicTab
	 * @return the musicTab
	 */
	public MusicTab getMusicTab()
	{
		return musicTab;
	}

	/** Method: setMusicTab
	 * @param musicTab the musicTab to set
	 */
	public void setMusicTab(MusicTab musicTab)
	{
		this.musicTab = musicTab;
	}

	/** Method: getLibraryMenuBar
	 * @return the libraryMenuBar
	 */
	public LibraryMenuBar getLibraryMenuBar()
	{
		return libraryMenuBar;
	}

	/** Method: setLibraryMenuBar
	 * @param libraryMenuBar the libraryMenuBar to set
	 */
	public void setLibraryMenuBar(LibraryMenuBar libraryMenuBar)
	{
		this.libraryMenuBar = libraryMenuBar;
	}

	/**	Method: writeDataFile
	 *	Description: Writes each table to a separate CSV file
	 */
	public void writeDataFile() 
	{
		BufferedWriter bookWriter = null;
		BufferedWriter musicWriter = null;
		BufferedWriter videoWriter = null;

		try 
		{
			bookWriter = new BufferedWriter(new FileWriter("Books.csv."));
			musicWriter = new BufferedWriter(new FileWriter("Music.csv."));
			videoWriter = new BufferedWriter(new FileWriter("Videos.csv."));

			for (Book currentBooks : this.getBookTab().getBookTableData()) 
			{
				String text = currentBooks.getItemNumber() + "," + currentBooks.getName() + "," + currentBooks.getType() + "," + currentBooks.getBookFormat() + "," + currentBooks.getAuthor() + "\n";
				bookWriter.write(text);
			}
			
			for (Music currentMusic : this.getMusicTab().getMusicTableData()) 
			{
				String text = currentMusic.getItemNumber() + "," + currentMusic.getName() + "," + currentMusic.getType() + "," + currentMusic.getMusicFormat() + "," + currentMusic.getArtist() + "\n";
				musicWriter.write(text);
			}
			
			for (Video currentVideos : this.getVideoTab().getVideoTableData()) 
			{
				String text = currentVideos.getItemNumber() + "," + currentVideos.getName() + "," + currentVideos.getType() + "," + currentVideos.getVideoFormat() + "," + currentVideos.getDirector() + "," + currentVideos.getRating() + "," + currentVideos.getGenre() + "\n";
				videoWriter.write(text);
			}
		} 
		
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		finally 
		{
			try 
			{
				bookWriter.flush();
				bookWriter.close();
				musicWriter.flush();
				musicWriter.close();
				videoWriter.flush();
				videoWriter.close();
			} 
			
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
	}

	/**	Method: readDataFile
	 *	Description: Reads in the 3 CSV files and adds them as new objects into the observable list's the table model uses.
	 */
	public void readDataFile()
	{
		BufferedReader bookReader = null;
		BufferedReader musicReader = null;
		BufferedReader videoReader = null;
		String line = "";
		String cvsSplitBy = ",";

		try 
		{
			bookReader = new BufferedReader(new FileReader("Books.csv."));
			musicReader = new BufferedReader(new FileReader("Music.csv."));
			videoReader = new BufferedReader(new FileReader("Videos.csv."));

			while ((line = bookReader.readLine()) != null) 
			{
				String[] currentBook = line.split(cvsSplitBy);
				this.getBookTab().getBookTableData().add(new Book(currentBook[0],currentBook[1],currentBook[2],currentBook[3],currentBook[4]));
			}

			line = "";

			while ((line = musicReader.readLine()) != null) 
			{
				String[] currentMusic = line.split(cvsSplitBy);
				this.getMusicTab().getMusicTableData().add(new Music(currentMusic[0],currentMusic[1],currentMusic[2],currentMusic[3],currentMusic[4]));
			}

			line = "";

			while ((line = videoReader.readLine()) != null) 
			{
				String[] currentVideo = line.split(cvsSplitBy);
				this.getVideoTab().getVideoTableData().add(new Video(currentVideo[0],currentVideo[1],currentVideo[2],currentVideo[3],currentVideo[4],currentVideo[5],currentVideo[6]));
			}
		} 
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		
		finally 
		{
			try 
			{
				if (bookReader != null) 
				{
					bookReader.close();
				}
				if (musicReader != null) 
				{
					musicReader.close();
				}
				if (videoReader != null) 
				{
					videoReader.close();
				}
			} 
			
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	/**	Method: start
	 *	Description: Overide method to start the application. Creates all the objects and the shows the stage.
	 * @param primaryStage the main stage for the application
	 */
	@Override
	public void start(Stage primaryStage) 
	{
		primaryStage.setTitle("Library");
		root = new Group();
		scene = new Scene(root, 900, 900, Color.WHITE);
		primaryStage.setScene(scene);
		bookTab = new BookTab();
		musicTab = new MusicTab();
		videoTab = new VideoTab();
		this.readDataFile();
		libraryMenuBar = new LibraryMenuBar(bookTab, musicTab, videoTab);
		pane = new TabPane();
		pane.getTabs().addAll(bookTab.getBookTab(), musicTab.getMusicTab(), videoTab.getVideoTab());
		borderPane = new BorderPane();
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		borderPane.setTop(libraryMenuBar.getMenuBar());
		borderPane.setCenter(pane);
		root.getChildren().addAll(borderPane);
		primaryStage.show();
	}

	/**	Method: stop
	 *	Description: Override method used in order to save the table data once the user exits the program 
	 */
	@Override
	public void stop()
	{
		try 
		{
			writeDataFile();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**	Method: main
	 *	Description: Main method for the class. Used to launch the application
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
}