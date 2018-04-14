package mypack;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class ConditionalSelection {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.print("Enter previlige count:");
		int pc=in.nextInt();
		in.close();
		System.out.println(
		"Selecting those emp who are availing >= "
		+pc+" previliges.");
		EntityManager manager=MyFactory.getEntityManager();
		Query q=manager.createQuery(
		"from Emp e where size(e.previliges) >= :pcount");
		q.setParameter("pcount", pc);
		List<Emp> list=q.getResultList();
		System.out.println("Following Emp are selected:");
		for(Emp e: list)
			System.out.println(e.getName());
		manager.close();
	}

}









