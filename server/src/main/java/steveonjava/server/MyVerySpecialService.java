package steveonjava.server;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MyVerySpecialService {

	private SessionFactory sessionFactory;

	public MyVerySpecialService() {
		super();
		System.out.println(" --------------------------------------------- building very special service [1] --------------------------------------------- ");
    }
    
    public MyVerySpecialService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        System.out.println(" --------------------------------------------- building very special service [2] --------------------------------------------- ");
    }

	public void helloOnService() {
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhello on service...");
	}
	
	//---
	
	public void createMyEntity() {
        MyEntity myEntity = new MyEntity();
        myEntity.setSomeEntityValue("pupsklaus123");
        sessionFactory.getCurrentSession().save(myEntity);
        int entityCount = sessionFactory.getCurrentSession().createCriteria(MyEntity.class).list().size();
        System.out.println("NOW I HAVE "+entityCount+" MY ENTITIES...BOOHOO!!!!");
	}
}
