package gui;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.AnnualExpense;
import model.Expense;
import model.ExpenseList;
import controller.ExpensesController;

public class MainWindow extends Application {

	public static final int NO_OF_ROWS = 6;
	public static final int NO_OF_COLS = 2;
	
	private ListView lview;
	private ObservableList<Expense> observableExpenseList;
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Main Window");
		
		BorderPane bp = new BorderPane();
		bp.setStyle("-fx-background-color : #FF0000");
		
		bp.setBottom(createBottomPane());
		bp.setLeft(createLeftPane());
		bp.setTop(createTopPanel());
		bp.setCenter(createCenterPane());
		bp.setRight(createRightPane());
		
		Scene firstScene = new Scene(bp, 500, 400);
		stage.setScene(firstScene);
		stage.show();
		
	}
	
	private Node createRightPane()
	{
		VBox vImageViewBox = new VBox();
		ImageView ivAddExpense = new ImageView();
		
		
		//Add a mouse click listener to the ImageView
		ivAddExpense.setOnMouseClicked(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e)
			{
				Alert alertDialog = new Alert(AlertType.INFORMATION);
				alertDialog.setHeaderText(null);
				alertDialog.setTitle("Button Clicked!");
				alertDialog.setContentText("Add button clicked");
				alertDialog.showAndWait();
				
				//Add a dummy expense
				Expense dummyExpense = new AnnualExpense(0.0, "dummyname", "dummydescription");
				//We need to add our new Expense directly to the ObservableList, this then adds
				//it to the ArrayList which it wraps. We need to do it like this in a "top-down"
				//fashion rather than adding to the ArrayList from the bottom up. When we add to the
				//ObservableList the GUI refreshes automatically.
				observableExpenseList.add(dummyExpense);
						
			}
		});
		
	
		Image plusImage = new Image("plus_sign.png");
		ivAddExpense.setImage(plusImage);
		vImageViewBox.getChildren().add(ivAddExpense);
		return vImageViewBox;
	}
	
	
	private Node createCenterPane()
	{
		this.lview = new ListView();
		
		ExpenseList expenseList = ExpensesController.getInstance().getListOfExpenses();
		ArrayList<Expense> expenses = expenseList.getExpenses();
		
		observableExpenseList = FXCollections.observableList(expenses);
		lview.setItems(observableExpenseList);
		return lview;
	}
	
	private Node createBottomPane()
	{
		Button okButton = new Button("OK");
		Button cancelButton = new Button("Cancel");
		
		HBox hbButtonBox = new HBox(10);
		hbButtonBox.setAlignment(Pos.CENTER_RIGHT);
		hbButtonBox.setPadding(new Insets(5,5,5,5));
		hbButtonBox.getChildren().addAll(okButton, cancelButton);
		
		hbButtonBox.setStyle("-fx-background-color : #0000FF");
		return hbButtonBox;
	}
	
	private Node createLeftPane()
	{
		GridPane gp = new GridPane();
	
		gp.setStyle("-fx-background-color : #00FF00");
		
		gp.setPadding(new Insets(5,5,5,5));
		gp.setHgap(3);
		gp.setVgap(3);
		
		Label titleLabel = new Label("Month Summary");
		gp.add(titleLabel, 0, 0, 2, 1);
		
		ArrayList<Button> monthsButtons = new ArrayList<Button>();
		//Create ArrayList of twelve buttons and add them to the TilePane as we go.
		for(int x=0; x<NO_OF_COLS; x++)
		{
			for(int y=1; y<NO_OF_ROWS+1; y++)
			{
				Button b = new Button();
				b.setPrefSize(40, 40);
				monthsButtons.add(b);
				gp.add(b, x, y);
			}
		}
		return gp;
		
	}

	private Node createTopPanel()
	{
		HBox topBox = new HBox(10);
		topBox.setStyle("-fx-background-color : #00FFFF");
		topBox.setPadding(new Insets(5,5,5,5));
		topBox.setAlignment(Pos.CENTER);
		Label filterLabel = new Label("Filter By : ");
		
		ComboBox expenseType = new ComboBox();
		expenseType.getItems().addAll("Monthly", "Weekly", "Annual");
	
		topBox.getChildren().addAll(filterLabel, expenseType);
		
		return topBox;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainWindow mainWin = new MainWindow();
		mainWin.launch(args);

	}

}
