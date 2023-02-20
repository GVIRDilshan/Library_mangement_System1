package view;

import Notification.Alerts;
import com.jfoenix.controls.JFXTextField;
import controller.BookController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modal.Book;

import java.io.IOException;

public class BookSearchFromController {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtBookId;

    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblPrice;

    @FXML
    void Search(ActionEvent event) {
        String searchId = txtBookId.getText();

        Book book = BookController.bookSearch(searchId);

        lblId.setText(book.getId());
        lblName.setText(book.getName());
        lblAuthor.setText(book.getAuthor());
        lblPrice.setText(String.valueOf(book.getQty()));

        Alerts alerts = new Alerts();
        alerts.notification("Search sucses....!", "Book Search");
    }
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
}
