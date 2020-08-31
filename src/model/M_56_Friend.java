package model;
 
public class M_56_Friend {

	private int id;
	private String name;
	private String email;
	private int age;
	private String color;
	
	public M_56_Friend() {
		this.name = "";
		this.email = "";
		this.age = 0;
		this.id = 0;
		this.color = "";
	}

	public M_56_Friend(String name, String email, int age, String color) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.color = color;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + ", email=" + email + ", age=" + age + ", color=" + color + "]";
	}
 
	
 
}