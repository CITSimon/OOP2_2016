
public abstract class Expense 
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
	
	public abstract double calculateCostPerMonth();
}
