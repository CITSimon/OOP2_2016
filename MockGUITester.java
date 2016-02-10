import java.util.ArrayList;

import model.AnnualExpense;
import model.Expense;
import model.MonthlyExpense;
import model.WeeklyExpense;

public class MockGUITester {

	public static void main(String[] args)
	{
		//Here we are going to mimic calls which the GUI will make on the controller
		
		//Create a few instances and send them to the controller
		AnnualExpense carInsurance = new AnnualExpense(311.99, "car insurance", "Insurance for my Ford");
		MonthlyExpense phone = new MonthlyExpense("Vodafone", 40.00, 22);
		WeeklyExpense lunch = new WeeklyExpense("lunch", 5, WeeklyExpense.MONDAY);
		
		ExpensesController.getInstance().addExpense(carInsurance);
		ExpensesController.getInstance().addExpense(phone);
		ExpensesController.getInstance().addExpense(lunch);
		
		//Display our expenses
		ArrayList<Expense> expenseList = ExpensesController.getInstance().getListOfExpenses();
		for(Expense e : expenseList)
		{
			System.out.println(e.getName()+ " "+e.getAmount());
		}
		
		//Show the total
		System.out.println("Total Monthly Expense = "+ExpensesController.getInstance().getMonthlyCost());
		
	}
	
}
