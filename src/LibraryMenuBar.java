import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**Class: LibraryMenuBar.java
 * @author Conner Layson
 * @version 1.0
 * Course: ITEC 3150 Spring 2015
 * Written: Feb 1, 2015
 *
 *
 * This Class - Creates the menu bar and all of the menu items that go with it. 
 *
 * Purpose: To be able to create all of the menu objects. The methods for launching the search/add food dialog boxes are also included. All of the action handling for the menu items is performed in an
 * inner class.
 */

public class LibraryMenuBar
{
	private MenuBar menuBar;
	private Menu menu;
	private MenuItem addRowMenu, deleteRowMenu, searchMenu, exit;
	private Stage popupStage;
	private HBox hBox;
	private Button okButton;
	private Stage dialog;
	private ComboBox<String> mediaTypeComboBox, videoGenreComboBox;
	private TextField ratingField, nameField, composerField, searchItemNumberBox;
	private ComboBox<String> mediaFormatComboBox;
	private final ObservableList<String> videoFormatComboBox = FXCollections.observableArrayList("DVD", "DVD High Definition", "Digital", "Digital High Definition");
	private final ObservableList<String> genreComboBox = FXCollections.observableArrayList("Drama", "Horror", "Comedy", "Family");
	private final ObservableList<String> bookFormatComboBox = FXCollections.observableArrayList("Print", "E-Book", "Audio Book");
	private final ObservableList<String> musicFormatComboBox = FXCollections.observableArrayList("Vinyl", "Digital", "CD");
	private BookTab bookTabReference;
	private MusicTab musicTabReference;
	private VideoTab videoTabReference;

	public LibraryMenuBar(BookTab bookTab, MusicTab musicTab, VideoTab videoTab)
	{
		this.bookTabReference = bookTab;
		this.musicTabReference = musicTab;
		this.videoTabReference = videoTab;
		menuBar = new MenuBar();
		menu = new Menu("File");
		addRowMenu = new MenuItem("Add Row");
		deleteRowMenu = new MenuItem("Delete Selected Row");
		searchMenu = new MenuItem("Search Item Number");
		exit = new MenuItem("Exit");
		menu.getItems().addAll(addRowMenu, deleteRowMenu, searchMenu, exit);
		menuBar.getMenus().add(menu);
		addRowMenu.setOnAction(new MenuBarActionHandling("addRowMenu"));
		deleteRowMenu.setOnAction(new MenuBarActionHandling("deleteRowMenu"));
		searchMenu.setOnAction(new MenuBarActionHandling("searchMenu"));
		exit.setOnAction(new MenuBarActionHandling("exit"));
	}

	/** Method: getMenuBar
	 * @return the menuBar
	 */
	public MenuBar getMenuBar()
	{
		return menuBar;
	}

	/** Method: setMenuBar
	 * @param menuBar the menuBar to set
	 */
	public void setMenuBar(MenuBar menuBar)
	{
		this.menuBar = menuBar;
	}

	/** Method: getMenu
	 * @return the menu
	 */
	public Menu getMenu()
	{
		return menu;
	}

	/** Method: setMenu
	 * @param menu the menu to set
	 */
	public void setMenu(Menu menu)
	{
		this.menu = menu;
	}

	/** Method: getAddRowMenu
	 * @return the addRowMenu
	 */
	public MenuItem getAddRowMenu()
	{
		return addRowMenu;
	}

	/** Method: setAddRowMenu
	 * @param addRowMenu the addRowMenu to set
	 */
	public void setAddRowMenu(MenuItem addRowMenu)
	{
		this.addRowMenu = addRowMenu;
	}

	/** Method: getDeleteRowMenu
	 * @return the deleteRowMenu
	 */
	public MenuItem getDeleteRowMenu()
	{
		return deleteRowMenu;
	}

	/** Method: setDeleteRowMenu
	 * @param deleteRowMenu the deleteRowMenu to set
	 */
	public void setDeleteRowMenu(MenuItem deleteRowMenu)
	{
		this.deleteRowMenu = deleteRowMenu;
	}

