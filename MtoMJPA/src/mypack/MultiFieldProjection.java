package mypack;

import java.util.List;

import javax.persistence.*;

public class MultiFieldProjection {

	public static void main(String arr[])
	{
		System.out.println("selecting name & cost of all previliges:");
		EntityManager manager=MyFactory.getEntityManager();
		Query q=manager.createQuery("select p.name, p.cost from Previlige p");
		List<Object[]> list=q.getResultList();
		for(Object obj[]:list)
			System.out.println(obj[0]+"\t"+obj[1]);
		manager.close();
	}
}
