package model;

import java.io.Serializable;

public class AnnualExpense extends Expense implements Serializable
{
	
	private String description;
	
	public static final int MONTHS_IN_YEAR = 12;
	
	public AnnualExpense(double amount, String name, String description)
	{
		super(amount, name);
		this.description = description;
	}
	//Overloaded constructor to allow setting of all attributes. Typically used when loading
	//saved expenses from the database.
	public AnnualExpense(double amount, String name, String description, long creationTime)
	{
		super(amount, name, creationTime);
		this.description = description;
	}

	public double calculateCostPerMonth()
	{
		return getAmount() / MONTHS_IN_YEAR;
	}
	
	public String toString()
	{
		return super.toString() + " "+this.description;
	}
	
	public String getDescription()
	{
		return this.description;
	}
}
