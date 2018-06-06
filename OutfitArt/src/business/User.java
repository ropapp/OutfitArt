package businessLogic;

public class User extends Node{
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
