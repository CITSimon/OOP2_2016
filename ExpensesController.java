import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import model.Expense;
import model.ExpenseList;


public class ExpensesController 
{
	//This is the variable which will store the reference to the instance of this class when created).
	private static ExpensesController instance;
	
	//This is a constant pointing to the location of the file on disk where we are going to serialize the
	//model object ExpenseList.
	private static final String FILE_LOCATION ="C:\\expenses\\myfile.dat";
	
	//This public method is called by calling ExpensesController.getInstance(). It manages the
	//private static variable called instance above which will point at the instance of the class when created.
	public static ExpensesController getInstance()
	{
		if(instance == null)
		{
			instance = new ExpensesController();
		}
		return instance;
	}
	
	
	//========== Instance part of the class ==========
	
	//Instance variable referring to the model
	private ExpenseList model; 
	
	//Constructor
	private ExpensesController()
	{
		//Create an instance of the model
		this.model = new ExpenseList();
	}
	
	
	public void addExpense(Expense e)
	{
		//Add a new Expense to the model
		this.model.add(e);
	}
	
	public void deleteExpense()
	{
		
	}
	
	public void editExpense()
	{
		
	}
	
	public ArrayList<Expense> getListOfExpenses()
	{
		Collections.sort(this.model.getExpenses());
		return this.model.getExpenses();
	}
		
	public double getMonthlyCost()
	{
		return this.model.getCostPerMonthOfAllExpenses();
	}
	
	public void load()
	{
		try
		{
			FileInputStream fis = new FileInputStream(FILE_LOCATION);
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.model = (ExpenseList)ois.readObject();
			ois.close();
		}
		catch(FileNotFoundException f)
		{
			System.out.println(f.getMessage());
		}
		catch(IOException i)
		{
			System.out.println(i.getMessage());
		}
		catch(ClassNotFoundException c)
		{
			System.out.println(c.getMessage());
		}
	}
	
	public void save()
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(FILE_LOCATION);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.model);
			oos.close();
		}
		catch(FileNotFoundException f)
		{
			System.out.println(f.getMessage());
		}
		catch(IOException i)
		{
			System.out.println(i.getMessage());
		}
	}
	
	
	
	
	
	
	
	
}
