package mypack;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

public class Saver {

	public static void main(String[] args) {
		Previlige p1=new Previlige("Car",120000);
		Previlige p2=new Previlige("Flat",480000);
		Previlige p3=new Previlige("Club Membership",
				1000000);
		Set<Previlige> s1=new HashSet<Previlige>();
		Set<Previlige> s2=new HashSet<Previlige>();
		Set<Previlige> s3=new HashSet<Previlige>();
		s1.add(p1);s1.add(p2);s1.add(p3);
		s2.add(p1);s2.add(p2);
		s3.add(p1);
		Emp e1=new Emp("Amit","CEO",99000,s1);
		Emp e2=new Emp("Vipul","CFO",89000,s2);
		Emp e3=new Emp("Karan","COO",79000,s3);
		System.out.println(
		"Saving Emp objects...");
		EntityManager manager=MyFactory.getEntityManager();
		EntityTransaction t=manager.getTransaction();
		t.begin();
		manager.persist(e1);
		manager.persist(e2);
		manager.persist(e3);
		t.commit();
		manager.close();
		System.out.println("Successfully saved.");
	}

}
