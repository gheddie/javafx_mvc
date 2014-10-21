package steveonjava.client;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class SimpleJavaFxSpringTestModel {

	private RestTemplate restTemplate;

	public void acceptValue(String value) {
		
		System.out.println("model : hello from test123 (value='"+value+"')...");
		restTemplate.execute("http://localhost:8080/eddie/quetsch", HttpMethod.GET, null, null);
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;		
	}
}
