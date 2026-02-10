package easv.event_tickets_easv_prototype.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class GreetWindowController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label titleLabel;

    @FXML
    private Label titleInfoLabel;

    @FXML
    private Button eventCoordinatorButton;

    @FXML
    private ChoiceBox<String> coordinatorChoice;

    @FXML
    private Button createBtn;

    @FXML
    private Button loginButton;

    @FXML
    private Button newEvent;

    @FXML
    private TableView<Object> coordinatorsTable;

    @FXML
    private TableView<Object> eventsTable;

    @FXML
    private Button adminButton;

    @FXML
    private TextField titleInput;

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
    @FXML
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
            if (this.admin){
                GreetWindowController gwc = loader.getController();
                gwc.setAdmin(this.admin);
            }
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

    @FXML
    private void deleteEvent(){
        showAlert("Are you sure that you want to delete this event?");
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
        showAlert("For assigning a coordinator you need to select a coordinator from a list above and select an event respectively");
    }

    @FXML
    private void grantAccess(){
        showAlert("For granting access you need to select an event from a list above and select a coordinator respectively");
    }

    @FXML
    private void seeMore() throws IOException {
        FXMLLoader loader = new FXMLLoader(GreetWindowController.class.getResource("/easv/event_tickets_easv_prototype/gui/see_more.fxml"));
        Parent parent = loader.load();
        GreetWindowController  gwc = loader.getController();
        gwc.setAdmin(this.admin);
        if (eventsTable != null) {
            Stage stage = (Stage) eventsTable.getScene().getWindow();
            stage.setScene(new Scene(parent));
        }else{
            Stage stage = (Stage) coordinatorsTable.getScene().getWindow();
            stage.setScene(new Scene(parent));
        }
    }

    @FXML
    private void createEventCoord(){
        String fileName = "/easv/event_tickets_easv_prototype/gui/new_event_coordinator.fxml";
        try{
            FXMLLoader loader = new FXMLLoader(GreetWindowController.class.getResource(fileName));
            VBox parent = (VBox) loader.load();
            GreetWindowController  gwc = loader.getController();
            gwc.setAdmin(this.admin);
            Stage stage = (Stage) coordinatorsTable.getScene().getWindow();
            stage.setScene(new Scene(parent));
        }
        catch (IOException e){
            System.out.println("error");
        }
    }

    @FXML
    private void createNewEvent(ActionEvent event) {
        String fileName = "/easv/event_tickets_easv_prototype/gui/new-event-view.fxml";
        String title = (event.getSource() == newEvent) ? "Create" : "Edit";
        try{
            FXMLLoader loader = new FXMLLoader(GreetWindowController.class.getResource(fileName));
            VBox parent = (VBox) loader.load();
            GreetWindowController controller = loader.getController();
            controller.titleLabel.setText(title + " Event");
            controller.createBtn.setText(title);
            Stage stage = (Stage) eventsTable.getScene().getWindow();
            stage.setScene(new Scene(parent));
        }
        catch (IOException e){
            System.out.println("tupoi huilan");
        }
    }

    @FXML
    private void onCancel(ActionEvent event) {
        String fileName = (this.admin) ? "/easv/event_tickets_easv_prototype/gui/admin_panel.fxml" : "/easv/event_tickets_easv_prototype/gui/coordinator-view.fxml";
        try{
            FXMLLoader loader = new FXMLLoader(GreetWindowController.class.getResource(fileName));
            VBox parent = (VBox) loader.load();
            GreetWindowController  gwc = loader.getController();
            gwc.setAdmin(this.admin);
            Stage stage;
            if (titleInput != null) {
                stage = (Stage) titleInput.getScene().getWindow();
            } else if (titleInfoLabel != null) {
                stage =  (Stage) titleInfoLabel.getScene().getWindow();
            }else{
                stage = (Stage) coordinatorChoice.getScene().getWindow();
            }
            stage.setScene(new Scene(parent));
        }
        catch (IOException e){
            System.out.println("tupoi huilan");
        }
    }


}
