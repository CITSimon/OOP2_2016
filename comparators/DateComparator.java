package comparators;

import java.util.Comparator;

import model.Expense;

public class DateComparator implements Comparator<Expense> {
	@Override
	public int compare(Expense e1, Expense e2) 
	{
		//This uses the static method of the wrapper class Long to compare the 
		//long values (representing time) in the two Expense objects.
		return Long.compare(e1.getCreationDateTime(), e2.getCreationDateTime());
	}
	

}
