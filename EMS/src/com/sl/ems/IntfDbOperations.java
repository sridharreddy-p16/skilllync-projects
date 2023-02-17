package com.sl.ems;

public interface IntfDbOperations {
	
	
	public void addEmployee(Employee emp); //create employee
    
    public void showAllEmployee();  //show all employee
    
    public void showEmployeeByID(int id);	//show employee based on id
    
    public void updateEmployee(int id,String name);	//update employee
    
    public void deleteEmployee(int id);	//delete employee

}
