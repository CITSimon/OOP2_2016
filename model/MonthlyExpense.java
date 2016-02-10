package model;

public class MonthlyExpense extends Expense 
{
	private int dateInMonth;
	
	public MonthlyExpense(String name, double amount, int dateInMonth)
	{
		//This calls the constructor of the superclass(Expense) and creates it before
		//adding on the rest of the object defined in this subclass (MonthlyExpense).
		super(amount, name);
		this.dateInMonth = dateInMonth;
	}
	
	//Implement the abstract method
	public double calculateCostPerMonth()
	{
		//This is the most straightford as the cost per month is just the amount seeing
		//as this class is MonthlyExpense.
		return getAmount();
	}
}