	/** Method: getSearchMenu
	 * @return the searchMenu
	 */
	public MenuItem getSearchMenu()
	{
		return searchMenu;
	}

	/** Method: setSearchMenu
	 * @param searchMenu the searchMenu to set
	 */
	public void setSearchMenu(MenuItem searchMenu)
	{
		this.searchMenu = searchMenu;
	}

	/** Method: getExit
	 * @return the exit
	 */
	public MenuItem getExit()
	{
		return exit;
	}

	/** Method: setExit
	 * @param exit the exit to set
	 */
	public void setExit(MenuItem exit)
	{
		this.exit = exit;
	}

	/** Method: getPopupStage
	 * @return the popupStage
	 */
	public Stage getPopupStage()
	{
		return popupStage;
	}

	/** Method: setPopupStage
	 * @param popupStage the popupStage to set
	 */
	public void setPopupStage(Stage popupStage)
	{
		this.popupStage = popupStage;
	}

	/** Method: gethBox
	 * @return the hBox
	 */
	public HBox gethBox()
	{
		return hBox;
	}

	/** Method: sethBox
	 * @param hBox the hBox to set
	 */
	public void sethBox(HBox hBox)
	{
		this.hBox = hBox;
	}

	/** Method: getOkButton
	 * @return the okButton
	 */
	public Button getOkButton()
	{
		return okButton;
	}

	/** Method: setOkButton
	 * @param okButton the okButton to set
	 */
	public void setOkButton(Button okButton)
	{
		this.okButton = okButton;
	}

	/** Method: getDialog
	 * @return the dialog
	 */
	public Stage getDialog()
	{
		return dialog;
	}

	/** Method: setDialog
	 * @param dialog the dialog to set
	 */
	public void setDialog(Stage dialog)
	{
		this.dialog = dialog;
	}

	/** Method: getMediaTypeComboBox
	 * @return the mediaTypeComboBox
	 */
	public ComboBox<String> getMediaTypeComboBox()
	{
		return mediaTypeComboBox;
	}

	/** Method: setMediaTypeComboBox
	 * @param mediaTypeComboBox the mediaTypeComboBox to set
	 */
	public void setMediaTypeComboBox(ComboBox<String> mediaTypeComboBox)
	{
		this.mediaTypeComboBox = mediaTypeComboBox;
	}

	/** Method: getVideoGenreComboBox
	 * @return the videoGenreComboBox
	 */
	public ComboBox<String> getVideoGenreComboBox()
	{
		return videoGenreComboBox;
	}

	/** Method: setVideoGenreComboBox
	 * @param videoGenreComboBox the videoGenreComboBox to set
	 */
	public void setVideoGenreComboBox(ComboBox<String> videoGenreComboBox)
	{
		this.videoGenreComboBox = videoGenreComboBox;
	}

	/** Method: getRatingField
	 * @return the ratingField
	 */
	public TextField getRatingField()
	{
		return ratingField;
	}

	/** Method: setRatingField
	 * @param ratingField the ratingField to set
	 */
	public void setRatingField(TextField ratingField)
	{
		this.ratingField = ratingField;
	}

	/** Method: getNameField
	 * @return the nameField
	 */
	public TextField getNameField()
	{
		return nameField;
	}

	/** Method: setNameField
	 * @param nameField the nameField to set
	 */
	public void setNameField(TextField nameField)
	{
		this.nameField = nameField;
	}

	/** Method: getComposerField
	 * @return the composerField
	 */
	public TextField getComposerField()
	{
		return composerField;
	}

	/** Method: setComposerField
	 * @param composerField the composerField to set
	 */
	public void setComposerField(TextField composerField)
	{
		this.composerField = composerField;
	}

	/** Method: getSearchItemNumberBox
	 * @return the searchItemNumberBox
	 */
	public TextField getSearchItemNumberBox()
	{
		return searchItemNumberBox;
	}

	/** Method: setSearchItemNumberBox
	 * @param searchItemNumberBox the searchItemNumberBox to set
	 */
	public void setSearchItemNumberBox(TextField searchItemNumberBox)
	{
		this.searchItemNumberBox = searchItemNumberBox;
	}

