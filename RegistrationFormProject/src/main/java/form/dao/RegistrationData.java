package form.dao;


import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;

import form.controller.RegistrationController;
import form.model.RegistrationModel;

public class RegistrationData  implements RegistrationI {
	
	
	public JdbcTemplate template;
public static final int MYSQL_DUPLICATE_PK =500; // Replace 1062 with exception no. you are getting in case it is different for different    database
	
	static Logger logger = Logger.getLogger(RegistrationController.class.getName());

	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}
	public void setDataSource(DataSource dataSource) {
	
	}
	
	public boolean create(RegistrationModel register) {
		try
		{
			logger.info("Inside try block");
			 String sql="insert into RegisterUserData(firstname,lastname,gender,city,password,email) values('"+register.getFname()+"','"+register.getLname()+"','"+register.getGender()+"','"+register.getCity()+"',   '"+register.getPassword()+"','"+register.getEmail()+"')";  
			int result=this.template.update(sql);
			return true;
			
		}
		catch(DuplicateKeyException e)
		{
			//Object data=e.getCause();
			logger.info("Exception occurs");
			return false ;
		}
		 //String sql="insert into RegisterUserData(firstname,lastname,gender,city,password,email) values('"+register.getFname()+"','"+register.getLname()+"','"+register.getGender()+"','"+register.getCity()+"',   '"+register.getPassword()+"','"+register.getEmail()+"')";  
		   
		// int result=this.template.update(sql);
		 
		//logger.info("Data is Inserted into database");	
	}

	public void delete(String email) {
		
		
	}

	public RegistrationModel displayData(String email) {
		
		return null;
	}

	public List<RegistrationModel> displayAllData() {
		String sql="select * from RegisterUserData";
		List<RegistrationModel>registrationobj=template.query(sql,new RegistrationMapper());
		
		
		for(RegistrationModel modelobj : registrationobj)
		{
			logger.info("firstname: "+modelobj.getFname());
			logger.info("Lastname" +modelobj.getLname());
			
		}
		return registrationobj;
	}
	@Override
	public void updateData(RegistrationModel register) {
		
		
	}
	public void editData(RegistrationModel register) {
		logger.info("Edit Data Method");
		String sql="insert into RegisterUserData(firstname,lastname,gender,city,password,email) values('"+register.getFname()+"','"+register.getLname()+"','"+register.getGender()+"','"+register.getCity()+"',   '"+register.getPassword()+"','"+register.getEmail()+"')";  
		int result=this.template.update(sql);
		
	}

}
