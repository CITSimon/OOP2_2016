package comparators;

import java.util.Comparator;

import model.Expense;

public class ExpenseNameComparator implements Comparator<Expense> {

	@Override
	public int compare(Expense e1, Expense e2) {
		//This is using the fact that String is already Comparable and has implemented the 
		//compareTo method to allow it to compare itself to other Strings.
		return e1.getName().compareTo(e2.getName());
	}

	//NOTE : Although equals is a method of the Comparator interface we are not forced to 
	//implement it here. Why ? Because java.lang.Object (which every class ultimately extends, including this one)
	//already has an implementation of equals. Therefore this class inherits that. The version of equals
	//in java.lang.Object compares two object for equality by their memory address. You only need to override / implement
	//equals here if you want to use something different to compare their equality. Most of the time the inherited version
	//of equals is fine.

}