	/** Method: getMediaFormatComboBox
	 * @return the mediaFormatComboBox
	 */
	public ComboBox<String> getMediaFormatComboBox()
	{
		return mediaFormatComboBox;
	}

	/** Method: setMediaFormatComboBox
	 * @param mediaFormatComboBox the mediaFormatComboBox to set
	 */
	public void setMediaFormatComboBox(ComboBox<String> mediaFormatComboBox)
	{
		this.mediaFormatComboBox = mediaFormatComboBox;
	}

	/** Method: getBookTabReference
	 * @return the bookTabReference
	 */
	public BookTab getBookTabReference()
	{
		return bookTabReference;
	}

	/** Method: setBookTabReference
	 * @param bookTabReference the bookTabReference to set
	 */
	public void setBookTabReference(BookTab bookTabReference)
	{
		this.bookTabReference = bookTabReference;
	}

	/** Method: getMusicTabReference
	 * @return the musicTabReference
	 */
	public MusicTab getMusicTabReference()
	{
		return musicTabReference;
	}

	/** Method: setMusicTabReference
	 * @param musicTabReference the musicTabReference to set
	 */
	public void setMusicTabReference(MusicTab musicTabReference)
	{
		this.musicTabReference = musicTabReference;
	}

	/** Method: getVideoTabReference
	 * @return the videoTabReference
	 */
	public VideoTab getVideoTabReference()
	{
		return videoTabReference;
	}

	/** Method: setVideoTabReference
	 * @param videoTabReference the videoTabReference to set
	 */
	public void setVideoTabReference(VideoTab videoTabReference)
	{
		this.videoTabReference = videoTabReference;
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

	/** Method: getBookFormatComboBox
	 * @return the bookFormatComboBox
	 */
	public ObservableList<String> getBookFormatComboBox()
	{
		return bookFormatComboBox;
	}

	/** Method: getMusicFormatComboBox
	 * @return the musicFormatComboBox
	 */
	public ObservableList<String> getMusicFormatComboBox()
	{
		return musicFormatComboBox;
	}

	/**	Method: createSearchMediaDialog
	 *	Description: Creates and shows the dialog box for searching media item by item number
	 */
	public void createSearchMediaDialog()
	{
		popupStage = new Stage();
		popupStage.setTitle("Search Item Number");
		hBox = new HBox(8);
		searchItemNumberBox = new TextField();
		okButton = new Button("OK");
		okButton.setOnAction(new MenuBarActionHandling("okButton"));
		okButton.setPrefWidth(100);
		okButton.setPrefHeight(50);
		searchItemNumberBox.setPrefHeight(50);
		HBox.setHgrow(searchItemNumberBox, Priority.ALWAYS);
		hBox.getChildren().addAll(searchItemNumberBox, okButton);
		popupStage.setScene(new Scene(hBox, 300, 50));
		popupStage.show();
	}

	/**	Method: createAddMediaDialog
	 *	Description: Creates and shows the dialog for adding a media item. The rating and genre input boxes are disabled until a user selects the video media type
	 */
	public void createAddMediaDialog()
	{
		dialog = new Stage();
		dialog.setTitle("Add New Media");

		ObservableList<String> mediaChoices = FXCollections.observableArrayList("Book", "Music", "Video");
		mediaTypeComboBox = new ComboBox<String>();
		mediaTypeComboBox.setItems(mediaChoices);
		mediaTypeComboBox.setMaxWidth(Double.MAX_VALUE);
		mediaTypeComboBox.setPromptText("Enter Media Type");
		mediaTypeComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
			public void changed(ObservableValue<? extends String> observable,String oldValue,String newValue) 
			{
				if (newValue.equals("Video"))
				{
					videoGenreComboBox.setDisable(false);
					mediaFormatComboBox.setItems(videoFormatComboBox);
					ratingField.setDisable(false);
				}

				else if (newValue.equals("Book"))
				{
					videoGenreComboBox.setDisable(true);
					videoGenreComboBox.getSelectionModel().clearSelection();
					ratingField.setDisable(true);
					ratingField.clear();
					mediaFormatComboBox.setItems(bookFormatComboBox);
				}

				else
				{
					mediaFormatComboBox.setItems(musicFormatComboBox);
					videoGenreComboBox.setDisable(true);
					videoGenreComboBox.getSelectionModel().clearSelection();
					ratingField.setDisable(true);
					ratingField.clear();
				}
			}});

