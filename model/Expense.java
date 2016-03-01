package model;

import java.io.Serializable;

public abstract class Expense implements Serializable, Cloneable 
{
	private double amount;
	private String name;
	private long creationTimeAndDate;
	
	
	public Expense(double amount, String name)
	{
		this.amount = amount;
		this.name = name;
		this.creationTimeAndDate = System.currentTimeMillis();
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
		
	public long getCreationDateTime()
	{
		return this.creationTimeAndDate;
	}

	public abstract double calculateCostPerMonth();
	
	//Override the toString() method
	public String toString()
	{
		return this.amount+" "+this.name;
	}
	
	public Expense clone() throws CloneNotSupportedException
	{
		try
		{
			return (Expense)super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			throw new CloneNotSupportedException(e.getMessage());
		}

	}
	
	
	
	
	
	
	
	
	
	
	
}
