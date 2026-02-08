package easv.event_tickets_easv_prototype.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GreetWindowController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
