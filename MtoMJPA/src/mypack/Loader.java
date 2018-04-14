package mypack;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.*;

public class Loader {

	public static void main(String[] args) {
		System.out.println("Loading all Emp...");
		EntityManager manager=MyFactory.getEntityManager();
		
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Emp Id:");
		int id=in.nextInt();
		Emp e=(Emp)manager.find(Emp.class, id);
		System.out.println("Emp Details:");
		System.out.println(e.getName()+"\t"+e.getJob()
		+e.getSalary());
		Set<Previlige> previliges=e.getPreviliges();
				
		System.out.println("Previliges availed by the Emp:");
		for(Previlige p: previliges)
			System.out.println(p.getName()+"\t"+p.getCost());
		
		System.out.print("Enter Previlige Id:");
		id=in.nextInt();
		Previlige p=(Previlige)manager.find(Previlige.class, id);
		System.out.println("Previlige Details:");
		System.out.println(p.getName()+"\t"+p.getCost());
		
		Set<Emp> users=p.getUsers();
		System.out.println("It is used by following Emp:");
		for(Emp emp: users)
			System.out.println(emp.getName()+"\t"+emp.getJob()
			+emp.getSalary());
		manager.close();
	}

}
