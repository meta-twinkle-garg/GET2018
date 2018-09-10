package com.metacube.training.EmployeePortal.service;



import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.metacube.training.EmployeePortal.dao.EmployeeDAO;
import com.metacube.training.EmployeePortal.model.Employee;



public class EmployeeService {


	
	
	public static Employee getEmployeeById(int id) {
		
		ResultSet rset= EmployeeDAO.getEmployeeById(id);
		Employee employee=new Employee();
		try{
			while(rset.next()){
				employee.setId(id);
				employee.setFirstName(rset.getString("first_name"));
				employee.setLastName(rset.getString("last_name"));
				employee.setDob(rset.getDate("dob"));
				employee.setGender(rset.getString("gender"));
				employee.setPrimaryContactNumber(rset.getString("primary_contact_number"));
				employee.setSecondaryContactNumber(rset.getString("secondary_contact_number"));
				employee.setEmailId(rset.getString("email_id"));
				employee.setSkypeId(rset.getString("skype_id"));
				employee.setProfilePicture(rset.getString("profile_picture"));
		}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	public static boolean createEmployee(Employee employee){
		String firstName=employee.getFirstName();
		String emailId=employee.getEmailId();
		String gender=employee.getGender();
		Date dob=employee.getDob();
		return EmployeeDAO.createEmployee(firstName,emailId,gender,dob);
	}
	
	public static boolean updateEmployee(Employee employee){
		String firstName=employee.getFirstName();
		int id=employee.getId();
		String lastName=employee.getLastName();
		String skypeId=employee.getSkypeId();
		String primary=employee.getPrimaryContactNumber();
		Date dob=employee.getDob();
		String secondary=employee.getSecondaryContactNumber();
		String profilePicture=employee.getProfilePicture();
		String gender=employee.getGender();
		String password=employee.getPassword();
		return EmployeeDAO.updateEmployee(firstName,lastName,skypeId,primary,secondary,dob,profilePicture,gender,password,id);
	}

	public static List<Employee> getAllEmpoyee() {
		ResultSet rset=EmployeeDAO.getAllEmployee();
		List<Employee> listOfEmployee=new ArrayList<Employee>();
		try{
			while(rset.next()){
				Employee employee=new Employee();
				employee.setId(rset.getInt("emp_code"));
				employee.setFirstName(rset.getString("first_name"));
				employee.setLastName(rset.getString("last_name"));
				employee.setDob(rset.getDate("dob"));
				employee.setEmailId(rset.getString("email_id"));
				employee.setSkypeId(rset.getString("skype_id"));
				employee.setGender(rset.getString("gender"));
				employee.setPrimaryContactNumber(rset.getString("primary_contact_no"));
				employee.setSecondaryContactNumber(rset.getString("secondary_contact_no"));
				employee.setProfilePicture(rset.getString("profile_picture"));
				listOfEmployee.add(employee);
		}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listOfEmployee;
	}

	public static int checkLogin(String username, String password) {
		ResultSet rset= EmployeeDAO.checkLogin(username,password);
		if(rset==null){
			return 0;
		}else{
			try {
				while(rset.next()){
					return rset.getInt("emp_code");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

}
