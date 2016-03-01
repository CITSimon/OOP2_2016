import java.util.ArrayList;

import model.Expense;
import model.ExpenseList;

import comparators.DateComparator;
import comparators.ExpenseNameComparator;



public class MockGUITestLoadingFromDisk {

	public static void main(String[] args) {
		ExpensesController.getInstance().load();
		
		ExpenseList list = ExpensesController.getInstance().getListOfExpenses();
	
		//If getSortedExpenses() did not clone the list before it sorted and returned it then the first and
		//second calls to list.getExpenses() would return the list in different orders.
		
		//This should be the list in ExpensesList as the objects went in
		System.out.println("First Call");
		printList(list.getExpenses());
		
		System.out.println("Second Call");
		//This should be a sorted list
		printList(list.getSortedExpenses(new ExpenseNameComparator()));
		
		System.out.println("Third Call");
		//This should be the original list untouched.
		printList(list.getExpenses());
	}

	private static void printList(ArrayList<Expense> list)
	{
		for(Expense e : list)
		{
			System.out.println(e);
		}
	}
	

}
