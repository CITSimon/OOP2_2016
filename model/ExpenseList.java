package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	//This will now take in any Comparator and use it to sort the list before returning it.
	public ArrayList<Expense> getSortedExpenses(Comparator<Expense> comparator)
	{
		//To avoid interfering with the order of the original list by sorting it, we could create a clone, sort it and 
		//return the sorted clone.
		ArrayList<Expense> listCopy = getDeepCopyOfList();
		
		Collections.sort(listCopy, comparator);
		return listCopy;
	}

	public ArrayList<Expense> getDeepCopyOfList()
	{
		//To create a deep copy of the list of expenses (i.e. this.expenses) we create a new list and fill
		//it with clones of the objects in the other list.
		ArrayList<Expense> clonedExpenses = new ArrayList<Expense>();
		
		try
		{
			//We go through the original list of expenses and clone each of its objects one by one and 
			//add them to our new list (clonedExpenses)
			for(Expense e : this.expenses)
			{
				clonedExpenses.add(e.clone());
			}
		}
		catch(CloneNotSupportedException e)
		{
			System.out.println(e.getMessage());
		}
		return clonedExpenses;
	}
	
}
