package mypack;

import java.util.List;

import javax.persistence.*;

public class AllEmpLoader {

	public static void main(String[] args) {
		System.out.println("Loading all Emp...");
		EntityManager manager=MyFactory.getEntityManager();
		Query q=manager.createQuery("from Emp e");
		List<Emp> list=q.getResultList();
		
		System.out.println("Following Emp are loaded:");
		for(Emp e: list)
			System.out.println(e.getName()+"\t"+e.getJob()+"\t"+e.getSalary());
		manager.close();
	}

}
