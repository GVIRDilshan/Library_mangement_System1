package view;

import Notification.Alerts;
import com.jfoenix.controls.JFXTextField;
import controller.BookController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import modal.Book;

import java.io.IOException;

public class BookAddFromController {
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    void back(ActionEvent event) {
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
    void save(ActionEvent event) {


        String BookId = txtId.getText();
        String BookName = txtName.getText();
        String BookAuthor = txtAuthor.getText();
        double BookQty = Double.parseDouble(txtPrice.getText());

        Book b1 = new Book();
        b1.setId(BookId);
        b1.setName(BookName);
        b1.setAuthor(BookAuthor);
        b1.setQty((int) BookQty);

        boolean book = BookController.AddBook(b1);

        Alerts alerts = new Alerts();
        alerts.notification("Book Add Sucses....!", "Book Adding");

    }

}
