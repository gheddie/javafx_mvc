package steveonjava.client;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SimpleJavaFxSpringTestController implements DialogController {

	private FXMLDialog dialog;
	
    @FXML
    TextField someTestWireUp;

	public void setDialog(FXMLDialog dialog) {
        this.dialog = dialog;
	}
	
    @FXML
    public void testMoo() {
    	System.out.println("hello from test123 (value='"+someTestWireUp.getText()+"')...");
//        dialog.close();
    }
}
