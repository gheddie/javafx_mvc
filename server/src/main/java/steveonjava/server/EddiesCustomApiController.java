package steveonjava.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/eddie/")
@Controller
public class EddiesCustomApiController {

    @Autowired
    private MyVerySpecialService myVerySpecialService;
    
    @ResponseBody
    @RequestMapping(value = "/testentities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> customers() {
        return this.myVerySpecialService.getAllEntities();
    }
    
    @ResponseBody
    @RequestMapping(value = "/quetsch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void someSimpleBLMethod() {
    	System.out.println("bl invoked...");
    	myVerySpecialService.createMyEntity();
    }
}
