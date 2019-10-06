package application;
import java.io.IOException;

import javafx.event.ActionEvent;
/**
 * 
 * @author Rino Espinal
 * 
 */
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainGUI_Controller {
	
	AccountBag account = new AccountBag();
	Vehicle vehicle = new Vehicle();
	GarageRates rate = new GarageRates();
	private int count = 0;
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
	private Button currentPrices_bt;
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
	private TextArea searchResult_TextA;
	@FXML
	private CheckBox isManager_ckBox;	

	/**
	 * This method is called when the Park vehicle button is pressed.
	 */
	public void checkinButtonPushed()
    {
		vehicle.setSize(Integer.parseInt(types_TextF.getText()));
		vehicle.setLicensePlate(lPlate_TextF.getText());
		//vehicle.setState(state_TextF.getText());
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
		//vehicle.generateLicensePlate();
		//lPlate_TextF.setText(vehicle.getLicensePlate());
		//state_TextF.setText(vehicle.getState());
		
		//lPlate_TextF.setText(vehicle.getLicensePlate());
		//lPlate_TextF
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
		//vehicleSearch_TextA.setText("NotFound, Please Try Again.");
		search_label.setVisible(true);
		//vehicleSearch_TextA.setText("Vehicle info search");
    }
		/**
		 * This method is called when the change price button is pressed.
		 * It will change the price.
		 */
		public void setPriceButtonPushed()
	    {	double cRate;
	    	double mRate;
	    	double tRate;
	
	    	cRate = Double.parseDouble(carPrices_TextF.getText());
	    	mRate = Double.parseDouble(carPrices_TextF.getText());
	    	tRate = Double.parseDouble(carPrices_TextF.getText());
	   
			rate = new GarageRates(cRate,mRate,tRate);
			price_label.setText("Price Changed!");
			price_label.setVisible(true);
	    }
		/**
		 * This method is called get current price button is pressed.
		 * It will show current prices.
		 */
		public void getPriceButtonPushed()
	    {	
			carPrices_TextF.setText(Double.toString(rate.getCarRate()));
			motorcPrices_TextF.setText(Double.toString(rate.getMotorcycleRate()));
			truckPrices_TextF.setText(Double.toString(rate.getTruckRate()));
			price_label.setText("Current Prices");
			price_label.setVisible(true);
	    }
		/**
		 * This method is called when the account save button is pressed.
		 * It will save changes to an account.
		 */
		public void accountUpdateButtonPushed()
	    {	
			account.updateAccount(userN_TextF.getText(), pw_PassF.getText(), address_TextF.getText(),
					phoneN_TextF.getText(), firstN_TextF.getText(), lastN_TextF.getText());
			accAction_label.setText("Account Updated");
			accAction_label.setVisible(true);
	    }
		/**
		 * This method is called when the account delete button is pressed.
		 * It will delete an account.
		 */
		public void accountDeleteButtonPushed()
	    {
			account.delete(userN_TextF.getText());
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
			searchResult_TextA.setText(account.toString());
			accAction_label.setText("Account Created");
			accAction_label.setVisible(true);
			//account
	    }
		/**
		 * This method is called when the account Search button is pressed.
		 * It will search for existing account.
		 */
		public void accountSearchButtonPushed()
	    {
			account.search(accSearch_TextF.getText());
			 searchResult_TextA.setText(account.search(accSearch_TextF.getText()));
			System.out.println(account.search(accSearch_TextF.getText()));
			
	    }
		public void manageTabPushed()
	    {
			
			if(this.account.getIsManager() != false)
			{
				manage_Tab.setDisable(true);
			}
			
			//manage_Tab.setDisable(true);
	    }
		/**
		 * @throws IOException 
		 * This methods sets the main scene as the signed in scene.
		 */
		
		public void signoutButtonPushed(ActionEvent event) throws IOException
		{	
				Parent mainView = FXMLLoader.load(getClass().getResource("LoginGui.fxml"));
				Scene mainScence = new Scene(mainView);
				Stage mainWindow = (Stage) ((Node)event.getSource()).getScene().getWindow();
				mainWindow.setScene(mainScence);
				mainWindow.setResizable(false);
				mainWindow.show();
		}
		@FXML
		private TextField userName_TextF;
		@FXML
		private PasswordField pasword_PassF;
		@FXML
		private Button signIn_bt;
		@FXML
		private Label loginMessage_Label;
		
		/**
		 * @throws IOException 
		 * This methods gets the sign in information and sends it to be checked.
		 * If the username and password are correct. Main menu is set as the scene.
		 */
		
		public void singinButtonPushed(ActionEvent event) throws IOException
		{	boolean validation;
			validation = account.login(userName_TextF.getText(), pasword_PassF.getText());
			if(validation == true){
				Parent mainView = FXMLLoader.load(getClass().getResource("MainGui.fxml"));
				Scene mainScence = new Scene(mainView);
				Stage mainWindow = (Stage) ((Node)event.getSource()).getScene().getWindow();
				mainWindow.setScene(mainScence);
				mainWindow.setResizable(false);
				mainWindow.show();
			}
			else{
				loginMessage_Label.setText("Invalid Account, Please Try again.");
				loginMessage_Label.setVisible(true);
			}
		}
	
	}


