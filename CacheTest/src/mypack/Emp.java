package mypack;

import java.util.Set;

//owner entity of mtom bidirectional relation
public class Emp {

	//state
	private int id;
	private String name,job;
	private int salary;
	//relation
	Set<Previlige> previliges;
	
	
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(String name, String job, int salary, Set<Previlige> previliges) {
		super();
		this.name = name;
		this.job = job;
		this.salary = salary;
		this.previliges = previliges;
	}
	public Set<Previlige> getPreviliges() {
		return previliges;
	}
	public void setPreviliges(Set<Previlige> previliges) {
		this.previliges = previliges;
	}
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
}
