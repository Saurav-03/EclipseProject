package mypack;

import java.util.List;

import javax.persistence.*;

public class SingleFieldProjection {

	public static void main(String arr[])
	{
		System.out.println("selecting name of Emp in asc order:");
		EntityManager manager=MyFactory.getEntityManager();
		Query q=manager.createQuery("select e.name from Emp e order by e.name");
		List<String> list=q.getResultList();
		for(String str:list)
			System.out.println(str);
		manager.close();
	}
}
