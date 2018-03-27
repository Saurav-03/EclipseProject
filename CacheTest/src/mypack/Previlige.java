package mypack;

import java.util.Set;

//Owned entity in mtom bidirectional relation
public class Previlige {

	//state
	private int id;
	private String name;
	private int cost;
	//relation
	private Set<Emp> users;
	
	
	
	public Previlige(String name, int cost) {
		super();
		this.name = name;
		this.cost = cost;
	}
	public Previlige() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Set<Emp> getUsers() {
		return users;
	}
	public void setUsers(Set<Emp> users) {
		this.users = users;
	}
	
	
	
}
