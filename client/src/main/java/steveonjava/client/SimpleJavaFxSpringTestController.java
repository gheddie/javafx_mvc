package steveonjava.client;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import org.springframework.beans.factory.annotation.Autowired;

public class SimpleJavaFxSpringTestController implements DialogController {
	
    @Autowired
    private SimpleJavaFxSpringTestModel model;

	private FXMLDialog dialog;
	
    @FXML
    TextField someTestWireUp;

	public void setDialog(FXMLDialog dialog) {
        this.dialog = dialog;
	}
	
    @FXML
    public void testMoo() {    	
    	model.acceptValue(someTestWireUp.getText());
        dialog.close();
    }
}
