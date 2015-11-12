import java.util.ArrayList;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DefaultStringConverter;

/**Class: VideoTab.java
 * @author Conner Layson
 * @version 1.0
 * Course: ITEC 3150 Spring 2015
 * Written: Feb 1, 2015
 *
 *
 * This Class - Contains all of the controls and containers used in the Video Tab of the user interface.
 *
 * Purpose: Contains constructor for creating all of the video tables and video table columns. Also contains methods for performing searches and deletions on the video table. An inner class provides all of the table cell
 * action listening.
 */

public class VideoTab
{
	private TableView<Video> videoTable = new TableView<Video>();
	private ObservableList<Video> videoTableData = FXCollections.observableArrayList();
	private TableColumn<Video,String> videoName, genre, rating, director, videoFormat, videoItemNumber;
	private final ObservableList<String> videoFormatComboBox = FXCollections.observableArrayList("DVD", "DVD High Definition", "Digital", "Digital High Definition");
	private final ObservableList<String> genreComboBox = FXCollections.observableArrayList("Drama", "Horror", "Comedy", "Family");
	private Tab videoTab;

	@SuppressWarnings("unchecked")
	public VideoTab()
	{
		videoItemNumber = new TableColumn<Video,String>("Item Number");
		videoItemNumber.setCellValueFactory(new PropertyValueFactory<Video, String>("itemNumber"));

		videoName = new TableColumn<Video,String>("Name");
		videoName.setCellValueFactory(new PropertyValueFactory<Video, String>("name"));
		videoName.setCellFactory(TextFieldTableCell.<Video>forTableColumn());
		videoName.setOnEditCommit(new VideoTableCellActionHandling("videoName"));

		videoFormat = new TableColumn<Video,String>("Format");
		videoFormat.setCellValueFactory(new PropertyValueFactory<Video, String>("videoFormat"));
		videoFormat.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), videoFormatComboBox));
		videoFormat.setOnEditCommit(new VideoTableCellActionHandling("videoFormat"));

		director = new TableColumn<Video,String>("Director");
		director.setCellValueFactory(new PropertyValueFactory<Video, String>("director"));
		director.setCellFactory(TextFieldTableCell.<Video>forTableColumn());
		director.setOnEditCommit(new VideoTableCellActionHandling("director"));

		rating = new TableColumn<Video,String>("Rating");
		rating.setCellValueFactory(new PropertyValueFactory<Video, String>("rating"));
		rating.setCellFactory(TextFieldTableCell.<Video>forTableColumn());
		rating.setOnEditCommit(new VideoTableCellActionHandling("rating"));

		genre = new TableColumn<Video,String>("Genre");
		genre.setCellValueFactory(new PropertyValueFactory<Video, String>("genre"));
		genre.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), genreComboBox));
		genre.setOnEditCommit(new VideoTableCellActionHandling("genre"));

		videoTable.getColumns().addAll(videoItemNumber, videoName, videoFormat, director, rating, genre);
		videoTable.setItems(videoTableData);
		videoTable.setEditable(true);		
		videoTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		videoTab = new Tab("Videos");
		videoTab.setClosable(false);
		videoTab.setContent(videoTable);
	}

	/** Method: getVideoTable
	 * @return the videoTable
	 */
	public TableView<Video> getVideoTable()
	{
		return videoTable;
	}

	/** Method: setVideoTable
	 * @param videoTable the videoTable to set
	 */
	public void setVideoTable(TableView<Video> videoTable)
	{
		this.videoTable = videoTable;
	}

	/** Method: getVideoTableData
	 * @return the videoTableData
	 */
	public ObservableList<Video> getVideoTableData()
	{
		return videoTableData;
	}

	/** Method: setVideoTableData
	 * @param videoTableData the videoTableData to set
	 */
	public void setVideoTableData(ObservableList<Video> videoTableData)
	{
		this.videoTableData = videoTableData;
	}

	/** Method: getVideoName
	 * @return the videoName
	 */
	public TableColumn<Video, String> getVideoName()
	{
		return videoName;
	}

	/** Method: setVideoName
	 * @param videoName the videoName to set
	 */
	public void setVideoName(TableColumn<Video, String> videoName)
	{
		this.videoName = videoName;
	}

	/** Method: getGenre
	 * @return the genre
	 */
	public TableColumn<Video, String> getGenre()
	{
		return genre;
	}

	/** Method: setGenre
	 * @param genre the genre to set
	 */
	public void setGenre(TableColumn<Video, String> genre)
	{
		this.genre = genre;
	}

	/** Method: getRating
	 * @return the rating
	 */
	public TableColumn<Video, String> getRating()
	{
		return rating;
	}

	/** Method: setRating
	 * @param rating the rating to set
	 */
	public void setRating(TableColumn<Video, String> rating)
	{
		this.rating = rating;
	}

	/** Method: getDirector
	 * @return the director
	 */
	public TableColumn<Video, String> getDirector()
	{
		return director;
	}

	/** Method: setDirector
	 * @param director the director to set
	 */
	public void setDirector(TableColumn<Video, String> director)
	{
		this.director = director;
	}

	/** Method: getVideoFormat
	 * @return the videoFormat
	 */
	public TableColumn<Video, String> getVideoFormat()
	{
		return videoFormat;
	}

	/** Method: setVideoFormat
	 * @param videoFormat the videoFormat to set
	 */
	public void setVideoFormat(TableColumn<Video, String> videoFormat)
	{
		this.videoFormat = videoFormat;
	}

	/** Method: getVideoItemNumber
	 * @return the videoItemNumber
	 */
	public TableColumn<Video, String> getVideoItemNumber()
	{
		return videoItemNumber;
	}

	/** Method: setVideoItemNumber
	 * @param videoItemNumber the videoItemNumber to set
	 */
	public void setVideoItemNumber(TableColumn<Video, String> videoItemNumber)
	{
		this.videoItemNumber = videoItemNumber;
	}

	/** Method: getVideoTab
	 * @return the videoTab
	 */
	public Tab getVideoTab()
	{
		return videoTab;
	}

	/** Method: setVideoTab
	 * @param videoTab the videoTab to set
	 */
	public void setVideoTab(Tab videoTab)
	{
		this.videoTab = videoTab;
	}

	/** Method: getVideoFormatComboBox
	 * @return the videoFormatComboBox
	 */
	public ObservableList<String> getVideoFormatComboBox()
	{
		return videoFormatComboBox;
	}

	/** Method: getGenreComboBox
	 * @return the genreComboBox
	 */
	public ObservableList<String> getGenreComboBox()
	{
		return genreComboBox;
	}
	
	/**	Method: removeSelectedVideoRow
	 *	Description: removes the selected row from the video table
	 */
	public void removeSelectedVideoRow()
	{
		videoTable.getItems().remove(videoTable.getSelectionModel().getSelectedItem());
	}
	
	/**	Method: searchVideoItemNumber
	 *	Description: searches the video table for the user input item number. If a mathc is found the correct record is selected.
	 * @param input the user input itemNumber
	 */
	public void searchVideoItemNumber(String input)
	{
		for (Video numberMatch : videoTableData)
		{
			if (numberMatch.getItemNumber().equals(input))
			{
				videoTab.getTabPane().getSelectionModel().select(videoTab);
				videoTable.getSelectionModel().select(numberMatch);
			}
		}
	}
	
	/**	Method: findCurrentTableMaxItemNumber
	 *	Description: finds the highest item number in the video table without the letter prefix. This value is used for the next row that is added to the video table to give it a unique id.
	 * @return maxNumber the highest itemNumber in the video table without the letter prefix.
	 */
	public int findCurrentTableMaxItemNumber()
	{
		ArrayList<Integer> maxNumberList = new ArrayList<Integer>();
		maxNumberList.add(0);

		for (int i = 0; i < videoTableData.size(); i++)
		{
			int currentNumber = Integer.parseInt((videoTableData.get(i)).getItemNumber().substring(0, (videoTableData.get(i)).getItemNumber().length()-1));
			maxNumberList.add(currentNumber);
		}

		Integer maxNumber = Collections.max(maxNumberList);
		return maxNumber;
	}

	/**Class: VideoTableCellActionHandling.java
	 * @author Conner Layson
	 * @version 1.0
	 * Course: ITEC 3150 Spring 2015
	 * Written: Feb 1, 2015
	 *
	 *
	 * This Class - Handles all of the cell edit events for the video table.
	 *
	 * Purpose: Allows the table to save any edits or changes made in the table cells.
	 */
	class VideoTableCellActionHandling implements EventHandler<CellEditEvent<Video, String>>
	{
		private String objectName;

		public VideoTableCellActionHandling(String objectName)
		{
			super();
			this.objectName = objectName;
		}

		/**	Method: handle
		 *	Description: Override method that handles all of the cell edit events based on the object id that an object was given when the listener was added.
		 * @param t the cell edit event
		 */
		@Override
		public void handle(CellEditEvent<Video, String> t)
		{
			if (this.objectName.equals("videoName"))
			{
				((Video) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
			}
			else if (this.objectName.equals("videoFormat"))
			{
				((Video) t.getTableView().getItems().get(t.getTablePosition().getRow())).setVideoFormat(t.getNewValue());
			}
			else if (this.objectName.equals("rating"))
			{
				((Video) t.getTableView().getItems().get(t.getTablePosition().getRow())).setRating(t.getNewValue());
			}
			else if (this.objectName.equals("director"))
			{
				((Video) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDirector(t.getNewValue());
			}
			else
			{
				((Video) t.getTableView().getItems().get(t.getTablePosition().getRow())).setGenre(t.getNewValue());
			}
		}
	}
}
