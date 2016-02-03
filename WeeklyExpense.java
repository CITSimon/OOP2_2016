
public class WeeklyExpense extends Expense 
{
	//static means a class variable shared by all instances of the class.
	public static final int SUNDAY = 1;
	public static final int MONDAY = 2;
	public static final int TUESDAY = 3;
	public static final int WEDNESDAY = 4;
	public static final int THURSDAY = 5;
	public static final int FRIDAY = 6;
	public static final int SATURDAY = 7;
	
	private static final double WEEKS_IN_MONTH = 4.2;
	
	private int dayOfWeek;
	
	public WeeklyExpense(String name, double amount, int dayOfWeek)
	{
		super(amount, name);
		this.dayOfWeek = dayOfWeek;
	}
	
	public double calculateCostPerMonth()
	{
		return getAmount() * WEEKS_IN_MONTH;
	}
}
