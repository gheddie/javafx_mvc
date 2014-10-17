package steveonjava.client;

import java.util.Date;

import org.springframework.web.client.RestTemplate;

import steveonjava.server.Customer;

public class SimpleJavaFxSpringTestModel {

	private RestTemplate restTemplate;

	public void acceptValue(String value) {
		
		System.out.println("model : hello from test123 (value='"+value+"')...");
		
		//---
		
        Customer customer = new Customer();
        customer.setFirstName("Moo");
        customer.setLastName("Mee");
        customer.setSignupDate(new Date());
        Integer id = restTemplate.postForObject("http://localhost:8080/crm/customers", customer, Integer.class);
        
        System.out.println("created customer with id '"+id+"'.");
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;		
	}
}
