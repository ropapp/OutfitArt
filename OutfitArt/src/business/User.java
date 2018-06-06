package business;

public class User{
	String name;
	char gender; //Non-binary. Remember gender is an spectra :)
	
	
	public User(String name, char gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
	
	public String toString() {
		return this.name;
	}
	
}
