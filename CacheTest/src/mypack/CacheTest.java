package mypack;

import java.util.Set;

import org.hibernate.*;
import org.hibernate.stat.SecondLevelCacheStatistics;
public class CacheTest {

	public static void main(String[] args) {
		
		//Obtaining SesssionFactory
		SessionFactory factory=MyFactory.getSessionFactory();
		for(int i=1;i<=2;i++)
		{
			System.out.println("Loading Emp with id 1...");
			long t1=System.currentTimeMillis();
			Session session=MyFactory.getSession();
			Emp e=(Emp)session.get(Emp.class, 1);
			Set<Previlige> set=e.getPreviliges();
			session.close();
			long t2=System.currentTimeMillis();
			long t=t2-t1;
			System.out.println("Loaded in "+t+" milliseconds...");
			System.out.println("Emp Details:");
			System.out.println(e.getName()+"\t"+e.getJob()+"\t"+e.getSalary());
			System.out.println("Availed Previliges:");
			for(Previlige p: set)
				System.out.println(p.getName()+"\t"+p.getCost());
			
			System.out.println("Statistics of the Emp cache region:");
			SecondLevelCacheStatistics sts1=
					factory.getStatistics().getSecondLevelCacheStatistics("r1");
			System.out.println(sts1);
			System.out.println("Statistics of the Previlige cache region:");
			SecondLevelCacheStatistics sts2=
					factory.getStatistics().getSecondLevelCacheStatistics("r2");
			System.out.println(sts2);
		}

	}

}