		nameField = new TextField();
		nameField.setPromptText("Enter Name");
		nameField.setMaxWidth(Double.MAX_VALUE);

		mediaFormatComboBox = new ComboBox<String>();
		mediaFormatComboBox.setPromptText("Enter Media Format");
		mediaFormatComboBox.setMaxWidth(Double.MAX_VALUE);

		composerField = new TextField();
		composerField.setPromptText("Enter Author/Director/Artist");
		composerField.setMaxWidth(Double.MAX_VALUE);

		ratingField = new TextField();
		ratingField.setPromptText("Enter Video Rating");
		ratingField.setMaxWidth(Double.MAX_VALUE);
		ratingField.setDisable(true);

		videoGenreComboBox = new ComboBox<String>();
		videoGenreComboBox.setItems(genreComboBox);
		videoGenreComboBox.setPromptText("Enter Video Genre");
		videoGenreComboBox.setMaxWidth(Double.MAX_VALUE);
		videoGenreComboBox.setDisable(true);

		Button okButton = new Button("OK");
		okButton.setMaxWidth(Double.MAX_VALUE);
		Button cancelButton = new Button("Cancel");
		cancelButton.setMaxWidth(Double.MAX_VALUE);
		cancelButton.setOnAction(new MenuBarActionHandling("cancelDialogButton"));
		okButton.setOnAction(new MenuBarActionHandling("okDialogButton"));

		VBox mainPane = new VBox(8);
		HBox addRowPane = new HBox(8);
		addRowPane.setPadding(new Insets(15, 12, 15, 12));
		HBox addRowPane2 = new HBox(8);
		addRowPane2.setPadding(new Insets(15, 12, 15, 12));
		HBox addRowPane3 = new HBox(8);
		addRowPane3.setPadding(new Insets(15, 12, 15, 12));
		
		HBox.setHgrow(okButton, Priority.ALWAYS);
		HBox.setHgrow(cancelButton, Priority.ALWAYS);
		HBox.setHgrow(mediaTypeComboBox, Priority.ALWAYS);
		HBox.setHgrow(nameField, Priority.ALWAYS);
		HBox.setHgrow(mediaFormatComboBox, Priority.ALWAYS);
		HBox.setHgrow(composerField, Priority.ALWAYS);
		HBox.setHgrow(ratingField, Priority.ALWAYS);
		HBox.setHgrow(videoGenreComboBox, Priority.ALWAYS);
		VBox.setVgrow(addRowPane, Priority.ALWAYS);
		VBox.setVgrow(addRowPane2, Priority.ALWAYS);
		VBox.setVgrow(addRowPane3, Priority.ALWAYS);
		
		addRowPane.getChildren().addAll(okButton, cancelButton);
		addRowPane2.getChildren().addAll(mediaTypeComboBox, nameField, mediaFormatComboBox);
		addRowPane3.getChildren().addAll(composerField, ratingField, videoGenreComboBox);
		mainPane.getChildren().addAll(addRowPane2, addRowPane3, addRowPane);

