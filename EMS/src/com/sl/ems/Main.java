
package com.sl.ems;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
        String name;
        int id;
        IntfDbOperations empDao=new DbOperationsImpl();
        System.out.println("Welcome to Employee management application");

        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("1. Add Employee\n" +
                    "2. Show All Employee\n" +
                    "3. Show Employee based on id \n" +
                    "4. Update the employee\n" +
                    "5. Delete the employee\n"+
                    "6. Exit\n");

            System.out.println("Enter Choice: ");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    Employee emp=new Employee();
                    System.out.println("Enter ID : ");
                     id=sc.nextInt();
                    System.out.println("Enter name ");
                     name=sc.next();
                    System.out.println("Enter Salary ");
                    double salary=sc.nextDouble();
                    System.out.println("Enter age");
                    int age=sc.nextInt();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    empDao.addEmployee(emp);
                    break;
                case 2:
                    empDao.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter id to show the details ");
                    int empid=sc.nextInt();
                    empDao.showEmployeeByID(empid);
                    break;
                case 4:
                    System.out.println("Enter id to update the details");
                    int empid1=sc.nextInt();
                    System.out.println("Enter the new name");
                     name=sc.next();
                    empDao.updateEmployee(empid1,name);
                    break;
                case 5:
                    System.out.println("Enter the id to delete");
                    id=sc.nextInt();
                    empDao.deleteEmployee(id);
                    break;

                case 6:
                    System.out.println("Thank you for using our Application !!!");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice !");
                    break;


            }

        }while (true);
	}

}
