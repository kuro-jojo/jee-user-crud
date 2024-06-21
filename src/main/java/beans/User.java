package beans;

public class User {
	private int id;
	private String lastName,firstName, login, password;
	
	public User() {
	}
	
	public User(int id, String lastName, String firstName, String login, String password) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.login = login;
		this.password = password;
	}
	public User(String lastName, String firstName, String login, String password) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.login = login;
		this.password = password;
	}

	public int getId() {
	    return id;
	}

	public void setId(int id) {
	    this.id = id;
	}

	public String getLastName() {
	    return lastName;
	}

	public void setLastName(String lastName) {
	    this.lastName = lastName;
	}

	public String getFirstName() {
	    return firstName;
	}

	public void setFirstName(String firstName) {
	    this.firstName = firstName;
	}

	public String getLogin() {
	    return login;
	}

	public void setLogin(String login) {
	    this.login = login;
	}

	public String getPassword() {
	    return password;
	}

	public void setPassword(String password) {
	    this.password = password;
	}
}
