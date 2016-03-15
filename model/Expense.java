package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
	//Overloaded constructor to allow setting of all three attributes. This would typically be
	//used when loading a saved Expense from the database.
	public Expense(double amount, String name, long creationTime)
	{
		this.amount = amount;
		this.name = name;
		this.creationTimeAndDate = creationTime;
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
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(this.creationTimeAndDate);
		DateFormat myFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
		String formattedDateString = myFormat.format(cal.getTime());
		
		
		return this.amount+" "+this.name + " "+formattedDateString;
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
