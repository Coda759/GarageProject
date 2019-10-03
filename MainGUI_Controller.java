package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class MainGUI_Controller {
	
	//check-in controllers
	@FXML
	private TextField lpTextF;
	@FXML
	private Button park_bt;
	@FXML
	private MenuButton typeMenu;
	@FXML
	private CheckBox monthly_ckBox;
	@FXML
	private MenuButton stateMenu;
	
	//Checkout controllers
	@FXML
	private TextField checkout_ID;
	@FXML
	private Button getInfo_bt;
	@FXML
	private TextField amountDue;
	@FXML
	private ListView ls_info;
	@FXML
	private Button checkout_bt;
	
}
