package domain;

public class Users {

	private int id;
	private String username;
	private String password;
	private String email;
    private String privileges;

	public Users(String username, String password, String email, String privileges) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.privileges = privileges;
	}

	public Users(int id, String username, String password, String email, String privileges) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.privileges = privileges;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
	public String getPrivileges() {
		return privileges;
	}

	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", privileges=" + privileges + "]";
	}

	
}

