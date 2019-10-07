package application;
/**
 * @author Rino Espinal
 * @version 1.0
 * @Since 09/30/2019
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class MainApp extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = (BorderPane)FXMLLoader.load(getClass().getResource("LogInGui.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Welcome");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
