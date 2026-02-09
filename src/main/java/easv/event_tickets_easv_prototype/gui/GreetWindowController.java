package easv.event_tickets_easv_prototype.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
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
    private TableView<Object> coordinatorsTable;

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
    private void loginClick(ActionEvent event) throws IOException {
        if (event.getSource() == adminButton){
            admin = true;
        }
        try {
            openLoginWindow();
        }
        catch (IOException e){
            throw e;
        }

    }

    private void openLoginWindow() throws IOException {
        if (admin){
            FXMLLoader loader = new FXMLLoader(GreetWindowController.class.getResource("/easv/event_tickets_easv_prototype/gui/login_view.fxml"));
            Parent parent = loader.load();
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

    private void setAdmin(boolean bool){
        this.admin = bool;
    }

    @FXML
    private void actualLoginClick(){
        String fileName = (admin) ? "/easv/event_tickets_easv_prototype/gui/admin_panel.fxml" : "/easv/event_tickets_easv_prototype/gui/coordinator-view.fxml";
        try{
            FXMLLoader loader = new FXMLLoader(GreetWindowController.class.getResource(fileName));
            VBox parent = (VBox) loader.load();
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(parent));
        }
        catch (IOException e){
            System.out.println("error");
        }
    }

    @FXML
    private void deleteEventCoord(){
        showAlert("Are you sure that you want to delete this event Coordinator?");
    }

    private void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @FXML
    private void assignCoordinator(){
        showAlert("For assigning a coordinator you need to select a coordinator from a list above and select an even respectively");
    }

    @FXML
    private void seeMore(){

    }

    @FXML
    private void createEventCoord(){
        String fileName = "/easv/event_tickets_easv_prototype/gui/new_event_coordinator.fxml";
        try{
            FXMLLoader loader = new FXMLLoader(GreetWindowController.class.getResource(fileName));
            VBox parent = (VBox) loader.load();
            Stage stage = (Stage) coordinatorsTable.getScene().getWindow();
            stage.setScene(new Scene(parent));
        }
        catch (IOException e){
            System.out.println("error");
        }
    }
}
