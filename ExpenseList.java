import java.util.ArrayList;

public class ExpenseList 
{
	private ArrayList<Expense> expenses;
	
	public ExpenseList()
	{
		this.expenses = new ArrayList<Expense>();
	}
	
	public void add(Expense e)
	{
		this.expenses.add(e);
	}
	
	public double getCostPerMonthOfAllExpenses()
	{
		double monthlyTotal = 0.0;		
		for(Expense exp : expenses)
		{
			System.out.println(exp.getName() + " "+exp.getAmount());
			monthlyTotal += exp.calculateCostPerMonth();
		}
		return monthlyTotal;
	}
}
