package model;

public class AnnualExpense extends Expense {
	
	private String description;
	
	public static final int MONTHS_IN_YEAR = 12;
	
	public AnnualExpense(double amount, String name, String description)
	{
		super(amount, name);
		this.description = description;
	}

	public double calculateCostPerMonth()
	{
		return getAmount() / MONTHS_IN_YEAR;
	}
}
