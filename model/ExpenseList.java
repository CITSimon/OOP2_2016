package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ExpenseList implements Serializable
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
			monthlyTotal += exp.calculateCostPerMonth();
		}
		return monthlyTotal;
	}
	
	public ArrayList<Expense> getExpenses()
	{
		return this.expenses;
	}
}
