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

/**Class: MusicTab.java
 * @author Conner Layson
 * @version 1.0
 * Course: ITEC 3150 Spring 2015
 * Written: Feb 1, 2015
 *
 *
 * This Class - Contains all of the controls and containers used in the Music Tab of the user interface.
 *
 * Purpose: Contains constructor for creating all of the music tables and music table columns. Also contains methods for performing searches and deletions on the music table. An inner class provides all of the table cell
 * action listening.
 */

public class MusicTab
{
	private TableView<Music> musicTable = new TableView<Music>();
	private ObservableList<Music> musicTableData = FXCollections.observableArrayList();
	private TableColumn<Music,String> artist, musicFormat, musicName, musicItemNumber;
	private final ObservableList<String> musicFormatComboBox = FXCollections.observableArrayList("Vinyl", "Digital", "CD");
	private Tab musicTab;

	@SuppressWarnings("unchecked")
	public MusicTab()
	{
		musicItemNumber = new TableColumn<Music,String>("Item Number");
		musicItemNumber.setCellValueFactory(new PropertyValueFactory<Music, String>("itemNumber"));

		musicName = new TableColumn<Music,String>("Name");
		musicName.setCellValueFactory(new PropertyValueFactory<Music, String>("name"));
		musicName.setCellFactory(TextFieldTableCell.<Music>forTableColumn());
		musicName.setOnEditCommit(new MusicTableCellActionHandling("musicName"));

		musicFormat = new TableColumn<Music,String>("Format");
		musicFormat.setCellValueFactory(new PropertyValueFactory<Music, String>("musicFormat"));
		musicFormat.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), musicFormatComboBox));
		musicFormat.setOnEditCommit(new MusicTableCellActionHandling("musicFormat"));

		artist = new TableColumn<Music,String>("Artist");
		artist.setCellValueFactory(new PropertyValueFactory<Music, String>("artist"));
		artist.setCellFactory(TextFieldTableCell.<Music>forTableColumn());
		artist.setOnEditCommit(new MusicTableCellActionHandling("artist"));

		musicTable.getColumns().addAll(musicItemNumber, musicName, musicFormat, artist);
		musicTable.setItems(musicTableData);
		musicTable.setEditable(true);
		musicTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		musicTab = new Tab("Music");
		musicTab.setClosable(false);
		musicTab.setContent(musicTable);
	}

	/** Method: getMusicTable
	 * @return the musicTable
	 */
	public TableView<Music> getMusicTable()
	{
		return musicTable;
	}

	/** Method: setMusicTable
	 * @param musicTable the musicTable to set
	 */
	public void setMusicTable(TableView<Music> musicTable)
	{
		this.musicTable = musicTable;
	}

	/** Method: getMusicTableData
	 * @return the musicTableData
	 */
	public ObservableList<Music> getMusicTableData()
	{
		return musicTableData;
	}

	/** Method: setMusicTableData
	 * @param musicTableData the musicTableData to set
	 */
	public void setMusicTableData(ObservableList<Music> musicTableData)
	{
		this.musicTableData = musicTableData;
	}

	/** Method: getArtist
	 * @return the artist
	 */
	public TableColumn<Music, String> getArtist()
	{
		return artist;
	}

	/** Method: setArtist
	 * @param artist the artist to set
	 */
	public void setArtist(TableColumn<Music, String> artist)
	{
		this.artist = artist;
	}

	/** Method: getMusicFormat
	 * @return the musicFormat
	 */
	public TableColumn<Music, String> getMusicFormat()
	{
		return musicFormat;
	}

	/** Method: setMusicFormat
	 * @param musicFormat the musicFormat to set
	 */
	public void setMusicFormat(TableColumn<Music, String> musicFormat)
	{
		this.musicFormat = musicFormat;
	}

	/** Method: getMusicName
	 * @return the musicName
	 */
	public TableColumn<Music, String> getMusicName()
	{
		return musicName;
	}

	/** Method: setMusicName
	 * @param musicName the musicName to set
	 */
	public void setMusicName(TableColumn<Music, String> musicName)
	{
		this.musicName = musicName;
	}

	/** Method: getMusicItemNumber
	 * @return the musicItemNumber
	 */
	public TableColumn<Music, String> getMusicItemNumber()
	{
		return musicItemNumber;
	}

	/** Method: setMusicItemNumber
	 * @param musicItemNumber the musicItemNumber to set
	 */
	public void setMusicItemNumber(TableColumn<Music, String> musicItemNumber)
	{
		this.musicItemNumber = musicItemNumber;
	}

	/** Method: getMusicTab
	 * @return the musicTab
	 */
	public Tab getMusicTab()
	{
		return musicTab;
	}

	/** Method: setMusicTab
	 * @param musicTab the musicTab to set
	 */
	public void setMusicTab(Tab musicTab)
	{
		this.musicTab = musicTab;
	}

	/** Method: getMusicFormatComboBox
	 * @return the musicFormatComboBox
	 */
	public ObservableList<String> getMusicFormatComboBox()
	{
		return musicFormatComboBox;
	}

	/**	Method: removeSelectedMusicRow
	 *	Description: removes the selected row from the music table
	 */
	public void removeSelectedMusicRow()
	{
		musicTable.getItems().remove(musicTable.getSelectionModel().getSelectedItem());
	}

	/**	Method: searchMusicItemNumber
	 *	Description: searches the music table for the user input item number. If a match is found the correct record is selected.
	 * @param input the user input item number
	 */
	public void searchMusicItemNumber(String input)
	{
		for (Music numberMatch : musicTableData)
		{
			if (numberMatch.getItemNumber().equals(input))
			{
				musicTab.getTabPane().getSelectionModel().select(musicTab);
				musicTable.getSelectionModel().select(numberMatch);
			}
		}
	}

	/**	Method: findCurrentTableMaxItemNumber
	 *	Description: searches the music table and returns the highest item number without the letter prefix
	 * @return maxNumber the highest item number in the music table. This value is used in the next add row function.
	 */
	public int findCurrentTableMaxItemNumber()
	{
		ArrayList<Integer> maxNumberList = new ArrayList<Integer>();
		maxNumberList.add(0);

		for (int i = 0; i < musicTableData.size(); i++)
		{
			int currentNumber = Integer.parseInt((musicTableData.get(i)).getItemNumber().substring(0, (musicTableData.get(i)).getItemNumber().length()-1));
			maxNumberList.add(currentNumber);
		}

		Integer maxNumber = Collections.max(maxNumberList);
		return maxNumber;
	}

	/**Class: MusicTableCellActionHandling.java
	 * @author Conner Layson
	 * @version 1.0
	 * Course: ITEC 3150 Spring 2015
	 * Written: Feb 1, 2015
	 *
	 *
	 * This Class - Contains all the cell edit handling for the music table. 
	 *
	 * Purpose: To allow the table to save any changes made when editing.
	 */
	class MusicTableCellActionHandling implements EventHandler<CellEditEvent<Music, String>>
	{
		private String objectName;

		public MusicTableCellActionHandling(String objectName)
		{
			super();
			this.objectName = objectName;
		}

		/**	Method: handle
		 *	Description: Override method to handle all of the cell edit events.
		 * @param t the cell edit event
		 */
		@Override
		public void handle(CellEditEvent<Music, String> t)
		{
			if (this.objectName.equals("musicName"))
			{
				((Music) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
			}
			else if (this.objectName.equals("musicFormat"))
			{
				((Music) t.getTableView().getItems().get(t.getTablePosition().getRow())).setMusicFormat(t.getNewValue());
			}
			else
			{
				((Music) t.getTableView().getItems().get(t.getTablePosition().getRow())).setArtist(t.getNewValue());
			}
		}
	}
}
