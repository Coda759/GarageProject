package application;
import java.io.IOException;

import javafx.event.ActionEvent;
/**
 * 
 * @author Rino Espinal
 * @version 1.0
 * @Since 09/30/2019
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
	
	static AccountBag account = new AccountBag();
	Vehicle vehicle = new Vehicle();
	static ParkingLot parklot = new ParkingLot();
	static ParkingSpot spot = new ParkingSpot();
	static GarageRates rate = new GarageRates();
	static TicketBag ticket = new TicketBag();
	static ReceiptBag receipt = new ReceiptBag();
	
	//check-in controllers
	@FXML
	private TextField lPlate_TextF;
	@FXML
	private TextField types_TextF;
	@FXML
	private TextField lot_TextF;
	@FXML
	private Label checkIn_label;
	
	//Checkout controllers
	@FXML
	private TextField getTicketID;
	@FXML
	private TextField checkout_ID;
	@FXML
	private TextField amountDue_TextF;
	@FXML
	private TextArea cheackOut_TextA;
	
	//Vehicle Search
	@FXML
	private TextArea vehicleSearch_TextA;
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
	private Label accAction_label;
	@FXML
	private TextArea searchResult_TextA;
	@FXML
	private CheckBox isManager_ckBox;	
	@FXML
	private Label currentUser_Label;
	
	//Sign in interface
	@FXML
	private TextField userName_TextF;
	@FXML
	private PasswordField pasword_PassF;
	@FXML
	private Label loginMessage_Label;
			
	
		/**
		* This method is called when the Park vehicle button is pressed.
	 	*/
		public void checkinButtonPushed()
		{	
			String activeUser,licensePlate,spotAssigned,ticketID;
			int vehicleSize; 
			double parkRate;
			
			activeUser = account.getActiveId();
			licensePlate = lPlate_TextF.getText();
			vehicleSize = Integer.parseInt(types_TextF.getText());
			parkRate = rate.getSpecificRate(vehicleSize);
		
			vehicle = new Vehicle(licensePlate,vehicleSize);
			
			System.out.println(spotAssigned = parklot.parkVehicle(vehicle));
			
			lot_TextF.setText(spotAssigned);
			if(!spotAssigned.contentEquals("Spots Full"))
			{
			ticketID =ticket.add(licensePlate, activeUser, parkRate, spotAssigned);
			getTicketID.setText(ticketID);
			}
			else
			{
				getTicketID.setText("No Ticket Generated.");
			}
		}
		
		/**
		* This method is called when the auto generate button is pressed.
		* It will auto generate a vehicle.
		*/
		public void autoGenButtonPushed()
		{	
			lPlate_TextF.setText(vehicle.generateLicensePlate());
			
		}
		
		/**
		 * When the checkout button is pressed.
		 * It will call this method generate a ticket and display amount due.
		 */
		public void checkoutButtonPushed()
		{	
			parklot.retrieveVehicle(ticket.searchTicket(checkout_ID.getText()).getVehicleID());
			//receipt.add(ticket.searchTicket(checkout_ID.getText()));
			amountDue_TextF.setText((receipt.add(ticket.searchTicket(checkout_ID.getText()))));
			cheackOut_TextA.setText("Thank You!\n Please come back.");
		}
		
		/**
		 * This method is called when the ticket search button is pressed.
		 * It will get the information of the vehicle and display it.
		 */
		public void checkoutSearchButtonPushed()
		{	
			String printTicket;
			printTicket = ticket.search(checkout_ID.getText());
			
			cheackOut_TextA.setText((printTicket));
		}
		
		/**
		 * This method calls the vehicle bag and retrieves vehicle information.
		 * It then displays the information, if vehicle not found,
		 * "NotFound, Please Try Again." is displayed.
		 */
		public void receiptSearchButtonPushed()
		{
			vehicleSearch_TextA.setText(receipt.search(vehicleSearch_TextF.getText()));
		}
		
		/**
		 * This method is called when the change price button is pressed.
		 * It will change the prices.
		 */
		public void setPriceButtonPushed()
	    {	
			double cRate;
	    	double mRate;
	    	double tRate;
	
	    	cRate = Double.parseDouble(carPrices_TextF.getText());
	    	mRate = Double.parseDouble(motorcPrices_TextF.getText());
	    	tRate = Double.parseDouble(truckPrices_TextF.getText());
	   
			rate = new GarageRates(cRate,mRate,tRate);
			price_label.setText("Price Changed!");
			price_label.setVisible(true);
	    }
		
		/**
		 * This method is called when the get current price button is pressed.
		 * It will show current prices for each vehicle size.
		 */
		public void getPriceButtonPushed()
	    {	
			String carSize,motorcycleSize,truckSize;
	    	carSize = Double.toString(rate.getCarRate());
	    	motorcycleSize = Double.toString(rate.getMotorcycleRate());
	    	truckSize = Double.toString(rate.getTruckRate());
	    	
			carPrices_TextF.setText(carSize);
			motorcPrices_TextF.setText(motorcycleSize);
			truckPrices_TextF.setText(truckSize);
			
			price_label.setText("Current Prices");
			price_label.setVisible(true);
	    }
		
		/**
		 * This method is called when the account save button is pressed.
		 * It will save changes made to an account.
		 */
		public void accountUpdateButtonPushed()
	    {	
			String userID,password, address, phoneNumber, firstName, lastName;
	    	userID = accSearch_TextF.getText();
	    	password = pw_PassF.getText();
	    	address = address_TextF.getText();
	    	phoneNumber = phoneN_TextF.getText();
	    	firstName = firstN_TextF.getText();
	    	lastName = lastN_TextF.getText();
	    	
			account.updateAccount(userID,password,address,phoneNumber,firstName,lastName);
			accAction_label.setText("Account Updated");
			accAction_label.setVisible(true);
	    }
		
		/**
		 * This method is called when the account delete button is pressed.
		 * It will delete an account.
		 */
		public void accountDeleteButtonPushed()
	    {	
			String userID;
	    	userID = accSearch_TextF.getText();
			account.delete(userID);
			
			accAction_label.setText("Account Deleted");
			accAction_label.setVisible(true);
	    }
		
		/**
		 * This method is called when the Create account button is pressed.
		 * It will create a new account and display the account information
		 * on a text area.
		 */
		public void accountCreateButtonPushed()
	    {	
			String userID,password, address, phoneNumber, firstName, lastName;
			userID = accSearch_TextF.getText();
	    	password = pw_PassF.getText();
	    	address = address_TextF.getText();
	    	phoneNumber = phoneN_TextF.getText();
	    	firstName = firstN_TextF.getText();
	    	lastName = lastN_TextF.getText();
	    	
			searchResult_TextA.setText((account.addAccount(address, phoneNumber, 
					firstName, lastName, isManager_ckBox.isSelected())));
			
			accAction_label.setText("Account Created");
			accAction_label.setVisible(true);
	    }
		
		/**
		 * This method is called when the account Search button is pressed.
		 * It will search for existing account.
		 */
		public void accountSearchButtonPushed()
	    {	
			String accountInfo;
			accountInfo = account.search(accSearch_TextF.getText());
			
			searchResult_TextA.setText(accountInfo);
	    }
		
		/**
		 * This method is called when the account Search button is pressed.
		 * It will search for existing account.
		 */
		public void manageTabPushed()
	    {	
			currentUser_Label.setText("User ID: "+ account.getActiveId());
			if(account.getIsManager() == false)
			{
				manage_Tab.setDisable(true);
			}
			else {
				manage_Tab.setDisable(false);
			}
	    }
		
		/**
		 * @throws IOException 
		 * This methods sets the main scene as the sign in scene.
		 * And sets active user to null.
		 */
		public void signoutButtonPushed(ActionEvent event) throws IOException
		{		
				account.logout();
				Parent mainView = FXMLLoader.load(getClass().getResource("LoginGui.fxml"));
				Scene mainScence = new Scene(mainView);
				Stage mainWindow = (Stage) ((Node)event.getSource()).getScene().getWindow();
				mainWindow.setScene(mainScence);
				mainWindow.setResizable(false);
				mainWindow.show();
		}
		
		/**
		 * @throws IOException 
		 * This methods gets the sign in information and sends it to be checked.
		 * If the username and password are correct. Main menu is set as the scene.
		 */
		public void singinButtonPushed(ActionEvent event) throws IOException
		{	
			boolean validation;
			validation = account.login(userName_TextF.getText(), pasword_PassF.getText());
			if(validation == true)
			{
				Parent mainView = FXMLLoader.load(getClass().getResource("MainGui.fxml"));
				Scene mainScence = new Scene(mainView);
				Stage mainWindow = (Stage) ((Node)event.getSource()).getScene().getWindow();
				mainWindow.setScene(mainScence);
				mainWindow.setResizable(false);
				mainWindow.show();
			}
			else
			{
				loginMessage_Label.setText("Invalid Account, Please Try again.");
				loginMessage_Label.setVisible(true);
			}
		}
	
	}


