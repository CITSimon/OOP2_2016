package gui;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application {

	public static final int NO_OF_ROWS = 6;
	public static final int NO_OF_COLS = 2;
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Main Window");
		
		BorderPane bp = new BorderPane();
		bp.setStyle("-fx-background-color : #FF0000");
		
		bp.setBottom(createBottomPane());
		bp.setLeft(createLeftPane());
		bp.setTop(createTopPanel());
		bp.setCenter(createCenterPane());
		
		Scene firstScene = new Scene(bp, 500, 400);
		stage.setScene(firstScene);
		stage.show();
		
	}
	
	
	private Node createCenterPane()
	{
		VBox vBox = new VBox();
		vBox.setStyle("-fx-background-color : #FFCCFF");
		return vBox;
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
