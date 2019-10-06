package application;
/**
 * @author Rino Espinal
 */
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogIn_Controller {
	
	AccountBag account = new AccountBag();
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
