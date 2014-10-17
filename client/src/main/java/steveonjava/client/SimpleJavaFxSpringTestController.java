package steveonjava.client;

import javafx.fxml.FXML;

public class SimpleJavaFxSpringTestController implements DialogController {

	private FXMLDialog dialog;

	public void setDialog(FXMLDialog dialog) {
        this.dialog = dialog;
	}
	
    @FXML
    public void testMoo() {
    	System.out.println("hello from test123...");
//        dialog.close();
    }
}
