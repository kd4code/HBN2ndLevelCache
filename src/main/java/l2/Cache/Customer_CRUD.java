package l2.Cache;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Customer_CRUD {
 public static void main(String[] args) {
	Customer cx1=new Customer(101,"Tokyo",8000);
	Customer cx2=new Customer(102,"Berlin",5000);
	Customer cx3=new Customer(103,"Moscow",2000);
	Customer cx4=new Customer(104,"Rio",3000);
	Customer cx5=new Customer(105,"Nairobi",4000);
	
	System.out.println("Process Started ..");
	Configuration cf=new Configuration().configure();
	SessionFactory sf=cf.buildSessionFactory();
	System.out.println("1st Session Started...");
	Session s1=sf.openSession();
//	s1.beginTransaction();
//    s1.save(cx1);
//    s1.save(cx2);
//    s1.save(cx3);
//    s1.save(cx4);
//    s1.save(cx5);
//    s1.getTransaction().commit();
    
    s1.beginTransaction();
    Query q=s1.createQuery("from Customer").setCacheable(true);
   // Query q= s1.createNativeQuery("SELECT * FROM L2_Customer");
    List<Customer> al=q.list();
    System.out.println(al.size());
    for(Customer item:al)
    	 System.out.println(item);	
//    System.out.println(s1.get(Customer.class,103));
    s1.getTransaction().commit();
    s1.close();
    
    System.out.println("\n2nd Session Started...");
    Session s2=sf.openSession();
    s2.beginTransaction();
    Query q1=s2.createQuery("from Customer").setCacheable(true);
    List<Customer> al1=q1.list();
    for(Customer item:al1)
    	System.out.println(item);
 //   System.out.println(s2.get(Customer.class,103));
    s2.getTransaction().commit();
    s2.close();;
    
    sf.close();
    
    System.out.println("All Transactions Completed Successfully..");
}
}
