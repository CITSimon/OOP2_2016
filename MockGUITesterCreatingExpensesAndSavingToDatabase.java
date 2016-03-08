import model.AnnualExpense;
import model.Day;
import model.MonthlyExpense;
import model.WeeklyExpense;

/**
 * This class creates three expenses and saves them to disk
 * @author Simon
 *
 */
public class MockGUITesterCreatingExpensesAndSavingToDatabase {

	public static void main(String[] args)
	{
		//Here we are going to mimic calls which the GUI will make on the controller
		
		//Create a few instances and send them to the controller
		AnnualExpense carInsurance = new AnnualExpense(311.99, "car insurance", "Insurance for my Ford");
		MonthlyExpense phone = new MonthlyExpense("vodafone", 40.00, 22);
		WeeklyExpense lunch = new WeeklyExpense("lunch", 5, Day.MONDAY);
		
		ExpensesController.getInstance().addExpense(carInsurance);
		ExpensesController.getInstance().addExpense(phone);
		ExpensesController.getInstance().addExpense(lunch);
	
		//The controller initially starts up in FILE persistence mode so now we want to switch it to DATABASE.
		ExpensesController.getInstance().setPersistenceMode(PersistenceType.DATABASE);
		
		//Save the model to disk
		ExpensesController.getInstance().save();
		
	}
	
}
