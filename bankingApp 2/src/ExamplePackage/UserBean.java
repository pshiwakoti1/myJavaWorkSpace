package ExamplePackage;

public class UserBean {
	
  
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    public boolean valid;
	
	
    public String getFirstName() {
       return firstName;
	}

    public void setFirstName(String newFirstName) {
       firstName = newFirstName;
	}

	
    public String getLastName() {
       return lastName;
	}

    public void setLastName(String newLastName) {
       lastName = newLastName;
			}
			

    public String getPassword() {
       return password;
	}

    public void setPassword(String newPassword) {
       password = newPassword;
	}
	
			
    

				
    public boolean isValid() {
       return valid;
	}

    public void setValid(boolean newValid) {
       valid = newValid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}	
}