package form.dao;

import java.util.List;

import javax.sql.DataSource;

import form.model.RegistrationModel;

public interface RegistrationI {

	//Method for database connection
		public void setDataSource(DataSource dataSource);

		//to create record in employee table
		public boolean create(RegistrationModel register);
		//public void create(String fname,String lname,String gender,String password,String city,String email);
		
		//to delete data
		public void delete(String email);
	     
		//to display  Specific data
	    public RegistrationModel displayData(String email);
	     
	    
	    public List<RegistrationModel> displayAllData();
	    
	    public void updateData(RegistrationModel register);
	    
	
}