		Scene scene = new Scene(mainPane, 550 , 180, Color.WHITE);
		dialog.setScene(scene);
		dialog.show();
	}

	/**Class: LibraryMenuBar.java
	 * @author Conner Layson
	 * @version 1.0
	 * Course: ITEC 3150 Spring 2015
	 * Written: Feb 1, 2015
	 *
	 *
	 * This Class - Handles all of the action events for the menu items in the menu bar as well as the dialog boxes.
	 *
	 * Purpose: To perform actions based on the specific buttons pressed.
	 */
	
	class MenuBarActionHandling implements EventHandler<ActionEvent>
	{
		private String objectName;

		public MenuBarActionHandling(String objectName)
		{
			this.objectName = objectName;
		}

		/**	Method: handle
		 *	Description: Override method that handles the action events. Filters the events based on the object name that was set when the listener was added to the object.
		 * @param event the action event
		 */
		@Override
		public void handle(ActionEvent event)
		{
			if (this.objectName.equals("searchMenu"))
			{
				LibraryMenuBar.this.createSearchMediaDialog();
			}

			else if (this.objectName.equals("okButton"))
			{
				LibraryMenuBar.this.bookTabReference.searchBookItemNumber(LibraryMenuBar.this.getSearchItemNumberBox().getText().toUpperCase());
				LibraryMenuBar.this.musicTabReference.searchMusicItemNumber(LibraryMenuBar.this.getSearchItemNumberBox().getText().toUpperCase());
				LibraryMenuBar.this.videoTabReference.searchVideoItemNumber(LibraryMenuBar.this.getSearchItemNumberBox().getText().toUpperCase());
				LibraryMenuBar.this.popupStage.close();
			}

			else if (this.objectName.equals("deleteRowMenu"))
			{
				if (LibraryMenuBar.this.bookTabReference.getBookTab().isSelected())
				{
					LibraryMenuBar.this.bookTabReference.removeSelectedBookRow();
				}
				else if (LibraryMenuBar.this.musicTabReference.getMusicTab().isSelected())
				{
					LibraryMenuBar.this.musicTabReference.removeSelectedMusicRow();
				}
				else
				{
					LibraryMenuBar.this.videoTabReference.removeSelectedVideoRow();
				}
			}

			else if (this.objectName.equals("addRowMenu"))
			{
				LibraryMenuBar.this.createAddMediaDialog();
			}

			else if (this.objectName.equals("cancelDialogButton"))
			{
				LibraryMenuBar.this.dialog.close();
			}

			else if (this.objectName.equals("okDialogButton"))
			{
				if (LibraryMenuBar.this.mediaTypeComboBox.getSelectionModel().getSelectedItem().equals("Book"))
				{
					LibraryMenuBar.this.bookTabReference.getBookTableData().add(new Book
							(LibraryMenuBar.this.bookTabReference.findCurrentTableMaxItemNumber() + 1 + "B", LibraryMenuBar.this.nameField.getText(), "Book", 
									LibraryMenuBar.this.mediaFormatComboBox.getSelectionModel().getSelectedItem(), LibraryMenuBar.this.composerField.getText()));
				}

				else if (LibraryMenuBar.this.mediaTypeComboBox.getSelectionModel().getSelectedItem().equals("Music"))
				{
					LibraryMenuBar.this.musicTabReference.getMusicTableData().add(new Music
							(LibraryMenuBar.this.musicTabReference.findCurrentTableMaxItemNumber() + 1 + "M", LibraryMenuBar.this.nameField.getText(), "Music", 
									LibraryMenuBar.this.mediaFormatComboBox.getSelectionModel().getSelectedItem(), LibraryMenuBar.this.composerField.getText()));
				}

				else if (LibraryMenuBar.this.mediaTypeComboBox.getSelectionModel().getSelectedItem().equals("Video"))
				{
					LibraryMenuBar.this.videoTabReference.getVideoTableData().add(new Video
							(LibraryMenuBar.this.videoTabReference.findCurrentTableMaxItemNumber() + 1 + "V", "Video Name", "Video", 
									LibraryMenuBar.this.mediaFormatComboBox.getSelectionModel().getSelectedItem(), 
									LibraryMenuBar.this.composerField.getText(), LibraryMenuBar.this.ratingField.getText(),
									LibraryMenuBar.this.videoGenreComboBox.getSelectionModel().getSelectedItem()));
				}

				else
				{

				}

				LibraryMenuBar.this.dialog.close();
			}

			else if (this.objectName.equals("exit"))
			{
				Platform.exit();
			}

			else
			{

			}
		}	
	}
}
