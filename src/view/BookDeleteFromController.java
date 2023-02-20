package view;

import Notification.Alerts;
import com.jfoenix.controls.JFXTextField;
import controller.BookController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class BookDeleteFromController {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtDelete;

    @FXML
    void Back(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("BookMainFrom.fxml"));
            Stage primaryStage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void onDelete(ActionEvent event) {
        String BookId = txtDelete.getText();

        boolean delete = BookController.BookDelete(BookId);

        Alerts alerts = new Alerts();
        alerts.notification("Deleteing Sucses  ! ", "Book Delete");
    }
}
