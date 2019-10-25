package form.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import form.model.RegistrationModel;

public class RegistrationMapper implements RowMapper<RegistrationModel> {

	public RegistrationModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		RegistrationModel registermodel=new RegistrationModel();
		registermodel.setFname(rs.getString("firstname"));
		registermodel.setLname(rs.getString("lastname"));
		registermodel.setGender(rs.getString("gender"));
		registermodel.setCity(rs.getString("city"));
		registermodel.setPassword(rs.getString("password"));
		registermodel.setEmail(rs.getString("email"));
		return registermodel;
	}

	
}
