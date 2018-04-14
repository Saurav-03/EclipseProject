package mypack;

import java.util.Set;

import javax.persistence.*;

//owner entity of mtom bidirectional relation
@Entity
public class Emp {

	//state
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name,job;
	private int salary;
	//relation
	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="Emp_Previlige",
	joinColumns={@JoinColumn(name="empId")},
	inverseJoinColumns={@JoinColumn(name="previligeId")})
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
