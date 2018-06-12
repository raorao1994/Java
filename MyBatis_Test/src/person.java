
public class person {
	private int id;
	private String name;
	private int age;
	private boolean sex;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	public String toString()
	{
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
