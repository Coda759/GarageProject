package application;
/**
 * 
 * @author RinoE
 */
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainGUI_Controller {
	
	AccountBag account = new AccountBag();
	//check-in controllers
	@FXML
	private TextField lPlate_TextF;
	@FXML
	private Button parkVehicle_bt;
	@FXML
	private Button autoGen_bt;
	@FXML
	private TextField types_TextF;
	@FXML
	private CheckBox monthlyPlan_ckBox;
	@FXML
	private TextField state_TextF;
	@FXML
	private TextField lot_TextF;
	@FXML
	private Label checkIn_label;
	
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
	@FXML
	private Label search_label;
	
	///Garage Prices controller
	@FXML
	private Tab manage_Tab;
	@FXML
	private TextField motorcPrices_TextF;
	@FXML
	private TextField carPrices_TextF;
	@FXML
	private TextField truckPrices_TextF;
	@FXML
	private Button saveNewPrices_bt;
	@FXML
	private Label price_label;
	
	//Account management
	@FXML
	private TextField address_TextF;
	@FXML
	private TextField phoneN_TextF;
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
	@FXML
	private Label accAction_label;
	@FXML
	private CheckBox isManager_ckBox;	

	/**
	 * This method is called when the Park vehicle button is pressed.
	 */
	public void checkinButtonPushed()
    {
       if(monthlyPlan_ckBox.isSelected())
       {	
        state_TextF.getText();
        }
    }
	/**
	 * This method is called when the auto generate button is pressed.
	 * It will auto generate a vehicle.
	 */
	public void autoGenButtonPushed()
    {
		System.out.println("Price");
    }
	/**
	 * when the checkout button is pressed.
	 * It will call this method and generate a ticket.
	 */
	public void checkoutButtonPushed()
    {
		amountDue_TextF.setText("20");
		cheackOut_TextA.setText("Thank You!\n Please come back.");
    }
	/**
	 * This method is called when the ticket search button is pressed.
	 * It will get the information of the vehicle and display it.
	 */
	public void ticketSearchButtonPushed()
    {	
		cheackOut_TextA.setText("Not Found. Please try again.");
		//cheackOut_TextA.setText("Vehicle info");
    }
	/**
	 * This method calls the vehicle bag and retrieves vehicle information.
	 * It then displays the information, if vehicle not found,
	 * "NotFound, Please Try Again." is displayed.
	 */
	public void vehicleSearchButtonPushed()
    {
		vehicleSearch_TextA.setText("NotFound, Please Try Again.");
		search_label.setVisible(true);
		//vehicleSearch_TextA.setText("Vehicle info search");
    }
		/**
		 * This method is called when the change price button is pressed.
		 * It will change the price.
		 */
		public void setPriceButtonPushed()
	    {
			price_label.setText("Price Changed!");
			price_label.setVisible(true);
	    }

		/**
		 * This method is called when the account save button is pressed.
		 * It will save changes to an account.
		 */
		public void accountUpdateButtonPushed()
	    {
			accAction_label.setText("Account Updated");
			accAction_label.setVisible(true);
	    }
		/**
		 * This method is called when the account delete button is pressed.
		 * It will delete an account.
		 */
		public void accountDeleteButtonPushed()
	    {
			accAction_label.setText("Account Deleted");
			accAction_label.setVisible(true);
	    }

		/**
		 * This method is called when the account Create button is pressed.
		 * It will create a new account.
		 */
		public void accountCreateButtonPushed()
	    {
			account.addAccount(address_TextF.getText(), phoneN_TextF.getText(), 
					firstN_TextF.getText(), lastN_TextF.getText(), isManager_ckBox.isSelected());
			accAction_label.setText("Account Created");
			accAction_label.setVisible(true);
	    }
		/**
		 * This method is called when the account Search button is pressed.
		 * It will search for existing account.
		 */
		public void accountSearchButtonPushed()
	    {
			accAction_label.setText("NotFound, Please Try Again.");
			accAction_label.setVisible(true);
			
	    }
		public void manageTabPushed()
	    {
			/*if(account.getIsManager != true)
			{
				manage_Tab.setDisable(true);
			}
			*/
			manage_Tab.setDisable(true);
	    }
	}


