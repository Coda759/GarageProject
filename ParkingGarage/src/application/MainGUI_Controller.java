package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainGUI_Controller {
	
	//check-in controllers
	@FXML
	private TextField lPlate_TextF;
	@FXML
	private Button parkVehicle_bt;
	@FXML
	private Button autoGen_bt;
	@FXML
	private MenuButton type_Menu;
	@FXML
	private CheckBox monthlyPlan_ckBox;
	@FXML
	private MenuButton state_Menu;
	@FXML
	private TextField lot_TextF;
	
	//Checkout controllers
	@FXML
	private TextField checkout_ID;
	@FXML
	private Button getInfo_bt;
	@FXML
	private TextField amountDue_TextF;
	@FXML
	private TextArea cheackOut_TextA;
	@FXML
	private Button checkout_bt;
	
	//Vehicle Search
	@FXML
	private TextArea vehicleSearch_TextA;
	@FXML
	private Button vehicleSearch_bt;
	@FXML
	private TextField vehicleSearch_TextF;
	
	///Garage Prices controller
	@FXML
	private TextField motorcPrices_TextF;
	@FXML
	private TextField carPrices_TextF;
	@FXML
	private TextField truckPrices_TextF;
	@FXML
	private Button saveNewPrices_bt;
	
	//Account management
	@FXML
	private TextField firstN_TextF;
	@FXML
	private TextField lastN_TextF;
	@FXML
	private TextField userN_TextF;
	@FXML
	private TextField idNumber_TextF;
	@FXML
	private PasswordField pw_PassF;
	@FXML
	private DatePicker date;
	@FXML
	private TextField accSearch_TextF;
	@FXML
	private Button accSearch_bt;
	@FXML
	private Button accDelete_bt;
	@FXML
	private Button accUpdate_bt;
	@FXML
	private Button accCreate_bt;
	
}
