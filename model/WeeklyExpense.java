package model;

import java.io.Serializable;

public class WeeklyExpense extends Expense implements Serializable
{	
	private static final double WEEKS_IN_MONTH = 4.2;
	
	private Day dayOfWeek;
	
	public WeeklyExpense(String name, double amount, Day dayOfWeek)
	{
		super(amount, name);
		this.dayOfWeek = dayOfWeek;
	}
	
	public double calculateCostPerMonth()
	{
		return getAmount() * WEEKS_IN_MONTH;
	}
	public String toString()
	{
		return super.toString() + " "+this.dayOfWeek;
	}
}
