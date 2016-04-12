package gui;


import model.AnnualExpense;
import controller.ExpensesController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ExpenesesApplication extends Application {
	
	private TextField expenseNameField;
	private TextField expenseAmountField;
	
	@Override
	public void start(Stage stage) {
		//Set the title of the window
		stage.setTitle("Expenses Manager v1.0");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setVgap(10);
		
		//Set a heading which spans two columns on the first row
		Text sceneTitle = new Text("Expenses Application");
		//Set a custom font
		sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(sceneTitle, 0, 0, 2, 1);
		
		
		Label expenseNameLabel = new Label ("Expense Name : ");
		Label expenseAmountLabel = new Label ("Expense Amount : ");

		this.expenseNameField = new TextField();
		this.expenseAmountField = new TextField();
		
		grid.add(expenseNameLabel, 0, 1);
		grid.add(expenseNameField, 1, 1);
		grid.add(expenseAmountLabel, 0, 2);
		grid.add(expenseAmountField, 1, 2);
		
		//Add the button
		Button btn = new Button("Add Expense");
		grid.add(btn, 0, 4);
		
		//Add anonymous inner class listener / handler to the button to handle when the button is clicked
		
		btn.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e)
			{
				String expenseAmountEntered = expenseAmountField.getText();
				String expenseNameEntered = expenseNameField.getText();
				
				AnnualExpense theExpense = new AnnualExpense(Double.parseDouble(expenseAmountEntered), expenseNameEntered, "");
				//This is the code which responds to the button click
				ExpensesController.getInstance().addExpense(theExpense);
				ExpensesController.getInstance().save();
			}
		});
		
		
		//Create the Scene and put the GridPane into it
		Scene firstScene = new Scene(grid, 300, 300);
		
		stage.setScene(firstScene);
		
		stage.show();
	}

	public static void main(String[] args) {
		ExpenesesApplication myApplication = new ExpenesesApplication();
		myApplication.launch(args);

	}

}
