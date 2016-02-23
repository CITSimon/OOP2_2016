import java.util.ArrayList;
import java.util.Collections;

import comparators.ExpenseNameComparator;

import model.Expense;


public class MockGUITestLoadingFromDisk {

	public static void main(String[] args) {
		ExpensesController.getInstance().load();
		//Display our expenses
		ArrayList<Expense> expenseList = ExpensesController.getInstance().getListOfExpenses();
		Collections.sort(expenseList, new ExpenseNameComparator());
		
		for(Expense e : expenseList)
		{
			System.out.println(e); //Automatically prints out e.toString()
		}
	}

}
