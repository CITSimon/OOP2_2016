import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import persistors.DatabasePersistor;
import persistors.ExpensesPersistor;
import persistors.FilePersistor;

import model.Expense;
import model.ExpenseList;


public class ExpensesController 
{
	//This is the variable which will store the reference to the instance of this class when created).
	private static ExpensesController instance;
	
	
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
	
	//Instance variable referring to the persistor
	private ExpensesPersistor persistor;
	
	//Instance variable to keep track of what persistence mode
	//the controller is currently in
	private PersistenceType pType;
	
	//Constructor
	private ExpensesController()
	{
		//Create an instance of the model
		this.model = new ExpenseList();
		//When the controller is initially created we default the persistence mode
		//to FILE here in the constructor.
		setPersistenceMode(PersistenceType.FILE);
	}
	
	public void setPersistenceMode(PersistenceType mode)
	{
		this.pType = mode;
		//Change the persistor being used.
		
		switch(mode)
		{
			case FILE : this.persistor = new FilePersistor(); break;
			case DATABASE : this.persistor = new DatabasePersistor(); break;
		}
		
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
	
	public ExpenseList getListOfExpenses()
	{
		return this.model;
	}
		
	public double getMonthlyCost()
	{
		return this.model.getCostPerMonthOfAllExpenses();
	}
	
	public void load()
	{
		this.model = this.persistor.load();
	}
	
	public void save()
	{
		//We delegate the saving of the model to the persistor.
		//This is an example of abstraction as the controller has no knowledge of the 
		//inner workings of the persistor.
		this.persistor.save(this.model);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
