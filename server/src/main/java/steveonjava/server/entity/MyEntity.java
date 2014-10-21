package steveonjava.server.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyEntity implements Serializable {

	private static final long serialVersionUID = 6620905633391064461L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String someEntityValue;
    
    public String getSomeEntityValue() {
		return someEntityValue;
	}
    
    public void setSomeEntityValue(String someEntityValue) {
		this.someEntityValue = someEntityValue;
	}
}
