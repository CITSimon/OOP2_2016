package model;

import java.io.Serializable;

public abstract class Expense implements Comparable<Expense>, Serializable 
{
	private double amount;
	private String name;
	
	public Expense(double amount, String name)
	{
		this.amount = amount;
		this.name = name;
	}
	
	public double getAmount()
	{
		return this.amount;
	}
	
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	//Implement Comparable interface
	public int compareTo(Expense otherExpense)
	{
		if(this.amount < otherExpense.getAmount())
		{
			return -1;
		}
		else if(this.amount > otherExpense.getAmount())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public abstract double calculateCostPerMonth();
	
	//Override the toString() method
	public String toString()
	{
		return this.amount+" "+this.name;
	}
}
