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

/**Class: BookTab.java
 * @author Conner Layson
 * @version 1.0
 * Course: ITEC 3150 Spring 2015
 * Written: Feb 1, 2015
 *
 *
 * This Class - Contains all of the controls and containers used in the Book Tab of the user interface. 
 *
 * Purpose: Contains constructor for creating all of the book tables and book table columns. Also contains methods for performing searches and deletions on the book table. An inner class provides all of the table cell
 * action listening.
 */

public class BookTab
{
	private ObservableList<Book> bookTableData = FXCollections.observableArrayList();
	private final TableView<Book> bookTable = new TableView<Book>();
	private TableColumn<Book,String> bookItemNumber, bookName, bookFormat, author;
	private final ObservableList<String> bookFormatComboBox = FXCollections.observableArrayList("Print", "E-Book", "Audio Book");
	private Tab bookTab;

	@SuppressWarnings("unchecked")
	public BookTab()
	{
		bookItemNumber = new TableColumn<Book,String>("Item Number");
		bookItemNumber.setCellValueFactory(new PropertyValueFactory<Book, String>("itemNumber"));
		bookItemNumber.setCellFactory(TextFieldTableCell.<Book>forTableColumn());

		bookName = new TableColumn<Book,String>("Name");
		bookName.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
		bookName.setCellFactory(TextFieldTableCell.<Book>forTableColumn());
		bookName.setOnEditCommit(new BookTableCellActionHandling("bookName"));

		bookFormat = new TableColumn<Book,String>("Format");
		bookFormat.setCellValueFactory(new PropertyValueFactory<Book, String>("bookFormat"));
		bookFormat.setCellFactory(ComboBoxTableCell.<Book,String>forTableColumn(new DefaultStringConverter(), bookFormatComboBox));
		bookFormat.setOnEditCommit(new BookTableCellActionHandling("bookFormat"));

		author = new TableColumn<Book,String>("Author");
		author.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
		author.setCellFactory(TextFieldTableCell.<Book>forTableColumn());
		author.setOnEditCommit(new BookTableCellActionHandling("author"));

		bookTable.getColumns().addAll(bookItemNumber, bookName, bookFormat, author);
		bookTable.setItems(bookTableData);
		bookTable.setEditable(true);
		bookTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		bookTab = new Tab("Books");
		bookTab.setClosable(false);
		bookTab.setContent(bookTable);
	}

	/** Method: getBookTableData
	 * @return the bookTableData
	 */
	public ObservableList<Book> getBookTableData()
	{
		return bookTableData;
	}

	/** Method: setBookTableData
	 * @param bookTableData the bookTableData to set
	 */
	public void setBookTableData(ObservableList<Book> bookTableData)
	{
		this.bookTableData = bookTableData;
	}

	/** Method: getBookItemNumber
	 * @return the bookItemNumber
	 */
	public TableColumn<Book, String> getBookItemNumber()
	{
		return bookItemNumber;
	}

	/** Method: setBookItemNumber
	 * @param bookItemNumber the bookItemNumber to set
	 */
	public void setBookItemNumber(TableColumn<Book, String> bookItemNumber)
	{
		this.bookItemNumber = bookItemNumber;
	}

	/** Method: getBookName
	 * @return the bookName
	 */
	public TableColumn<Book, String> getBookName()
	{
		return bookName;
	}

	/** Method: setBookName
	 * @param bookName the bookName to set
	 */
	public void setBookName(TableColumn<Book, String> bookName)
	{
		this.bookName = bookName;
	}

	/** Method: getBookFormat
	 * @return the bookFormat
	 */
	public TableColumn<Book, String> getBookFormat()
	{
		return bookFormat;
	}

	/** Method: setBookFormat
	 * @param bookFormat the bookFormat to set
	 */
	public void setBookFormat(TableColumn<Book, String> bookFormat)
	{
		this.bookFormat = bookFormat;
	}

	/** Method: getAuthor
	 * @return the author
	 */
	public TableColumn<Book, String> getAuthor()
	{
		return author;
	}

	/** Method: setAuthor
	 * @param author the author to set
	 */
	public void setAuthor(TableColumn<Book, String> author)
	{
		this.author = author;
	}

	/** Method: getBookTab
	 * @return the bookTab
	 */
	public Tab getBookTab()
	{
		return bookTab;
	}

	/** Method: setBookTab
	 * @param bookTab the bookTab to set
	 */
	public void setBookTab(Tab bookTab)
	{
		this.bookTab = bookTab;
	}

	/** Method: getBookTable
	 * @return the bookTable
	 */
	public TableView<Book> getBookTable()
	{
		return bookTable;
	}

	/** Method: getBookFormatComboBox
	 * @return the bookFormatComboBox
	 */
	public ObservableList<String> getBookFormatComboBox()
	{
		return bookFormatComboBox;
	}

	/**	Method: removeSelectedBookRow
	 *	Description: Removes the selected row in the book table
	 */
	public void removeSelectedBookRow()
	{
		bookTable.getItems().remove(bookTable.getSelectionModel().getSelectedItem());
	}
	
	/**	Method: searchBookItemNumber
	 *	Description: Searches the users input item number and if a match is found it selects the appropriate tab, then selects the appropriate item in the table
	 * @param input
	 */
	public void searchBookItemNumber(String input)
	{
		for (Book numberMatch : bookTableData)
		{
			if (numberMatch.getItemNumber().equals(input))
			{
				bookTab.getTabPane().getSelectionModel().select(bookTab);
				bookTable.getSelectionModel().select(numberMatch);
			}
		}
	}

	/**	Method: findCurrentTableMaxItemNumber
	 *	Description: Searches the book table for the highest number in the itemNumber field without the letter prefix.
	 * @return maxNumber the maximum number which will be used for the next added row's itemNumber
	 */
	public int findCurrentTableMaxItemNumber()
	{
		ArrayList<Integer> maxNumberList = new ArrayList<Integer>();
		maxNumberList.add(0);

		for (int i = 0; i < bookTableData.size(); i++)
		{
			int currentNumber = Integer.parseInt((bookTableData.get(i)).getItemNumber().substring(0, (bookTableData.get(i)).getItemNumber().length()-1));
			maxNumberList.add(currentNumber);
		}

		Integer maxNumber = Collections.max(maxNumberList);
		return maxNumber;
	}

	/**Class: BookTableCellActionHandling.java
	 * @author Conner Layson
	 * @version 1.0
	 * Course: ITEC 3150 Spring 2015
	 * Written: Feb 1, 2015
	 *
	 *
	 * This Class - An inner class used for cell edit events in the book table.
	 *
	 * Purpose: To allow the table to be editable and save user changes in the table cells.
	 */
	
	class BookTableCellActionHandling implements EventHandler<CellEditEvent<Book, String>>
	{
		private String objectName;

		public BookTableCellActionHandling(String objectName)
		{
			super();
			this.objectName = objectName;
		}

		/**	Method: handle
		 *	Description: An override action handler method to handle book cell edit events
		 * @param t the cell edit event
		 */
		@Override
		public void handle(CellEditEvent<Book, String> t)
		{
			if (this.objectName.equals("bookName"))
			{
				((Book) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
			}
			else if (this.objectName.equals("bookFormat"))
			{
				((Book) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBookFormat(t.getNewValue());
			}
			else
			{
				((Book) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAuthor(t.getNewValue());
			}
		}
	}
}
