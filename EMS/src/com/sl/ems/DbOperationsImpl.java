package com.sl.ems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbOperationsImpl implements IntfDbOperations {

	Connection con;

	@Override
	public void showAllEmployee() {
		con =DbConnection.createConnection();
		String query="select * from employee";
        System.out.println("Employee Details :");
        
        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
            	System.out.println(result.getInt(1)+"\t"+
                        result.getString(2)+"\t"+
                        result.getDouble(3)+"\t"+
                        result.getInt(4));
             
                System.out.println("---------------------------------------------");
                
            }
            con.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }

		
	}

	@Override
	public void showEmployeeByID(int id) {
		con =DbConnection.createConnection();
		String query = "select * from employee where id=?";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			ResultSet result = psmt.executeQuery();
			while (result.next()){
            	System.out.println(result.getInt(1)+"\t"+
                        result.getString(2)+"\t"+
                        result.getDouble(3)+"\t"+
                        result.getInt(4));
            	}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateEmployee(int id, String name) {
		con =DbConnection.createConnection();
		 String query="update employee set name=? where id=?";
	        try{
	            PreparedStatement pstm=con.prepareStatement(query);
	            pstm.setString(1,name);
	            pstm.setInt(2,id);
	            int cnt=pstm.executeUpdate();
	            if(cnt!=0)
	                System.out.println("Employee Details updated successfully !!");
	            

	        }catch (Exception ex){
	            ex.printStackTrace();
	        }
		
	}

	@Override
	public void deleteEmployee(int id) {
		con =DbConnection.createConnection();
		 String query="delete from employee where id=?";
	        try{
	            PreparedStatement pstm=con.prepareStatement(query);
	            pstm.setInt(1,id);
	           int cnt= pstm.executeUpdate();
	           if(cnt!=0)
	               System.out.println("Employee Deleted Successfully!!! "+id);

	        }catch (Exception ex){
	            ex.printStackTrace();
	        }

	}

	@Override
	public void addEmployee(Employee emp) {
		con =DbConnection.createConnection();
	       String query="insert into employee values(?,?,?,?)";
	       try{
	           PreparedStatement pstm=con.prepareStatement(query);
	           pstm.setInt(1,emp.getId());
	           pstm.setString(2,emp.getName());
	           pstm.setDouble(3,emp.getSalary());
	           pstm.setInt(4,emp.getAge());
	          int cnt= pstm.executeUpdate();
	          if(cnt!=0)
	              System.out.println("Employee Inserted Successfully !!!");
	          con.close();


	       }catch (Exception ex){
	           ex.printStackTrace();
	       }
	       
		
	}

	
}
