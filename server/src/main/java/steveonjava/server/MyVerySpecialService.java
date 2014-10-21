package steveonjava.server;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import steveonjava.server.entity.Bill;
import steveonjava.server.entity.BillPosition;
import steveonjava.server.entity.Customer;
import steveonjava.server.entity.MyEntity;

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
        myEntity.setSomeEntityValue("invoked from bl...");
        sessionFactory.getCurrentSession().save(myEntity);
        int entityCount = sessionFactory.getCurrentSession().createCriteria(MyEntity.class).list().size();
        System.out.println("NOW I HAVE "+entityCount+" MY ENTITIES...BOOHOO!!!!");
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Customer> getAllEntities() {
		return sessionFactory.getCurrentSession().createCriteria(MyEntity.class).list();
	}

	public void addBillPosition(String billNnumber, String positionText) {
		System.out.println("adding bill position...");
		//get bill by bill number
		Query qry = sessionFactory.getCurrentSession().createQuery("SELECT object(o) FROM Bill AS o WHERE o.billNumber = :billNumber");
		qry.setParameter("billNumber", billNnumber);
		Bill bill = (Bill) qry.list().get(0);
		System.out.println("bill found : " + bill);
		if (bill != null) {
			BillPosition newPos = new BillPosition();
			newPos.setPositionText(positionText);
			newPos.setBill(bill);
			sessionFactory.getCurrentSession().save(newPos);
			sessionFactory.getCurrentSession().save(bill);
			System.out.println("bill saved, it has now "+bill.getBillPositions().size()+" positions...");
		} else {
			System.out.println("bill ["+billNnumber+"] not found...");
		}
	}
}
