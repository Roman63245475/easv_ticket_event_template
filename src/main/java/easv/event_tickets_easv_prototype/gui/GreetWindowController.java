package easv.event_tickets_easv_prototype.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class GreetWindowController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button eventCoordinatorButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button adminButton;

    @FXML
    private boolean admin;

    private Scene previousScene;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void loginClick(ActionEvent event){
        if (event.getSource() == adminButton){
            admin = true;
        }
        try {
            openLoginWindow();
        }
        catch (IOException e){
            System.out.println("error while opening login window");
        }

    }

    private void setAdmin(boolean bool){
        this.admin = bool;
    }

    private void openLoginWindow() throws IOException {
        if (admin){
            FXMLLoader loader = new FXMLLoader(GreetWindowController.class.getResource("/easv/event_tickets_easv_prototype/gui/login_view.fxml"));
            VBox parent = (VBox) loader.load();
            GreetWindowController gwc = loader.getController();
            gwc.setAdmin(true);
            Stage stage = (Stage) adminButton.getScene().getWindow();
            stage.setScene(new Scene(parent));
        }
        else{
            FXMLLoader loader = new FXMLLoader(GreetWindowController.class.getResource("/easv/event_tickets_easv_prototype/gui/login_view.fxml"));
            VBox parent = (VBox) loader.load();
            Stage stage = (Stage) adminButton.getScene().getWindow();
            stage.setScene(new Scene(parent));
        }

    }

    @FXML
    private void actualLoginIn() {
        if (admin){
            try {
                FXMLLoader loader = new FXMLLoader(GreetWindowController.class.getResource("/easv/event_tickets_easv_prototype/gui/admin_panel.fxml"));
                VBox parent = (VBox) loader.load();
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.setScene(new Scene(parent));
            }
            catch (IOException e){
                System.out.println("error");
            }
        }
        else{
            System.out.println("pashol nahuy");
        }
    }

    @FXML
    private void actualLoginClick(){

    }
}
