package form.model;

public class RegistrationModel {
	String fname;
	String lname;
	String gender;
	String email;
	String city;
	String password;
	
	public String getFname() {
		return fname;
	}
	@Override
	public String toString() {
		return "RegistrationModel [fname=" + fname + ", lname=" + lname + ", gender=" + gender + ", email=" + email
				+ ", city=" + city + ", password=" + password + "]";
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
