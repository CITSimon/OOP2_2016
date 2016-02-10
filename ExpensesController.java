import java.util.ArrayList;
import java.util.Collections;

import model.Expense;
import model.ExpenseList;


public class ExpensesController 
{
	//This is the variable which will store the reference to the instance of this class when created).
	private static ExpensesController instance;
	
	//This public method is called by calling ExpensesController.getInstance(). It manages the
	//private static variable called instance above which will point at the instance of the class when created.
	public static ExpensesController getInstance()
	{
		if(instance == null)
		{
			instance = new ExpensesController();
		}
		return instance;
	}
	
	
	//========== Instance part of the class ==========
	
	//Instance variable referring to the model
	private ExpenseList model; 
	
	//Constructor
	private ExpensesController()
	{
		//Create an instance of the model
		this.model = new ExpenseList();
	}
	
	
	public void addExpense(Expense e)
	{
		//Add a new Expense to the model
		this.model.add(e);
	}
	
	public void deleteExpense()
	{
		
	}
	
	public void editExpense()
	{
		
	}
	
	public ArrayList<Expense> getListOfExpenses()
	{
		Collections.sort(this.model.getExpenses());
		return this.model.getExpenses();
	}
		
	public double getMonthlyCost()
	{
		return this.model.getCostPerMonthOfAllExpenses();
	}
	
}
