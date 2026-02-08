module easv.event_tickets_easv_prototype {
    requires javafx.controls;
    requires javafx.fxml;


    opens easv.event_tickets_easv_prototype to javafx.fxml;
    exports easv.event_tickets_easv_prototype;
    exports easv.event_tickets_easv_prototype.gui;
    opens easv.event_tickets_easv_prototype.gui to javafx.fxml;
}